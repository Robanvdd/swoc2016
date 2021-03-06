package com.sioux.Micro;

import com.sioux.Micro.Command.Move;
import com.sioux.Micro.Command.MoveTo;
import com.sioux.Micro.Command.Shoot;
import com.sioux.Micro.Command.ShootAt;

class BotInput {
    private int id;
    private Move move;
    private MoveTo moveTo;
    private Shoot shoot;
    private ShootAt shootAt;

    public int getId() {
        return id;
    }

    public Move getMove() {
        return move;
    }

    public MoveTo getMoveTo() { return moveTo; }

    public Shoot getShoot() {
        return shoot;
    }

    public ShootAt getShootAt() { return shootAt; }
}
