package Users;

public enum DistributionPoints {
    OAXACA("OAX", 48.2, 2.50),
    QUINTANA_ROO("QROO", 36.5, 3.70),
    MORELOS("MOR", 18.4, 1.60),
    QUERETARO("QRO", 35.3, 3.00),
    SINALOA("SIN", 48.4, 4.00);

    private final String code;
    private final double arrivalTimeInHours;
    private final double costPerKg;

    // Constructor
    DistributionPoints(String code, double arrivalTimeInHours, double costPerKg) {
        this.code = code;
        this.arrivalTimeInHours = arrivalTimeInHours;
        this.costPerKg = costPerKg;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public double getArrivalTimeInHours() {
        return arrivalTimeInHours;
    }

    public double getCostPerKg() {
        return costPerKg;
    }
}
