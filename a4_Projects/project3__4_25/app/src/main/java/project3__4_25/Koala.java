import java.awt.*;
import java.util.Random;

public class Koala extends Critter {
    private int hunger; // number of times the Koala will eat
    private int timesEaten; // track how many times the Koala has eaten
    private Critter.Direction currentDirection; // current movement direction
    private int steps; // track steps in the current direction
    private Random random; // random number generator

    public Koala(int hunger) {
        this.hunger = hunger; // initialize the Koala's hunger
        this.timesEaten = 0; // initially hasn't eaten
        this.random = new Random(); // initialize random generator
        this.currentDirection = randomDirection(); // choose a random initial direction
        this.steps = 0; // initially no steps taken
    }

    private Critter.Direction randomDirection() {
        Critter.Direction[] directions = { Critter.Direction.NORTH, Critter.Direction.SOUTH, Critter.Direction.EAST,
                Critter.Direction.WEST };
        return directions[random.nextInt(directions.length)]; // choose a random direction from the array above
    }

    @Override
    public boolean eat() {
        if (timesEaten < hunger) { // eat only if still hungry
            timesEaten++; // increment times eaten
            return true;
        }
        return false; // otherwise, don't eat
    }

    @Override
    public Critter.Attack fight(String opponent) {
        if (timesEaten < hunger) { // if still hungry
            return Critter.Attack.SCRATCH;
        }
        return Critter.Attack.POUNCE; // otherwise, pounces
    }

    @Override
    public Color getColor() {
        return (timesEaten < hunger) ? Color.GRAY : Color.WHITE; // gray if hungry, white otherwise
    }

    @Override
    public Critter.Direction getMove() {
        if (steps >= 5) { // change direction every 5 steps
            currentDirection = randomDirection(); // choose a new random direction
            steps = 0; // reset step count
        }
        steps++; // increment step count
        return currentDirection;
    }

    @Override
    public String toString() {
        return "" + (hunger - timesEaten); // return the number of pieces of food left to eat
    }
}
