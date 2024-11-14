package view;

import controller.ReservaController;
import interfaces.DateSelectedListener;
import interfaces.ReservaListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReservaView extends JFrame {
    private JTextField nombreField;
    private JTextField telefonoField;
    private JTextField fechaField;
    private JComboBox<String> horaComboBox;
    private JComboBox<String> barberoComboBox;
    private JTextArea barberoDetallesArea;
    private JComboBox<String> servicioComboBox;
    private JTextArea servicioDetallesArea;
    private List<String> citasReservadas;
    private ReservaListener reservaListener;

    public ReservaView() {
        citasReservadas = new ArrayList<>();
        setTitle("Reserva tu cita - Barbería Modernizada");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 245));

        Font font = new Font("SansSerif", Font.PLAIN, 14);

        // Panel superior con título estilizado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 152, 219));
        JLabel headerLabel = new JLabel("Reserva tu cita");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con campos de entrada
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(10, 2, 10, 10));
        contentPanel.setBackground(new Color(245, 245, 245));

        // Campos de entrada
        addLabeledField(contentPanel, "Nombre:", font);
        nombreField = new JTextField();
        nombreField.setFont(font);
        contentPanel.add(nombreField);

        addLabeledField(contentPanel, "Teléfono:", font);
        telefonoField = new JTextField();
        telefonoField.setFont(font);
        contentPanel.add(telefonoField);

        // Selección de fecha
        addLabeledField(contentPanel, "Fecha:", font);
        fechaField = new JTextField();
        fechaField.setEditable(false);
        fechaField.setFont(font);
        contentPanel.add(fechaField);

        JButton seleccionarFechaButton = new JButton("Seleccionar Fecha");
        seleccionarFechaButton.setFont(font);
        seleccionarFechaButton.setBackground(new Color(52, 152, 219));
        seleccionarFechaButton.setForeground(Color.WHITE);
        seleccionarFechaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCalendarioParaFecha();
            }
        });
        contentPanel.add(seleccionarFechaButton);

        // Selección de hora
        addLabeledField(contentPanel, "Hora:", font);
        String[] horas = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        horaComboBox = new JComboBox<>(horas);
        horaComboBox.setFont(font);
        contentPanel.add(horaComboBox);

        // Selección de barbero
        addLabeledField(contentPanel, "Selecciona un Barbero:", font);
        String[] barberos = {"Santiago Montenegro", "Miguel Angel Velez", "Gustavo del Papa"};
        barberoComboBox = new JComboBox<>(barberos);
        barberoComboBox.setFont(font);
        barberoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDetallesBarbero((String) barberoComboBox.getSelectedItem());
            }
        });
        contentPanel.add(barberoComboBox);

        barberoDetallesArea = new JTextArea(5, 20);
        barberoDetallesArea.setEditable(false);
        contentPanel.add(new JScrollPane(barberoDetallesArea));

        // Selección de servicio
        addLabeledField(contentPanel, "Selecciona un Servicio:", font);
        String[] servicios = {"Corte de cabello", "Corte y barba", "Afeitado", "Corte y cejas", "Tinte"};
        servicioComboBox = new JComboBox<>(servicios);
        servicioComboBox.setFont(font);
        servicioComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDetallesServicio((String) servicioComboBox.getSelectedItem());
            }
        });
        contentPanel.add(servicioComboBox);

        // Área de texto para mostrar detalles del servicio seleccionado
        servicioDetallesArea = new JTextArea(5, 20);
        servicioDetallesArea.setEditable(false);
        contentPanel.add(new JScrollPane(servicioDetallesArea));

        add(contentPanel, BorderLayout.CENTER);

        // Panel inferior con botones de acción
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(245, 245, 245));

        JButton reservarButton = new JButton("Reservar cita");
        reservarButton.setFont(font);
        reservarButton.setBackground(new Color(39, 174, 96));
        reservarButton.setForeground(Color.WHITE);
        reservarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String telefono = telefonoField.getText();
                String fecha = fechaField.getText();
                String hora = (String) horaComboBox.getSelectedItem();
                String barbero = (String) barberoComboBox.getSelectedItem();
                String servicio = (String) servicioComboBox.getSelectedItem();

                if (nombre.isEmpty() || telefono.isEmpty() || fecha.isEmpty()) {
                    JOptionPane.showMessageDialog(ReservaView.this, "Por favor completa todos los campos.");
                } else {
                    citasReservadas.add("Nombre: " + nombre + ", Teléfono: " + telefono + ", Fecha: " + fecha + ", Hora: " + hora + ", Barbero: " + barbero + ", Servicio: " + servicio);
                    if (reservaListener != null) {
                        reservaListener.onReserva(nombre, telefono, fecha, hora, barbero, servicio);
                    }
                    ConfirmacionView confirmacionView = new ConfirmacionView(nombre, telefono, fecha, hora, barbero, servicio, citasReservadas, ReservaView.this);
                    confirmacionView.setVisible(true);
                }
            }
        });
        footerPanel.add(reservarButton);

        JButton modificarButton = new JButton("Modificar");
        modificarButton.setFont(font);
        footerPanel.add(modificarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setFont(font);
        footerPanel.add(cancelarButton);

        add(footerPanel, BorderLayout.SOUTH);
    }

    private void addLabeledField(JPanel panel, String labelText, Font font) {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        panel.add(label);
    }

    private void mostrarDetallesBarbero(String barbero) {
        String detalles = switch (barbero) {
            case "Santiago Montenegro" -> "Teléfono: +57 3218269937\nCorreo: Santiago3567.ml@gmail.com\nEspecialidad: Freestyle\nExperiencia: 3 años";
            case "Miguel Angel Velez" -> "Teléfono: +57 3186748283\nCorreo: Miguelbarber1@gmail.com\nEspecialidad: Difuminado\nExperiencia: 5 años";
            case "Gustavo del Papa" -> "Teléfono: +57 3168513285\nCorreo: Gustavo2015@gmail.com\nEspecialidad: Tijera\nExperiencia: 1 año";
            default -> "";
        };
        barberoDetallesArea.setText(detalles);
    }

    private void mostrarDetallesServicio(String servicio) {
        String detalles = switch (servicio) {
            case "Corte de cabello" -> "Precio: $15.000\nDescripción: Corte de cabello profesional.";
            case "Corte y barba" -> "Precio: $18.000\nDescripción: Corte de cabello y barba.";
            case "Afeitado" -> "Precio: $17.000\nDescripción: Afeitado completo y cuidado facial.";
            case "Corte y cejas" -> "Precio: $20.000\nDescripción: Corte de cabello y cejas.";
            case "Tinte" -> "Precio: $50.000\nDescripción: Tinte de cabello y barba.";
            default -> "";
        };
        servicioDetallesArea.setText(detalles);
    }

    private void abrirCalendarioParaFecha() {
        CalendarioView calendarioView = new CalendarioView();
        calendarioView.showCalendar();
        calendarioView.addDateSelectedListener(new DateSelectedListener() {
            @Override
            public void onDateSelected(String selectedDate) {
                fechaField.setText(selectedDate);
            }
        });
    }

    public void setReservaListener(ReservaListener listener) {
        this.reservaListener = listener;
    }

    public void limpiarCampos() {
        nombreField.setText("");
        telefonoField.setText("");
        fechaField.setText("");
        horaComboBox.setSelectedIndex(0);
        barberoComboBox.setSelectedIndex(0);
        barberoDetallesArea.setText("");
        servicioComboBox.setSelectedIndex(0);
        servicioDetallesArea.setText("");
    }

    public void addReservarListener(ReservaController.ReservarListener reservarListener) {
    }

    public void addModificarListener(ReservaController.ModificarListener modificarListener) {
    }

    public void addCancelarListener(ReservaController.CancelarListener cancelarListener) {
    }

    public String getNombre() {
        return "";
    }

    public String getTelefono() {
        return "";
    }

    public String getFecha() {
        return "";
    }

    public String getHora() {
        return "";
    }

    public String getServicio() {
        return "";
    }

    public void showMessage(String s) {
    }
}
