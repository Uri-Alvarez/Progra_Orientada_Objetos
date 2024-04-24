
package Chess;

public class King extends Piece {
    public King(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    //destRow-> 'destination row' and destColumn-> 'destination column'
    public boolean movement(Piece[][] tablero, int destRow, int destColumn) {
        // The king can move one square in any direction
        int difRow = Math.abs(destRow - row);
        int difColumn = Math.abs(destColumn - column);
        return difRow <= 1 && difColumn <= 1;
    }
}
