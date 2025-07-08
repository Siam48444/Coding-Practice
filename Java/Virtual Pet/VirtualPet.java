public class VirtualPet {
    public String name;
    private int hunger = 0;
    private int happiness = 0;

    VirtualPet(String name) {
        this.name = name;
    }

    public void feed() {
        this.hunger += 1;
    }

    public void play() {
        this.happiness += 1;
    }

    public void status() {
        System.out.printf("Name: %s\nHunger: %s\nHappiness: %s", this.name, this.hunger, this.happiness);
    }
}