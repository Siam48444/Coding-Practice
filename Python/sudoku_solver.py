from termcolor import cprint


class Sudoku:
    def __init__(self, board):
        self.board = board
        self.original = [row[:] for row in board]


    def print_board(self, show_heading=True):
        '''Prints the current Sudoku board in a readable 9x9 grid.'''
        if show_heading:
            cprint("The given sudoku puzzle:", "red")

        horizontal_line = "-" * 25
        vertical_line = "|"
        empty_cell = " "
        for (i, row) in enumerate(self.board):
            if i % 3 == 0:
                print(horizontal_line)
            for j, val in enumerate(row):
                if j % 3 == 0:
                    print(vertical_line, end=" ")
                if val == 0:
                    print(empty_cell, end=" ")
                elif self.original[i][j] == 0:
                    cprint(val, "green", end=" ")
                else:
                    print(val, end=" ")
            print(vertical_line)
        print(horizontal_line, "\n")


    def find_empty(self):
        '''Finds the first empty cell in the board and returns its (row, col) position.'''
        for i in range(9):
            for j in range(9):
                if self.board[i][j] == 0:
                    return (i, j)
        return None


    def is_valid(self, row, col, num):
        '''Checks if placing the number `num` at position (row, col) is valid.'''
        # Check rows
        for j in range(9):
            if self.board[row][j] == num:
                return False

        # Check columns
        for i in range(9):
            if self.board[i][col] == num:
                return False

        # Check 3×3 boxes
        box_row = (row // 3) * 3
        box_col = (col // 3) * 3
        for i in range(box_row, box_row + 3):
            for j in range(box_col, box_col + 3):
                if self.board[i][j] == num:
                    return False

        return True


    def is_solved(self):
        '''Recursive backtracking algorithm to try filling the board.
        Returns True if the board can be solved, otherwise False.'''
        empty = self.find_empty()
        if not empty:
            return True

        row, col = empty
        for num in range(1, 10):
            if self.is_valid(row, col, num):
                self.board[row][col] = num

                if self.is_solved():
                    return True

                self.board[row][col] = 0

        return False


    def is_invalid_board(self):
        '''Checks if the initial board has any contradictions.'''
        for i in range(9):
            for j in range(9):
                num = self.board[i][j]
                if num != 0:
                    self.board[i][j] = 0
                    if not self.is_valid(i, j, num):
                        self.board[i][j] = num
                        return False
                    else:
                        self.board[i][j] = num
        return True


    def print_solved_board(self):
        '''Prints the solved sudoku board, if valid and solvable.'''
        if not self.is_invalid_board():
            cprint("Invalid puzzle board.", "red")
            return

        if self.is_solved():
            cprint("The solved puzzle:", "green")
            self.print_board(show_heading=False)
        else:
            cprint("No solution for this puzzle.", "red")
            return





raw_board = [
    [5, 3, 0, 0, 7, 0, 0, 0, 0],
    [6, 0, 0, 1, 9, 5, 0, 0, 0],
    [0, 9, 8, 0, 0, 0, 0, 6, 0],
    [8, 0, 0, 0, 6, 0, 0, 0, 3],
    [4, 0, 0, 8, 0, 3, 0, 0, 1],
    [7, 0, 0, 0, 2, 0, 0, 0, 6],
    [0, 6, 0, 0, 0, 0, 2, 8, 0],
    [0, 0, 0, 4, 1, 9, 0, 0, 5],
    [0, 0, 0, 0, 8, 0, 0, 7, 9],
]

board = Sudoku(raw_board)

board.print_board()
board.print_solved_board()