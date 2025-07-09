public class Pet {
    private String name;
    private String type;
    private int hunger = 5;
    private int happiness = 5;

    Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Get the pet's name
    public String getName() {
        return this.name;
    }

    // Return the pet's type
    public String getType() {
        return this.type;
    }

    // Return current hunger level
    public int getHunger() {
        return this.hunger;
    }

    // Return current happiness level
    public int getHappiness() {
        return this.happiness;
    }

    // Feed the pet to reduce hunger by 1 (not below 0)
    public void feed() {
        if (this.hunger > 0) this.hunger--;
    }

    // Play with the pet to increase happiness by 1 (up to 10)
    public void play() {
        if (this.happiness < 10) this.happiness++;
    }

    // Return a formatted status string of the pet's details
    public String toString() {
        String line = "---------------------";
        return 
            String.format("%s\nName      : %s\nType      : %s\nHunger    : %d\nHappiness : %d\n%s", 
            line, this.name, this.type, this.hunger, this.happiness, line);
    }
}
