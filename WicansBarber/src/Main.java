import db.connection;
import view.InicioView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        connection.getConnection();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InicioView inicioView = new InicioView();
                inicioView.setVisible(true);
            }
        });
    }
}
