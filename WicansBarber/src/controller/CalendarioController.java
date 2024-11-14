package controller;

import view.CalendarioView;
import view.CancelarCitaView;
import view.ModificarCitaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarioController {
    private CalendarioView vista;

    public CalendarioController(CalendarioView vista) {
        this.vista = vista;
        this.vista.addModificarCitaListener(new ModificarCitaButtonListener());
        this.vista.addCancelarCitaListener(new CancelarCitaButtonListener());
    }

    public class ModificarCitaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.setVisible(false); // Cerrar vista de calendario
            ModificarCitaView modificarCitaView = new ModificarCitaView(); // Crear vista para modificar cita
            ModificarCitaController modificarCitaController = new ModificarCitaController(modificarCitaView); // Controlador de modificar cita
            modificarCitaView.setVisible(true); // Mostrar vista para modificar cita
        }
    }

    public class CancelarCitaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.setVisible(false); // Cerrar vista de calendario
            CancelarCitaView cancelarCitaView = new CancelarCitaView(); // Crear vista para cancelar cita
            CancelarCitaController cancelarCitaController = new CancelarCitaController(cancelarCitaView); // Controlador de cancelar cita
            cancelarCitaView.setVisible(true); // Mostrar vista para cancelar cita
        }
    }
}
