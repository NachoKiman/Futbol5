/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;
import javax.swing.JOptionPane;
import negocio.*;
import java.util.*;

/**
 *
 * @author Nacho
 */
public class CalificarJugador extends javax.swing.JFrame {

    Miembro jugadorACalificar;
    ArrayList<Aspirante> jugadores;
    Miembro jugadorCalificante;
    int index;
    /**
     * Creates new form ListarJugadoresCalificar
     */
    public CalificarJugador(Miembro miembro, ArrayList<Aspirante> jugadores, int i) {
        initComponents();
        jugadorACalificar= jugadores.get(i).getMiembro();
        this.jugadores=jugadores;
        this.jugadorCalificante=miembro;
        this.index=i;
        lNombre.setText("Nombre: "+jugadorACalificar.getNombre());
        lApellido.setText("Apellido: "+jugadorACalificar.getApellido());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lNombre = new javax.swing.JLabel();
        lApellido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        califiacion = new javax.swing.JTextField();
        bSeguir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comentario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Calificar Jugadores");

        jLabel2.setText("Califique al siguiente Jugador:");

        lNombre.setText("Nombre:");

        lApellido.setText("Apellido:");

        jLabel5.setText("Calificación:");

        bSeguir.setText("Seguir Calificando");
        bSeguir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSeguirMouseClicked(evt);
            }
        });
        bSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeguirActionPerformed(evt);
            }
        });

        jLabel3.setText("Breve comentario:");

        comentario.setColumns(20);
        comentario.setRows(5);
        jScrollPane1.setViewportView(comentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(califiacion))
                                .addComponent(lApellido)
                                .addComponent(lNombre)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bSeguir)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(lNombre)
                .addGap(18, 18, 18)
                .addComponent(lApellido)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(califiacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(bSeguir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSeguirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSeguirMouseClicked
        if((califiacion.getText().equals("")))
        {
                JOptionPane.showMessageDialog(this, "Debe ingresar una calificación.", "Advertencia",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            if(califiacion.getText().length()<=3)
            {
                if((Integer.parseInt(califiacion.getText())>-1)&&(Integer.parseInt(califiacion.getText())<11))
                {
                    Calificacion cali = new Calificacion(Integer.parseInt(califiacion.getText()), comentario.getText(), Menu.partido.getFecha());
                    //jugadorACalificar.getCalificaciones().add(cali); 

                    if(jugadores.size()==(index+1))
                    {
                        JOptionPane.showMessageDialog(this, "No quedan jugadores por calificar.", "Advertencia",JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                    }
                    else
                    {
                        (new CalificarJugador(jugadorCalificante, jugadores, index+1)).setVisible(true);
                        this.setVisible(false);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Se califica con valores desde 0 hasta el 10.", "Advertencia",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ingrese un valor valido.", "Advertencia",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }

        
        
    }//GEN-LAST:event_bSeguirMouseClicked

    private void bSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeguirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSeguirActionPerformed

    
    private void guardarDatos()
    {
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSeguir;
    private javax.swing.JTextField califiacion;
    private javax.swing.JTextArea comentario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lApellido;
    private javax.swing.JLabel lNombre;
    // End of variables declaration//GEN-END:variables
}
