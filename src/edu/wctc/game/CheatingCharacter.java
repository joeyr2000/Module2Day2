package edu.wctc.game;

import edu.wctc.game.interfaces.Cheatable;

import java.util.Random;

public class CheatingCharacter extends Character implements Cheatable {

    public CheatingCharacter(String name) {
        super(name, 110);
    }

    @Override
    public boolean attemptCheat() {
        return new Random().nextDouble() >= .8;
    }
}
