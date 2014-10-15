/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;

/**
 *
 * @author Nacho
 */
<<<<<<< HEAD:src/usuario/darseBaja.java
public class darseBaja extends javax.swing.JFrame {
    private Object nroReemplazante;
    private Object nroMiembro;
=======
public class DarseBaja extends javax.swing.JFrame {
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java

    /**
     * Creates new form Baja
     */
    public DarseBaja() {
        initComponents();
        //nroReemplazante desahabilitar el field;
    }

    /**
     
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
<<<<<<< HEAD:src/usuario/darseBaja.java
        nroMiembro = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        nroReemplazante = new javax.swing.JTextField();
        botonTerminar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
=======
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Darse de baja");

        jLabel2.setText("Ingrese su numero de miembro:");

<<<<<<< HEAD:src/usuario/darseBaja.java
        nroMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nroMiembroActionPerformed(evt);
            }
        });

=======
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java
        jCheckBox1.setText("Ingresar el numero de miembro del reemplazante:");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyPressed(evt);
            }
        });

<<<<<<< HEAD:src/usuario/darseBaja.java
        nroReemplazante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nroReemplazanteActionPerformed(evt);
            }
        });

        botonTerminar.setText("Terminar");
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
=======
        jButton1.setText("Terminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nroMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jCheckBox1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nroReemplazante, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(botonTerminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
<<<<<<< HEAD:src/usuario/darseBaja.java
                        .addComponent(botonCancelar)))
                .addContainerGap(178, Short.MAX_VALUE))
=======
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nroMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(nroReemplazante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonTerminar)
                    .addComponent(botonCancelar))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

<<<<<<< HEAD:src/usuario/darseBaja.java
    private void nroMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nroMiembroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nroMiembroActionPerformed
=======
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java

    private void jCheckBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1KeyPressed

<<<<<<< HEAD:src/usuario/darseBaja.java
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        nroReemplazante.setEnabled(!isEnabled());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        
        if((nroMiembro.getText().equals("")) || nroReemplazante.getText().equals(""))
		{
		/**	Infraccion infraccion = new SinReemplazante();
			miembroViejo.getInfracciones().add(infraccion);
			System.out.println("Se lo ha sancionado");
			Mock mockObject = new Mock();
			mockObject.enviarMail(partido.getAdministrador());
		*/	
		}
		else
		{
		/**	Miembro miembroNuevo = buscarMiembro(idMiembroNuevo);
			partido.reemplazoJugadores(miembroViejo, miembroNuevo);
			System.out.println("Reemplazo realizado satisfactoriamente");
                */
		}
		
		
		
	}
    }//GEN-LAST:event_botonTerminarActionPerformed

    private void nroReemplazanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nroReemplazanteActionPerformed
        if(jCheckBox1.isCheck())
            {
                //habilitar field
            }
    }//GEN-LAST:event_nroReemplazanteActionPerformed

=======
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DarseBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DarseBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DarseBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DarseBaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DarseBaja().setVisible(true);
            }
        });
    }
>>>>>>> 9e077a992c494360f7fab57b7f98c13f8951ad6d:src/usuario/DarseBaja.java

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonTerminar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nroMiembro;
    private javax.swing.JTextField nroReemplazante;
    // End of variables declaration//GEN-END:variables
}
