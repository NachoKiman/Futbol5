/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usuario;
import negocio.*;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Nacho
 */
public class InscribirsePartido extends javax.swing.JFrame {

    /**
     * Creates new form IncorporarNuevoJugador
     */
    public InscribirsePartido() {
        initComponents();
        
        //cargar cmbForma();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbForma = new javax.swing.JComboBox();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bGuardar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel12.setText("Inscribir Jugador");

        jLabel2.setText("Forma de Inscripción");

        cmbForma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estandar", "Solidario", "Condicional" }));

        jLabel1.setText("ID Postulante");

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCancelar)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
    
        if(txtID.getText().length()<=3)
        {
            int idMiembro  = Integer.parseInt(txtID.getText());

            Miembro miembro = Menu.buscarMiembro(idMiembro);
            if(!Menu.partido.getJugadores().contains(miembro))
            {
                int opcion= cmbForma.getSelectedIndex() +1;// = cmbForma.getSelectedItem();

                FormaInscripcion insc = seleccionFormaInscripcion(opcion);

                Date fechaIncripcion = new Date();

                Aspirante aspirante = new Aspirante(miembro,insc, fechaIncripcion);

                if(Menu.partido.permiteInscribir(aspirante))
                {
                    Menu.partido.inscribirJugador(aspirante);
                    JOptionPane.showMessageDialog(this, "Jugador Inscripto correctamente.", "Información",JOptionPane.INFORMATION_MESSAGE);
                    miembro.notificarInscripcion();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "No pudo inscribirse al partido.", "Información",JOptionPane.INFORMATION_MESSAGE);
                }

                this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Solicitud rechazada. Usted ya se encuentra inscripto al partido.", "Información",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un ID valido.", "Alerta",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
         setVisible(false);
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    //Instancia la forma de inscripcion dependiendo de la opcion elegida
	public static FormaInscripcion seleccionFormaInscripcion(int opcion)
	{
		switch(opcion)
		{
			case 1:
				return new Estandar();
			case 2:
				return new Solidario();
			case 3:
				return new Condicional(); 
			default:
				System.out.println("Opcion no valida");
				break;
		}
		//me obliga a hacer esto porque sino dice que puede llegar
		//a no tener valor
		return new Estandar();
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JComboBox cmbForma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}