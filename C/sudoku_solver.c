#include <stdio.h>


// Method to print a formatted Sudoku board
void print_board(int board[][9]) {
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


// Checks whether placing number n at board[row][col] is valid
int is_valid_num(int board[][9], int row, int col, int n) {
    for (int i = 0; i < 9; i++) {
        if (board[row][i] == n) {
            return 0;
        }
        if (board[i][col] == n) {
            return 0;
        }
    }

    int start_row = (row / 3) * 3;
    int start_col = (col / 3) * 3;
    for (int i = start_row; i < start_row + 3; i++) {
        for (int j = start_col; j < start_col + 3; j++) {
            if (board[i][j] == n) {
                return 0;
            }
        }
    }

    return 1;
}


// Recursive backtracking method to solve the Sudoku board
int is_solved(int board[][9], int row, int col) {
    if (row == 9) return 1;

    int new_row = (col == 8) ? row + 1 : row;
    int new_col = (col == 8) ? 0 : col + 1;

    if (board[row][col] != 0) {
        if (is_solved(board, new_row, new_col)) {
            return 1;
        }
    }
    else {
        for (int n = 1; n <= 9; n++) {
            if (is_valid_num(board, row, col, n)) {
                board[row][col] = n;

                if (is_solved(board, new_row, new_col)) {
                    return 1;
                }
                else {
                    board[row][col] = 0;
                }
            }
        }
    }

    return 0;
}


// Prints the solved sudoku board (if exists)
void print_solved_board(int board[][9]) {
    if (is_solved(board, 0, 0)) {
        printf("Solved:\n");
        print_board(board);
    }
    else {
        printf("No solution exists!\n");
    }
}


int main() {
    int board[][9] = {
        {1, 0, 0, 0, 7, 0, 0, 0, 2},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {5, 0, 0, 0, 9, 0, 0, 0, 6},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {4, 0, 0, 0, 8, 0, 0, 0, 3}
    };

    print_solved_board(board);

    
    return 0;
}
