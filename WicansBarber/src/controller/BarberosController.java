package controller;

import model.Servicio;
import view.BarberosView;
import view.ReservaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarberosController {
    private BarberosView vista;

    public BarberosController(BarberosView vista, Servicio[] servicios) {
        this.vista = vista;
        this.vista.addReservarListener(new ReservarButtonListener());
    }

    class ReservarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.setVisible(false); // Cerrar vista de barberos
            ReservaView reservaView = new ReservaView();
            ReservaController reservaController = new ReservaController(reservaView); // Controlador de reservas
            reservaView.setVisible(true); // Mostrar vista de reservas
        }
    }
}
