import controlador.*;
import db.connection;
import interfaces.Grades;
import modelo.*;
import vista.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a nuestro sistema academico!");

        // Inicializar vistas
        ViewStudent viewStudent = new ViewStudent();
        ViewTeacher viewTeacher = new ViewTeacher();
        ViewCourse viewCourse = new ViewCourse();
        ViewEnrollment ViewEnrollment = new ViewEnrollment ();
        ViewGrades viewGrades = new ViewGrades();
        ViewGradeType viewGradeType = new ViewGradeType();

        // Inicializar controladores
        StudentController studentController = new StudentController(viewStudent);
        TeacherController teacherController = new TeacherController(viewTeacher);
        CourseController courseController = new CourseController(viewCourse);
        EnrollmentController enrollmentController = new EnrollmentController(ViewEnrollment);
        GradesController gradesController = new GradesController(viewGrades);
        GradeTypeController gradeTypeController = new GradeTypeController(viewGradeType);

        // Inicializar objeto estudiante
        Student newStudent = new Student(12345, "Daniel", "daniel@gmail.com");
        Student newStudent1 = new Student(4321, "Juanito", "juanito@gmail.com");

        // Guardar estudiante en la base de datos
        studentController.insertNewStudent(newStudent);
        studentController.insertNewStudent(newStudent1);

        // Mostrar datos en las vistas
        studentController.displayAllStudents();

        Teacher newTeacher = new Teacher(1235, "Pablo", "Ciencias Sociales");
        teacherController.insertNewTeacher(newTeacher);
        teacherController.displayAllTeachers();

        Course newCourse = new Course(1234, "Historia", "...", true, newTeacher.getId());
        courseController.insertNewCourse(newCourse);
        courseController.displayAllCourses();

        // Agregar inscripciones
        Enrollment enrollment1 = new Enrollment(1, newStudent.getId(), newCourse.getId());
        enrollmentController.addEnrollment(enrollment1);

        Enrollment enrollment2 = new Enrollment(2, newStudent1.getId(), newCourse.getId());
        enrollmentController.addEnrollment(enrollment2);

        // Mostrar todas las inscripciones
        enrollmentController.displayAllEnrollments();

        // Agregar calificaciones
        Grades grades1 = new Grade(1,1,1, 95.50);
        Grades grades2 = new Grade(2,1,1, 80.0);

        gradesController.addGrade(grades1);
        gradesController.addGrade(grades2);

        // Mostrar todas las calificaciones
        gradesController.displayAllGrades();

        // Agregar tipos de calificaciones
        GradeTypes gradeTypes1 = new GradeTypes(1,"Examen", 0.9);
        GradeTypes gradeTypes2 = new GradeTypes(2, "Tarea",1.5);

        // Mostrar todos los tipos de calificaciones
        gradeTypeController.displayAllGradeType();

        System.out.println("Parcial elaborado por Cristian Camilo Medina y Sebastián Bolivar");

    }
}