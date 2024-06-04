package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public class IntersectionCell extends Cell {
    private int timer;
    private TrafficSignalState currentState;
    private int greenDuration;
    private int yellowDuration;
    private int redDuration;

    public IntersectionCell(int x, int y, int greenDuration, int yellowDuration, int redDuration) {
        super(x, y, Color.GREEN); // Initial color is green
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        this.redDuration = redDuration;
        this.timer = greenDuration; // Start with green duration
        this.currentState = TrafficSignalState.GREEN;
    }

    @Override
    public void update() {
        timer--;
        if (timer <= 0) {
            if (currentState == TrafficSignalState.GREEN) {
                currentState = TrafficSignalState.YELLOW;
                timer = yellowDuration;
                setColor(Color.YELLOW);
            } else if (currentState == TrafficSignalState.YELLOW) {
                currentState = TrafficSignalState.RED;
                timer = redDuration;
                setColor(Color.RED);
            } else if (currentState == TrafficSignalState.RED) {
                currentState = TrafficSignalState.GREEN;
                timer = greenDuration;
                setColor(Color.GREEN);
            }
        }
    }

    private enum TrafficSignalState {
        GREEN, YELLOW, RED
    }
}
