package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

import java.awt.Color;
import java.util.List;

public abstract class Vehicle {
    private Cell currentCell;
    private Color color;
    private int currentPosition;
    private double speed;
    private double maxSpeed;
    private double acceleration;
    private double deceleration;

    public Vehicle(Cell initialCell, Color color, int initialPosition, double maxSpeed, double acceleration, double deceleration) {
        this.currentCell = initialCell;
        this.color = color;
        this.currentPosition = initialPosition; // Set the initial position
        this.speed = maxSpeed; // Start at max speed
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
    }

    public void move(Cell newCell) {
        this.currentCell = newCell;
    }

    public void update(Track track) {
        // Update speed based on the distance to the vehicle in front
        Vehicle vehicleInFront = getVehicleInFront(track);
        if (vehicleInFront != null) {
            double distanceToVehicleInFront = getDistanceToVehicleInFront(vehicleInFront, track);
            if (distanceToVehicleInFront < 5) { // Very close, decelerate more
                double targetSpeed = Math.max(speed - 2 * deceleration, 0); // Smooth deceleration but don't stop
                speed = Math.min(targetSpeed, speed); // Adjust speed smoothly
            } else if (distanceToVehicleInFront < 10) { // Close distance, decelerate less
                double targetSpeed = Math.max(speed - deceleration, 0); // Smooth deceleration but don't stop
                speed = Math.min(targetSpeed, speed); // Adjust speed smoothly
            } else if (distanceToVehicleInFront < 20) { // Moderate distance, maintain speed
                speed = Math.min(speed, maxSpeed);
            } else {
                // Accelerate if there is enough distance
                speed = Math.min(speed + acceleration, maxSpeed);
            }
        } else {
            // Accelerate if there is no vehicle in front within a safe distance
            if (speed < maxSpeed) {
                speed = Math.min(speed + acceleration, maxSpeed);
            }
        }

        // Debug output to track the green car
        if (color.equals(Color.GREEN)) {
            System.out.println("Green car: speed=" + speed + ", currentPosition=" + currentPosition);
        }

        currentPosition = (currentPosition + (int) (speed)) % track.getTrackCells().size(); // Adjusted movement increment
        move(track.getTrackCells().get(currentPosition));
    }

    private Vehicle getVehicleInFront(Track track) {
        List<Vehicle> vehicles = track.getVehicles();
        Vehicle closestVehicle = null;
        int closestDistance = Integer.MAX_VALUE;
        for (Vehicle vehicle : vehicles) {
            if (vehicle != this) {
                int thisPosition = this.currentPosition;
                int otherPosition = vehicle.getCurrentPosition();
                int distance = otherPosition > thisPosition ? otherPosition - thisPosition : otherPosition + track.getTrackCells().size() - thisPosition;
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestVehicle = vehicle;
                }
            }
        }
        return closestVehicle;
    }

    private double getDistanceToVehicleInFront(Vehicle vehicleInFront, Track track) {
        int distance = vehicleInFront.getCurrentPosition() - this.currentPosition;
        if (distance < 0) {
            distance += track.getTrackCells().size();
        }
        return distance;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public Color getColor() {
        return color;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
