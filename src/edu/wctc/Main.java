package edu.wctc;

import edu.wctc.game.Attack;
import edu.wctc.game.Character;
import edu.wctc.game.CheatingCharacter;
import edu.wctc.game.SwiftCharacter;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Character player1 = new SwiftCharacter("Mario");
        Character player2 = new CheatingCharacter("Bowser");

        player1.addAttack(new Attack("Punch", 15));
        player1.addAttack(new Attack("Kick", 20));
        player1.addAttack(new Attack("Fireball", 30));

        player2.addAttack(new Attack("Tail Swipe", 30));
        player2.addAttack(new Attack("Fireball", 35));
        player2.addAttack(new Attack("Fall Over", 0));

        playGame(player1, player2);

        if (player1.isStillAlive()) {
            System.out.printf("%s wins!", player1.getName());
        } else if (player2.isStillAlive()) {
            System.out.printf("%s wins!", player2.getName());
        } else System.out.println("It's a tie!");
    }

    public static void playGame(Character player1, Character player2) throws InterruptedException {
        while(player1.isStillAlive() && player2.isStillAlive()) {
            System.out.println(player1);
            System.out.println(player2);

            System.out.printf("\n%s%s", player1.getName(), player2.isAttacked(player1.dealsDamage()));
            doubleStrike(player1, player2);
            System.out.printf("\n%s%s", player2.getName(), player1.isAttacked(player2.dealsDamage()));
            doubleStrike(player2, player1);

            Thread.sleep(3000);
            System.out.printf("\n");
        }
    }

    public static void doubleStrike(Character attacking, Character defending) {
        if(attacking instanceof CheatingCharacter) {
            if(((CheatingCharacter) attacking).attemptCheat()) {
                System.out.printf("\n%s cheated! %s%s", attacking.getName(), attacking.getName(), defending.isAttacked(attacking.dealsDamage()));
            }
        }
        System.out.println();
    }
}
