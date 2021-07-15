public abstract class Phone {
    protected String versionNumber;
    protected int batteryPercentage;
    protected String carrier;
    protected String ringTone;

    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }

    public String getVersionNumber() {
        return this.versionNumber;
    }
    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }
    public String getCarrier() {
        return this.carrier;
    }
    public String getRingTone() {
        return this.ringTone;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }
    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public void setRingTone(String ringTone) {
        this.ringTone = ringTone;
    }

    public abstract void displayInfo();
}