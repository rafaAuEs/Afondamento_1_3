import java.util.Random;

public class Cliente implements Runnable {

    private String nombreCliente;
    private int tiempoTransaccion; // El tiempo aleatorio en segundos

    // Define el rango de tiempo aleatorio para la transacción
    private static final int MIN_SEG = 2;
    private static final int MAX_SEG = 6;

    //Constructor
    public Cliente(String nombre) {
        this.nombreCliente = nombre;

        // Generar el tiempo aleatorio en el constructor
        Random random = new Random();
        // Randomizamos
        this.tiempoTransaccion = random.nextInt(MAX_SEG - MIN_SEG + 1) + MIN_SEG;
    }

    // Getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getTiempo() {
        return tiempoTransaccion;
    }

    // Hilo
    @Override
    public void run() {
        System.out.println("   [CLIENTE " + nombreCliente + "]: Inicia transacción.");
        try {
            // Simulamos el tiempo de espera de cada cliente
            Thread.sleep(tiempoTransaccion * 1000);
        } catch (InterruptedException e) {
            System.out.println("   [CLIENTE " + nombreCliente + "]: Transacción interrumpida.");
            Thread.currentThread().interrupt();
        }
        System.out.println("   [CLIENTE " + nombreCliente + "]: Transacción FINALIZADA. Duracioón:" + tiempoTransaccion + "segundos.");
    }
}