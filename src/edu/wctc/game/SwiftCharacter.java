package edu.wctc.game;

import edu.wctc.game.interfaces.Swift;

import java.util.Random;

public class SwiftCharacter extends Character implements Swift {


    public SwiftCharacter(String name) {
        super(name, 100);
    }

    @Override
    public boolean dodgeAttack() {
        return new Random().nextDouble() >= .7;
    }

    @Override
    public String isAttacked(Attack incomingAttack) {
        if (dodgeAttack()) {
            return String.format(" uses %s! ... but %s dodged!", incomingAttack.getName(), getName());
        }
        return incomingAttack.toString();
    }
}
