package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BarberosView extends JFrame {
    private JTextArea barberosArea;
    private JButton reservarButton;

    public BarberosView() {
        setTitle("Nuestros Barberos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuración del área de texto para mostrar la información de los barberos
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

        // Configuración del área de texto para que sea más agradable visualmente
        barberosArea.setFont(new Font("Arial", Font.PLAIN, 14));
        barberosArea.setBackground(new Color(245, 245, 245));
        barberosArea.setForeground(new Color(33, 33, 33));

        JScrollPane scrollPane = new JScrollPane(barberosArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));

        // Botón para reservar cita
        reservarButton = new JButton("Reservar Cita");
        configurarBoton(reservarButton, new Color(52, 152, 219), Color.WHITE);
        buttonPanel.add(reservarButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    public void addReservarListener(ActionListener listener) {
        reservarButton.addActionListener(listener);
    }

    private void configurarBoton(JButton button, Color bgColor, Color fgColor) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setPreferredSize(new Dimension(150, 40));
        button.setFocusPainted(false);
    }
}
