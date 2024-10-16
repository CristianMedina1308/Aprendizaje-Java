package controlador;
import modelo.Enrollment;
import vista.ViewEnrollment;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentController {
    private List<Enrollment> enrollments;
    private ViewEnrollment view;

    public EnrollmentController(ViewEnrollment view){
        this.view = view;
        this.enrollments = new ArrayList<>();
}

public void addEnrollment (Enrollment enrollment){
    enrollments.add(enrollment);
    }
    public void displayAllEnrollments (){
        view.displayEnrollments(enrollments);
    }
}
