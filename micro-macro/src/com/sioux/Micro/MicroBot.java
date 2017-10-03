package com.sioux.Micro;

import com.sioux.Micro.Command.Move;
import com.sioux.Micro.Command.Shoot;

import java.awt.*;

class MicroBot {
    private String name;
    private int hitpoints;
    private Point.Double position;

    // Non-serialized members (transient)
    private transient int cooldownShoot;
    private transient int lastShoot;
    private transient int radius;

    public MicroBot(String name, Integer hp, Point.Double pos, Integer radius) {
        this.name = name;
        this.hitpoints = hp;
        this.position = pos;
        this.cooldownShoot = 30;
        this.lastShoot = 0;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public Point.Double getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }

    public boolean isAlive() {
        return hitpoints > 0;
    }

    public void destroy() {
        hitpoints = 0;
    }

    public boolean canMove() {
        return isAlive();
    }

    public boolean canShoot(int tickShoot) {
        return isAlive() && (lastShoot == 0 || ((lastShoot + cooldownShoot) < tickShoot));
    }

    public void Move(Move cmd) {
        if (cmd == null) return;

        Point.Double newPos = Utils.PolarToCartesian(cmd.getSpeed(), cmd.getDirection());
        position.x += newPos.x;
        position.y += newPos.y;
    }

    public void Shoot(int tickShoot) {
        lastShoot = tickShoot;
    }

    public Boolean Hit(MicroProjectile projectile) {
        if (projectile == null || !this.isAlive()) return false;

        Double projectileRadius = 7.0;
        Double dx = projectile.getPosition().getX() - this.position.getX();
        Double dy = projectile.getPosition().getY() - this.position.getY();
        Double radii = radius + projectileRadius;

        if (( dx * dx ) + ( dy * dy ) < radii * radii) {
            hitpoints -= projectile.getDamage();
            return true;
        }
        return false;
    }
}