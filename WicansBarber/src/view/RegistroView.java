package view;

import db.connection;

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
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo gris claro

        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // Panel superior con título estilizado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 152, 219));
        JLabel headerLabel = new JLabel("Registro de Usuario");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con campos de entrada
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(5, 1, 10, 10));
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

        // Campo de teléfono
        JPanel telefonoPanel = new JPanel();
        telefonoPanel.setBackground(new Color(245, 245, 245));
        telefonoPanel.setLayout(new BorderLayout());
        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setFont(font);
        telefonoPanel.add(telefonoLabel, BorderLayout.WEST);
        telefonoField = new JTextField();
        telefonoField.setFont(font);
        telefonoPanel.add(telefonoField, BorderLayout.CENTER);
        contentPanel.add(telefonoPanel);

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

        // Panel inferior con botón de registro
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(245, 245, 245));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton registrarButton = new JButton("Registrarse");
        registrarButton.setFont(font);
        registrarButton.setBackground(new Color(43, 110, 192));
        registrarButton.setForeground(Color.WHITE);
        registrarButton.setPreferredSize(new Dimension(120, 40));
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        footerPanel.add(registrarButton);
        add(footerPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

    }

    private void registrarUsuario() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String password = new String(passwordField.getPassword());

        // Validación simple
        if (nombre.isEmpty() || telefono.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean respuesta = connection.registrarUsuario(nombre,password);

        if (respuesta){
            JOptionPane.showMessageDialog(this, "Registro exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            abrirInicioView();
        }else{
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error, intentalo de nuevo por favor.!", "Error", JOptionPane.INFORMATION_MESSAGE);
            abrirInicioView();
        }

    }

    private void abrirInicioView() {
        InicioView inicioView = new InicioView();
        inicioView.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistroView().setVisible(true);
            }
        });
    }
}