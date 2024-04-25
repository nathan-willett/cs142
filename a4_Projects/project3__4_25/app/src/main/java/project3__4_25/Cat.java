import java.awt.*;
import java.util.ArrayList;

public class Cat extends Critter {
    private int moveCounter; // keeps track of the current move
    private ArrayList<Critter.Direction> movePattern; // the predefined pattern of moves

    public Cat() {
        this.moveCounter = 0; // starts at the beginning of the move pattern
        this.movePattern = new ArrayList<>(); // initialize the move pattern
        // Define the pattern for the clockwise square movement
        for (int i = 0; i < 3; i++) {
            movePattern.add(Critter.Direction.NORTH);
        }
        for (int i = 0; i < 3; i++) {
            movePattern.add(Critter.Direction.EAST);
        }
        for (int i = 0; i < 3; i++) {
            movePattern.add(Critter.Direction.SOUTH);
        }
        for (int i = 0; i < 3; i++) {
            movePattern.add(Critter.Direction.WEST);
        }
    }

    @Override
    public boolean eat() {
        return false; // cat never eats
    }

    @Override
    public Critter.Attack fight(String opponent) {
        if (opponent.equals("%")) { // if opponent is Aardvark
            return Critter.Attack.ROAR;
        }
        return Critter.Attack.POUNCE; // otherwise, pounces
    }

    @Override
    public Color getColor() {
        return Color.BLUE; // blue color
    }

    @Override
    public Critter.Direction getMove() {
        Critter.Direction move = movePattern.get(moveCounter % movePattern.size()); // current move
        moveCounter++; // increment move counter
        return move;
    }

    @Override
    public String toString() {
        if (movePattern == null || movePattern.isEmpty()) {
            return "?"; // default if there's no pattern
        }

        int index = (moveCounter - 1) % movePattern.size();
        if (index < 0 || index >= movePattern.size()) {
            return "?"; // default if index is invalid
        }

        Critter.Direction lastMove = movePattern.get(index); // safe access to index

        switch (lastMove) {
            case NORTH:
                return "^"; // caret for north
            case EAST:
                return ">"; // greater-than for east
            case SOUTH:
                return "V"; // uppercase 'V' for south
            case WEST:
                return "<"; // less-than for west
            default:
                return "?"; // fallback in case of unexpected behavior
        }
    }
}