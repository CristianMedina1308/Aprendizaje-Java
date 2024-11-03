package controller;

import view.ModificarCitaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModificarCitaController {
    private ModificarCitaView vista;

    public ModificarCitaController(ModificarCitaView vista) {
        this.vista = vista;
        this.vista.addModificarListener(new ModificarButtonListener());
    }

    class ModificarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String citaId = vista.getCitaId();

            vista.showMessage("Cita modificada con éxito.");
        }
    }
}
