import java.awt.*;
import java.util.Random;

/**
 * Class: Salmon
 * 
 * Represents a Salmon critter in a simulation environment. The Salmon has specific behaviors 
 * related to eating, fighting, movement, and its representation as a string. Its behavior 
 * can change based on the number of moves and its hunger state.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class Salmon extends Critter {
    private Random random; // Random number generator for choosing directions
    private int moveCounter; // Tracks the number of moves
    private boolean isHungry; // Indicates whether the Salmon is hungry

    /**
     * Constructs a Salmon with an initial state.
     */
    public Salmon() {
        this.random = new Random(); // Initialize the random generator
        this.moveCounter = 0; // Start with zero moves
        this.isHungry = true; // Salmon begins in a hungry state
    }

    /**
     * Determines whether the Salmon will eat.
     *
     * @return true if the Salmon eats, otherwise false.
     */
    @Override
    public boolean eat() {
        if (moveCounter % 3 == 0) { // Hungry every third move
            isHungry = !isHungry; // Toggle hunger state
            return true; // Salmon eats
        }
        return false; // Otherwise, doesn't eat
    }

    /**
     * Defines the Salmon's fighting strategy based on the opponent.
     *
     * @param opponent The string representation of the opponent.
     * @return ROAR for Aardvark, SCRATCH for Stone, POUNCE for others.
     */
    @Override
    public Critter.Attack fight(String opponent) {
        switch (opponent) {
            case "%": // Against Aardvark
                return Critter.Attack.ROAR;
            case "S": // Against Stone
                return Critter.Attack.SCRATCH;
            default: // All other opponents
                return Critter.Attack.POUNCE;
        }
    }

    /**
     * Specifies the color of the Salmon based on move count.
     *
     * @return BLUE or GREEN depending on the moveCounter.
     */
    @Override
    public Color getColor() {
        // Alternate between blue and green
        return (moveCounter % 2 == 0) ? Color.BLUE : Color.GREEN;
    }

    /**
     * Determines the Salmon's movement pattern.
     *
     * @return The direction for the Salmon's movement.
     */
    @Override
    public Critter.Direction getMove() {
        // If moveCounter is a multiple of 5, choose a new random direction
        if (moveCounter % 5 == 0) {
            return randomDirection(); // Move in a new random direction
        }

        // Otherwise, follow a predefined pattern: East, South, West, North
        int index = (moveCounter / 5) % 4; // Determine the pattern index
        switch (index) {
            case 0:
                return Critter.Direction.EAST;
            case 1:
                return Critter.Direction.SOUTH;
            case 2:
                return Critter.Direction.WEST;
            case 3:
                return Critter.Direction.NORTH;
            default:
                return Critter.Direction.NORTH; // Default fallback
        }
    }

    /**
     * Chooses a random movement direction for the Salmon.
     *
     * @return A random direction (NORTH, SOUTH, EAST, or WEST).
     */
    private Critter.Direction randomDirection() {
        Critter.Direction[] directions = {
            Critter.Direction.NORTH,
            Critter.Direction.SOUTH,
            Critter.Direction.EAST,
            Critter.Direction.WEST
        };
    
        int randomIndex = random.nextInt(directions.length); // Get a random index
        return directions[randomIndex]; // Return the direction at that index
    }

    /**
     * Represents the Salmon as a character indicating its hunger state.
     *
     * @return 'H' if hungry, 'F' if full.
     */
    @Override
    public String toString() {
        return isHungry ? "H" : "F"; // Display based on hunger state
    }
}
