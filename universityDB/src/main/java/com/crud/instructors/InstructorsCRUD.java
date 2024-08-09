package com.crud.instructors;

import com.DBconection.ConexionMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorsCRUD {

    private Connection connection;

    public InstructorsCRUD() {
        this.connection = ConexionMariaDB.getConnection();
    }

    // Create
    public void insertarInstructor(String name, String location) {
        String sql = "INSERT INTO Instructors (Name, Location) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, location);
            statement.executeUpdate();
            System.out.println("Instructor insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar instructor.");
            e.printStackTrace();
        }
    }

    // Read
    public List<String> leerInstructors() {
        List<String> instructors = new ArrayList<>();
        String sql = "SELECT Id, Name, Location FROM Instructors";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String location = resultSet.getString("Location");
                instructors.add("ID: " + id + ", Name: " + name + ", Location: " + location);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer instructores.");
            e.printStackTrace();
        }
        return instructors;
    }

    // Update
    public void actualizarInstructor(int id, String nuevoNombre, String nuevaUbicacion) {
        String sql = "UPDATE Instructors SET Name = ?, Location = ? WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevaUbicacion);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Instructor actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar instructor.");
            e.printStackTrace();
        }
    }

    // Delete
    public void eliminarInstructor(int id) {
        String sql = "DELETE FROM Instructors WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Instructor eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar instructor.");
            e.printStackTrace();
        }
    }
}
