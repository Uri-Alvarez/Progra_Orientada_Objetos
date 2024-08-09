package com.crud.test;

import java.util.List;

import com.crud.courses.CoursesCRUD;
import com.crud.coursesgrades.CoursesGradesCRUD;
import com.crud.instructors.InstructorsCRUD;
import com.crud.students.StudentsCRUD;

public class crudMain {

	public static void main(String[] args) {
        // Start CRUDs
        StudentsCRUD studentsCRUD = new StudentsCRUD();
        InstructorsCRUD instructorsCRUD = new InstructorsCRUD();
        CoursesCRUD coursesCRUD = new CoursesCRUD();
        CoursesGradesCRUD coursesGradesCRUD = new CoursesGradesCRUD();

        //Students CRUD Operation
        studentsCRUD.insertarStudent("Juan", "Computer Science");
        studentsCRUD.insertarStudent("Maria", "Mathematics");

        List<String> students = studentsCRUD.leerStudents();
        for (String student : students) {
            System.out.println(student);
        }

        studentsCRUD.actualizarStudent(1, "Juan", "Physics");
        studentsCRUD.eliminarStudent(2);

        // Instructors CRUD Operation
        instructorsCRUD.insertarInstructor("Profesor X", "Room 101");
        instructorsCRUD.insertarInstructor("Profesor Y", "Room 102");

        List<String> instructors = instructorsCRUD.leerInstructors();
        for (String instructor : instructors) {
            System.out.println(instructor);
        }

        instructorsCRUD.actualizarInstructor(1, "Profesor X", "Room 201");
        instructorsCRUD.eliminarInstructor(2);

        // Courses CRUD Operation
        coursesCRUD.insertarCourse("Calculus", 1);
        coursesCRUD.insertarCourse("Physics", 1);

        List<String> courses = coursesCRUD.leerCourses();
        for (String course : courses) {
            System.out.println(course);
        }

        coursesCRUD.actualizarCourse(1, "Advanced Calculus", 1);
        coursesCRUD.eliminarCourse(2);

        // Courses_Grades CRUD Operation
        coursesGradesCRUD.insertarCourseGrade(1, 1, 95.0f);
        coursesGradesCRUD.insertarCourseGrade(1, 2, 85.0f);

        List<String> coursesGrades = coursesGradesCRUD.leerCoursesGrades();
        for (String courseGrade : coursesGrades) {
            System.out.println(courseGrade);
        }

        coursesGradesCRUD.actualizarCourseGrade(1, 1, 98.0f);
        coursesGradesCRUD.eliminarCourseGrade(1, 2);
    }

}
