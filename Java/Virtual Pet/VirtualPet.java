public class VirtualPet {
    public String name;
    private int hunger = 0;
    private int happiness = 0;

    VirtualPet(String name) {
        this.name = name;
    }

    public void feed() {
        if (this.hunger > 0) {
            this.hunger -= 1;
        } 
    }

    public void play() {
        if (this.happiness < 10) {
            this.happiness += 1;
        }
    }

    public void passTime() {
        if (this.hunger < 10) {
            this.hunger += 1;
        }
        if (this.happiness > 0) {
            this.happiness -= 1;
        }
    }

    public void status() {
        System.out.printf("Name      : %s\nHunger    : %s\nHappiness : %s\n", this.name, this.hunger, this.happiness);
    }
}