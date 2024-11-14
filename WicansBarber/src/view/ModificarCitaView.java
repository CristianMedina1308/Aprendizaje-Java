package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModificarCitaView {
    private JFrame frame;
    private JTextField citaIdField;
    private JTextField nuevaFechaField;
    private JTextField nuevaHoraField;
    private JButton modificarButton;

    public ModificarCitaView() {
        frame = new JFrame("Modificar Cita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Configuración del layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Elementos de la interfaz
        JLabel titleLabel = new JLabel("Modificar Cita", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel citaIdLabel = new JLabel("ID de Cita:");
        citaIdField = new JTextField(20);

        JLabel nuevaFechaLabel = new JLabel("Nueva Fecha (YYYY-MM-DD):");
        nuevaFechaField = new JTextField(20);

        JLabel nuevaHoraLabel = new JLabel("Nueva Hora (HH:MM):");
        nuevaHoraField = new JTextField(20);

        modificarButton = new JButton("Modificar Cita");

        // Posicionamiento en el panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(citaIdLabel, gbc);
        gbc.gridx = 1;
        panel.add(citaIdField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(nuevaFechaLabel, gbc);
        gbc.gridx = 1;
        panel.add(nuevaFechaField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        panel.add(nuevaHoraLabel, gbc);
        gbc.gridx = 1;
        panel.add(nuevaHoraField, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(modificarButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void addModificarListener(ActionListener listener) {
        modificarButton.addActionListener(listener);
    }

    public String getCitaId() {
        return citaIdField.getText();
    }

    public String getNuevaFecha() {
        return nuevaFechaField.getText();
    }

    public String getNuevaHora() {
        return nuevaHoraField.getText();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
