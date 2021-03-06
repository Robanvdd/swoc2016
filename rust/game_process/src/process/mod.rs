use std::io::prelude::*;
use std::process::{Child, Command, Stdio};
use game_structures::game::GameObject;
use serde_json;


pub struct GameProcess {
    process: Child,
}

impl GameProcess {
    pub fn new(command: String, arguments: String) -> GameProcess {
        let result = Command::new(command)
            .arg(arguments)
            .stdin(Stdio::piped())
            .stdout(Stdio::piped())
            .spawn();

        match result {
            Ok(child) => GameProcess { process: child },
            Err(cause) => panic!(cause),
        }
    }

    pub fn send_input(&mut self, game_object: &GameObject) {
        let json = match serde_json::to_string(&game_object) {
            Ok(json) => json,
            Err(_) => panic!("Failed to serialize game object"),
        };

        match self.process.stdin {
            Some(ref mut input) => {
                match input.write_all(json.as_bytes()) {
                    Ok(_) => {}
                    Err(_) => panic!("Failed to write input"),
                }
            }
            None => {}
        }
    }

    pub fn get_output(&mut self) -> GameObject {
        let mut json = String::new();

        match self.process.stdout {
            Some(ref mut output) => {
                match output.read_to_string(&mut json) {
                    Ok(_) => {}
                    Err(_) => panic!("Failed to read output"),
                }
            }
            None => {}
        }

        match serde_json::from_str(json.as_str()) {
            Ok(game_object) => game_object,
            Err(_) => panic!("Failed to deserialize json"),
        }
    }
}
