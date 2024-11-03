package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioView extends JFrame {
    public InicioView() {
        setTitle("Inicio");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JButton registroButton = new JButton("Registrarse");
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistroView();
            }
        });

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirLoginView();
            }
        });

        add(new JLabel("Bienvenido a Wicansbarber", SwingConstants.CENTER));
        add(registroButton);
        add(loginButton);
    }

    private void abrirRegistroView() {
        RegistroView registroView = new RegistroView();
        registroView.setVisible(true);
        dispose();
    }

    private void abrirLoginView() {
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
        dispose();
    }
}
