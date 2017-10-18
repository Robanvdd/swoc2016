﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Newtonsoft.Json;
using Bot.Protocol;

namespace MicroBot.Protocol
{
    public sealed class Bot
    { 
        public string Name { get; set; }
        public float Hitpoints { get; set; }
    
        [JsonConverter(typeof(PositionConverter))]
        public Position Position { get; set; }
    }
}
