
package Chess;

public class Bishop extends Piece {
    public Bishop(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);
    }

    @Override
    //destRow-> 'destination row' and destColumn-> 'destination column'
    public boolean movement(Piece[][] board, int destRow, int destColumn) {
        // The bishop moves diagonally
        return Math.abs(destRow - row) == Math.abs(destColumn - column);
    }
}
