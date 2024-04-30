import java.awt.*;
import java.util.ArrayList;

/**
 * Class: Cat
 * 
 * Represents a Cat critter in a simulation environment with predefined movement
 * patterns and behaviors. The Cat moves in a clockwise square pattern and has
 * specific
 * fighting strategies based on the opponent.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class Cat extends Critter {
    private int moveCounter; // Keeps track of the current move count
    private ArrayList<Critter.Direction> movePattern; // Predefined movement pattern

    /**
     * Initializes a new Cat with a specific clockwise square move pattern.
     */
    public Cat() {
        moveCounter = 0; // Reset the move counter
        movePattern = new ArrayList<>(); // Initialize the move pattern

        // Add the pattern for clockwise square movement
        for (Critter.Direction direction : new Critter.Direction[] {
                Critter.Direction.NORTH,
                Critter.Direction.EAST,
                Critter.Direction.SOUTH,
                Critter.Direction.WEST
        }) {
            for (int i = 0; i < 3; i++) {
                movePattern.add(direction); // Add each direction three times
            }
        }
    }

    /**
     * The Cat does not eat.
     *
     * @return false.
     */
    @Override
    public boolean eat() {
        return false;
    }

    /**
     * Defines the Cat's fighting strategy based on the opponent.
     *
     * @param opponent The representation of the opponent.
     * @return ROAR if opponent is an Aardvark, otherwise POUNCE.
     */
    @Override
    public Critter.Attack fight(String opponent) {
        return opponent.equals("%") ? Critter.Attack.ROAR : Critter.Attack.POUNCE;
    }

    /**
     * Specifies the color of the Cat.
     *
     * @return Blue.
     */
    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    /**
     * Determines the Cat's movement based on its pattern and move counter.
     *
     * @return The next direction for movement.
     */
    @Override
    public Critter.Direction getMove() {
        Critter.Direction move = movePattern.get(moveCounter % movePattern.size()); // Get the current move
        moveCounter++; // Increment the move counter
        return move;
    }

    /**
     * Represents the Cat as a character, indicating its last move direction.
     *
     * @return Character representing the last move.
     */
    @Override
    public String toString() {
        if (movePattern == null || movePattern.isEmpty()) {
            return "?"; // Default if no pattern
        }

        int index = (moveCounter - 1) % movePattern.size(); // Get the last move index
        if (index < 0 || index >= movePattern.size()) {
            return "?"; // Default if invalid index
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
                return "?"; // Default fallback
        }
    }
}
