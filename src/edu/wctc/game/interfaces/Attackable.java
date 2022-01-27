package edu.wctc.game.interfaces;

import edu.wctc.game.Attack;
import java.util.List;

public interface Attackable {
    String isAttacked(Attack incomingAttack);
    Attack dealsDamage();
    List<Attack> getAttacks();
    void addAttack(Attack newAttack);
}
