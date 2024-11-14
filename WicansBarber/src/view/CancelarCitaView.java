package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CancelarCitaView {
    private JFrame frame;
    private JTextField citaIdField;
    private JButton cancelarButton;

    public CancelarCitaView() {
        frame = new JFrame("Cancelar Cita");
        citaIdField = new JTextField(20);
        cancelarButton = new JButton("Cancelar Cita");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("ID de Cita:"));
        frame.add(citaIdField);
        frame.add(cancelarButton);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addCancelarListener(ActionListener listener) {
        cancelarButton.addActionListener(listener);
    }

    public String getCitaId() {
        return citaIdField.getText();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void setVisible(boolean b) {

    }
}
