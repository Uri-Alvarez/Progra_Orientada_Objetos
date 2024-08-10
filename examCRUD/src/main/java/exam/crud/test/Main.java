package exam.crud.test;

import java.sql.*;

import exam.crud.lectores.LectoresCRUD;
import exam.crud.libros.LibrosCRUD;
import exam.crud.prestamos.PrestamosCRUD;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/exam";
        String jdbcUser = "uri";
        String jdbcPass = "123";

        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass)) {
            LibrosCRUD librosCRUD = new LibrosCRUD(conn);
            LectoresCRUD lectoresCRUD = new LectoresCRUD(conn);
            PrestamosCRUD prestamosCRUD = new PrestamosCRUD(conn);

            librosCRUD.createLibro(1008, "Nuevo Libro", "Nuevo Autor", "Nueva Editorial");
            librosCRUD.readLibros();
            librosCRUD.updateLibro(1008, "Libro Actualizado");
            librosCRUD.deleteLibro(1008);

            lectoresCRUD.createLector("Nuevo Lector");
            lectoresCRUD.readLectores();
            lectoresCRUD.updateLector("Nuevo Lector", "Lector Actualizado");
            lectoresCRUD.deleteLector("Lector Actualizado");

            prestamosCRUD.createPrestamo(1008, "Lector Actualizado", Date.valueOf("2024-08-09"));
            prestamosCRUD.readPrestamos();
            prestamosCRUD.updatePrestamo(1008, "Lector Actualizado", Date.valueOf("2024-08-10"));
            prestamosCRUD.deletePrestamo(1008, "Lector Actualizado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
