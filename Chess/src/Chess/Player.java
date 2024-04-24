
package Chess;

public class Player {
    private String name;
    private boolean isWhite; // True if the player plays with the white pieces, false for the black pieces

    // Constructor
    public Player(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }

    // Getters
    public String getNombre() {
        return name;
    }

    public boolean esBlanco() {
        return isWhite;
    }

    // Setters
    public void setNombre(String name) {
        this.name = name;
    }

    public void setEsBlanco(boolean isWhite) {
        this.isWhite = isWhite;
    }

    // Optional method to print player details
    @Override
    public String toString() {
        return "Player: " + name + (isWhite ? " [White]" : " [Black]");
    }
}
