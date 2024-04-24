import java.awt.*; // for Color

public class Aardvark extends Critter {
    private boolean walkSouth; // to determine the zigzag pattern
    private boolean isSouth; // internal state for alternating moves

    public Aardvark(boolean walkSouth) {
        this.walkSouth = walkSouth;
        this.isSouth = walkSouth; // if true, start with south movement
    }

    @Override
    public boolean eat() {
        return true; // always eats
    }

    @Override
    public Critter.Attack fight(String opponent) {
        return Critter.Attack.SCRATCH; // always scratches
    }

    @Override
    public Color getColor() {
        return Color.RED; // red color
    }

    @Override
    public Critter.Direction getMove() {
        if (isSouth) {
            isSouth = !isSouth; // toggle direction
            return walkSouth ? Critter.Direction.SOUTH : Critter.Direction.NORTH;
        } else {
            isSouth = !isSouth; // toggle direction
            return Critter.Direction.EAST; // always goes east in alternate moves
        }
    }

    @Override
    public String toString() {
        return "%"; // represented by a percent sign
    }
}
