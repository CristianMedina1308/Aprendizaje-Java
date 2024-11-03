package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField nombreField;
    private JPasswordField passwordField;

    public LoginView() {
        setTitle("Iniciar Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
        add(loginButton);
    }

    private void iniciarSesion() {
        String nombre = nombreField.getText();
        String password = new String(passwordField.getPassword());

        boolean inicioExitoso = true;

        if (inicioExitoso) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            abrirReservaView();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirReservaView() {
        ReservaView reservaView = new ReservaView();
        reservaView.setVisible(true);
        dispose();
    }

    public void addLoginListener(LoginController.LoginButtonListener loginButtonListener) {
    }

    public String getEmail() {
        return "";
    }

    public String getPassword() {
        return "";
    }

    public void showMessage(String s) {

    }
}
