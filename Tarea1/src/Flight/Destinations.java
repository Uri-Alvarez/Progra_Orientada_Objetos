package Flight;

public enum Destinations {
    GUADALAJARA(200),  // Example distances, you can change these values
    CANCUN(200),
    USA(200),
    LONDON(1000), 
    MONTERREY(100), 
    TIJUANA(100), 
    NEW_YORK(200), 
    PARIS(2500), 
    CDMX(0);

    private final float distance;

    Destinations(float distance) {
        this.distance = distance;
    }

    public float getDistance() {
        return distance;
    }

    public boolean isInternational() {
        return distance > 1000;
    }

    public boolean isPrivate() {
        return distance < 100;
    }
}
