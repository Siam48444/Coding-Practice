public class VirtualPet {
    private String name;
    private int hunger = 0;
    private int happiness = 0;

    VirtualPet(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getHappiness() {
        return this.happiness;
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
        String line = "--------------------";
        System.out.println(line);
        System.out.println("    Pet Status");
        System.out.println(line);
        System.out.println("Name      : " + this.name);
        System.out.println("Hunger    : " + this.hunger);
        System.out.println("Happiness : " + this.happiness);
        System.out.println(line);
    }
}