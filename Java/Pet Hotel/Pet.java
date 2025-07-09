public class Pet {
    private String name;
    private String type;
    private int hunger = 5;
    private int happiness = 5;

    Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void feed() {
        if (this.hunger > 0) this.hunger--;
    }

    public void play() {
        if (this.happiness < 10) this.happiness++;
    }

    public String toString() {
        return 
            String.format("Name      : %s\nType      : %s\nHunger    : %d\nHappiness : %d", 
            this.name, this.type, this.hunger, this.happiness);
    }
}