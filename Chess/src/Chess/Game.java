
package Chess;

public class Game {
    private Board board;
    private boolean whiteTurn; // true if it is white's turn, false for black

    // Constructor
    public Game() {
        board = new Board();
        whiteTurn = true; // White always starts
    }

    // Method to start the game
    public void initialiceGame() {
        while (!isCheckmate() && !isTie()) {
            board.showBoard();
            makeMove();
            whiteTurn = !whiteTurn; // Change shift
        }

        System.out.println("Game Over. " + (whiteTurn ? "Black Win" : "White Win") + " by Checkmate.");
    }

    // Method to perform a movement
    private void makeMove() {
        boolean validMovement = false;
        do { 
            int[] origin = getMotionCoordinates(whiteTurn ? "White" : "Black", "origin");
            int[] destiny = getMotionCoordinates(whiteTurn ? "White" : "Black", "destiny");
            
            if (board.movePiece(origin[0], origin[1], destiny[0], destiny[1])) {
                validMovement = true;
            } else {
                System.out.println("Invalid Movement, Try Again.");
            }
        } while (!validMovement);
    }

    // Method to obtain user input coordinates
    private int[] getMotionCoordinates(String player, String movementType) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("\nTurn of: " + player + ", enter the " + movementType + " row and column (0-7) separated by space:");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new int[]{row, column};
    }

    //Method to check for checkmate
    private boolean isCheckmate() {
        return false;
    }

    // Method to check if the game is a tie
    private boolean isTie() {
        return false; 
    }
}
