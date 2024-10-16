package vista;

import interfaces.Grades;

import java.util.List;

public class ViewGrades {
    public void displayGrades (List<Grades> grades){
        for (Grades grade : grades){
            System.out.println( "ID: " + grade.getId() +
                    ", Enrollment ID: " + grade.getGradeTypeId() +
                    ", Grade: " + grade.getGrade());
        }
    }
}
