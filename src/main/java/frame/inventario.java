

package frame;

import java.awt.CardLayout;

public class inventario extends javax.swing.JFrame {

    public inventario() {
        initComponents();
        
        Content.add(new pag1(), "pag1");
        Content.add(new pag2(), "pag2");
        Content.add(new pag3(), "pag3");
        Content.add(new pag4(), "pag4");
        Content.add(new pag5(), "pag5");
        Content.add(new pag6(), "pag6");
        Content.add(new pag7(), "pag7");
        
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag1");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneladm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pag7CerrarSecion = new javax.swing.JButton();
        pag1Inventario = new javax.swing.JButton();
        pag2Devolucion = new javax.swing.JButton();
        pag3Reportes = new javax.swing.JButton();
        pag4Usuarios = new javax.swing.JButton();
        pag5Proveedores = new javax.swing.JButton();
        pag6Configuracion = new javax.swing.JButton();
        Content = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneladm.setBackground(new java.awt.Color(255, 133, 57));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setText("Administrador (nombre)");

        pag7CerrarSecion.setText("Salir");
        pag7CerrarSecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag7CerrarSecionActionPerformed(evt);
            }
        });

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

        pag3Reportes.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag3Reportes.setText("Reportes");
        pag3Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag3ReportesActionPerformed(evt);
            }
        });

        pag4Usuarios.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        pag4Usuarios.setText("Usuarios");
        pag4Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag4UsuariosActionPerformed(evt);
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Content.add(jPanel1, "card2");

        javax.swing.GroupLayout paneladmLayout = new javax.swing.GroupLayout(paneladm);
        paneladm.setLayout(paneladmLayout);
        paneladmLayout.setHorizontalGroup(
            paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneladmLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pag5Proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pag4Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pag3Reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pag2Devolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pag6Configuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pag1Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneladmLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pag7CerrarSecion, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        paneladmLayout.setVerticalGroup(
            paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paneladmLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(pag1Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pag2Devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pag3Reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pag4Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pag5Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pag6Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paneladmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paneladmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pag7CerrarSecion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneladm, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneladm, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pag1InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag1InventarioActionPerformed
       CardLayout cl = (CardLayout) Content.getLayout();
       cl.show(Content, "pag1");
    }//GEN-LAST:event_pag1InventarioActionPerformed

    private void pag2DevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag2DevolucionActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag2");
    }//GEN-LAST:event_pag2DevolucionActionPerformed

    private void pag3ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag3ReportesActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag3");
    }//GEN-LAST:event_pag3ReportesActionPerformed

    private void pag4UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag4UsuariosActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag4");
    }//GEN-LAST:event_pag4UsuariosActionPerformed

    private void pag5ProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag5ProveedoresActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag5");
    }//GEN-LAST:event_pag5ProveedoresActionPerformed

    private void pag6ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag6ConfiguracionActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag6");
    }//GEN-LAST:event_pag6ConfiguracionActionPerformed

    private void pag7CerrarSecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag7CerrarSecionActionPerformed
        CardLayout cl = (CardLayout) Content.getLayout();
        cl.show(Content, "pag7");
    }//GEN-LAST:event_pag7CerrarSecionActionPerformed

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
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pag1Inventario;
    private javax.swing.JButton pag2Devolucion;
    private javax.swing.JButton pag3Reportes;
    private javax.swing.JButton pag4Usuarios;
    private javax.swing.JButton pag5Proveedores;
    private javax.swing.JButton pag6Configuracion;
    private javax.swing.JButton pag7CerrarSecion;
    private javax.swing.JPanel paneladm;
    // End of variables declaration//GEN-END:variables
}
