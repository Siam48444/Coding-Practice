import java.util.ArrayList;

public class Hotel {
    // List to store all pets in the hotel
    private ArrayList<Pet> pets = new ArrayList<>();

    // Add a pet to the hotel
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    // Remove a pet from the hotel by its name
    public void removePetByName(String name) {
        pets.removeIf(p -> p.getName().equals(name));
    }

    // Remove all pets from the hotel
    public void removeAllPets() {
        pets.clear();
    }

    // Feed every pet in the hotel
    public void feedAllPets() {
        for (Pet p : pets) {
            p.feed();
        }
    }

    // Feed a specific pet by name
    public void feedPetByName(String name) {
        for (Pet p : pets) {
            if (p.getName().equals(name)) {
                p.feed();
                return;  // Stop searching after feeding the pet
            }
        }
    }

    // Play with every pet in the hotel
    public void playWithAllPets() {
        for (Pet p : pets) {
            p.play();
        }
    }

    // Play with a specific pet by name
    public void playWithPetByName(String name) {
        for (Pet p : pets) {
            if (p.getName().equals(name)) {
                p.play();
                return;  // Stop searching after playing with the pet
            }
        }
    }

    // Display info for all pets in the hotel
    public void showAllPets() {
        for (Pet p : pets) {
            System.out.println(p);
        }
    }
}