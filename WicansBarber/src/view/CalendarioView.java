package view;

import controller.CalendarioController;
import interfaces.DateSelectedListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarioView extends JFrame {
    private JButton[] dayButtons;
    private DateSelectedListener dateSelectedListener;
    private JLabel selectedDateLabel;

    private String selectedDate = "";

    public CalendarioView() {
        setTitle("Selecciona una fecha");
        setSize(450, 450);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Obtener el calendario actual
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        String currentMonth = sdf.format(calendar.getTime());

        JLabel monthLabel = new JLabel(currentMonth, SwingConstants.CENTER);
        monthLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(monthLabel, BorderLayout.NORTH);

        // Panel para los días de la semana
        JPanel daysPanel = new JPanel();
        daysPanel.setLayout(new GridLayout(1, 7)); // 7 columnas para los días de la semana
        daysPanel.setBackground(new Color(245, 245, 245));

        String[] daysOfWeek = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 14));
            label.setForeground(new Color(96, 185, 255)); // Color azul más claro
            daysPanel.add(label);
        }
        add(daysPanel, BorderLayout.CENTER);

        // Panel para los días del mes
        JPanel calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(6, 7)); // 6 filas para los días del mes
        calendarPanel.setBackground(new Color(245, 245, 245));

        // Crear los botones de los días
        dayButtons = new JButton[42]; // 6 semanas * 7 días
        for (int i = 0; i < 42; i++) {
            JButton dayButton = new JButton();
            dayButton.setFont(new Font("SansSerif", Font.PLAIN, 12)); // Reducimos el tamaño de la fuente
            dayButton.setBackground(new Color(96, 185, 255)); // Color azul más claro
            dayButton.setForeground(Color.WHITE);
            dayButton.setFocusPainted(false);
            dayButton.setEnabled(false);
            calendarPanel.add(dayButton);
            dayButtons[i] = dayButton;
        }

        // Configurar los días del mes en el calendario
        updateCalendar(calendar);
        add(calendarPanel, BorderLayout.CENTER);

        // Etiqueta para mostrar la fecha seleccionada
        selectedDateLabel = new JLabel("Fecha seleccionada: Ninguna", SwingConstants.CENTER);
        selectedDateLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        selectedDateLabel.setForeground(Color.BLACK);
        add(selectedDateLabel, BorderLayout.SOUTH); // Agregar la etiqueta al pie de la ventana

        // Botón para seleccionar la fecha
        JButton selectButton = new JButton("Seleccionar Fecha");
        selectButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        selectButton.setBackground(new Color(39, 174, 96));
        selectButton.setForeground(Color.WHITE);
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!selectedDate.isEmpty()) {
                    if (dateSelectedListener != null) {
                        dateSelectedListener.onDateSelected(selectedDate);
                    }
                    dispose(); // Cerrar el calendario después de la selección
                } else {
                    JOptionPane.showMessageDialog(CalendarioView.this, "Por favor, selecciona una fecha primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        add(selectButton, BorderLayout.SOUTH);
    }

    // Método para actualizar el calendario con los días del mes
    private void updateCalendar(Calendar calendar) {
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 0; i < 42; i++) {
            dayButtons[i].setEnabled(false); // Desactivar todos los botones inicialmente
            dayButtons[i].setText("");
        }

        for (int i = 0; i < daysInMonth; i++) {
            int buttonIndex = i + firstDayOfWeek - 1; // Ajuste para el primer día de la semana
            dayButtons[buttonIndex].setText(String.valueOf(i + 1));
            dayButtons[buttonIndex].setEnabled(true);
            int finalI = i + 1;
            dayButtons[buttonIndex].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Aquí se almacena la fecha seleccionada
                    selectedDate = "2024-11-" + (finalI < 10 ? "0" + finalI : finalI);
                    selectedDateLabel.setText("Fecha seleccionada: " + selectedDate); // Actualizar la etiqueta
                }
            });
        }
    }

    // Método para mostrar el calendario
    public void showCalendar() {
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    // Registrar el listener para la selección de fecha
    public void addDateSelectedListener(DateSelectedListener listener) {
        this.dateSelectedListener = listener;
    }

    public void addModificarCitaListener(CalendarioController.ModificarCitaButtonListener modificarCitaButtonListener) {
    }

    public void addCancelarCitaListener(CalendarioController.CancelarCitaButtonListener cancelarCitaButtonListener) {
    }
}
