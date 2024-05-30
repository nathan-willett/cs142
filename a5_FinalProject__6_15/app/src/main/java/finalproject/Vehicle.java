package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public abstract class Vehicle {
    private Cell currentCell;
    private Color color;
    private int currentPosition;

    public Vehicle(Cell initialCell, Color color) {
        this.currentCell = initialCell;
        this.color = color;
        this.currentPosition = 0; // Initial position on the track
    }

    public void move(Cell newCell) {
        this.currentCell = newCell;
    }

    public void update(Track track) {
        currentPosition = (currentPosition + 1) % track.getTrackCells().size(); // Move to the next cell
        move(track.getTrackCells().get(currentPosition));
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public Color getColor() {
        return color;
    }
}
