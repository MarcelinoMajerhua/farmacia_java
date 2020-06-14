/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import control.Herramienta;
import dataAccesObject.DAOProveedorImpl;
import datos.Proveedor;
import datos.Usuario;
import interfaces.DAOProveedor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UIProveedor extends javax.swing.JFrame {
    Herramienta herramienta = new Herramienta();
    Proveedor proveedor = new Proveedor();
    Usuario usuario = new Usuario();
    DAOProveedor daoPr = new DAOProveedorImpl();
    public UIProveedor() {
        
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public UIProveedor(Usuario u){
        this.usuario=u;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Proveedor " + usuario.getNombre());
        //habilitando boton para agregar
        btnAgregar.setVisible(true);
        btnEditar.setVisible(false);
    }
    public UIProveedor(Usuario u,Proveedor pr){
        this.usuario=u;
        this.proveedor=pr;
        initComponents();
        this.setLocationRelativeTo(null);
        llenarCampo(pr);
        this.setTitle("Proveedor " + usuario.getNombre());
        //habilitando boton para editar
        btnAgregar.setVisible(false);
        btnEditar.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        txtDireccionProvedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(371, 425));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(371, 425));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 33, 121, 25));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dirección:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 76, 121, 25));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 119, 121, 25));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Detalle");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 170, 121, 25));

        txtDetalle.setBackground(new java.awt.Color(255, 255, 255));
        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        txtDetalle.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));
        jScrollPane1.setViewportView(txtDetalle);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 201, 268, 121));

        txtDireccionProvedor.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionProvedor.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(txtDireccionProvedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 76, 183, -1));

        txtNombreProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreProveedor.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 33, 183, -1));

        txtTelefonoProveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoProveedor.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 119, 183, -1));

        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Multiply_32px.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 30, 30));

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 328, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        boolean existenciaProveedor=false;
        if(!herramienta.esVacio(txtNombreProveedor.getText())&&!herramienta.esVacio(txtTelefonoProveedor.getText())&&!herramienta.esVacio(txtDireccionProvedor.getText())&&!herramienta.esVacio(txtDetalle.getText())){
            try {
                if(herramienta.esDiferente(proveedor.getNombreProveedor(),txtNombreProveedor.getText())){//evaluando i el nombre a cmbiado
                    if(daoPr.evaluarExistenciaNombre(txtNombreProveedor.getText())){
                        System.err.println("El usuario ya esta registrado");
                        existenciaProveedor=true;//existe el usuario
                    };
                }
                if(herramienta.esDiferente(proveedor.getTelefonoProveedor(), txtTelefonoProveedor.getText())){
                    if(daoPr.evaluarExistenciaTelefono(txtTelefonoProveedor.getText())){
                        System.err.println("El usuario ya esta registrado");
                        existenciaProveedor=true;//el telefono usuario
                    };
                }
                if(!existenciaProveedor){
                    proveedor.setDetalleProveedor(txtDetalle.getText());
                    daoPr.actualizar(proveedor);
                    System.out.println("Actualizacion correacta");
                    this.setVisible(false);
                }
            } catch (Exception ex) {
                Logger.getLogger(UIProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }else{
            System.out.println("llene todos los campos");
        };
    }//GEN-LAST:event_btnEditarMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        boolean existenciaProveedor=false;
        if(!herramienta.esVacio(txtNombreProveedor.getText())&&!herramienta.esVacio(txtTelefonoProveedor.getText())&&!herramienta.esVacio(txtDireccionProvedor.getText())&&!herramienta.esVacio(txtDetalle.getText())){
            try {
                if(daoPr.evaluarExistenciaNombre(txtNombreProveedor.getText())){
                    System.err.println("El usuario ya esta registrado");
                    existenciaProveedor=true;//existe el usuario
                 };
                if(daoPr.evaluarExistenciaTelefono(txtTelefonoProveedor.getText())){
                    System.err.println("El Telefono ya está regitrado");
                    existenciaProveedor=true;//el telefono usuario
                };
                if(!existenciaProveedor){
                    proveedor.setDetalleProveedor(txtDetalle.getText());
                    proveedor.setDireccionProveedor(txtDireccionProvedor.getText());
                    proveedor.setNombreProveedor(txtNombreProveedor.getText());
                    proveedor.setTelefonoProveedor(txtTelefonoProveedor.getText());
                    daoPr.insertar(proveedor);
                    System.out.println("Se agrego correctamente");
                    this.setVisible(false);
                }
            } catch (Exception ex) {
                Logger.getLogger(UIProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }else{
            System.out.println("llene todos los campos");
        };
    }//GEN-LAST:event_btnAgregarMouseClicked
    
    private void llenarCampo(Proveedor pr){
        txtDetalle.setText(pr.getDetalleProveedor());
        txtDireccionProvedor.setText(pr.getDireccionProveedor());
        txtNombreProveedor.setText(pr.getNombreProveedor());
        txtTelefonoProveedor.setText(pr.getTelefonoProveedor());
    };
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
            java.util.logging.Logger.getLogger(UIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtDireccionProvedor;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables
}
