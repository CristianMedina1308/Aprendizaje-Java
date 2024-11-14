package db;

import java.sql.*;
import java.text.SimpleDateFormat;

public class connection {

    private static Connection connection;

    public static final String URL = "jdbc:mysql://localhost:3306/Barberias?useSSL=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "toor";

    // Método para obtener la conexión (mantener la conexión abierta)
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("¡Conexión exitosa!");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Error de conexión: " + e.getMessage());
                e.printStackTrace();
            }
        }

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // Método para registrar una cita en la base de datos
    public static boolean registrarCita(String nombre, String telefono, String fecha, String barbero, String corte) {
        String query = "INSERT INTO citasb (nombre, telefono, fecha, barbero, corte) VALUES (?, ?, ?, ?, ?)";
        boolean isSuccess = false;



        try {
            // Obtener la conexión global
            Connection conn = getConnection();


            // Establecer los parámetros de la consulta
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nombre);
                stmt.setString(2, telefono);
                stmt.setString(3, fecha);  // Establecer la fecha como Timestamp
                stmt.setString(4, barbero);
                stmt.setString(5, corte);

                // Ejecutar la consulta
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    isSuccess = true;
                    System.out.println("¡Cita registrada exitosamente!");
                }
            }

        } catch (SQLException  e) {
            System.out.println("Error al registrar la cita: " + e.getMessage());
            e.printStackTrace();
        }

        return isSuccess;
    }

    public static boolean validateUser(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Establecer los parámetros de la consulta
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                // Si encontramos al usuario, es válido
                if (rs.next()) {
                    isValid = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al validar el usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return isValid;
    }

    // Método para cerrar la conexión (cuando ya no se necesite)
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public static boolean registrarUsuario(String nombre, String contraseña) {
        String query = "INSERT INTO usuarios (nombre, contraseña) VALUES (?, ?)";
        boolean isSuccess = false;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Establecer los parámetros de la consulta
            stmt.setString(1, nombre);
            stmt.setString(2, contraseña);

            // Ejecutar la consulta
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
                System.out.println("¡Usuario registrado exitosamente!");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return isSuccess;
    }
}
