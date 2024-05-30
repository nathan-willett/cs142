package a5_FinalProject__6_15.app.src.main.java.finalproject; // comment out before submitting

public class TrafficSimulation {
    private Track track;
    private int vehicleSpeed;
    private int trafficLightTiming;

    public TrafficSimulation(int trackLength) {
        track = new Track(trackLength);
    }

    public void start() {
        // Logic to start the simulation
    }

    public void pause() {
        // Logic to pause the simulation
    }

    public void reset() {
        // Logic to reset the simulation
    }

    public void update() {
        track.updateTrack();
    }

    public void setVehicleSpeed(int speed) {
        this.vehicleSpeed = speed;
    }

    public void setTrafficLightTiming(int timing) {
        this.trafficLightTiming = timing;
    }

    public Track getTrack() {
        return track;
    }

    public int getVehicleSpeed() {
        return vehicleSpeed;
    }
}
