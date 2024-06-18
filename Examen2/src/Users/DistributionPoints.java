package Users;

public enum DistributionPoints {
    // Destination, arrival time in hours, cost for each kg sent in USD
    OAXACA("OAX", 48.2, 2.50),
    QUINTANAROO("QROO", 36.5, 3.70),
    MORELOS("MOR", 18.4, 1.60),
    QUERETARO("QRO", 35.3, 3.0),
    SINALOA("SIN", 48.4, 4.0);

    // Class attributes
    private final String code;
    private final double arrivalTime;
    private final double costPerKg;

    // Constructor
    DistributionPoints(String code, double arrivalTime, double costPerKg) {
        this.code = code;
        this.arrivalTime = arrivalTime;
        this.costPerKg = costPerKg;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getCostPerKg() {
        return costPerKg;
    }
}
