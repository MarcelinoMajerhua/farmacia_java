
package presentacion;

import control.Herramienta;
import dataAccesObject.DAOProductoImpl;
import dataAccesObject.DAOVentaImpl;
import datos.Producto;
import datos.Usuario;
import datos.Venta;
import interfaces.DAOProducto;
import interfaces.DAOVenta;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UIVenta extends javax.swing.JPanel {
    DAOVenta vender = new DAOVentaImpl();
    List<Venta> productosParaVender =new ArrayList();;//llista de los productos que se encuentran en la tabla para vender
    Venta v=new Venta();
    Usuario usuario= new Usuario(); //contiene los datos del usuario logueado
    DefaultTableModel modelo = new DefaultTableModel(); //modelo de la tabla producto
    DefaultTableModel modeloVenta = new DefaultTableModel();//modelo de la tabla de venta
    List<Producto> lista;//lista de los productos 
    Herramienta herramienta = new Herramienta();
    List<Venta> venta;
    List<Producto> listaInicialProducto;
    DAOProducto daoP = new DAOProductoImpl();
    int filaSelecionadaProducto; //contiene la fila selecionada de la tabla producto
    int filaSelecionadaVEnta; //contiene la fila selecionada de la tabla venta
    public UIVenta() {
        initComponents();
        llenarLista();
        generarModelo();
        generarModeloVenta();
        llenarTabla(lista);
        this.jlNombreProducto.setText("Nombre del producto");
        seleccionarCeldaProducto();
        seleccionarCeldaVenta();
        herramienta.validarSoloNumeros(jtCantidadProducto);
        jbQuitar.setVisible(false);
        jlPrecioTotal.setText(String.valueOf(calcularPrecioTotal()));
    }
    
    public UIVenta(Usuario u ,List<Producto> listaProducto){
        usuario.setId_modificar(u.getId_modificar());
        this.listaInicialProducto=listaProducto;
        initComponents();
        llenarLista();
        generarModelo();
        generarModeloVenta();
        llenarTabla(lista);
        this.jlNombreProducto.setText("Nombre del producto");
        seleccionarCeldaProducto();
        seleccionarCeldaVenta();
        herramienta.validarSoloNumeros(jtCantidadProducto);
        jbQuitar.setVisible(false);
        jlPrecioTotal.setText(String.valueOf(calcularPrecioTotal()));
    };
    private void seleccionarCeldaProducto(){
        
        jtProducto.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(jtProducto.getSelectedRow()!=-1){
                    filaSelecionadaProducto = jtProducto.getSelectedRow();//actualizando la fila seleccionada de TProducto
                    jlNombreProducto.setText(jtProducto.getValueAt(filaSelecionadaProducto, 1).toString());
       
                };
            }
        }
        );
    }//no
    private void seleccionarCeldaVenta(){
        
        jtVenta.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(jtVenta.getSelectedRow()!=-1){
                    filaSelecionadaVEnta = jtVenta.getSelectedRow();
                    jbQuitar.setVisible(true);
                    //v.setFechaVenta(h.fechaSql());     
                };
            }
        }
        );
    }//no
    private List<Producto> llenarLista(){
        try {
           this.lista=listaInicialProducto;
        } catch (Exception e) {
            
            System.err.println("Error en consultar");
        }
        return this.lista;
    }
    private DefaultTableModel generarModelo(){
        ArrayList<Object> nombreColumna =new ArrayList<Object>();
        nombreColumna.add("Id producto");
        nombreColumna.add("Nombre Producto");
        nombreColumna.add("Vencimiento");
        nombreColumna.add("Cantidad");
        nombreColumna.add("Id proveedor");
        nombreColumna.add("Precio");
        nombreColumna.add("Tipo");
        for(Object columna:nombreColumna){
            modelo.addColumn(columna);
        }
        this.jtProducto.setModel(modelo);
        return modelo;
    }//si
    private DefaultTableModel generarModeloVenta(){
        ArrayList<Object> nombreColumna =new ArrayList<Object>();
        nombreColumna.add("Id");
        nombreColumna.add("Nombre");
        nombreColumna.add("Cantidad");
        nombreColumna.add("Precio Venta");
        for(Object columna:nombreColumna){
            modeloVenta.addColumn(columna);
        }
        this.jtVenta.setModel(modeloVenta);
        return modeloVenta;
    }//si
    private void llenarTabla(List<Producto> lista){
        
        modelo.setRowCount(0);
        for(Producto p:lista){
            Object[] fila={
                p.getCodigo(),
                p.getNombre(),
                p.getFecha_vencimiento(),
                p.getStock(),
                p.getId_proveedor(),
                p.getPrecio(),
                p.getTipo_producto()
            };
            modelo.addRow(fila);
        }
    
    }
    private void llenarTablaVenta(List<Venta> lista){
        for(Venta vent:lista){
            Object[] fila={
                vent.getIdProducto(),
                jtProducto.getValueAt(filaSelecionadaProducto,1),
                vent.getCandidadVenta(),
                vent.getPrecioTotalVenta(),

            };
            modeloVenta.addRow(fila);
        }
    };
    private int evaluarExitenciaTV(int id){//devuelve el nuero de fila de la tabla venta si no exiiste devuel -2
        int resp =-2;
        for (int i = 0; i < jtVenta.getRowCount(); i++) {
            if((int)jtVenta.getValueAt(i,0)==id){
                resp=i;
                break;
            }
        }
        return resp;
    }
    private void limpiarCampo(){
        jtCantidadProducto.setText(null);
    };
    private void eleminarTablaVenta(DefaultTableModel modelo){
       modelo.setRowCount(0);
    };
    private float calcularPrecioTotal(){
        float precio_total=0;
        if(jtVenta.getRowCount()>0){
            for(int i=0;i<jtVenta.getRowCount();i++){
                precio_total=precio_total+(float)jtVenta.getValueAt(i, 3);
            };
        };
        return precio_total;
    }
    /*
    private int buscarIdProducto(int id){
        
    };*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlPrecioTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlNombreProducto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtCantidadProducto = new javax.swing.JTextField();
        jbAgregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtVenta = new javax.swing.JTable();
        jbCancelar = new javax.swing.JButton();
        jbVender = new javax.swing.JButton();
        jbQuitar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1050, 575));
        setLayout(new java.awt.BorderLayout());

        jpVenta.setBackground(new java.awt.Color(255, 255, 255));
        jpVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpVenta.setForeground(new java.awt.Color(255, 255, 255));
        jpVenta.setPreferredSize(new java.awt.Dimension(1050, 575));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        jPanel1.setName(""); // NOI18N

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProducto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jtBuscar.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jtBuscar.setForeground(new java.awt.Color(153, 153, 153));
        jtBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 51, 51)));
        jtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Search_32px_2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtBuscar)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Total a pagar:");

        jlPrecioTotal.setBackground(new java.awt.Color(255, 255, 255));
        jlPrecioTotal.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Nombre producto:");

        jlNombreProducto.setBackground(new java.awt.Color(255, 255, 255));
        jlNombreProducto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jlNombreProducto.setForeground(new java.awt.Color(153, 153, 153));
        jlNombreProducto.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Cantidad vender:");

        jtCantidadProducto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N

        jbAgregar.setBackground(new java.awt.Color(204, 204, 204));
        jbAgregar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbAgregarMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jtVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtVenta);

        jbCancelar.setBackground(new java.awt.Color(204, 204, 204));
        jbCancelar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbCancelarMouseClicked(evt);
            }
        });

        jbVender.setBackground(new java.awt.Color(204, 204, 204));
        jbVender.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jbVender.setText("Vender");
        jbVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVenderMouseClicked(evt);
            }
        });

        jbQuitar.setBackground(new java.awt.Color(204, 204, 204));
        jbQuitar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jbQuitar.setText("Quitar");
        jbQuitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbQuitarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jbVender, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbVender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpVentaLayout = new javax.swing.GroupLayout(jpVenta);
        jpVenta.setLayout(jpVentaLayout);
        jpVentaLayout.setHorizontalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpVentaLayout.setVerticalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpVentaLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        add(jpVenta, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyReleased

            try {
                llenarTabla(daoP.buscarProducto(jtBuscar.getText()));
            } catch (Exception e) {
                System.err.println("Error en consultar");
            }
 
        
    }//GEN-LAST:event_jtBuscarKeyReleased

    private void jbAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAgregarMouseClicked
        
        float precio = (float) jtProducto.getValueAt(filaSelecionadaProducto, 5);//recuperando el precio de la tabla producto
        int cantidadActualTP = (int) jtProducto.getValueAt(filaSelecionadaProducto, 3);//recuperando la cantidad actual en la tabla de producto
        if (jtCantidadProducto.getText().length()>0) {//verificando que no este vacio el campo
            int cantidadJTP =Integer.parseInt(jtCantidadProducto.getText());
            if(cantidadJTP>0){
                if(evaluarExitenciaTV((int)jtProducto.getValueAt(filaSelecionadaProducto, 0))==-2){//no existe en la tbla de venta 
                    if(cantidadJTP<(int)jtProducto.getValueAt(filaSelecionadaProducto, 3)){//evaluando que la cantidad quqe se desea vender no exceda a la cantoidad existente
                        //agregando nuevo elemento a la tabla vetan
                        v.setIdProducto((int) jtProducto.getValueAt(filaSelecionadaProducto,0));
                        v.setCandidadVenta(cantidadJTP);
                        v.setPrecioTotalVenta(cantidadJTP*precio);
                        //se llena la listade productosParaVender para llenar la tabla venta
                        productosParaVender.add(v);
                        llenarTablaVenta(productosParaVender);//llenando la tabla venta
                        productosParaVender.clear();//eliminado de la lista
                    }//poner mensaje
                    
                }else{//si el producto ya esta agregado en la tabla de venta
                    int numeroFilaVenta = evaluarExitenciaTV((int)jtProducto.getValueAt(filaSelecionadaProducto, 0));//recuperando el numero de fila de la tabla venta con el id del productp
                    int cantidadActualTV=(int)jtVenta.getValueAt(numeroFilaVenta,2);//recuperando la cantidad de la tabla venta
                    int cantidadNuevo = cantidadActualTV+Integer.parseInt(jtCantidadProducto.getText());//cantidad de la tabla venta sumado a la nueva cantidad ingresada 
                    if(cantidadNuevo<cantidadActualTP){//evaluando si la cantidad que deseamos vender no exede a cantidad existente
                        //se tiene que modificar los valores de las celdas de la tabla venta
                        jtVenta.setValueAt(cantidadNuevo, numeroFilaVenta, 2);
                        jtVenta.setValueAt(cantidadNuevo*precio, numeroFilaVenta, 3);
                    };
                    
                }
                
            }
        }
        limpiarCampo();
        jtBuscar.setText(null);
        llenarTabla(lista);
        jlPrecioTotal.setText(String.valueOf(calcularPrecioTotal()));
        
    }//GEN-LAST:event_jbAgregarMouseClicked

    private void jbQuitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbQuitarMouseClicked
        if(jtVenta.getRowCount()>0){
            modeloVenta.removeRow(filaSelecionadaVEnta);
        };
        jlPrecioTotal.setText(String.valueOf(calcularPrecioTotal()));
        
    }//GEN-LAST:event_jbQuitarMouseClicked

    private void jbAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAgregarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAgregarMouseEntered

    private void jbCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCancelarMouseClicked
        eleminarTablaVenta(modeloVenta);
        jlPrecioTotal.setText(String.valueOf(calcularPrecioTotal()));
    }//GEN-LAST:event_jbCancelarMouseClicked

    private void jbVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVenderMouseClicked
        if(jtVenta.getRowCount()>0){
            
            for(int i=0;i<jtVenta.getRowCount();i++){
                Venta vent = new Venta();
                vent.setCandidadVenta((int) jtVenta.getValueAt(i, 2));
                vent.setIdProducto((int) jtVenta.getValueAt(i, 0));
                vent.setIdUsuario(usuario.getId_modificar());
                vent.setFechaVenta(herramienta.fechaHoy());
                System.err.println(usuario.getId_modificar());
                try {
                    vender.registrar(vent);
                    System.err.println("venta exitosa");
                } catch (Exception ex) {
                    Logger.getLogger(UIVenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            eleminarTablaVenta(modeloVenta);
            lista=llenarLista();
            llenarTabla(lista);
            jlPrecioTotal.setText(String.valueOf(calcularPrecioTotal()));
        };
    }//GEN-LAST:event_jbVenderMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JButton jbVender;
    private javax.swing.JLabel jlNombreProducto;
    private javax.swing.JLabel jlPrecioTotal;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTextField jtCantidadProducto;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTable jtVenta;
    // End of variables declaration//GEN-END:variables
}
