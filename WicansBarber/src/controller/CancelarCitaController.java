package controller;

import view.CancelarCitaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelarCitaController {
    private CancelarCitaView vista;

    public CancelarCitaController(CancelarCitaView vista) {
        this.vista = vista;
        this.vista.addCancelarListener(new CancelarButtonListener());
    }

    class CancelarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String citaId = vista.getCitaId();

            vista.showMessage("Cita cancelada con éxito.");
        }
    }
}
