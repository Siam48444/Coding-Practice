#include <stdio.h>


void printBoard(int board[][9]) {
    char horizontal_line[] = "-------------------------";
    char vertical_line[] = "|";
    char empty_cell[] = ".";

    for (int row = 0; row < 9; row++) {
        if (row % 3 == 0) {
            printf("%s\n", horizontal_line);
        }
        
        for (int col = 0; col < 9; col++) {
            if (col % 3 == 0) {
                printf("%s ", vertical_line);
            }

            if (board[row][col] == 0) {
                printf("%s ", empty_cell);
            }
            else {
                printf("%d ", board[row][col]);
            }
        }

        printf("%s\n", vertical_line);
    }

    printf("%s\n", horizontal_line);
}


int main() {
    int board[][9] = {
        {1, 0, 0,  0, 7, 0,  0, 0, 2},
        {0, 0, 0,  0, 0, 0,  0, 0, 0},
        {0, 0, 0,  0, 0, 0,  0, 0, 0},

        {0, 0, 0,  0, 0, 0,  0, 0, 0},
        {5, 0, 0,  0, 9, 0,  0, 0, 6},
        {0, 0, 0,  0, 0, 0,  0, 0, 0},

        {0, 0, 0,  0, 0, 0,  0, 0, 0},
        {0, 0, 0,  0, 0, 0,  0, 0, 0},
        {4, 0, 0,  0, 8, 0,  0, 0, 3}
    };

    printBoard(board);

    
    return 0;
}