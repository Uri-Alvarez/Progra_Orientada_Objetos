
package Chess;

public class Horse extends Piece {
    public Horse(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    //destRow-> 'destination row' and destColumn-> 'destination column'
    public boolean movement(Piece[][] board, int destRow, int destColumn) {
        // The horse has an "L" shaped movement
        int difRow = Math.abs(destRow - row);
        int difColumn = Math.abs(destColumn - column);
        return (difRow == 2 && destColumn == 1) || (difRow == 1 && difColumn == 2);
    }
}
