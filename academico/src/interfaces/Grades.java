package interfaces;

public interface Grades {
    int getId();
    int getEnrollmentId();
    int getGradeTypeId();
    double getGrade();
    void setId(int id);
    void setEnrollmentId(int enrollmentId);
    void setGradeTypeId(int gradeTypeId);
    void setGrade(double grade);
}
