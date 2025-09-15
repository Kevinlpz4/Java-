// Declaramos el paquete donde está ubicada la clase
package farmacia.ui;

// Importamos las librerías necesarias
import java.awt.*;        // Contiene clases para manejar layouts, fuentes y diseño de la ventana
import javax.swing.*;     // Contiene los componentes gráficos de Swing (JFrame, JButton, JLabel, etc.)

// Clase pública VentanaResumen que hereda de JFrame (ventana principal de Swing)
public class VentanaResumen extends JFrame {

    // Constructor de la clase VentanaResumen
    // Recibe los datos del pedido que se mostrarán en la ventana de confirmación
    public VentanaResumen(String medicamento, String tipo, int cantidad, String distribuidor,
                          boolean sucPrincipal, boolean sucSecundaria) {
        
        // Establece el título de la ventana con el distribuidor seleccionado
        setTitle("Pedido al distribuidor " + distribuidor);
        
        // Define el tamaño de la ventana (ancho 420px, alto 250px)
        setSize(420, 250);
        
        // Centra la ventana en la pantalla al abrirse
        setLocationRelativeTo(null);
        
        // Define el layout principal como BorderLayout, con espacios de 10 píxeles
        setLayout(new BorderLayout(10, 10));

        // Panel que contendrá la información del pedido
        // GridLayout con 2 filas y 1 columna, y espacios entre componentes
        JPanel panelInfo = new JPanel(new GridLayout(2, 1, 10, 10));
        
        // Establece márgenes internos de 20 píxeles en el panel
        panelInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Etiqueta para mostrar el medicamento con su cantidad y tipo
        JLabel lblMedicamento = new JLabel(cantidad + " unidades del " + tipo + " " + medicamento);
        // Cambia la fuente a Arial, en negrita, tamaño 14
        lblMedicamento.setFont(new Font("Arial", Font.BOLD, 14));

        // Construcción del texto con la(s) sucursal(es) seleccionada(s)
        StringBuilder direcciones = new StringBuilder("Para la farmacia situada en ");
        if (sucPrincipal) direcciones.append("Calle de la Rosa n. 28 ");
        if (sucSecundaria) direcciones.append("y en Calle Alcazabilla n. 3");

        // Etiqueta para mostrar la dirección de la(s) sucursal(es)
        JLabel lblSucursal = new JLabel(direcciones.toString());
        // Fuente estándar en Arial, tamaño 13
        lblSucursal.setFont(new Font("Arial", Font.PLAIN, 13));

        // Agrega las etiquetas al panel de información
        panelInfo.add(lblMedicamento);
        panelInfo.add(lblSucursal);

        // Panel para contener los botones de acción
        // FlowLayout coloca los botones alineados horizontalmente
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        // Botón para enviar el pedido
        JButton btnEnviar = new JButton(" Enviar pedido");
        
        // Botón para cancelar el pedido
        JButton btnCancelar = new JButton(" Cancelar");

        // Añadimos los botones al panel de botones
        panelBotones.add(btnEnviar);
        panelBotones.add(btnCancelar);

        // Agregamos los paneles a la ventana principal (JFrame)
        add(panelInfo, BorderLayout.CENTER);  // El panel con la información va al centro
        add(panelBotones, BorderLayout.SOUTH); // El panel de botones va abajo

        // Acción del botón Enviar: imprime en consola y muestra un cuadro de confirmación
        btnEnviar.addActionListener(e -> {
            System.out.println("Pedido enviado");
            JOptionPane.showMessageDialog(this, " Pedido enviado exitosamente");
            dispose(); // Cierra la ventana
        });

        // Acción del botón Cancelar: simplemente cierra la ventana
        btnCancelar.addActionListener(e -> dispose());

        // Hace visible la ventana una vez configurada
        setVisible(true);
    }
}
