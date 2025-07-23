#include <iostream>



// Function to convert a decimal number to binary (as an int)
int decimal_to_binary(int decimal) {
    int binary = 0;
    int position = 1;

    while (decimal > 0) {
        int remainder = decimal % 2;
        decimal /= 2;

        binary += remainder * position;
        position *= 10;
    }

    return binary;
}


int binary_to_decimal(int binary) {
    int decimal = 0;
    int power = 1;
    
    while (binary > 0) {
        int remainder = binary % 2;
        binary /= 10;

        decimal += remainder * power;
        power *= 2;
    }

    return decimal;
}


int main() {
    for (int i = 0; i <= 10; i++) {
        std::cout << i << "  -->  " << decimal_to_binary(i) << "\n";
    }

    return 0;
}