package project3__4_25;

import java.awt.*;
import java.util.Random;

/**
 * Class: Koala
 * 
 * Represents a Koala critter in a simulation environment. The Koala has
 * specific behaviors related to eating, fighting, movement, and its 
 * representation as a string. It changes direction randomly after a set 
 * number of steps.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class Koala extends Critter {
    private int hunger; // Determines how many times the Koala will eat
    private int timesEaten; // Tracks how many times the Koala has eaten
    private Critter.Direction currentDirection; // Current movement direction
    private int steps; // Number of steps taken in the current direction
    private Random random; // Random number generator for choosing directions

    /**
     * Constructs a Koala with a specific level of hunger.
     *
     * @param hunger The number of times the Koala will eat before it is no longer
     *               hungry.
     */
    public Koala(int hunger) {
        this.hunger = hunger; // Initialize the Koala's hunger level
        this.timesEaten = 0; // The Koala hasn't eaten yet
        this.random = new Random(); // Initialize the random number generator
        this.currentDirection = randomDirection(); // Choose an initial random direction
        this.steps = 0; // Start with zero steps taken
    }

    /**
     * Chooses a random direction for the Koala to move.
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
        return directions[random.nextInt(directions.length)]; // Randomly select a direction
    }

    /**
     * Determines whether the Koala will eat.
     *
     * @return true if the Koala is still hungry, false otherwise.
     */
    @Override
    public boolean eat() {
        if (timesEaten < hunger) { // Eat only if the Koala is still hungry
            timesEaten++; // Increment the number of times eaten
            return true; // Indicates that the Koala eats
        }
        return false; // Otherwise, it doesn't eat
    }

    /**
     * Defines the Koala's fighting strategy based on its hunger level.
     *
     * @param opponent The string representation of the opponent.
     * @return SCRATCH if the Koala is hungry, POUNCE otherwise.
     */
    @Override
    public Critter.Attack fight(String opponent) {
        if (timesEaten < hunger) { // If the Koala is still hungry
            return Critter.Attack.SCRATCH; // Use SCRATCH attack
        }
        return Critter.Attack.POUNCE; // Otherwise, use POUNCE
    }

    // Specifies the color of the Koala based on its hunger level.
    @Override
    public Color getColor() {
        return (timesEaten < hunger) ? Color.GRAY : Color.WHITE; // Gray when hungry, white when not
    }

    /**
     * Determines the Koala's movement pattern based on steps and current direction.
     *
     * @return The direction in which the Koala will move.
     */
    @Override
    public Critter.Direction getMove() {
        if (++steps >= 5) { // Increment and check if direction change is needed
            currentDirection = randomDirection(); // Choose a new random direction
            steps = 0; // Reset step count
        }
        return currentDirection; // Return the current movement direction
    }

    /**
     * Represents the Koala as a string showing how many times it can still eat.
     *
     * @return The number of times the Koala has left to eat.
     */
    @Override
    public String toString() {
        return "" + (hunger - timesEaten); // Indicates the remaining hunger level
    }
}
