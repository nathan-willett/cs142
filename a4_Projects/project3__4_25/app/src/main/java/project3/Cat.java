import java.awt.*; // for Color
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
        Critter.Direction lastMove = movePattern.get((moveCounter - 1) % movePattern.size()); // get the last move
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
                return "^"; // default to caret
        }
    }
}
