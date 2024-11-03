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
        citaIdField = new JTextField(20);
        nuevaFechaField = new JTextField(20);
        nuevaHoraField = new JTextField(20);
        modificarButton = new JButton("Modificar Cita");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("ID de Cita:"));
        frame.add(citaIdField);
        frame.add(new JLabel("Nueva Fecha (YYYY-MM-DD):"));
        frame.add(nuevaFechaField);
        frame.add(new JLabel("Nueva Hora (HH:MM):"));
        frame.add(nuevaHoraField);
        frame.add(modificarButton);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    }
}
