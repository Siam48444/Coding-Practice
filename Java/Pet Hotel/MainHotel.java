class MainHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Pet p1 = new Pet("Whiskers", "Cat");
        Pet p2 = new Pet("Buddy", "Dog");

        hotel.addPet(p1);
        hotel.addPet(p2);

        hotel.feedAllPets();
        hotel.playWithPetByName("Buddy");

        hotel.removePetByName("Whiskers");
        hotel.showAllPets();
    }
}