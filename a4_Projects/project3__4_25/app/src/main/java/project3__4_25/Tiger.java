import java.awt.*;
import java.util.ArrayList;

public class Tiger extends Critter {
    private int moveCounter; // tracks the current move
    private boolean isHungry; // whether the Tiger is hungry
    private ArrayList<Critter.Direction> movePattern; // pattern for movement

    public Tiger() {
        this.moveCounter = 0; // initialize move counter
        this.isHungry = true; // Tiger starts hungry
        this.movePattern = new ArrayList<>(); // initialize move pattern
        // Define the clockwise square pattern
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
        if (isHungry) { // if the Tiger is hungry
            isHungry = false; // become non-hungry after eating
            return true; // eats
        }
        return false; // otherwise, doesn't eat
    }

    @Override
    public Critter.Attack fight(String opponent) {
        isHungry = true; // after a fight, becomes hungry again
        if (opponent.equals("%")) { // if opponent is Aardvark
            return Critter.Attack.ROAR;
        }
        return Critter.Attack.POUNCE; // otherwise, pounces
    }

    @Override
    public Color getColor() {
        return Color.BLACK; // Tiger is black
    }

    @Override
    public Critter.Direction getMove() {
        Critter.Direction move = movePattern.get(moveCounter % movePattern.size()); // current move
        moveCounter++; // increment move counter
        return move;
    }

    @Override
    public String toString() {
        int index = (moveCounter - 1) % movePattern.size();
        
        // Ensure the index is within bounds
        if (index < 0 || index >= movePattern.size()) {
            return "?"; // return a default symbol if index is invalid
        }
        
        Critter.Direction lastMove = movePattern.get(index); // safe index access
        
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
                return "^"; // fallback in case of unexpected behavior
        }
    }
}
