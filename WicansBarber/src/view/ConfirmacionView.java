package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConfirmacionView extends JFrame {
    public ConfirmacionView(String nombre, String telefono, String fecha, String hora, String barbero, String servicio, List<String> citasReservadas, ReservaView reservaView) {
        setTitle("Confirmación de Cita");
        setSize(400, 300);
        setLayout(new GridLayout(0, 1));

        // Mostrar los detalles de la cita
        add(new JLabel("Cita Confirmada"));
        add(new JLabel("Nombre: " + nombre));
        add(new JLabel("Teléfono: " + telefono));
        add(new JLabel("Fecha: " + fecha));
        add(new JLabel("Hora: " + hora));
        add(new JLabel("Barbero: " + barbero));
        add(new JLabel("Servicio: " + servicio));

        // Botón para confirmar la cita
        JButton confirmarButton = new JButton("Confirmar Cita");
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConfirmacionView.this, "Su cita ha sido confirmada.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                reservaView.limpiarCampos(); // Limpiar campos de ReservaView
                dispose();
            }
        });
        add(confirmarButton);


        JButton otraReservaButton = new JButton("Reservar Otra Cita");
        otraReservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reservaView.limpiarCampos(); // Limpiar campos de ReservaView
                reservaView.setVisible(true); // Volver a mostrar la ventana de reserva
                dispose();
            }
        });
        add(otraReservaButton);


        JButton cancelarButton = new JButton("Cancelar Cita");
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ConfirmacionView.this, "La cita ha sido cancelada.", "Cancelación", JOptionPane.WARNING_MESSAGE);
                dispose();
            }
        });
        add(cancelarButton);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
