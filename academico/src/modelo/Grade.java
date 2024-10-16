package modelo;

import interfaces.Grades;

public class Grade implements Grades{
    private int id;
    private int enrollmentId;
    private int gradeTypeId;
    private double grade;

    public Grade (int id, int enrollmentId, int gradeTypeId, double grade){
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.gradeTypeId = gradeTypeId;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }
    public  int getEnrollmentId(){
        return enrollmentId;
    }
    public  int getGradeTypeId(){
        return  gradeTypeId;
    }
    public double getGrade(){
        return grade;
    }
    public void setId(int id){
        this.id = id;
    }
    public void  setEnrollmentId(int enrollmentId){
        this.enrollmentId = enrollmentId;
    }
    public void setGradeTypeId(int gradeTypeId){
        this.gradeTypeId = gradeTypeId;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
