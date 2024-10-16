package vista;

import interfaces.IMostrarMensaje;
import modelo.Student;
import modelo.Teacher;

import java.util.List;

public class ViewTeacher implements IMostrarMensaje {
    public void displayListTeachers(List<Teacher> teachers) {
        System.out.println(" == Lista de profesores == ");
        for (Teacher teacher : teachers) {
            System.out.println("Id Profesor: " + teacher.getId() + ", Nombre: " + teacher.getName() + ", Role: " + teacher.getRole());
        }
    }
}
