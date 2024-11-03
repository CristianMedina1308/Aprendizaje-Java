package view;

import controller.CalendarioController;
import interfaces.DateSelectedListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CalendarioView extends JFrame {
    private Calendar calendar;
    private JPanel calendarPanel;
    private JLabel monthLabel;
    private DateSelectedListener dateSelectedListener;

    public CalendarioView() {
        setTitle("Calendario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        calendar = Calendar.getInstance();
        monthLabel = new JLabel("", SwingConstants.CENTER);
        updateMonthLabel();

        // Botones de navegación
        JButton previousButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");


        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, -1); // Ir al mes anterior
                updateCalendar();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calendar.add(Calendar.MONTH, 1); // Ir al siguiente mes
                updateCalendar();
            }
        });


        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new FlowLayout());
        navigationPanel.add(previousButton);
        navigationPanel.add(monthLabel);
        navigationPanel.add(nextButton);


        add(navigationPanel, BorderLayout.NORTH);

        // Inicializar el panel del calendario
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(7, 7));
        add(calendarPanel, BorderLayout.CENTER);

        updateCalendar();
    }

    public CalendarioView(String nombre, String telefono, String barbero, String servicio) {
    }

    private void updateMonthLabel() {

        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, getLocale());
        int year = calendar.get(Calendar.YEAR);
        monthLabel.setText(month + " " + year);
    }

    private void updateCalendar() {

        calendarPanel.removeAll();
        updateMonthLabel();


        String[] dias = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String dia : dias) {
            calendarPanel.add(new JLabel(dia, SwingConstants.CENTER));
        }


        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);


        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= daysInMonth; day++) {
            JLabel dayLabel = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            dayLabel.setOpaque(true);
            dayLabel.setBackground(Color.LIGHT_GRAY);
            dayLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            dayLabel.setPreferredSize(new Dimension(40, 40));


            dayLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    int selectedDay = Integer.parseInt(dayLabel.getText());
                    String selectedDate = selectedDay + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
                    if (dateSelectedListener != null) {
                        dateSelectedListener.onDateSelected(selectedDate);
                    }
                    dispose();
                }
            });

            calendarPanel.add(dayLabel);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public void showCalendar() {
        setVisible(true);
    }


    public void addDateSelectedListener(DateSelectedListener listener) {
        this.dateSelectedListener = listener;
    }

    public void addModificarCitaListener(CalendarioController.ModificarCitaButtonListener modificarCitaButtonListener) {
    }

    public void addCancelarCitaListener(CalendarioController.CancelarCitaButtonListener cancelarCitaButtonListener) {

    }
}
