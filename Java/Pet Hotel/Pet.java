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

    
}