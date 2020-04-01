package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Random;
    /**
    @author : Samuel-Sorial
    */
public class Clorus extends Creature  {

    /**
     * Creates a creature with the name N. The intention is that this
     * name should be shared between all creatures of the same type.
     * @param i
     */
    public Clorus(double i) {
        super("clorus");
        energy = i;
    }
        /**
         * red color.
         */
        private int r;
        /**
         * green color.
         */
        private int g;
        /**
         * blue color.
         */
        private int b;

        private final static double STAY_DECREASE_RATE = .01;

        private final static double MOVE_DECREASE_RATE = .03;

    @Override
    public void move() {
        energy -= MOVE_DECREASE_RATE;
    }

    @Override
    public void attack(Creature c)
    {
        this.energy += c.energy();
    }

    @Override
    public Creature replicate()
    {
        Clorus child = new Clorus(energy/2);
        this.energy /= 2;
        return child;
    }

    @Override
    public void stay() {
        this.energy -= STAY_DECREASE_RATE;
    }

    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {

        Deque<Direction> emptyPlaces = new ArrayDeque<>();
        Deque<Direction> pliplsPlaces = new ArrayDeque<>();
        for(Direction d : neighbors.keySet()){
            if(neighbors.get(d).name().equals("empty")){
                emptyPlaces.addFirst(d);
            }
            else if(neighbors.get(d).name().equals("plip")){
                pliplsPlaces.addFirst(d);
            }
        }
        if(emptyPlaces.isEmpty())
            return new Action(Action.ActionType.STAY);
        else if(!pliplsPlaces.isEmpty())
            return new Action(Action.ActionType.ATTACK,randomDirection(pliplsPlaces));
        else if (this.energy >=1)
            return new Action(Action.ActionType.REPLICATE, randomDirection(emptyPlaces));
        else
            return new Action(Action.ActionType.MOVE, randomDirection(emptyPlaces));
    }


    private Direction randomDirection(Deque<Direction> emptyNeighbours){
            Random random = new Random();
            int index = random.nextInt(emptyNeighbours.size()); //Choose randomly any index from 0 (inclusively) to the size (exclusively)
            Direction d = emptyNeighbours.getFirst(); // Dummy value
            for(int i =0; i<index; i++)
                d = emptyNeighbours.getFirst();
            return d;
        }
    @Override
    public Color color() {
        r = 34;
        g= 0;
        b = 231;
        return new Color(r,g,b);
    }
}
