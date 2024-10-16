package controlador;
import modelo.Grade;
import interfaces.Grades;
import vista.ViewGrades;

import java.util.ArrayList;
import java.util.List;

public class GradesController {
    private List<Grades> gradesList;
    private ViewGrades view;

    public GradesController(ViewGrades view){
        this.view = view;
        this.gradesList = new ArrayList<>();
    }
    public void addGrade(Grades grade){
        gradesList.add(grade);
    }
    public void displayAllGrades(){
        view.displayGrades(gradesList);
    }
}

