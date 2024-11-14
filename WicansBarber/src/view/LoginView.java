package view;

import controller.LoginController;
import db.connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField nombreField;
    private JPasswordField passwordField;

    public LoginView() {
        setTitle("Iniciar Sesión");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo gris claro

        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // Panel superior con título estilizado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 152, 219));
        JLabel headerLabel = new JLabel("Iniciar Sesión");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con campos de entrada
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 1, 10, 10));
        contentPanel.setBackground(new Color(245, 245, 245));

        // Campo de nombre
        JPanel nombrePanel = new JPanel();
        nombrePanel.setBackground(new Color(245, 245, 245));
        nombrePanel.setLayout(new BorderLayout());
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setFont(font);
        nombrePanel.add(nombreLabel, BorderLayout.WEST);
        nombreField = new JTextField();
        nombreField.setFont(font);
        nombrePanel.add(nombreField, BorderLayout.CENTER);
        contentPanel.add(nombrePanel);

        // Campo de contraseña
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(new Color(245, 245, 245));
        passwordPanel.setLayout(new BorderLayout());
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(font);
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        contentPanel.add(passwordPanel);

        add(contentPanel, BorderLayout.CENTER);

        // Panel inferior con botón de inicio de sesión
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(245, 245, 245));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(font);
        loginButton.setBackground(new Color(39, 174, 96));
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(150, 40));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        footerPanel.add(loginButton);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void iniciarSesion() {
        String nombre = nombreField.getText();
        String password = new String(passwordField.getPassword());

        // Se realiza el llamado al controlador.
        LoginController lg = new LoginController();
        boolean inicioExitoso = lg.validarCredenciales(nombre, password);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView().setVisible(true);
            }
        });
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
