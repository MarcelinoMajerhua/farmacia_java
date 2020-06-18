package presentacion;

import control.Config;
import control.Encripty;
import control.Herramienta;
import dataAccesObject.DAOUsuarioImpl;
import datos.Usuario;
import interfaces.DAOUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UIPersonal extends javax.swing.JPanel {

    private int filaSelecionadaUsurio;
    DAOUsuario daoU = new DAOUsuarioImpl();
    DefaultTableModel modeloUsuario = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };
    List<Usuario> listaUsuario = new ArrayList();
    Encripty en = new Encripty();
    Herramienta h = new Herramienta();
    Config config = new Config();
    public UIPersonal() throws Exception {
        initComponents();
        this.listaUsuario=daoU.listar();
        seleccionarCeldaUsuario(); 
        generarModelo();
        llenarTabla(listaUsuario);
        h.validarSoloNumeros(txtTelefono);
    }

    private void seleccionarCeldaUsuario() {

        jtUsuario.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtUsuario.getSelectedRow() != -1) {
                    filaSelecionadaUsurio = jtUsuario.getSelectedRow();//actualizando la fila seleccionada de TProducto
                    desactivaBoton(false);
                    llenarFormulario(filaSelecionadaUsurio);
                    jpAccion.setText("Editando personal");
                } else {
                    desactivaBoton(true);
                    limpiarFormulario();
                    jpAccion.setText("Agregar nuevo personal");
                };
            }
        }
        );
    }//no
    private void desactivaBoton(boolean isActive){
        txtPassword.setVisible(isActive);
        jpPassword.setVisible(isActive);
        jtBuscarUsuario.setEnabled(isActive);
        if(!isActive){
            btnAccion.setText("Editar");
        }else{
            btnAccion.setText("Agregar");
        };
    };
    private DefaultTableModel generarModelo(){
        ArrayList<Object> nombreColumna =new ArrayList<Object>();
        nombreColumna.add("Id");
        nombreColumna.add("Nombre");
        nombreColumna.add("Email");
        nombreColumna.add("Teléfono");
        nombreColumna.add("Categoria");
        nombreColumna.add("Iniciar sesión");
        for(Object columna:nombreColumna){
            modeloUsuario.addColumn(columna);
        }
        this.jtUsuario.setModel(modeloUsuario);
        return modeloUsuario;
    }//si
    
     private void llenarTabla(List<Usuario> lista){
        modeloUsuario.setRowCount(0);
        for(Usuario u:lista){
            String categoria="vendedor";
            String activo="No";
            if(u.getCategoria()){
                categoria="Administrador";
            };
            if(u.getActivo()){
                activo="Si";
            };
            Object[] fila={
                u.getId_modificar(),
                u.getNombre(),
                u.getEmail(),
                u.getTelefono(),
                categoria,
                activo
            };
            modeloUsuario.addRow(fila);
        }
    
    }
     
     private void limpiarFormulario(){
         txtEmail.setText(null);
         txtNombre.setText(null);
         txtTelefono.setText(null);
         btnIniciarS.setSelected(false);
         btnAdministrador.setSelected(false);
         jtBuscarUsuario.setText(null);
         if(btnAccion.getText().equals("Agregar")){
             txtPassword.setText(null);
         };
     };
     
     private void llenarFormulario(int fila){
         txtEmail.setText((String) jtUsuario.getValueAt(fila, 2));
         txtNombre.setText((String) jtUsuario.getValueAt(fila, 1));
         txtTelefono.setText((String) jtUsuario.getValueAt(fila, 3));
         if(jtUsuario.getValueAt(fila, 5).equals("Si")){
             btnIniciarS.setSelected(true);
         }else{
             btnIniciarS.setSelected(false);
         };
         if(jtUsuario.getValueAt(fila, 4).equals("Administrador")){
             btnAdministrador.setSelected(true);
         }else{
             btnAdministrador.setSelected(false);
         };
         
    
     };
     private void agregarUsuario() throws Exception{
         //evaluar si los campos estan vacio 
         //evaliar si el email y nombre estan en uso
         
         boolean exiteUsuario=false;
         boolean esVacio = h.esVacio(txtEmail.getText())||h.esVacio(txtNombre.getText())||h.esVacio(txtPassword.getText())||h.esVacio(txtTelefono.getText());
         if(!esVacio){//evaluar si el campo esta vacio 
            if(daoU.evaluarExistenciaEmail(txtEmail.getText())){//evaluando si el email esta en uso 
                exiteUsuario=true;
                h.mensaje("El email ya está es uso");
            }; 
            if(daoU.evaluarExistenciaNombre(txtNombre.getText())){
                exiteUsuario=true;
                h.mensaje("El nombre ya está en uso");
            };
            if(!exiteUsuario){
                Usuario us = new Usuario();
                us.setEmail(txtEmail.getText());
                us.setContraseña(en.ecnode(config.getSecretKey(), txtPassword.getText()));
                us.setTelefono(txtTelefono.getText());
                us.setNombre(txtNombre.getText());
                if(btnAdministrador.isSelected()){
                    us.setCategoria(true);
                }else{
                    us.setCategoria(false);
                };
                if(btnIniciarS.isSelected()){
                    us.setActivo(true);
                }else{
                    us.setActivo(false);
                };
                daoU.registrar(us);
                llenarTabla(daoU.listar());
                limpiarFormulario();
                h.mensaje("El usuario se registró correctamente");
            };
         }else{//mensaje de que algun campoe sta vacio 
             h.mensaje("Llene todos los campos");
         };
         
     };
     private void EditarUsuario() throws Exception{
         boolean exiteUsuario=false;
         boolean esVacio = h.esVacio(txtEmail.getText())||h.esVacio(txtNombre.getText())||h.esVacio(txtTelefono.getText());
         if(!esVacio){//evaluar si el campo esta vacio 
            if(h.esDiferente((String) jtUsuario.getValueAt(filaSelecionadaUsurio, 2), txtEmail.getText())){
                if(daoU.evaluarExistenciaEmail(txtEmail.getText())){//evaluando si el email esta en uso 
                    exiteUsuario=true;
                    h.mensaje("El email ya está es uso");
                };
            }; 
            if(h.esDiferente((String) jtUsuario.getValueAt(filaSelecionadaUsurio, 1), txtNombre.getText())){
                if(daoU.evaluarExistenciaNombre(txtNombre.getText())){
                    exiteUsuario=true;
                    h.mensaje("El nombre ya está en uso");
                };
            };
            if(!exiteUsuario){
                Usuario us = new Usuario();
                us.setId_modificar((int) jtUsuario.getValueAt(filaSelecionadaUsurio, 0));
                us.setEmail(txtEmail.getText());
                us.setTelefono(txtTelefono.getText());
                us.setNombre(txtNombre.getText());
                if(btnAdministrador.isSelected()){
                    us.setCategoria(true);
                }else{
                    us.setCategoria(false);
                };
                if(btnIniciarS.isSelected()){
                    us.setActivo(true);
                }else{
                    us.setActivo(false);
                };
                daoU.modificar(us);
                llenarTabla(daoU.listar());
                limpiarFormulario();
                h.mensaje("El usuario fue editado correctamete");
            };
         }else{//mensaje de que algun campoe sta vacio 
             h.mensaje("Llene todos los campos");
         };
     
     };
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        jtBuscarUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombrePanel = new javax.swing.JPanel();
        jpAccion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpPassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdministrador = new javax.swing.JRadioButton();
        btnIniciarS = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnAccion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1050, 575));
        setLayout(new java.awt.BorderLayout());

        jpVenta.setBackground(new java.awt.Color(255, 255, 255));
        jpVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpVenta.setForeground(new java.awt.Color(255, 255, 255));
        jpVenta.setPreferredSize(new java.awt.Dimension(1050, 575));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        jPanel1.setName(""); // NOI18N

        jtUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4", "Título 5", "Título 6", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtUsuario);

        jtBuscarUsuario.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jtBuscarUsuario.setForeground(new java.awt.Color(153, 153, 153));
        jtBuscarUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 51, 51)));
        jtBuscarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscarUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtBuscarUsuarioFocusGained(evt);
            }
        });
        jtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarUsuarioKeyReleased(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Search_32px_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        txtNombrePanel.setBackground(new java.awt.Color(255, 255, 255));
        txtNombrePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jpAccion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jpAccion.setText("Agregar nuevo personal");

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Teléfono:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");

        jpPassword.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jpPassword.setText("Contraseña:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Iniciar seción:");

        btnAdministrador.setText("Administrador");

        btnIniciarS.setText("Si");

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));

        btnAccion.setText("Agregar");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtNombrePanelLayout = new javax.swing.GroupLayout(txtNombrePanel);
        txtNombrePanel.setLayout(txtNombrePanelLayout);
        txtNombrePanelLayout.setHorizontalGroup(
            txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtNombrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtNombrePanelLayout.createSequentialGroup()
                        .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txtNombrePanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txtNombrePanelLayout.createSequentialGroup()
                                .addComponent(jpAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
                            .addGroup(txtNombrePanelLayout.createSequentialGroup()
                                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtPassword))))
                        .addGap(64, 64, 64))
                    .addGroup(txtNombrePanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIniciarS)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(txtNombrePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdministrador)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(txtNombrePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAccion)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtNombrePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );
        txtNombrePanelLayout.setVerticalGroup(
            txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtNombrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnIniciarS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnAdministrador))
                .addGap(18, 18, 18)
                .addGroup(txtNombrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccion)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpVentaLayout = new javax.swing.GroupLayout(jpVenta);
        jpVenta.setLayout(jpVentaLayout);
        jpVentaLayout.setHorizontalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpVentaLayout.setVerticalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombrePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(jpVenta, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarFormulario();
        llenarTabla(listaUsuario);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        if(btnAccion.getText().equals("Agregar")){
            try {
            //evento cuando el boton esta para agregar
            agregarUsuario();
            } catch (Exception ex) {
                Logger.getLogger(UIPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
            //evento para editar usuario
            EditarUsuario();
            } catch (Exception ex) {
                Logger.getLogger(UIPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
    }//GEN-LAST:event_btnAccionActionPerformed

    private void jtBuscarUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtBuscarUsuarioFocusGained
        h.fitrarBusqueda(jtBuscarUsuario, jtUsuario);
    }//GEN-LAST:event_jtBuscarUsuarioFocusGained

    private void jtBuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarUsuarioKeyReleased

    }//GEN-LAST:event_jtBuscarUsuarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JRadioButton btnAdministrador;
    private javax.swing.JRadioButton btnIniciarS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jpAccion;
    private javax.swing.JLabel jpPassword;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JTextField jtBuscarUsuario;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPanel txtNombrePanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
