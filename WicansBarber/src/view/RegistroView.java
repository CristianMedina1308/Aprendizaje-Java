package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroView extends JFrame {
    private JTextField nombreField;
    private JTextField telefonoField;
    private JPasswordField passwordField;

    public RegistroView() {
        setTitle("Registro");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        add(telefonoField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton registrarButton = new JButton("Registrarse");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
        add(registrarButton);
    }

    private void registrarUsuario() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String password = new String(passwordField.getPassword());

        JOptionPane.showMessageDialog(this, "Registro exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        abrirInicioView();
    }

    private void abrirInicioView() {
        InicioView inicioView = new InicioView();
        inicioView.setVisible(true);
        dispose();
    }
}
