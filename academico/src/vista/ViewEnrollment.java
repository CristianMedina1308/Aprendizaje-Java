package vista;
import modelo.Enrollment;

import java.util.List;

public class ViewEnrollment {
   public void displayEnrollments(List<Enrollment> enrollments){
       for (Enrollment enrollment : enrollments){
           System.out.println("ID: " + enrollment.getId() +
                   ", Student ID " + enrollment.getStudentId() +
                   ", Course Id " + enrollment.getCourseId());
       }
   }
}
