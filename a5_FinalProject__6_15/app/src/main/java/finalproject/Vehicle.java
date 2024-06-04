package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public abstract class Vehicle {
    protected Cell currentCell;
    protected Color color;
    protected int currentPosition;
    protected double speed;
    protected double maxSpeed;
    protected double acceleration;
    protected double deceleration;

    public Vehicle(Cell startCell, Color color, int initialPosition, double maxSpeed, double acceleration, double deceleration) {
        this.currentCell = startCell;
        this.color = color;
        this.currentPosition = initialPosition;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
        this.speed = 0; // Initial speed
    }

    public abstract void update(Track track);

    public void move(Cell newCell) {
        this.currentCell = newCell;
    }

    public void setCurrentPosition(int position) {
        this.currentPosition = position;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public Color getColor() {
        return color;
    }
}
