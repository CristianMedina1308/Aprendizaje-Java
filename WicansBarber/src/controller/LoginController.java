package controller;

import view.BarberosView;
import view.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView vista;
    private BarberosView barberosView;

    public LoginController(LoginView vista, BarberosView barberosView) {
        this.vista = vista;
        this.barberosView = barberosView;
        this.vista.addLoginListener(new LoginButtonListener());
    }

    public class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = vista.getEmail();
            String password = vista.getPassword();

            // Validar el inicio de sesión

            if (validarCredenciales(email, password)) {
                vista.showMessage("Inicio de sesión exitoso.");
                vista.setVisible(false);
                barberosView.setVisible(true);
            } else {
                vista.showMessage("Credenciales incorrectas.");
            }
        }

        private boolean validarCredenciales(String email, String password) {
            return email.equals("test@barberia.com") && password.equals("1234");
        }
    }
}
