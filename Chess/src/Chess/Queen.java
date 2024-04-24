
package Chess;

public class Queen extends Piece {
    public Queen(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    //destRow-> 'destination row' and destColumn-> 'destination column'
    public boolean movement(Piece[][] board, int destRow, int destColumn) {
        //The queen can move in a straight or diagonal line without distance limitation
        return row == destRow || column == destColumn ||
               Math.abs(destRow - row) == Math.abs(destColumn - column);
    }
}
