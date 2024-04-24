
package Chess;

public class Board {
    private Piece[][] board;

    // Constructor to initialize the board with all empty spaces
    public Board() {
        board = new Piece[8][8];  // A chess board has 8x8 squares
        initialize();
    }

    // Method to place all pieces in their initial positions
    public void initialize() {
        // Place pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i, true);  // White Pawn
            board[6][i] = new Pawn(6, i, false); // Black Pawn
        }

        // Place towers
        board[0][0] = new Tower(0, 0, true);
        board[0][7] = new Tower(0, 7, true);
        board[7][0] = new Tower(7, 0, false);
        board[7][7] = new Tower(7, 7, false);

        // Place horses
        board[0][1] = new Horse(0, 1, true);
        board[0][6] = new Horse(0, 6, true);
        board[7][1] = new Horse(7, 1, false);
        board[7][6] = new Horse(7, 6, false);

        // Place bishops
        board[0][2] = new Bishop(0, 2, true);
        board[0][5] = new Bishop(0, 5, true);
        board[7][2] = new Bishop(7, 2, false);
        board[7][5] = new Bishop(7, 5, false);

        // Place kings and queens
        board[0][3] = new Queen(0, 3, true);
        board[0][4] = new King(0, 4, true);
        board[7][3] = new Queen(7, 3, false);
        board[7][4] = new King(7, 4, false);
    }

    // Method to display the dashboard in the console
    public void showBoard() {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (board[row][column] != null) {
                    System.out.print("| " + board[row][column] + "|");
                } else {
                    System.out.print("| Empty |");
                }
            }
            System.out.println();  // New line at the end of each row
        }
    }

    // Method to move a piece on the board
    public boolean movePiece(int originRow, int originColumn, int destRow, int destColumn) {
        if (board[originRow][originColumn] != null &&
            board[originRow][originColumn].movement(board, destRow, destColumn)) {
            board[destRow][destColumn] = board[originRow][originColumn];
            board[originRow][originColumn] = null;
            board[destRow][destColumn].setRow(destRow);
            board[destRow][destColumn].setColumn(destColumn);
            return true;
        }
        return false;
    }
}
