package edu.wctc.game;

import edu.wctc.game.interfaces.Attackable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Character implements Attackable {
    private String name;
    private int health;
    private boolean isAlive;
    private List<Attack> attacks;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        isAlive = true;
        attacks = new ArrayList<>();
    }


    @Override
    public String isAttacked(Attack incomingAttack) {
        health -= incomingAttack.getDamage();

        if (health <= 0) {
            isAlive = false;
            health = 0;
        }

        return incomingAttack.toString();
    }

    @Override
    public Attack dealsDamage() {
        return attacks.get(new Random().nextInt(attacks.size()));
    }

    @Override
    public List<Attack> getAttacks() {
        return attacks;
    }

    @Override
    public void addAttack(Attack newAttack) {
        attacks.add(newAttack);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public boolean isStillAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return String.format("%s has %d health!", name, health);
    }
}
