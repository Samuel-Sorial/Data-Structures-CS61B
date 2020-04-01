package creatures;
import huglife.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Deque;
import java.util.HashMap;
import java.awt.Color;
import java.util.Map;

/**
 * @author :Samuel-Sorial
 * Testing the behavior of Clorus class.
 */
public class TestClorus {
    @Test
    public void testBasics(){
        Clorus c = new Clorus(2);
        assertEquals(2,c.energy(),.01);
        assertEquals("clorus",c.name());

        c.move();
        assertEquals(1.97,c.energy(),.001);

        c.stay();
        assertEquals(1.96,c.energy(),.001);
    }

    @Test
    public void testAttact(){
        Clorus c = new Clorus(2);
        Plip p = new Plip(2);
        c.attack(p);
        assertEquals(4,c.energy(),.01);
    }

    @Test
    public void testReplicate(){
        Clorus c = new Clorus(2);
        Creature child = c.replicate();

        assertEquals("clorus",child.name());
        assertEquals(1, c.energy(),.01);
        assertEquals(1,child.energy(),.01);
    }

    @Test
    public void testChooseAction(){
        Clorus c = new Clorus(2);
        Map<Direction, Occupant> noPlaceToGo = new HashMap<>();
        noPlaceToGo.put(Direction.TOP,new Impassible());
        noPlaceToGo.put(Direction.BOTTOM, new Impassible());
        noPlaceToGo.put(Direction.LEFT, new Impassible());
        noPlaceToGo.put(Direction.RIGHT, new Impassible());

        // There's no empty place to go, stay!
        Action expected = new Action(Action.ActionType.STAY);
        Action returned = c.chooseAction(noPlaceToGo);
        assertEquals(expected,returned);

        // Even if there's a plip there!
        noPlaceToGo.put(Direction.RIGHT, new Plip(2));
        returned = c.chooseAction(noPlaceToGo);
        assertEquals(expected,returned);


        Map<Direction, Occupant> attackOne = new HashMap<>();
        attackOne.put(Direction.TOP,new Impassible());
        attackOne.put(Direction.BOTTOM, new Plip());
        attackOne.put(Direction.LEFT, new Empty());
        attackOne.put(Direction.RIGHT, new Impassible());
        // Attack this plip!
        expected = new Action(Action.ActionType.ATTACK,Direction.BOTTOM);
        returned = c.chooseAction(attackOne);
        assertEquals(expected,returned);

        // If energy >=1 then replicate to empty square
        Map<Direction, Occupant> replicateEmpty = new HashMap<>();
        replicateEmpty.put(Direction.TOP,new Empty());
        replicateEmpty.put(Direction.BOTTOM, new Impassible());
        replicateEmpty.put(Direction.LEFT, new Impassible());
        replicateEmpty.put(Direction.RIGHT, new Impassible());

        expected = new Action(Action.ActionType.REPLICATE,Direction.TOP);
        returned = c.chooseAction(replicateEmpty);
        assertEquals(expected,returned);
    }
}
