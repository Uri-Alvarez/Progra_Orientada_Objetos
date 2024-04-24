
package Chess;

public class Tower extends Piece {
    public Tower(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
        //destRow-> 'destination row' and destColumn-> 'destination column'
    public boolean movement(Piece[][] board, int destRow, int destColumn) {
        // The tower can move in a straight horizontal or vertical line
        return row == destRow || column == destColumn;
    }
}
