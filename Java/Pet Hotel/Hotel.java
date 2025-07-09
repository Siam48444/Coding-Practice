import java.util.ArrayList;


public class Hotel {
    private ArrayList<Pet> pets = new ArrayList<>();


    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePetByName(String name) {
        pets.removeIf(p -> p.getName().equals(name));
    }

    public void removeAllPets() {
        pets.clear();
    }

    public void feedAllPets() {
        for (Pet p : pets) {
            p.feed();
        }
    }

    public void feedPetByName(String name) {
        for (Pet p : pets) {
            if (p.getName().equals(name)) {
                p.feed();
            }
            return;
        }
    }

    public void playWithAllPets() {
        for (Pet p : pets) {
            p.play();
        }
    }

    public void playWithPetByName(String name) {
        for (Pet p : pets) {
            if (p.getName().equals(name)) {
                p.play();
            }
            return;
        }
    }

    public void showAllPets() {
        for (Pet p : pets) {
            System.out.println(p);
        }
    }
}