public class Gorilla extends Mammal {
	public Gorilla() {
        super();
	}
	public void throwSomething() {
		System.out.println(this.getClass().getSimpleName() + " is throwing something here");
		this.energyLevel -= 5;
	}
	public void eatBanana() {
		System.out.println(this.getClass().getSimpleName() + " is eating bananas");
		this.energyLevel += 10;
	}
	public void climb() {
		System.out.println(this.getClass().getSimpleName() + " is climbing a tree");
		this.energyLevel -= 10;
	}
}
