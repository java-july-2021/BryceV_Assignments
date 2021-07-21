public class Pokemon {
    protected String name;
    protected int health;
    protected String type;

    static int count = 0;

    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
    }

    public String getPokemonName() {
        return this.name;
    }
    public int getPokemonHealth() {
        return this.health;
    }
    public String getPokemonType() {
        return this.type;
    }

    public void setPokemonName(String name) {
        this.name = name;
    }
    public void setPokemonHealth(int health) {
        this.health = health;
    }
    public void setPokemonType(String type) {
        this.type = type;
    }

    public void attackPokemon(Pokemon pokemon) {
        System.out.println(this.name + " attacks " + pokemon);
        pokemon.health -= 10;
    }

}