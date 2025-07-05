public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
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
        
        printSolvedBoard(board);
    }


    // Method to print a formatted Sudoku board
    public static void printBoard(int[][] board) {
        // Strings for drawing the grid
        String horizontalLine = "-------------------------";
        String verticalLine = "|";
        String emptyCell = " ";

        // Loop through each row
        for (int row = 0; row < board.length; row++) {
            // Print horizontal line every 3 rows
            if (row % 3 == 0) {
                System.out.println(horizontalLine);
            }

            // Loop through each column in the row
            for (int col = 0; col < board[row].length; col++) {
                // Print vertical divider every 3 columns
                if (col % 3 == 0) {
                    System.out.print(verticalLine + " ");
                }

                // Print "." for empty cells (0), otherwise print the number
                if (board[row][col] == 0) {
                    System.out.print(emptyCell + " ");
                } else {
                    System.out.print(board[row][col] + " ");
                }
            }

            // End of row
            System.out.println(verticalLine);
        }

        // Print final horizontal line
        System.out.println(horizontalLine);
    }


    // Recursive backtracking method to solve the Sudoku board
    public static boolean isSolved(int[][] board, int row, int col) {
        // If we've reached past the last row, the board is solved
        if (row == board.length) {
            return true;
        }

        int newRow = 0;
        int newCol = 0;

        // Move to the next column, or wrap to next row
        if (col != board.length - 1) {
            newRow = row;
            newCol = col + 1;
        }
        else {
            newRow = row + 1;
            newCol = 0;
        }

        // Skip filled cells
        if (board[row][col] != 0) {
            if (isSolved(board, newRow, newCol)) {
                return true;
            }
        }
        else {
            // Try placing numbers 1 through 9
            for (int n = 1; n <= 9; n++) {
                // Check if placing n is valid
                if (isValidNum(board, row, col, n)) {
                    board[row][col] = n;  // Place number

                    // Recurse with next cell
                    if (isSolved(board, newRow, newCol)) {
                        return true;
                    }
                    else {
                        board[row][col] = 0;  // Backtrack
                    }
                }
            }

        }

        // No solution found for this path
        return false;
    }


    // Checks whether placing number n at board[row][col] is valid
    public static boolean isValidNum(int[][] board, int row, int col, int n) {
        // Check the column and row for duplicates
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == n) {
                return false; // Duplicate in column
            }
            if (board[row][i] == n) {
                return false; // Duplicate in row
            }
        }

        // Calculate starting index of the 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check 3x3 subgrid for duplicates
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == n) {
                    return false; // Duplicate in box
                }
            }
        }

        // No conflicts found
        return true;
    }


    // Prints the solved sudoku board (if exists)
    public static void printSolvedBoard(int[][] board) {
        if (isSolved(board, 0, 0)) {
            System.out.println("Solved board:");
            printBoard(board);
        }
        else {
            System.out.println("No solution exists!");
        }
    }
}