package com.crud.students;

import com.DBconection.ConexionMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsCRUD {

    private Connection connection;

    public StudentsCRUD() {
        this.connection = ConexionMariaDB.getConnection();
    }

    // Create
    public void insertarStudent(String name, String major) {
        String sql = "INSERT INTO Students (Name, Major) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, major);
            statement.executeUpdate();
            System.out.println("Estudiante insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar estudiante.");
            e.printStackTrace();
        }
    }

    // Read
    public List<String> leerStudents() {
        List<String> students = new ArrayList<>();
        String sql = "SELECT Id, Name, Major FROM Students";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String major = resultSet.getString("Major");
                students.add("ID: " + id + ", Name: " + name + ", Major: " + major);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer estudiantes.");
            e.printStackTrace();
        }
        return students;
    }

    // Update
    public void actualizarStudent(int id, String nuevoNombre, String nuevaCarrera) {
        String sql = "UPDATE Students SET Name = ?, Major = ? WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setString(2, nuevaCarrera);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Estudiante actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar estudiante.");
            e.printStackTrace();
        }
    }

    // Delete
    public void eliminarStudent(int id) {
        String sql = "DELETE FROM Students WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Estudiante eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar estudiante.");
            e.printStackTrace();
        }
    }
}
