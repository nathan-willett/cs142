import java.awt.*; // for Color
import java.util.Random;

public class Salmon extends Critter {
    private Random random; // random number generator
    private int moveCounter; // tracks the number of moves
    private boolean isHungry; // whether the Salmon is hungry

    public Salmon() {
        this.random = new Random(); // initialize random generator
        this.moveCounter = 0; // start with zero moves
        this.isHungry = true; // Salmon starts hungry
    }

    @Override
    public boolean eat() {
        // Salmon is hungry every third move
        if (moveCounter % 3 == 0) {
            isHungry = !isHungry; // toggle hunger state
            return true; // eats
        }
        return false; // otherwise, doesn't eat
    }

    @Override
    public Critter.Attack fight(String opponent) {
        // Adapt fighting behavior based on the opponent
        switch (opponent) {
            case "%": // against Aardvark
                return Critter.Attack.ROAR;
            case "S": // against Stone
                return Critter.Attack.SCRATCH;
            default: // other critters
                return Critter.Attack.POUNCE;
        }
    }

    @Override
    public Color getColor() {
        // Alternates between blue and green based on move count
        return (moveCounter % 2 == 0) ? Color.BLUE : Color.GREEN;
    }

    @Override
    public Critter.Direction getMove() {
        // Moves in a pattern with randomness
        if (moveCounter % 5 == 0) { // every 5 moves, choose a random direction
            return randomDirection();
        }
        // otherwise, move in a basic pattern: East, South, West, North
        switch ((moveCounter / 5) % 4) {
            case 0:
                return Critter.Direction.EAST;
            case 1:
                return Critter.Direction.SOUTH;
            case 2:
                return Critter.Direction.WEST;
            default:
                return Critter.Direction.NORTH;
        }
    }

    private Critter.Direction randomDirection() {
        Critter.Direction[] directions = { Critter.Direction.NORTH, Critter.Direction.SOUTH, Critter.Direction.EAST,
                Critter.Direction.WEST };
        return directions[random.nextInt(directions.length)]; // choose a random direction
    }

    @Override
    public String toString() {
        // Display changes with hunger state
        return isHungry ? "H" : "F"; // 'H' for hungry, 'F' for full
    }
}
