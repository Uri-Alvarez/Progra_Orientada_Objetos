package com.crud.courses;

import com.DBconection.ConexionMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesCRUD {

    private Connection connection;

    public CoursesCRUD() {
        this.connection = ConexionMariaDB.getConnection();
    }

    // Create
    public void insertarCourse(String name, int instructorId) {
        String sql = "INSERT INTO Courses (Name, Instructor_Id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, instructorId);
            statement.executeUpdate();
            System.out.println("Curso insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar curso.");
            e.printStackTrace();
        }
    }

    // Read
    public List<String> leerCourses() {
        List<String> courses = new ArrayList<>();
        String sql = "SELECT Id, Name, Instructor_Id FROM Courses";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                int instructorId = resultSet.getInt("Instructor_Id");
                courses.add("ID: " + id + ", Name: " + name + ", Instructor ID: " + instructorId);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer cursos.");
            e.printStackTrace();
        }
        return courses;
    }

    // Update
    public void actualizarCourse(int id, String nuevoNombre, int nuevoInstructorId) {
        String sql = "UPDATE Courses SET Name = ?, Instructor_Id = ? WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setInt(2, nuevoInstructorId);
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Curso actualizado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar curso.");
            e.printStackTrace();
        }
    }

    // Delete
    public void eliminarCourse(int id) {
        String sql = "DELETE FROM Courses WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Curso eliminado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar curso.");
            e.printStackTrace();
        }
    }
}
