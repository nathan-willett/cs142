package project3__4_25;

import java.awt.*;

/**
 * Class: Aardvark
 * 
 * Represents an Aardvark critter in a simulation environment. The Aardvark has
 * a specific movement pattern and behavior with other critters.
 * 
 * @author Nathan Willett
 * @section 15596
 * @course CS 142, Spring 2024
 */
public class Aardvark extends Critter {
    private boolean walkSouth; // Direction of the zigzag pattern
    private boolean isSouth; // Tracks direction to alternate moves

    /**
     * Initializes a new Aardvark with the specified starting direction.
     *
     * @param walkSouth If true, Aardvark starts south, otherwise north.
     */
    public Aardvark(boolean walkSouth) {
        this.walkSouth = walkSouth;
        this.isSouth = walkSouth;
    }

    /**
     * Aardvark always eats.
     *
     * @return true.
     */
    @Override
    public boolean eat() {
        return true;
    }

    /**
     * Aardvark's fight behavior.
     *
     * @param opponent Opponent's symbol.
     * @return SCRATCH in all cases.
     */
    @Override
    public Critter.Attack fight(String opponent) {
        return Critter.Attack.SCRATCH;
    }

    /**
     * Returns the color of the Aardvark.
     *
     * @return Red.
     */
    @Override
    public Color getColor() {
        return Color.RED;
    }

    /**
     * Determines the Aardvark's move.
     *
     * @return Direction based on alternating pattern.
     */
    @Override
    public Critter.Direction getMove() {
        isSouth = !isSouth; // Toggle direction
        if (isSouth) {
            return walkSouth ? Critter.Direction.SOUTH : Critter.Direction.NORTH;
        } else {
            return Critter.Direction.EAST;
        }
    }

    /**
     * String representation of the Aardvark.
     *
     * @return Percent sign ("%").
     */
    @Override
    public String toString() {
        return "%";
    }
}
