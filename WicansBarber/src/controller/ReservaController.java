package controller;

import view.CalendarioView;
import view.ReservaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservaController {
    private ReservaView vista;

    public ReservaController(ReservaView vista) {
        this.vista = vista;


        this.vista.addReservarListener(new ReservarListener());
        this.vista.addModificarListener(new ModificarListener());
        this.vista.addCancelarListener(new CancelarListener());
    }

    public class ReservarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = vista.getNombre();
            String telefono = vista.getTelefono();
            String fecha = vista.getFecha();
            String hora = vista.getHora();
            String servicio = vista.getServicio();


            vista.showMessage("Cita reservada exitosamente para " + nombre);
            vista.setVisible(false);
            CalendarioView calendarioView = new CalendarioView();
            CalendarioController calendarioController = new CalendarioController(calendarioView);
            calendarioView.setVisible(true);
        }
    }

    public class ModificarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            vista.showMessage("Funcionalidad de modificación no implementada."); //Aun hace falta implmentar esto en el codigo
        }
    }

    public class CancelarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            vista.showMessage("Funcionalidad de cancelación no implementada.");
        }
    }
}
