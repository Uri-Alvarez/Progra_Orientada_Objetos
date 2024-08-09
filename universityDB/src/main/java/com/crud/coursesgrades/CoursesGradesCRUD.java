package com.crud.coursesgrades;

import com.DBconection.ConexionMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesGradesCRUD {

    private Connection connection;

    public CoursesGradesCRUD() {
        this.connection = ConexionMariaDB.getConnection();
    }

    // Create
    public void insertarCourseGrade(int studentId, int courseId, float grade) {
        String sql = "INSERT INTO Courses_Grades (Student_Id, Course_Id, Grade) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.setFloat(3, grade);
            statement.executeUpdate();
            System.out.println("Calificación insertada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al insertar calificación.");
            e.printStackTrace();
        }
    }

    // Read
    public List<String> leerCoursesGrades() {
        List<String> coursesGrades = new ArrayList<>();
        String sql = "SELECT Student_Id, Course_Id, Grade FROM Courses_Grades";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int studentId = resultSet.getInt("Student_Id");
                int courseId = resultSet.getInt("Course_Id");
                float grade = resultSet.getFloat("Grade");
                coursesGrades.add("Student ID: " + studentId + ", Course ID: " + courseId + ", Grade: " + grade);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer calificaciones.");
            e.printStackTrace();
        }
        return coursesGrades;
    }

    // Update
    public void actualizarCourseGrade(int studentId, int courseId, float nuevaCalificacion) {
        String sql = "UPDATE Courses_Grades SET Grade = ? WHERE Student_Id = ? AND Course_Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setFloat(1, nuevaCalificacion);
            statement.setInt(2, studentId);
            statement.setInt(3, courseId);
            statement.executeUpdate();
            System.out.println("Calificación actualizada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar calificación.");
            e.printStackTrace();
        }
    }

    // Delete
    public void eliminarCourseGrade(int studentId, int courseId) {
        String sql = "DELETE FROM Courses_Grades WHERE Student_Id = ? AND Course_Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
            System.out.println("Calificación eliminada con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar calificación.");
            e.printStackTrace();
        }
    }
}
