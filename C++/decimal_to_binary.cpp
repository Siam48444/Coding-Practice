#include <iostream>


int decimal_to_binary(int dec) {
    int bin = 0;
    int place = 1;

    while (dec > 0) {
        int rem = dec % 2;
        dec /= 2;
        bin += rem * place;
        place *= 10;
    }

    return bin;
}

int main() {
    for (int i = 0; i <= 20; i++) {
        std::cout << i << "  -->  " << decimal_to_binary(i) << "\n";
    }


    return 0;
}