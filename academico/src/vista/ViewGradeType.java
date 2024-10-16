package vista;

import modelo.GradeTypes;

import java.util.List;

public class ViewGradeType {
    public void displayGradeTypes(List<GradeTypes> gradeTypes){
        System.out.println("Lista de Tipos de Calificaciones:");
        for (GradeTypes gradeType : gradeTypes){
            System.out.println("ID: " + gradeType.getId()+
                    ", Nombre: " + gradeType.getName() +
                    ", Peso: " + gradeType.getWeight());
        }
    }
}
