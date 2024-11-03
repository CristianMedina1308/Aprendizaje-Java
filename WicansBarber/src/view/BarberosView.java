package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BarberosView extends JFrame {
    private JTextArea barberosArea;
    private JButton reservarButton;

    public BarberosView() {
        setTitle("Nuestros Barberos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto para mostrar la información de los barberos
        barberosArea = new JTextArea();
        barberosArea.setEditable(false);
        barberosArea.setLineWrap(true);
        barberosArea.setWrapStyleWord(true);
        barberosArea.setText("Nuestros Barberos:\n\n" +
                "Santiago Montenegro\n" +
                "Teléfono: +57 3218269937\n" +
                "Correo: Santiago3567.ml@gmail.com\n" +
                "Especialidad: Freestyle\n" +
                "Experiencia: 3 años\n\n" +
                "Miguel Angel Velez\n" +
                "Teléfono: +57 3186748283\n" +
                "Correo: Miguelbarber1@gmail.com\n" +
                "Especialidades: Difuminado\n" +
                "Experiencia: 5 años\n\n" +
                "Gustavo del papa\n" +
                "Teléfono: +57 3168513285\n" +
                "Correo: Gustavo2015@gmail.com\n" +
                "Especialidades: Tijera\n" +
                "Experiencia: 1 año\n");


        JScrollPane scrollPane = new JScrollPane(barberosArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para reservar cita
        reservarButton = new JButton("Reservar Cita");
        add(reservarButton, BorderLayout.SOUTH);
    }

    public void addReservarListener(ActionListener listener) {
        reservarButton.addActionListener(listener);
    }
}
