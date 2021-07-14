public class Bat extends Mammal {
	public Bat() {
		super();
        energyLevel = 300;
	}
	public void fly() {
		System.out.println(this.getClass().getSimpleName() + " " + "is taking flight");
		energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println(this.getClass().getSimpleName() + " " + "is eating a human");
		energyLevel += 25;
	}
	public void attackTown() {
		System.out.println(this.getClass().getSimpleName() + " " + "is attacking a town");
		energyLevel -= 100;
	}
	

}