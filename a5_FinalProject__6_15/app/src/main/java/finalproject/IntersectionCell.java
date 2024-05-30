package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public class IntersectionCell extends Cell {
    private int timing;
    private boolean lightGreen;

    public IntersectionCell(int x, int y, Color color, int timing) {
        super(x, y, color);
        this.timing = timing;
        this.lightGreen = true;
    }

    public void setTiming(int timing) {
        this.timing = timing;
    }

    public void changeLight() {
        lightGreen = !lightGreen;
    }

    public boolean isLightGreen() {
        return lightGreen;
    }

    @Override
    public void update() {
        // Logic to change light state based on timing
    }

    @Override
    public Color getColor() {
        return lightGreen ? Color.GREEN : Color.RED;
    }
}
