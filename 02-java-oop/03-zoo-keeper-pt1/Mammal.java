public class Mammal {
	protected int energyLevel = 100;
	
	public int displayEnergy() {
		System.out.println("Energy Level: " + this.energyLevel);
		return energyLevel;
	}
	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}