
package presentacion;

import dataAccesObject.DAOProductoImpl;
import dataAccesObject.DAOProveedorImpl;
import datos.Producto;
import datos.Proveedor;
import interfaces.DAOProducto;
import interfaces.DAOProveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UIInicio extends javax.swing.JPanel {
    DAOProducto daoP = new DAOProductoImpl();
    List<Producto> listaPVencer;
    List<Producto> listaPVencido;
    List<Producto> listaPBajoStock;
    DefaultTableModel modeloVencer = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };
    DefaultTableModel modeloVencido = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };
    DefaultTableModel modeloBajoStock = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };
    DAOProveedor daoPr = new DAOProveedorImpl();
    public UIInicio() throws Exception {
        this.listaPVencer = daoP.listarProductoVencer();
        this.listaPBajoStock=daoP.listarProductoBajoStock();
        this.listaPVencido=daoP.listarProductoVencido();
        initComponents();
        generarModeloBajoStock();
        generarModeloVecido();
        generarModeloVencer();
        llenarTablaVencido(listaPVencido);
        llenarTablaBajoStock(listaPBajoStock);
        llenarTablaVencer(listaPVencer);
        seleccionarCeldaBajoStock();
        seleccionarCeldaVencer();
        seleccionarCeldaVencido();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVencer = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pnlDetalleProveedor = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JLabel();
        txtTipoProducto = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDetalleProvedor = new javax.swing.JTextArea();
        txtDireccionProveedor = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVencido = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtBajoStock = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1050, 575));
        setLayout(new java.awt.BorderLayout());

        jpVenta.setBackground(new java.awt.Color(255, 255, 255));
        jpVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpVenta.setForeground(new java.awt.Color(255, 255, 255));
        jpVenta.setPreferredSize(new java.awt.Dimension(1050, 575));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        jPanel1.setName(""); // NOI18N

        jtVencer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtVencer);

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Productos por vencer");

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Detalles del producto");

        txtNombreProducto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtNombreProducto.setText("Nombre producto:");

        txtNombreProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtNombreProveedor.setText("Nombre proveedor:");

        txtTipoProducto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtTipoProducto.setText("Tipo de producto:");

        txtTelefonoProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtTelefonoProveedor.setText("Teléfono proveedor:");

        txtDetalleProvedor.setBackground(new java.awt.Color(240, 240, 240));
        txtDetalleProvedor.setColumns(20);
        txtDetalleProvedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtDetalleProvedor.setRows(5);
        jScrollPane4.setViewportView(txtDetalleProvedor);

        txtDireccionProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtDireccionProveedor.setText("Dirección proveedor:");

        jLabel18.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel18.setText("Detalle");

        javax.swing.GroupLayout pnlDetalleProveedorLayout = new javax.swing.GroupLayout(pnlDetalleProveedor);
        pnlDetalleProveedor.setLayout(pnlDetalleProveedorLayout);
        pnlDetalleProveedorLayout.setHorizontalGroup(
            pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                        .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDetalleProveedorLayout.setVerticalGroup(
            pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreProducto)
                    .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonoProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlDetalleProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalleProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jtVencido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtVencido);

        jtBajoStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Título 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtBajoStock.setEditingColumn(0);
        jtBajoStock.setEditingRow(0);
        jScrollPane3.setViewportView(jtBajoStock);

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Productos bajos en Stock");

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Productos vencidos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpVentaLayout = new javax.swing.GroupLayout(jpVenta);
        jpVenta.setLayout(jpVentaLayout);
        jpVentaLayout.setHorizontalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private List<Object> generarNombreColumna(){
        ArrayList<Object> nombreColumna = new ArrayList<Object>();
        nombreColumna.add("Nombre");
        nombreColumna.add("Vencimiento");
        nombreColumna.add("Cantidad");
        nombreColumna.add("Id proveedor");
        nombreColumna.add("Tipo");
        return nombreColumna;
    };
    private DefaultTableModel generarModeloBajoStock() {
        
        for (Object columna : generarNombreColumna()) {
            modeloBajoStock.addColumn(columna);

        }
        this.jtBajoStock.setModel(modeloBajoStock);
        return modeloBajoStock;
    };
    private DefaultTableModel generarModeloVencer() {
        
        for (Object columna : generarNombreColumna()) {
            modeloVencer.addColumn(columna);

        }
        this.jtVencer.setModel(modeloVencer);
        return modeloVencer;
    };
    private DefaultTableModel generarModeloVecido() {
        
        for (Object columna : generarNombreColumna()) {
            modeloVencido.addColumn(columna);

        }
        this.jtVencido.setModel(modeloVencido);
        return modeloVencido;
    };
    private void llenarTablaBajoStock(List<Producto> lista) {
        modeloBajoStock.setRowCount(0);
        for (Producto p : lista) {
            Object[] fila = {
                p.getNombre(),
                p.getFecha_vencimiento(),
                p.getStock(),
                p.getId_proveedor(),
                p.getTipo_producto()
            };
            modeloBajoStock.addRow(fila);
        }

    };
    private void llenarTablaVencer(List<Producto> lista) {
        modeloVencer.setRowCount(0);
        for (Producto p : lista) {
            Object[] fila = {
                p.getNombre(),
                p.getFecha_vencimiento(),
                p.getStock(),
                p.getId_proveedor(),
                p.getTipo_producto()
            };
            modeloVencer.addRow(fila);
        }

    };
    private void llenarTablaVencido(List<Producto> lista) {
        modeloVencido.setRowCount(0);
        for (Producto p : lista) {
            Object[] fila = {
                p.getNombre(),
                p.getFecha_vencimiento(),
                p.getStock(),
                p.getId_proveedor(),
                p.getTipo_producto()
            };
            modeloVencido.addRow(fila);
        }

    };
    private void seleccionarCeldaBajoStock() {
        jtBajoStock.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtBajoStock.getSelectedRow() != -1) {
                    try {
                        llenarCartilla(jtBajoStock.getSelectedRow(), jtBajoStock);
                        llenarTablaVencer(listaPVencer);
                        llenarTablaVencido(listaPVencido);
                    } catch (Exception ex) {
                        Logger.getLogger(UIInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                };
            }
        }
        );
    };//no
    private void seleccionarCeldaVencer() {
        jtVencer.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtVencer.getSelectedRow() != -1) {
                    try {
                        llenarCartilla(jtVencer.getSelectedRow(), jtVencer);
                        llenarTablaBajoStock(listaPBajoStock);
                        llenarTablaVencido(listaPVencido);
                    } catch (Exception ex) {
                        Logger.getLogger(UIInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                };
            }
        }
        );
    };//no
    private void seleccionarCeldaVencido() {
        jtVencido.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtVencido.getSelectedRow() != -1) {
                    try {
                        llenarCartilla(jtVencido.getSelectedRow(), jtVencido);
                        llenarTablaBajoStock(listaPBajoStock);
                        llenarTablaVencer(listaPVencer);
                    } catch (Exception ex) {
                        Logger.getLogger(UIInicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {

                };
            }
        }
        );
    };//no
    private void llenarCartilla(int fila, JTable tabla) throws Exception{
        txtNombreProducto.setText("Nombre producto: "+(String) tabla.getValueAt(fila,0 ));
        txtTipoProducto.setText("Tipo: "+(String) tabla.getValueAt(fila, 4));
        Proveedor proveedor = new Proveedor();
        proveedor = daoPr.listarUno((int) tabla.getValueAt(fila, 3));
        txtNombreProveedor.setText("Nombre proveedor: "+proveedor.getNombreProveedor());
        txtTelefonoProveedor.setText("Teléfono proveedor: "+proveedor.getTelefonoProveedor());
        txtDireccionProveedor.setText("Dirección: "+proveedor.getDireccionProveedor());
        txtDetalleProvedor.setText(proveedor.getDetalleProveedor()); 
    };
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JTable jtBajoStock;
    private javax.swing.JTable jtVencer;
    private javax.swing.JTable jtVencido;
    private javax.swing.JPanel pnlDetalleProveedor;
    private javax.swing.JTextArea txtDetalleProvedor;
    private javax.swing.JLabel txtDireccionProveedor;
    private javax.swing.JLabel txtNombreProducto;
    private javax.swing.JLabel txtNombreProveedor;
    private javax.swing.JLabel txtTelefonoProveedor;
    private javax.swing.JLabel txtTipoProducto;
    // End of variables declaration//GEN-END:variables
}
