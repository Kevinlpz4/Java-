// Declaramos el paquete donde se encuentra la clase
package farmacia.ui;

// Importamos librerías necesarias
import java.awt.*;        // Manejo de layouts, paneles, distribución, etc.
import javax.swing.*;     // Componentes gráficos de Swing (JFrame, JButton, JLabel, etc.)

// Clase VentanaPedido que hereda de JFrame (ventana principal)
public class VentanaPedido extends JFrame {

    // Declaramos los componentes gráficos como atributos de la clase
    private JTextField txtMedicamento, txtCantidad;      // Campos de texto
    private JComboBox<String> cbTipo;                    // Lista desplegable
    private JRadioButton rbCofarma, rbEmpsephar, rbCemefar; // Botones de opción
    private JCheckBox chkPrincipal, chkSecundaria;       // Casillas de verificación
    private JButton btnConfirmar, btnBorrar;             // Botones de acción

    // Constructor de la clase VentanaPedido
    public VentanaPedido() {
        // Título de la ventana
        setTitle("Sistema de Pedidos - Farmacia");
        
        // Indica que la aplicación se cierre al cerrar esta ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tamaño de la ventana (ancho, alto)
        setSize(450, 450);
        
        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);
        
        // Usamos BorderLayout para organizar la ventana principal
        setLayout(new BorderLayout(10, 10));

        // Panel principal con GridBagLayout (para mayor control de distribución)
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Márgenes internos

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);   // Espacio entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST; // Alinear componentes a la izquierda

        // ===== CREACIÓN DE LOS COMPONENTES =====
        txtMedicamento = new JTextField(20); // Campo de texto para medicamento
        txtCantidad = new JTextField(10);    // Campo de texto para cantidad

        // Menú desplegable con tipos de medicamento
        cbTipo = new JComboBox<>(new String[]{
                "Seleccione...", "Analgésico", "Analéptico", "Anestésico",
                "Antiácido", "Antidepresivo", "Antibiótico"
        });

        // Botones de opción para seleccionar distribuidor
        rbCofarma = new JRadioButton("Cofarma");
        rbEmpsephar = new JRadioButton("Empsephar");
        rbCemefar = new JRadioButton("Cemefar");

        // Agrupamos los JRadioButton para que solo se pueda elegir uno
        ButtonGroup grupoDistribuidores = new ButtonGroup();
        grupoDistribuidores.add(rbCofarma);
        grupoDistribuidores.add(rbEmpsephar);
        grupoDistribuidores.add(rbCemefar);

        // Casillas de verificación para sucursal
        chkPrincipal = new JCheckBox("Sucursal Principal");
        chkSecundaria = new JCheckBox("Sucursal Secundaria");

        // Botones principales
        btnConfirmar = new JButton("✅ Confirmar");
        btnBorrar = new JButton("🗑️ Borrar");

        // ===== DISTRIBUCIÓN DE COMPONENTES =====
        
        // Fila 1: Medicamento
        gbc.gridx = 0; gbc.gridy = 0; // Posición en la cuadrícula
        panelPrincipal.add(new JLabel("Nombre del medicamento:"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtMedicamento, gbc);

        // Fila 2: Tipo de medicamento
        gbc.gridx = 0; gbc.gridy = 1;
        panelPrincipal.add(new JLabel("Tipo de medicamento:"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(cbTipo, gbc);

        // Fila 3: Cantidad
        gbc.gridx = 0; gbc.gridy = 2;
        panelPrincipal.add(new JLabel("Cantidad:"), gbc);
        gbc.gridx = 1;
        panelPrincipal.add(txtCantidad, gbc);

        // Fila 4: Distribuidores (usamos un panel con FlowLayout)
        gbc.gridx = 0; gbc.gridy = 3;
        panelPrincipal.add(new JLabel("Distribuidor:"), gbc);
        JPanel panelDistribuidores = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelDistribuidores.add(rbCofarma);
        panelDistribuidores.add(rbEmpsephar);
        panelDistribuidores.add(rbCemefar);
        gbc.gridx = 1;
        panelPrincipal.add(panelDistribuidores, gbc);

        // Fila 5: Sucursales (también con FlowLayout)
        gbc.gridx = 0; gbc.gridy = 4;
        panelPrincipal.add(new JLabel("Sucursal:"), gbc);
        JPanel panelSucursales = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panelSucursales.add(chkPrincipal);
        panelSucursales.add(chkSecundaria);
        gbc.gridx = 1;
        panelPrincipal.add(panelSucursales, gbc);

        // Fila 6: Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelBotones.add(btnConfirmar);
        panelBotones.add(btnBorrar);

        // Agregamos paneles al frame principal
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // ===== EVENTOS =====
        
        // Botón Borrar → limpia los campos del formulario
        btnBorrar.addActionListener(e -> limpiarCampos());

        // Botón Confirmar → valida los datos e invoca VentanaResumen
        btnConfirmar.addActionListener(e -> validarDatos());

        // Hace visible la ventana
        setVisible(true);
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        txtMedicamento.setText("");
        txtCantidad.setText("");
        cbTipo.setSelectedIndex(0);
        rbCofarma.setSelected(false);
        rbEmpsephar.setSelected(false);
        rbCemefar.setSelected(false);
        chkPrincipal.setSelected(false);
        chkSecundaria.setSelected(false);
    }

    // Método para validar los datos ingresados
    private void validarDatos() {
        String medicamento = txtMedicamento.getText().trim();
        String tipo = cbTipo.getSelectedItem().toString();
        String cantidadStr = txtCantidad.getText().trim();

        // Validación del nombre
        if (medicamento.isEmpty() || !medicamento.matches("[a-zA-Z0-9 ]+")) {
            JOptionPane.showMessageDialog(this, "Nombre inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Validación del tipo de medicamento
        if (cbTipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de medicamento", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación de cantidad (debe ser número positivo)
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación del distribuidor
        String distribuidor = null;
        if (rbCofarma.isSelected()) distribuidor = "Cofarma";
        else if (rbEmpsephar.isSelected()) distribuidor = "Empsephar";
        else if (rbCemefar.isSelected()) distribuidor = "Cemefar";
        else {
            JOptionPane.showMessageDialog(this, "Seleccione un distribuidor", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validación de sucursal (al menos una)
        if (!chkPrincipal.isSelected() && !chkSecundaria.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione al menos una sucursal", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Si todo está correcto, se abre la ventana de resumen
        new VentanaResumen(medicamento, tipo, cantidad, distribuidor, chkPrincipal.isSelected(), chkSecundaria.isSelected());
    }
}
