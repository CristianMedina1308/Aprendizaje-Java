package view;

import controller.ReservaController;
import interfaces.DateSelectedListener;
import interfaces.ReservaListener;
import interfaces.ConfirmacionListener;

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
        setTitle("Reserva tu cita");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(10, 2));


        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        add(telefonoField);

        // Selección de fecha
        add(new JLabel("Fecha:"));
        fechaField = new JTextField();
        fechaField.setEditable(false);
        add(fechaField);

        JButton seleccionarFechaButton = new JButton("Seleccionar Fecha");
        seleccionarFechaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCalendarioParaFecha();
            }
        });
        add(seleccionarFechaButton);

        // Selección de hora
        add(new JLabel("Hora:"));
        String[] horas = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"};
        horaComboBox = new JComboBox<>(horas);
        add(horaComboBox);

        // Selección de barbero
        add(new JLabel("Selecciona un Barbero:"));
        String[] barberos = {"Santiago Montenegro", "Miguel Angel Velez", "Gustavo del Papa"};
        barberoComboBox = new JComboBox<>(barberos);
        barberoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDetallesBarbero((String) barberoComboBox.getSelectedItem());
            }
        });
        add(barberoComboBox);


        barberoDetallesArea = new JTextArea(5, 20);
        barberoDetallesArea.setEditable(false);
        add(new JScrollPane(barberoDetallesArea));

        // Selección de servicio
        add(new JLabel("Selecciona un Servicio:"));
        String[] servicios = {"Corte de cabello", "Corte y barba", "Afeitado", "Corte y cejas", "Tinte"};
        servicioComboBox = new JComboBox<>(servicios);
        servicioComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDetallesServicio((String) servicioComboBox.getSelectedItem());
            }
        });
        add(servicioComboBox);

        // Área de texto para mostrar detalles del servicio seleccionado
        servicioDetallesArea = new JTextArea(5, 20);
        servicioDetallesArea.setEditable(false);
        add(new JScrollPane(servicioDetallesArea));

        // Botón para reservar la cita y abrir la ventana de confirmación
        JButton reservarButton = new JButton("Reservar cita");
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
        add(reservarButton);


        JButton modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirCalendarioParaFecha();
            }
        });
        add(modificarButton);


        JButton cancelarButton = new JButton("Cancelar");
        add(cancelarButton);
    }


    private void mostrarDetallesBarbero(String barbero) {
        String detalles = "";
        switch (barbero) {
            case "Santiago Montenegro":
                detalles = "Teléfono: +57 3218269937\n" +
                        "Correo: Santiago3567.ml@gmail.com\n" +
                        "Especialidad: Freestyle\n" +
                        "Experiencia: 3 años";
                break;
            case "Miguel Angel Velez":
                detalles = "Teléfono: +57 3186748283\n" +
                        "Correo: Miguelbarber1@gmail.com\n" +
                        "Especialidad: Difuminado\n" +
                        "Experiencia: 5 años";
                break;
            case "Gustavo del Papa":
                detalles = "Teléfono: +57 3168513285\n" +
                        "Correo: Gustavo2015@gmail.com\n" +
                        "Especialidad: Tijera\n" +
                        "Experiencia: 1 año";
                break;
        }
        barberoDetallesArea.setText(detalles);
    }


    private void mostrarDetallesServicio(String servicio) {
        String detalles = "";
        switch (servicio) {
            case "Corte de cabello":
                detalles = "Precio: $15.000\nDescripción: Corte de cabello profesional.";
                break;
            case "Corte y barba":
                detalles = "Precio: $18.000\nDescripción: Corte de cabello y barba.";
                break;
            case "Afeitado":
                detalles = "Precio: $17.000\nDescripción: Afeitado completo y cuidado facial.";
                break;
            case "Corte y cejas":
                detalles = "Precio: $20.000\nDescripción: Corte de cabello y cejas.";
                break;
            case "Tinte":
                detalles = "Precio: $50.000\nDescripción: Tinte de cabello y barba.";
                break;
        }
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
        servicioComboBox.setSelectedIndex(0);
        barberoDetallesArea.setText("");
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
