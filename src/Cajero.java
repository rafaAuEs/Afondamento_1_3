import java.util.List;
import java.util.Arrays;

public class Cajero extends Thread {

    private String nombreCajero;
    private List<Cliente> clientes;

    //Constructor y Getters/Setters
    public Cajero (String nombre, List<Cliente> lista){
        this.nombreCajero=nombre;
        this.clientes=lista;
    }

    // El resto de métodos de la clase Cajero...

    @Override
    public void run() { //metodo nativo del Thread
        System.out.println(this.nombreCajero + " abre y comienza a atender a " +
                this.clientes.size() + " clientes");

        // El Cajero itera sobre su lista de clientes
        for (Cliente cliente : this.clientes) {

            // hilo de cliente
            Thread hiloCliente = new Thread(cliente);

            // Iniciar el hilo
            hiloCliente.start();

            // APLICACIÓN DE JOIN()
            try {
                // esperar al hiloCliente
                hiloCliente.join();
            } catch (InterruptedException e) {
                System.out.println(this.nombreCajero + " fue interrumpido mientras esperaba al cliente " + cliente.getNombreCliente());
                Thread.currentThread().interrupt();
                return; // Salir si hay algún error
            }

            //El Cajero continúa con el siguiente cliente
            System.out.println(this.nombreCajero + " ha terminado con " + cliente.getNombreCliente() +
                    " y está libre para el siguiente.");
        }
        System.out.println(this.nombreCajero + " ha terminado con sus 4 clientes. ---");
    }
}