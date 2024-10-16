package controlador;

import modelo.GradeTypes;
import vista.ViewGradeType;

import java.util.ArrayList;
import java.util.List;

public class GradeTypeController {
    private List<GradeTypes> gradeTypes;
    private ViewGradeType view;

    public GradeTypeController (ViewGradeType view){
        this.view = view;
        this.gradeTypes = new ArrayList<>();
    }
    public void addGredeType(GradeTypes gradeType){
        gradeTypes.add(gradeType);
    }
    public void displayAllGradeType(){
        view.displayGradeTypes(gradeTypes);
    }
}
