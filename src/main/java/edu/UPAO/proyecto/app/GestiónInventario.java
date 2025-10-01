

package edu.UPAO.proyecto.app;

import java.awt.CardLayout;

public class GestiónInventario extends javax.swing.JFrame {

    public GestiónInventario() {
        initComponents();
        
        Content.add(new ModuloInventario(), "pag1");
        Content.add(new HistorialDevoluciones(), "pag2");
        Content.add(new GestionUsuarios(), "pag3");
        
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag1");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneladm = new javax.swing.JPanel();
        pag1Inventario = new javax.swing.JButton();
        pag2Devolucion = new javax.swing.JButton();
        pag3Usuarios = new javax.swing.JButton();
        pag5Proveedores = new javax.swing.JButton();
        pag6Configuracion = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pag7CerrarSecion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneladm.setBackground(new java.awt.Color(255, 255, 204));

        pag1Inventario.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag1Inventario.setText("Stock Inventario");
        pag1Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag1InventarioActionPerformed(evt);
            }
        });

        pag2Devolucion.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag2Devolucion.setText("Devolucion");
        pag2Devolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag2DevolucionActionPerformed(evt);
            }
        });

        pag3Usuarios.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag3Usuarios.setText("Permisos Usuarios");
        pag3Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag3UsuariosActionPerformed(evt);
            }
        });

        pag5Proveedores.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag5Proveedores.setText("Proveedores");
        pag5Proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag5ProveedoresActionPerformed(evt);
            }
        });

        pag6Configuracion.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag6Configuracion.setText("Configuracion");
        pag6Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag6ConfiguracionActionPerformed(evt);
            }
        });

        Content.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Administrador (nombre)");

        pag7CerrarSecion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        pag7CerrarSecion.setText("Salir");
        pag7CerrarSecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag7CerrarSecionActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 0, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 656, Short.MAX_VALUE)
                .addComponent(pag7CerrarSecion, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pag7CerrarSecion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout paneladmLayout = new javax.swing.GroupLayout(paneladm);
        paneladm.setLayout(paneladmLayout);
        paneladmLayout.setHorizontalGroup(
            paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneladmLayout.createSequentialGroup()
                .addGroup(paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneladmLayout.createSequentialGroup()
                        .addGroup(paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pag5Proveedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pag3Usuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(pag2Devolucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pag1Inventario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pag6Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneladmLayout.setVerticalGroup(
            paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(paneladmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneladmLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(pag1Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pag2Devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pag3Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pag5Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pag6Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneladmLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(129, 129, 129))
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneladm, javax.swing.GroupLayout.PREFERRED_SIZE, 1121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paneladm, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pag7CerrarSecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag7CerrarSecionActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag7");
    }//GEN-LAST:event_pag7CerrarSecionActionPerformed

    private void pag6ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag6ConfiguracionActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag6");
    }//GEN-LAST:event_pag6ConfiguracionActionPerformed

    private void pag5ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag5ProveedoresActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag5");
    }//GEN-LAST:event_pag5ProveedoresActionPerformed

    private void pag3UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag3UsuariosActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag3");
    }//GEN-LAST:event_pag3UsuariosActionPerformed

    private void pag2DevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag2DevolucionActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag2");
    }//GEN-LAST:event_pag2DevolucionActionPerformed

    private void pag1InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag1InventarioActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag1");
    }//GEN-LAST:event_pag1InventarioActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestiónInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestiónInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestiónInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestiónInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestiónInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton pag1Inventario;
    private javax.swing.JButton pag2Devolucion;
    private javax.swing.JButton pag3Usuarios;
    private javax.swing.JButton pag5Proveedores;
    private javax.swing.JButton pag6Configuracion;
    private javax.swing.JButton pag7CerrarSecion;
    private javax.swing.JPanel paneladm;
    // End of variables declaration//GEN-END:variables
}
