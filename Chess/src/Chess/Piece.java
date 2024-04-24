
package Chess;

public abstract class Piece {
    protected int row;//filas
    protected int column;
    protected boolean isWhite;

    // Constructor to initialize the part
    public Piece(int row, int column, boolean isWhite) {
        this.row = row;
        this.column = column;
        this.isWhite = isWhite;
    }

    // Getters y Setters
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setEsBlanca(boolean isWhite) {
        this.isWhite = isWhite;
    }

    // Abstract method to move the piece
    //destRow-> 'destination row' and destColumn-> 'destination column'
    public abstract boolean movement(Piece[][] board, int destRow, int destColumn);

    // Optional method to print the part
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + (isWhite ? " White" : " Black") + " is in " + "(" + row + "," + column + ")";
    }
}
