package presentacion;

import control.Herramienta;
import dataAccesObject.DAOCompraImpl;
import dataAccesObject.DAOUsuarioImpl;
import dataAccesObject.DAOVentaImpl;
import datos.Usuario;
import interfaces.DAOCompra;
import interfaces.DAOUsuario;
import interfaces.DAOVenta;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UIReporte extends javax.swing.JPanel {
    DAOUsuario daoU = new DAOUsuarioImpl();
    DAOVenta daoV = new DAOVentaImpl();
    DAOCompra daoC = new DAOCompraImpl();
    DefaultTableModel modeloUsuario = new DefaultTableModel();
    Map<String, Integer> idUsuario =  new HashMap<String, Integer>();
    List<Object> listaInicial =new ArrayList();
    Herramienta herramienta = new Herramienta();
    public UIReporte() throws Exception {
        initComponents();
        listaInicial=daoV.listarVenPersonal("todo", 0, herramienta.cambiarFechaDateSql(herramienta.cambiarFormato("2020-10-10")));
        generarModeloProveedor();
        llenarComboBoxUsuario(daoU.listar());
        llenarTabla(listaInicial);
    }

    private DefaultTableModel generarModeloProveedor() {
        ArrayList<Object> nombreColumna = new ArrayList<Object>();
        nombreColumna.add("Usuario");
        nombreColumna.add("Nombre producto");
        nombreColumna.add("Cantidad");
        if (jComboTipoOperacion.getSelectedItem().toString().equals("Venta")) {
            nombreColumna.add("Precio de Venta");
        } else {
            nombreColumna.add("Precio de Compra");
        };
        nombreColumna.add("Fecha");
        for (Object columna : nombreColumna) {
            modeloUsuario.addColumn(columna);
        }
        this.jtUsuario.setModel(modeloUsuario);
        return modeloUsuario;
    }

    ;//si
    
    private void llenarComboBoxUsuario(List<Usuario> lista) {// agregar esto a marce
        for (int i = 0; i < lista.size(); i++) {
            jComboUsuario.addItem(lista.get(i).getNombre());
            idUsuario.put(lista.get(i).getNombre(),lista.get(i).getId_modificar());
        }
    }
    
    private void llenarTabla(List<Object> lista) {

        modeloUsuario.setRowCount(0);
        for (Object p : lista) {
            modeloUsuario.addRow((Object[]) p);
        }

    }

    ;
    private void reporteVenta() throws Exception{
        if(jComboUsuario.getSelectedItem().toString().equals("Todos")){
            if(jCalendarFecha.getDate()!=null){//hay una fecha
                try {
                    System.out.println(herramienta.cambiarFechaDateSql(jCalendarFecha.getDate()));
                    listaInicial=daoV.listarVenPersonal("todo_fecha", 0, herramienta.cambiarFechaDateSql(jCalendarFecha.getDate()));
                    
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{//no hay fecha
                try {
                    listaInicial=daoV.listarVenPersonal("todo", 0, herramienta.cambiarFechaDateSql(herramienta.cambiarFormato("2020-10-10")));
                    
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
        }else{
            if(jCalendarFecha.getDate()!=null){//hay un nombre y la fecha no es nula
                 try {
                    listaInicial=daoV.listarVenPersonal("unitario_fecha",idUsuario.get(jComboUsuario.getSelectedItem().toString()), herramienta.cambiarFechaDateSql(jCalendarFecha.getDate()));
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    listaInicial=daoV.listarVenPersonal("unitario_sin_fecha",idUsuario.get(jComboUsuario.getSelectedItem()), herramienta.cambiarFechaDateSql(herramienta.cambiarFormato("2020-10-10")));
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
        };
        llenarTabla(listaInicial);
    };
    
    private void reporteCompra() throws Exception{
        if(jComboUsuario.getSelectedItem().toString().equals("Todos")){
            if(jCalendarFecha.getDate()!=null){//hay una fecha
                try {
                    System.out.println(herramienta.cambiarFechaDateSql(jCalendarFecha.getDate()));
                    listaInicial=daoC.listarConPersonal("todo_fecha", 0, herramienta.cambiarFechaDateSql(jCalendarFecha.getDate()));
                    
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{//no hay fecha
                try {
                    listaInicial=daoC.listarConPersonal("todo", 0, herramienta.cambiarFechaDateSql(herramienta.cambiarFormato("2020-10-10")));
                    
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
        }else{
            if(jCalendarFecha.getDate()!=null){//hay un nombre y la fecha no es nula
                 try {
                    listaInicial=daoC.listarConPersonal("unitario_fecha",idUsuario.get(jComboUsuario.getSelectedItem().toString()), herramienta.cambiarFechaDateSql(jCalendarFecha.getDate()));
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    listaInicial=daoC.listarConPersonal("unitario_sin_fecha",idUsuario.get(jComboUsuario.getSelectedItem()), herramienta.cambiarFechaDateSql(herramienta.cambiarFormato("2020-10-10")));
                } catch (ParseException ex) {
                    Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
        };
        llenarTabla(listaInicial);
    
    };
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboUsuario = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboTipoOperacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jCalendarFecha = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarProducto = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jComboUsuario.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jComboUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione fecha");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione usuario");

        jComboTipoOperacion.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jComboTipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Venta", "Compra", " " }));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Seleccione tipo operación");

        jButton1.setText("Consultar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Filtrar por producto");

        txtBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarProductoFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jCalendarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpVentaLayout = new javax.swing.GroupLayout(jpVenta);
        jpVenta.setLayout(jpVentaLayout);
        jpVentaLayout.setHorizontalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpVentaLayout.setVerticalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(jpVenta, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(jComboTipoOperacion.getSelectedItem().toString().equals("Venta")){
           try {
               reporteVenta();
           } catch (Exception ex) {
               Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else{//compra
           try {
               reporteCompra();
           } catch (Exception ex) {
               Logger.getLogger(UIReporte.class.getName()).log(Level.SEVERE, null, ex);
           }
       };
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtBuscarProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarProductoFocusGained
        herramienta.fitrarBusqueda(txtBuscarProducto, jtUsuario);
    }//GEN-LAST:event_txtBuscarProductoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jCalendarFecha;
    private javax.swing.JComboBox<String> jComboTipoOperacion;
    private javax.swing.JComboBox<String> jComboUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
