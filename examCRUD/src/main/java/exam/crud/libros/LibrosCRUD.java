package exam.crud.libros;

import java.sql.*;

public class LibrosCRUD {
    private Connection conn;

    public LibrosCRUD(Connection conn) {
        this.conn = conn;
    }

    // Create
    public void createLibro(int codLibro, String titulo, String autor, String editorial) throws SQLException {
        String sql = "INSERT INTO Libros (CodLibro, Titulo, Autor, Editorial) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codLibro);
            stmt.setString(2, titulo);
            stmt.setString(3, autor);
            stmt.setString(4, editorial);
            stmt.executeUpdate();
        }
    }

    // Read
    public void readLibros() throws SQLException {
        String sql = "SELECT * FROM Libros";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("CodLibro: " + rs.getInt("CodLibro"));
                System.out.println("Titulo: " + rs.getString("Titulo"));
                System.out.println("Autor: " + rs.getString("Autor"));
                System.out.println("Editorial: " + rs.getString("Editorial"));
                System.out.println("----");
            }
        }
    }

    // Update
    public void updateLibro(int codLibro, String nuevoTitulo) throws SQLException {
        String sql = "UPDATE Libros SET Titulo = ? WHERE CodLibro = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoTitulo);
            stmt.setInt(2, codLibro);
            stmt.executeUpdate();
        }
    }

    // Delete
    public void deleteLibro(int codLibro) throws SQLException {
        String sql = "DELETE FROM Libros WHERE CodLibro = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codLibro);
            stmt.executeUpdate();
        }
    }
}
