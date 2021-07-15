public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        System.out.println(this.getClass().getSimpleName() + " " + this.versionNumber + " says " + this.ringTone);
        return this.getRingTone();
    }
    @Override
    public String unlock() {
        System.out.println("Unlocking via facial recognition");
        return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
        System.out.println(this.getClass().getSimpleName() + " " + this.versionNumber + " from " + this.carrier);
    }
}