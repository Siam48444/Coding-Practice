public class MainPet {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet("Tom");
        
        pet1.feed();
        pet1.play();
        pet1.status();
    }
}