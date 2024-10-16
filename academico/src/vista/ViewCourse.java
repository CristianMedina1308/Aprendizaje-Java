package vista;

import interfaces.IMostrarMensaje;
import modelo.Course;

import java.util.List;

public class ViewCourse implements IMostrarMensaje {
    public void displayListCourses(List<Course> courses) {
        System.out.println(" == Lista de Cursos == ");
        for (Course course : courses) {
            System.out.println("Id Curso: " + course.getId() + ", Nombre: " + course.getName() + ", Contenido: " + course.getContent() + ", Estado: " + course.getStatus()+ ", Profesor ID: " + course.getTeacherId());
        }
    }
}
