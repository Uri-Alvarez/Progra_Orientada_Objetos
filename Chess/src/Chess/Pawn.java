
package Chess;

public class Pawn extends Piece {
    public Pawn(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    //destRow-> 'destination row' and destColumn-> 'destination column'
    public boolean movement(Piece[][] board, int destRow, int destColumn) {
        // The pawn moves forward one square, two squares from its initial position, and captures diagonally
        int direction = isWhite ? 1 : -1;
        int iniritalRow = isWhite ? 1 : 6;
        boolean simpleMovement = (destRow - row == direction) && column == destColumn;
        boolean diagonalCapture = (destRow - row == direction) && Math.abs(destColumn - column) == 1;
        boolean initialMovement = (row == iniritalRow) && (destRow - row == 2 * direction) && column == destColumn;
        return simpleMovement || diagonalCapture || initialMovement;
    }
}

