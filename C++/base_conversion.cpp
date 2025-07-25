#include <iostream>


// Function to convert a decimal number to binary
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


// Function to convert a binary number to decimal
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


// Function to convert a decimal number to octal
int decimal_to_octal(int decimal) {
    int octal = 0;
    int position = 1;
    
    while (decimal > 0) {
        int remainder = decimal % 8;
        decimal /= 8;
        
        octal += remainder * position;
        position *= 10;
    }
    
    return octal;
}




int main() {
    std::cout << "Decimal\t\tBinary\t\tOctal\n";
    
    for (int i = 0; i <= 10; i++) {
        std::cout << i << "\t\t" 
            << decimal_to_binary(i) << "\t\t" 
            << decimal_to_octal(i) << "\n";
    }
    

    return 0;
}