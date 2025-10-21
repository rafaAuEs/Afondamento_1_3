import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("INICIO DE LA SIMULACIÓN DE BANCOS CONCURRENTE");

        // Clientes para el Cajero 1
        List<Cliente> clientesCajero1 = new ArrayList<>();
        clientesCajero1.add(new Cliente("Cliente-A"));
        clientesCajero1.add(new Cliente("Cliente-B"));
        clientesCajero1.add(new Cliente("Cliente-C"));
        clientesCajero1.add(new Cliente("Cliente-D"));

        // Clientes para el Cajero 2
        List<Cliente> clientesCajero2 = new ArrayList<>();
        clientesCajero2.add(new Cliente("Cliente-E"));
        clientesCajero2.add(new Cliente("Cliente-F"));
        clientesCajero2.add(new Cliente("Cliente-G"));
        clientesCajero2.add(new Cliente("Cliente-H"));

        // Crear los hilos de los cajeros
        Cajero cajero1 = new Cajero("CAJERO-1", clientesCajero1);
        Cajero cajero2 = new Cajero("CAJERO-2", clientesCajero2);

        //Iniciar los hilos de los cajeros
        cajero1.start();
        cajero2.start();

        System.out.println("\nEl Hilo Principal ha lanzado a los 2 Cajeros concurrentes.");
    }
}