class MainHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Pet p1 = new Pet("Tom", "Cat");
        Pet p2 = new Pet("Garfield", "Cat");

        hotel.addPet(p1);
        hotel.addPet(p2);
    }
}