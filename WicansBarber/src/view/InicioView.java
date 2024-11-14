package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InicioView extends JFrame {
    public InicioView() {
        setTitle("Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 0));
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255)); // Fondo oscuro (barbería estilo vintage)

        // Panel superior con el mensaje de bienvenida
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(253, 0, 0)); // Color rojo oscuro
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espaciado

        // Cargar imagen del logotipo desde una ruta absoluta o relativa
        ImageIcon logoIcon = new ImageIcon("logo.jpg"); // Ruta absoluta o relativa
        Image logoImage = logoIcon.getImage(); // Convertir la imagen a un objeto Image
        Image scaledLogo = logoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Redimensionar la imagen
        logoIcon = new ImageIcon(scaledLogo); // Crear una nueva ImageIcon con la imagen redimensionada
        JLabel logoLabel = new JLabel(logoIcon);
        headerPanel.add(logoLabel);

        JLabel welcomeLabel = new JLabel("Bienvenido a Wicansbarber", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con botones de Registro e Iniciar Sesión
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1, 10, 20)); // Más espaciado entre los botones
        contentPanel.setBackground(new Color(255, 255, 255));

        JButton registroButton = new JButton("Registrarse");
        customizeButton(registroButton, new Color(39, 118, 174), new Color(36, 55, 74)); // Naranja cálido y un hover más oscuro
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirRegistroView();
            }
        });

        JButton loginButton = new JButton("Iniciar Sesión");
        customizeButton(loginButton, new Color(39, 118, 174), new Color(36, 55, 74)); // Naranja cálido y un hover más oscuro
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirLoginView();
            }
        });

        contentPanel.add(registroButton);
        contentPanel.add(loginButton);

        add(contentPanel, BorderLayout.CENTER);

        // Panel inferior para espacio adicional (opcional)
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(255, 255, 255)); // Fondo oscuro
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void customizeButton(JButton button, Color background, Color hoverBackground) {
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(180, 40)); // Ajustamos el tamaño para botones más pequeños
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(background, 2, true)); // Bordes redondeados
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar sobre el botón
        button.setOpaque(true);

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverBackground);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(background);
            }
        });

        // Hacer que los botones tengan bordes redondeados
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Espaciado interior del botón
        button.setBorder(new RoundedBorder(20)); // Añadir borde redondeado
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicioView().setVisible(true);
            }
        });
    }

    // Clase interna para redondear los bordes del botón
    static class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(5, 5, 5, 5);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.WHITE);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}