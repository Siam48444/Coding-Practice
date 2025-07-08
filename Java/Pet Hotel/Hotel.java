import java.util.ArrayList;


public class Hotel {
    private ArrayList<Pet> pets = new ArrayList<>();


    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePetByName(Pet name) {
        pets.removeIf(p -> p.getName().equals(name));
    }
}