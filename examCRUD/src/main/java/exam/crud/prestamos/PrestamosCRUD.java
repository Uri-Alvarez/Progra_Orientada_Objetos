package exam.crud.prestamos;

import java.sql.*;

public class PrestamosCRUD {
    private Connection conn;

    public PrestamosCRUD(Connection conn) {
        this.conn = conn;
    }

    // Create
    public void createPrestamo(int codLibro, String nombreLector, Date fechaDev) throws SQLException {
        String sql = "INSERT INTO Prestamos (CodLibro, NombreLector, FechaDev) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codLibro);
            stmt.setString(2, nombreLector);
            stmt.setDate(3, fechaDev);
            stmt.executeUpdate();
        }
    }

    // Leer
    public void readPrestamos() throws SQLException {
        String sql = "SELECT * FROM Prestamos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("CodLibro: " + rs.getInt("CodLibro"));
                System.out.println("NombreLector: " + rs.getString("NombreLector"));
                System.out.println("FechaDev: " + rs.getDate("FechaDev"));
                System.out.println("----");
            }
        }
    }

    // Update
    public void updatePrestamo(int codLibro, String nombreLector, Date nuevaFechaDev) throws SQLException {
        String sql = "UPDATE Prestamos SET FechaDev = ? WHERE CodLibro = ? AND NombreLector = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, nuevaFechaDev);
            stmt.setInt(2, codLibro);
            stmt.setString(3, nombreLector);
            stmt.executeUpdate();
        }
    }

    // Delete
    public void deletePrestamo(int codLibro, String nombreLector) throws SQLException {
        String sql = "DELETE FROM Prestamos WHERE CodLibro = ? AND NombreLector = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, codLibro);
            stmt.setString(2, nombreLector);
            stmt.executeUpdate();
        }
    }
}
