import java.awt.*;
import java.util.ArrayList;

/**
 * Class: Tiger
 * 
 * Represents a Tiger critter in a simulation environment. The Tiger has a predefined movement pattern,
 * fighting strategy, and eating behavior. It moves in a clockwise square pattern and adjusts its hunger state
 * based on certain conditions.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class Tiger extends Critter {
    private int moveCounter; // Tracks the current move count
    private boolean isHungry; // Indicates whether the Tiger is hungry
    private ArrayList<Critter.Direction> movePattern; // Predefined movement pattern

    // Constructs a Tiger with a predefined movement pattern and hunger state.
    public Tiger() {
        this.moveCounter = 0; // Initialize the move counter
        this.isHungry = true; // Tiger starts in a hungry state
        this.movePattern = new ArrayList<>(); // Initialize the move pattern
        
        // Define the pattern for clockwise square movement
        for (Critter.Direction direction : new Critter.Direction[]{
            Critter.Direction.NORTH,
            Critter.Direction.EAST,
            Critter.Direction.SOUTH,
            Critter.Direction.WEST
        }) {
            for (int i = 0; i < 3; i++) { // Add each direction three times
                movePattern.add(direction); 
            }
        }
    }

    /**
     * Determines whether the Tiger will eat.
     *
     * @return true if the Tiger is hungry, otherwise false.
     */
    @Override
    public boolean eat() {
        if (isHungry) { // Only eats if hungry
            isHungry = false; // Become non-hungry after eating
            return true; // Indicates that the Tiger eats
        }
        return false; // Otherwise, doesn't eat
    }

    /**
     * Defines the Tiger's fighting strategy based on the opponent.
     *
     * @param opponent The representation of the opponent.
     * @return ROAR for Aardvark, POUNCE for others.
     */
    @Override
    public Critter.Attack fight(String opponent) {
        isHungry = true; // After a fight, the Tiger becomes hungry again
        if (opponent.equals("%")) { // If the opponent is Aardvark
            return Critter.Attack.ROAR; // Roar attack
        }
        return Critter.Attack.POUNCE; // Pounce for other opponents
    }

    /**
     * Returns the color of the Tiger.
     *
     * @return BLACK to represent the Tiger.
     */
    @Override
    public Color getColor() {
        return Color.BLACK; // The Tiger is black
    }

    /**
     * Determines the Tiger's movement based on its predefined pattern.
     *
     * @return The direction for the Tiger's movement.
     */
    @Override
    public Critter.Direction getMove() {
        // Get the direction based on the current move counter
        Critter.Direction move = movePattern.get(moveCounter % movePattern.size());
        moveCounter++; // Increment the move counter after getting the move
        return move; // Return the selected movement direction
    }

    /**
     * Represents the Tiger as a character, indicating its last move direction.
     *
     * @return Character representing the last move.
     */
    @Override
    public String toString() {
        int index = (moveCounter - 1) % movePattern.size(); // Get the last move index
        
        // Ensure the index is within valid bounds
        if (index < 0 || index >= movePattern.size()) {
            return "?"; // Default symbol if index is invalid
        }

        Critter.Direction lastMove = movePattern.get(index); // Get the last move direction

        switch (lastMove) {
            case NORTH:
                return "^";
            case EAST:
                return ">";
            case SOUTH:
                return "V";
            case WEST:
                return "<";
            default:
                return "^"; // Fallback in case of unexpected behavior
        }
    }
}
