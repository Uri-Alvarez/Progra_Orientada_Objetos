
package to_do_list_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Tarea {
    int id;
    String fecha;
    String nombre;
    String descripcion;
    boolean completada;
    int prioridad;

    public Tarea(int id, String fecha, String nombre, String descripcion, boolean completada, int prioridad) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = completada;
        this.prioridad = prioridad;
    }//End "Tarea" Constructor

    @Override
    public String toString() {
        return "ID: " + id + ", Fecha: " + fecha + ", Nombre: " + nombre + ", Descripcion: " + descripcion
                + ", Estado: " + (completada ? "Completada" : "Incompleta") + ", Prioridad: " + prioridad;
    }
}//End "Tarea" class

public class To_Do_List_App {
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            // Mostrar menú de opciones al usuario.
            System.out.println("\n1. Crear una nueva tarea");
            System.out.println("2. Eliminar una tarea");
            System.out.println("3. Cambiar estado de la tarea");
            System.out.println("4. Ordenar tareas");
            System.out.println("5. Mostrar todas las tareas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea para evitar errores de entrada.

            // Manejo de las opciones seleccionadas por el usuario.
            switch (opcion) {
                case 1 -> createTarea();
                case 2 -> eliminarTarea();
                case 3 -> cambiarEstadoTarea();
                case 4 -> ordenarTareas();
                case 5 -> mostrarTareas();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no válida");
            }//End Switch
        } while (opcion != 0);//End Do-While
    }//End main

    private static void createTarea() {
        System.out.print("Ingrese el ID de la tarea: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la fecha (dd/mm/yyyy): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese el nombre de la tarea: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripcion de la tarea: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese la prioridad (1-5): ");
        int prioridad = scanner.nextInt();
        scanner.nextLine();
        Tarea nuevaTarea = new Tarea(id, fecha, nombre, descripcion, false, prioridad);
        tareas.add(nuevaTarea);
        System.out.println("Tarea agregada exitosamente.");
    }//End "CrearTarea" method

    private static void eliminarTarea() {
        System.out.print("Ingrese el ID de la tarea a eliminar: ");
        int id = scanner.nextInt();
        tareas.removeIf(t -> t.id == id);
        System.out.println("Tarea eliminada exitosamente.");
    }//End "EliminarTarea" method

    private static void cambiarEstadoTarea() {
        System.out.print("Ingrese el ID de la tarea a cambiar estado: ");
        int id = scanner.nextInt();
        for (Tarea t : tareas) {
            if (t.id == id) {
                t.completada = !t.completada;
                System.out.println("Estado de la tarea actualizado a " + (t.completada ? "Completada" : "Incompleta"));
                return;
            }
        }
        System.out.println("Tarea no encontrada.");
    }//End "CambiarEstado" method

    private static void ordenarTareas() {
        System.out.println("1. Ordenar por fecha ascendente");
        System.out.println("2. Ordenar por fecha descendente");
        System.out.println("3. Ordenar por prioridad");
        System.out.print("Seleccione una opcion de ordenamiento: ");
        int opcion = scanner.nextInt();
        switch (opcion) {
            //Se utiliza el método sort de la clase Collections para ordenar la lista tareas.
            case 1 -> Collections.sort(tareas, Comparator.comparing(t -> t.fecha));//Se utiliza "Comparator.comparing(t -> t.fecha)" para ordenar por la propiedad ?fecha' en orden ascendente.
            case 2 -> Collections.sort(tareas, (t1, t2) -> t2.fecha.compareTo(t1.fecha));//Ordena por la propiedad 'fecha' en orden descendente.
            case 3 -> Collections.sort(tareas, Comparator.comparingInt(t -> t.prioridad));//Ordena por la propiedad 'prioridad' de menor a mayor.
        }
        System.out.println("Tareas ordenadas exitosamente.");
    }//End "Ordenar Tareas" method

    private static void mostrarTareas() {
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }//End "Mostrar Tareas" method
}//End class To_Do_List_App