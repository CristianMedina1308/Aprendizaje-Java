package interfaces;

public interface ConfirmacionListener {
    void onConfirmar(String nombre, String telefono, String fecha, String hora, String barbero, String servicio);
    void onReservarOtraCita();
    void onCancelar();
}
