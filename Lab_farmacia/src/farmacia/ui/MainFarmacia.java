// Declaramos el paquete donde se encuentra la clase
package farmacia.ui;

// Clase principal del proyecto
public class MainFarmacia {
    
    // Método main: punto de entrada de la aplicación
    public static void main(String[] args) {
        
        // SwingUtilities.invokeLater() asegura que la interfaz gráfica
        // se ejecute en el hilo de eventos de Swing (Event Dispatch Thread),
        // lo cual es una buena práctica para evitar problemas de concurrencia.
        javax.swing.SwingUtilities.invokeLater(() -> {
            
            // Se crea una nueva instancia de VentanaPedido (ventana principal del sistema)
            new VentanaPedido();
        });
    }
}

