
package edu.UPAO.proyecto.app;

public class ModuloInventario extends javax.swing.JPanel {
    
    public ModuloInventario() {
        initComponents();
        
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        jTable2.setFillsViewportHeight(true);
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        // Hacer clickeable el panel de notificaciones
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrarNotificaciones();
            }
        });
        
        
        actualizarContadorStockCritico();
    }
    
    
    private boolean validarNombreProducto(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        return nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+");
    }
    
    
    private String determinarEstado(int stock) {
        if (stock == 0) {
            return "Agotado";
        } else if (stock < 50) {
            return "Casi Agotado";
        } else {
            return "Disponible";
        }
    }
    
    
    private void actualizarContadorStockCritico() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        int contador = 0;
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            int stock = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            if (stock < 50) {
                contador++;
            }
        }
        
        jLabel12.setText(String.valueOf(contador));
        
        
        if (contador == 0) {
            jLabel12.setForeground(new java.awt.Color(34, 139, 34)); 
        } else if (contador < 3) {
            jLabel12.setForeground(new java.awt.Color(255, 165, 0)); 
        } else {
            jLabel12.setForeground(new java.awt.Color(220, 20, 60)); 
        }
    }
    
    
    private void mostrarNotificaciones() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        
        
        java.util.List<String[]> productosConStockBajo = new java.util.ArrayList<>();
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String codigo = modelo.getValueAt(i, 0).toString();
            String nombre = modelo.getValueAt(i, 1).toString();
            int stock = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            String estado = modelo.getValueAt(i, 4).toString();
            
            if (stock < 50) {
                productosConStockBajo.add(new String[]{codigo, nombre, String.valueOf(stock), estado});
            }
        }
        
        
        javax.swing.JDialog dialogoNotificaciones = new javax.swing.JDialog();
        dialogoNotificaciones.setTitle("Notificaciones de Stock");
        dialogoNotificaciones.setSize(650, 450);
        dialogoNotificaciones.setLocationRelativeTo(this);
        dialogoNotificaciones.setModal(true);
        
        
        javax.swing.JPanel panelPrincipal = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        panelPrincipal.setBackground(java.awt.Color.WHITE);
        panelPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        javax.swing.JPanel panelHeader = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelHeader.setBackground(java.awt.Color.WHITE);
        
        javax.swing.JLabel lblTitulo = new javax.swing.JLabel("🔔 Notificaciones de Inventario");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));
        lblTitulo.setForeground(new java.awt.Color(220, 20, 60));
        panelHeader.add(lblTitulo);
        
        
        if (productosConStockBajo.isEmpty()) {
            javax.swing.JPanel panelVacio = new javax.swing.JPanel();
            panelVacio.setLayout(new javax.swing.BoxLayout(panelVacio, javax.swing.BoxLayout.Y_AXIS));
            panelVacio.setBackground(java.awt.Color.WHITE);
            
            javax.swing.JLabel lblIcono = new javax.swing.JLabel("✅");
            lblIcono.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 72));
            lblIcono.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            
            javax.swing.JLabel lblMensaje = new javax.swing.JLabel("No hay productos con stock bajo");
            lblMensaje.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 18));
            lblMensaje.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            lblMensaje.setForeground(new java.awt.Color(100, 100, 100));
            
            panelVacio.add(javax.swing.Box.createVerticalGlue());
            panelVacio.add(lblIcono);
            panelVacio.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 20)));
            panelVacio.add(lblMensaje);
            panelVacio.add(javax.swing.Box.createVerticalGlue());
            
            panelPrincipal.add(panelHeader, java.awt.BorderLayout.NORTH);
            panelPrincipal.add(panelVacio, java.awt.BorderLayout.CENTER);
        } else {
            
            String[] columnas = {"Código", "Producto", "Stock", "Estado"};
            javax.swing.table.DefaultTableModel modeloNotif = new javax.swing.table.DefaultTableModel(columnas, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
            for (String[] producto : productosConStockBajo) {
                modeloNotif.addRow(producto);
            }
            
            javax.swing.JTable tablaNotificaciones = new javax.swing.JTable(modeloNotif);
            tablaNotificaciones.setRowHeight(35);
            tablaNotificaciones.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
            tablaNotificaciones.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
            tablaNotificaciones.getTableHeader().setBackground(new java.awt.Color(220, 20, 60));
            tablaNotificaciones.getTableHeader().setForeground(java.awt.Color.WHITE);
            
            
            tablaNotificaciones.getColumnModel().getColumn(3).setCellRenderer(
                new javax.swing.table.DefaultTableCellRenderer() {
                    @Override
                    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, 
                            Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        
                        javax.swing.JLabel label = (javax.swing.JLabel) super.getTableCellRendererComponent(
                            table, value, isSelected, hasFocus, row, column);
                        
                        label.setHorizontalAlignment(javax.swing.JLabel.CENTER);
                        label.setOpaque(true);
                        label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 11));
                        
                        String estado = value.toString();
                        if (estado.equals("Agotado")) {
                            label.setBackground(new java.awt.Color(220, 20, 60));
                            label.setForeground(java.awt.Color.WHITE);
                        } else if (estado.equals("Casi Agotado")) {
                            label.setBackground(new java.awt.Color(255, 165, 0));
                            label.setForeground(java.awt.Color.WHITE);
                        }
                        
                        return label;
                    }
                }
            );
            
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(tablaNotificaciones);
            
            
            javax.swing.JPanel panelResumen = new javax.swing.JPanel();
            panelResumen.setBackground(new java.awt.Color(255, 245, 230));
            panelResumen.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 165, 0), 2),
                javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)
            ));
            panelResumen.setLayout(new javax.swing.BoxLayout(panelResumen, javax.swing.BoxLayout.Y_AXIS));
            
            javax.swing.JLabel lblResumen = new javax.swing.JLabel(
                "⚠️  " + productosConStockBajo.size() + " producto(s) requieren atención"
            );
            lblResumen.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
            lblResumen.setForeground(new java.awt.Color(180, 80, 0));
            
            javax.swing.JLabel lblAccion = new javax.swing.JLabel(
                "Se recomienda realizar una orden de compra"
            );
            lblAccion.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
            lblAccion.setForeground(new java.awt.Color(100, 100, 100));
            
            panelResumen.add(lblResumen);
            panelResumen.add(javax.swing.Box.createRigidArea(new java.awt.Dimension(0, 5)));
            panelResumen.add(lblAccion);
            
            panelPrincipal.add(panelHeader, java.awt.BorderLayout.NORTH);
            panelPrincipal.add(scrollPane, java.awt.BorderLayout.CENTER);
            panelPrincipal.add(panelResumen, java.awt.BorderLayout.SOUTH);
        }
        
        dialogoNotificaciones.add(panelPrincipal);
        dialogoNotificaciones.setVisible(true);
    }
    
    private void agregarProducto() {
        String codigo = jTextField1.getText().trim();
        
        if (codigo.isEmpty() || codigo.equals("ID Producto")) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Ingrese un código válido", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String nombre = null;
        boolean nombreValido = false;
        
        while (!nombreValido) {
            nombre = javax.swing.JOptionPane.showInputDialog(this, 
                "Nombre del producto : ");
            
            if (nombre == null) return;
            
            if (validarNombreProducto(nombre)) {
                nombreValido = true;
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "El nombre solo puede contener letras y espacios\n" +
                    "No se permiten números ni caracteres especiales", 
                    "Nombre Inválido", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
        String stockStr = null;
        int stock = -1;
        boolean stockValido = false;
        
        while (!stockValido) {
            stockStr = javax.swing.JOptionPane.showInputDialog(this, 
                "Stock inicial : ");
            
            if (stockStr == null) return;
            
            try {
                stock = Integer.parseInt(stockStr.trim());
                
                if (stock < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "El stock no puede ser negativo\n" +
                        "Ingrese un valor de 0 o mayor", 
                        "Stock Inválido", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    stockValido = true;
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Ingrese un número válido para el stock", 
                    "Error de Formato", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
        String precioStr = null;
        double precio = -1;
        boolean precioValido = false;
        
        while (!precioValido) {
            precioStr = javax.swing.JOptionPane.showInputDialog(this, 
                "Precio unitario : ");
            
            if (precioStr == null) return;
            
            try {
                precio = Double.parseDouble(precioStr.trim());
                
                if (precio < 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "El precio no puede ser negativo\n" +
                        "Ingrese un valor de 0 o mayor", 
                        "Precio Inválido", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    precioValido = true;
                }
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Ingrese un número válido para el precio", 
                    "Error de Formato", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
        
        String estado = determinarEstado(stock);
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        Object[] fila = {codigo, nombre, stock, precio, estado};
        modelo.addRow(fila);
        
        jTextField1.setText("ID Producto");
        
        
        actualizarContadorStockCritico();
        
        String mensajeEstado = "";
        if (estado.equals("Casi Agotado")) {
            mensajeEstado = "\n⚠️ ADVERTENCIA: Stock bajo (menos de 50 unidades ejemplo*)";
        } else if (estado.equals("Agotado")) {
            mensajeEstado = "\n❌ ADVERTENCIA: Producto sin stock";
        }
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Producto agregado: " + nombre + "\n" +
            "Stock: " + stock + "\n" +
            "Precio: $" + precio + "\n" +
            "Estado: " + estado + mensajeEstado, 
            "Producto Agregado", 
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void eliminarProducto() {
        int filaSeleccionada = jTable2.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un producto de la tabla para eliminar", 
                "No hay selección", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        String codigo = modelo.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modelo.getValueAt(filaSeleccionada, 1).toString();
        
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, 
            "¿Está seguro de eliminar el producto?\n\n" +
            "Código: " + codigo + "\n" +
            "Nombre: " + nombre, 
            "Confirmar Eliminación", 
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            modelo.removeRow(filaSeleccionada);
            
            
            actualizarContadorStockCritico();
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Producto eliminado: " + nombre, 
                "Eliminación Exitosa", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void registrarEntrada() {
        int filaSeleccionada = jTable2.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un producto existente para registrar entrada de mercancía", 
                "No hay selección", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        String codigo = modelo.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modelo.getValueAt(filaSeleccionada, 1).toString();
        int stockActual = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 2).toString());
        
        String cantidadStr = javax.swing.JOptionPane.showInputDialog(this, 
            "REGISTRO DE ENTRADA DE MERCANCÍA\n\n" +
            "Producto: " + nombre + "\n" +
            "Stock actual: " + stockActual + "\n\n" +
            "Cantidad recibida:", 
            "0");
        
        if (cantidadStr == null) return;
        
        String proveedor = javax.swing.JOptionPane.showInputDialog(this, 
            "Nombre del proveedor:", 
            "Proveedor");
        
        if (proveedor == null || proveedor.trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Debe especificar el proveedor", 
                "Proveedor Requerido", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            int cantidadRecibida = Integer.parseInt(cantidadStr.trim());
            
            if (cantidadRecibida < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "La cantidad no puede ser negativa", 
                    "Cantidad Inválida", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (cantidadRecibida == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "La cantidad debe ser mayor a 0", 
                    "Cantidad Inválida", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int nuevoStock = stockActual + cantidadRecibida;
            
            modelo.setValueAt(nuevoStock, filaSeleccionada, 2);
            String nuevoEstado = determinarEstado(nuevoStock);
            modelo.setValueAt(nuevoEstado, filaSeleccionada, 4);
            
            
            actualizarContadorStockCritico();
            
            String fechaHora = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            
            String logEntry = String.format(
                "[%s] ENTRADA - Producto: %s | Cantidad: +%d | Stock: %d→%d | Proveedor: %s",
                fechaHora, nombre, cantidadRecibida, stockActual, nuevoStock, proveedor
            );
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                "ENTRADA REGISTRADA EXITOSAMENTE\n\n" +
                "Producto: " + nombre + "\n" +
                "Cantidad recibida: +" + cantidadRecibida + "\n" +
                "Stock anterior: " + stockActual + "\n" +
                "Stock nuevo: " + nuevoStock + "\n" +
                "Estado: " + nuevoEstado + "\n" +
                "Proveedor: " + proveedor + "\n" +
                "Fecha: " + fechaHora, 
                "Entrada Registrada", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            System.out.println("LOG ENTRADA: " + logEntry);
            
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "La cantidad debe ser un número válido", 
                "Error de Formato", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarStock() {
        int filaSeleccionada = jTable2.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Seleccione un producto de la tabla para actualizar su stock", 
                "No hay selección", 
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        String codigo = modelo.getValueAt(filaSeleccionada, 0).toString();
        String nombre = modelo.getValueAt(filaSeleccionada, 1).toString();
        String stockActual = modelo.getValueAt(filaSeleccionada, 2).toString();
        
        String nuevoStockStr = javax.swing.JOptionPane.showInputDialog(this, 
            "Producto: " + nombre + "\n" +
            "Stock actual: " + stockActual + "\n\n" +
            "Ingrese el nuevo stock (0 o mayor):", 
            stockActual);
        
        if (nuevoStockStr == null) return;
        
        try {
            int nuevoStock = Integer.parseInt(nuevoStockStr.trim());
            
            if (nuevoStock < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "El stock no puede ser negativo\n" +
                    "Debe ser 0 o mayor", 
                    "Stock Inválido", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            modelo.setValueAt(nuevoStock, filaSeleccionada, 2);
            String nuevoEstado = determinarEstado(nuevoStock);
            modelo.setValueAt(nuevoEstado, filaSeleccionada, 4);
            
           
            actualizarContadorStockCritico();
            
            String mensajeAdicional = "";
            if (nuevoEstado.equals("Casi Agotado")) {
                mensajeAdicional = "\n\n⚠️ ADVERTENCIA: Stock bajo (menos de 50 unidades)";
            } else if (nuevoEstado.equals("Agotado")) {
                mensajeAdicional = "\n\n❌ ADVERTENCIA: Producto sin stock";
            }
            
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Stock actualizado exitosamente\n\n" +
                "Producto: " + nombre + "\n" +
                "Stock anterior: " + stockActual + "\n" +
                "Stock nuevo: " + nuevoStock + "\n" +
                "Estado: " + nuevoEstado + mensajeAdicional, 
                "Actualización Exitosa", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un número válido para el stock", 
                "Error de Formato", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 133, 58));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Codigo producto");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("🔍");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Registrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Actualizar Stock");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Modulo Inventario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Stock actual", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setPreferredSize(new java.awt.Dimension(370, 370));
        jScrollPane1.setViewportView(jTable2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Stock Critico");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setText("1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Notificaciones");

        jLabel8.setText("⚠️ Stock Crítico ");

        jLabel9.setText("📦 Nueva orden de compra");

        jLabel10.setText("📤 Actualización de Precios");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agregarProducto();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarProducto();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        actualizarStock();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        registrarEntrada();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
