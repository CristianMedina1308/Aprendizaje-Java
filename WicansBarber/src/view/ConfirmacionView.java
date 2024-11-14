package view;

import db.connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConfirmacionView extends JFrame {
    public ConfirmacionView(String nombre, String telefono, String fecha, String hora, String barbero, String servicio, List<String> citasReservadas, ReservaView reservaView) {
        setTitle("Confirmación de Cita");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo gris claro

        Font titleFont = new Font("SansSerif", Font.BOLD, 18);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 14);

        // Panel superior con título
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 152, 219)); // Azul
        JLabel headerLabel = new JLabel("Cita Confirmada");
        headerLabel.setFont(titleFont);
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con detalles de la cita
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(0, 1, 5, 5));
        detailsPanel.setBackground(new Color(245, 245, 245));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        detailsPanel.add(createLabel("Nombre: " + nombre, labelFont));
        detailsPanel.add(createLabel("Teléfono: " + telefono, labelFont));
        detailsPanel.add(createLabel("Fecha: " + fecha, labelFont));
        detailsPanel.add(createLabel("Hora: " + hora, labelFont));
        detailsPanel.add(createLabel("Barbero: " + barbero, labelFont));
        detailsPanel.add(createLabel("Servicio: " + servicio, labelFont));

        add(detailsPanel, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));

        // Botón de confirmar cita
        JButton confirmarButton = new JButton("Confirmar Cita");
        connection.getConnection();
        connection.registrarCita(nombre,telefono,fecha, barbero, servicio );
        configurarBoton(confirmarButton, new Color(39, 174, 96), Color.WHITE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConfirmacionView.this, "Su cita ha sido confirmada.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                reservaView.limpiarCampos(); // Limpiar campos de ReservaView
                dispose();
            }
        });
        buttonPanel.add(confirmarButton);

        // Botón para reservar otra cita
        JButton otraReservaButton = new JButton("Reservar Otra Cita");
        configurarBoton(otraReservaButton, new Color(52, 152, 219), Color.WHITE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservaView.limpiarCampos(); // Limpiar campos de ReservaView
                reservaView.setVisible(true); // Volver a mostrar la ventana de reserva
                dispose();
            }
        });
        buttonPanel.add(otraReservaButton);

        // Botón para cancelar cita
        JButton cancelarButton = new JButton("Cancelar Cita");
        configurarBoton(cancelarButton, new Color(192, 57, 43), Color.WHITE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConfirmacionView.this, "La cita ha sido cancelada.", "Cancelación", JOptionPane.WARNING_MESSAGE);
                dispose();
            }
        });
        buttonPanel.add(cancelarButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private void configurarBoton(JButton button, Color bgColor, Color fgColor, ActionListener action) {
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.addActionListener(action);
    }
}
