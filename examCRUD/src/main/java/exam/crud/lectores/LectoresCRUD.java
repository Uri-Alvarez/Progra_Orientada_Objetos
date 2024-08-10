package exam.crud.lectores;

import java.sql.*;

public class LectoresCRUD {
    private Connection conn;

    public LectoresCRUD(Connection conn) {
        this.conn = conn;
    }

    // Create
    public void createLector(String nombreLector) throws SQLException {
        String sql = "INSERT INTO Lectores (NombreLector) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreLector);
            stmt.executeUpdate();
        }
    }

    // Read
    public void readLectores() throws SQLException {
        String sql = "SELECT * FROM Lectores";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("NombreLector: " + rs.getString("NombreLector"));
                System.out.println("----");
            }
        }
    }

    // Update
    public void updateLector(String nombreLector, String nuevoNombreLector) throws SQLException {
        String sql = "UPDATE Lectores SET NombreLector = ? WHERE NombreLector = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nuevoNombreLector);
            stmt.setString(2, nombreLector);
            stmt.executeUpdate();
        }
    }

    // Delete
    public void deleteLector(String nombreLector) throws SQLException {
        String sql = "DELETE FROM Lectores WHERE NombreLector = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreLector);
            stmt.executeUpdate();
        }
    }
}
