package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;

public class Car extends Vehicle {
    public Car(Cell startCell, Color color, int initialPosition, double maxSpeed, double acceleration, double deceleration) {
        super(startCell, color, initialPosition, maxSpeed, acceleration, deceleration);
    }

    @Override
    public void update(Track track) {
        // Update the car's speed (simplified example logic)
        speed = Math.min(speed + acceleration, maxSpeed);

        // Calculate the next position
        int nextPosition = (currentPosition + 1) % track.getTrackCells().size();

        // Check if the next position is occupied by another vehicle
        boolean isNextPositionOccupied = isPositionOccupied(track, nextPosition);
        
        // If the next position is occupied, slow down
        if (isNextPositionOccupied) {
            speed = Math.max(speed - deceleration, 0);
        } else {
            // Move to the next position
            currentPosition = nextPosition;
            move(track.getTrackCells().get(currentPosition));
        }

        // Debug output to track the cars
        System.out.println((color.equals(Color.GREEN) ? "Green car" : "Blue car") + ": speed=" + speed + ", currentPosition=" + currentPosition);
    }

    private boolean isPositionOccupied(Track track, int position) {
        for (Vehicle vehicle : track.getVehicles()) {
            if (vehicle.getCurrentPosition() == position) {
                return true;
            }
        }
        return false;
    }
}
