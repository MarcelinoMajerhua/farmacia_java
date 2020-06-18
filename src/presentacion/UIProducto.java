package presentacion;

import control.Herramienta;
import dataAccesObject.DAOCompraImpl;
import dataAccesObject.DAOProductoImpl;
import dataAccesObject.DAOProveedorImpl;
import datos.Compra;
import datos.Producto;
import datos.Proveedor;
import datos.Usuario;
import interfaces.DAOCompra;
import interfaces.DAOProducto;
import interfaces.DAOProveedor;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UIProducto extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };
    DefaultTableModel modeloProveedor = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //To change body of generated methods, choose Tools | Templates.
        }
    };
    Usuario usuario = new Usuario();
    Herramienta herramienta = new Herramienta();
    Compra compra = new Compra();
    Producto producto = new Producto();
    DAOProducto daoP = new DAOProductoImpl();
    DAOProveedor daoPr = new DAOProveedorImpl();
    Proveedor pr = new Proveedor();
    private int filaSeleccionadaProveedor;
    private List<Producto> listaProductoInicial = new ArrayList();
    private List<Proveedor> listaProveedorInicial = new ArrayList();
    int filaSelecionadaProducto;
    int filaSelecionadaProveedor;
    Compra com = new Compra();
    DAOCompra daoC = new DAOCompraImpl();
    Producto productoEditar = new Producto();

    public UIProducto() {
        initComponents();
    }

    public UIProducto(Usuario u) throws Exception {
        listaProductoInicial = daoP.listarproducto();
        listaProveedorInicial = daoPr.listar();
        initComponents();
        ocultarBoton();
        generarModelo();
        generarModeloProveedor();
        llenarTabla(this.listaProductoInicial);
        llenarTablaProveedor(this.listaProveedorInicial);
        usuario.setCategoria(u.getCategoria());
        usuario.setId_modificar(u.getId_modificar());
        usuario.setNombre(u.getNombre());
        herramienta.validarSoloNumeros(txtCodigobarra);
        herramienta.validarSoloNumeros(txtCantidad);
        herramienta.validarSoloNumeros(txtCantidadAgregar);
        herramienta.validarSoloNumerosFlotante(txtPracioProducto);
        herramienta.validarSoloNumerosFlotante(txtPrecioAgregar);
        herramienta.validarSoloNumerosFlotante(txtPrecioCompra);
        seleccionarCeldaProducto();
        seleccionarProveedor();
    }

    private DefaultTableModel generarModelo() {
        ArrayList<Object> nombreColumna = new ArrayList<Object>();
        nombreColumna.add("Id");
        nombreColumna.add("Nombre");
        nombreColumna.add("Vencimiento");
        nombreColumna.add("Cantidad");
        nombreColumna.add("Codigo barra");
        nombreColumna.add("Id proveedor");
        nombreColumna.add("Precio");
        nombreColumna.add("Tipo");
        for (Object columna : nombreColumna) {
            modelo.addColumn(columna);
        }
        this.jtProducto.setModel(modelo);
        return modelo;
    }

    ;//si
    private void ocultarBoton() {
        pnlDetalleProveedor.setVisible(false);
        btnEditarProducto.setVisible(false);
        btnEditarProveedor.setVisible(false);
        jlFvProducto.setVisible(false);
        txtCantidadAgregar.setVisible(false);
        btbAgregarStock.setVisible(false);
        pnlDetalleProducto.setVisible(false);
        txtPrecioAgregar.setVisible(false);
        jlPrecio.setVisible(false);
        jlCantidad.setVisible(false);
        btnFV.setVisible(false);
    }

    ;
    private DefaultTableModel generarModeloProveedor() {
        ArrayList<Object> nombreColumna = new ArrayList<Object>();
        nombreColumna.add("Id");
        nombreColumna.add("Nombre");
        nombreColumna.add("Telefono");
        nombreColumna.add("Dirección");
        nombreColumna.add("Detalle");

        for (Object columna : nombreColumna) {
            modeloProveedor.addColumn(columna);
        }
        this.jtProveedor.setModel(modeloProveedor);
        return modeloProveedor;
    }

    ;//si
    private void llenarTabla(List<Producto> lista) {

        modelo.setRowCount(0);
        for (Producto p : lista) {
            Object[] fila = {
                p.getCodigo(),
                p.getNombre(),
                p.getFecha_vencimiento(),
                p.getStock(),
                p.getCodigo_barra(),
                p.getId_proveedor(),
                p.getPrecio(),
                p.getTipo_producto()
            };
            modelo.addRow(fila);
        }

    }

    ;
    private void llenarTablaProveedor(List<Proveedor> lista) {
        modeloProveedor.setRowCount(0);
        for (Proveedor proveedor : lista) {
            Object[] fila = {
                proveedor.getIdProveedor(),
                proveedor.getNombreProveedor(),
                proveedor.getTelefonoProveedor(),
                proveedor.getDireccionProveedor(),
                proveedor.getDetalleProveedor()
            };
            modeloProveedor.addRow(fila);
        }

    }

    ;
    private void buscarProveedor(JTextField area) {
        try {
            llenarTablaProveedor(daoPr.buscarProveedor(area.getText()));
        } catch (Exception e) {
            System.err.println("Error en consultar");
        }
    }

    ;
    private void agregarProducto(boolean isActivo) {
        jlFvProducto.setVisible(isActivo);
        txtCantidadAgregar.setVisible(isActivo);
        herramienta.focus(txtCantidadAgregar);
        btbAgregarStock.setVisible(isActivo);
        jlPrecio.setVisible(isActivo);
        txtPrecioAgregar.setVisible(isActivo);
        jlFvProducto.setVisible(isActivo);
        btnFV.setVisible(isActivo);
        jlCantidad.setVisible(isActivo);
    }

    ;
    private Proveedor recuperarDatosTablaProveedor() {
        int filaSelecionadaProveedor = jtProveedor.getSelectedRow();
        pr.setDetalleProveedor((String) jtProveedor.getValueAt(filaSelecionadaProveedor, 4));
        pr.setDireccionProveedor((String) jtProveedor.getValueAt(filaSelecionadaProveedor, 3));
        pr.setIdProveedor((int) jtProveedor.getValueAt(filaSelecionadaProveedor, 0));
        pr.setNombreProveedor((String) jtProveedor.getValueAt(filaSelecionadaProveedor, 1));
        pr.setTelefonoProveedor((String) jtProveedor.getValueAt(filaSelecionadaProveedor, 2));
        return pr;
    }

    ;
    private void seleccionarCeldaProducto() {
        jtProducto.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtProducto.getSelectedRow() != -1) {
                    filaSelecionadaProducto = jtProducto.getSelectedRow();//actualizando la fila seleccionada de TProducto
                    agregarProducto(true);
                    txtCantidadAgregar.setText(null);
                    txtPrecioAgregar.setText(null);
                    pnlDetalleProducto.setVisible(true);
                    jpAccion.setText("Editando Producto");
                    llenarPanelDetalleProducto();
                    if (usuario.getCategoria()) {
                        btnEditarProducto.setVisible(true);
                    };
                } else {
                    agregarProducto(false);
                    pnlDetalleProducto.setVisible(false);
                    jpAccion.setText("Agregar nuevo producto");
                    if (usuario.getCategoria()) {
                        btnEditarProducto.setVisible(false);
                    };
                };
            }
        }
        );
    }

    ;//no
    private void seleccionarProveedor() {
        jtProveedor.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jtProveedor.getSelectedRow() != -1) {
                    filaSelecionadaProveedor = jtProveedor.getSelectedRow();//actualizando la fila seleccionada de TProducto
                    pnlDetalleProveedor.setVisible(true);
                    llenarPanelDetalleProveedor();
                    if (usuario.getCategoria()) {
                        btnEditarProveedor.setVisible(true);
                    };
                } else {
                    pnlDetalleProveedor.setVisible(false);
                    if (usuario.getCategoria()) {
                        btnEditarProveedor.setVisible(false);
                    };
                };
            }
        }
        );
    }

    ;//no
    private void Comprar() throws Exception {
        com.setCamtidadComprada(Integer.parseInt(txtCantidad.getText()));
        com.setFechaCompra(herramienta.fechaHoy());
        com.setIdProducto(daoP.recuperarCodigo(producto));
        com.setIdUsuario(usuario.getId_modificar());
        com.setPrecioTotalCompra(Float.parseFloat(txtPrecioCompra.getText()));
        daoC.registrar(com);
    }

    ;
    private void agregarProducto() {
        int exitenciaProducto = 0;
        if (herramienta.esPunto(txtPracioProducto.getText()) < 2 && herramienta.esPunto(txtPrecioCompra.getText()) < 2) {//evaluando si la casilla de precio no tiene mas d eun punto
            try {

                //agregando nuevo producto
                producto.setCodigo_barra(txtCodigobarra.getText());
                producto.setTipo_producto(txtTipoProducto.getText());
                producto.setNombre(txtNombreProducto.getText());
                producto.setStock(Integer.parseInt(txtCantidad.getText()));
                producto.setPrecio(Float.parseFloat(txtPracioProducto.getText()));
                producto.setFecha_vencimiento(herramienta.cambiarFechaDateSql(btnFechaV.getDate()));
                producto.setId_proveedor((int) jtProveedor.getValueAt(filaSeleccionadaProveedor, 0));
                exitenciaProducto = daoP.evaluarExistencia(producto.getNombre(), producto.getCodigo_barra());
                if (exitenciaProducto == 0) {
                    daoP.registrar(producto);
                    //agregando nueva compra
                    Comprar();
                    herramienta.mensaje("El producto se agregó correctamente");
                    borrarFormulario();
                    jtBuscarProducto.setEditable(true);
                    refrescarTablas();
                } else {
                    herramienta.mensaje("El producto ya existe. Por favor busquelo");
                };

                //fin
            } catch (ParseException ex) {
                Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            herramienta.mensaje("Caracter invalido en precio compra");
        };
    }

    ;
    private void borrarFormulario() {
        if (btnNuevoProducto.getText().equals("Editar")) {
            txtPrecioCompra.setVisible(true);
            jlCompra.setVisible(true);
            txtCantidad.setVisible(true);
            jLabel4.setVisible(true);
            btnNuevoProducto.setText("Agregar");
        } else {
            txtCantidad.setText(null);
            txtPrecioCompra.setText(null);
        };
        txtCantidad.setText(null);
        txtCodigobarra.setText(null);
        txtNombreProducto.setText(null);
        txtPracioProducto.setText(null);
        txtTipoProducto.setText(null);
        btnFechaV.setDate(null);
        try {
            listaProductoInicial = daoP.listarproducto();
        } catch (Exception ex) {
            Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTabla(listaProductoInicial);
        jtBuscarProducto.setText(null);
        jtBuscarProveedor.setText(null);
    }

    ;
    private void editarProducto() throws ParseException {
        boolean exitenciaProducto = false;
        try {
            productoEditar.setId_proveedor((int) jtProveedor.getValueAt(filaSeleccionadaProveedor, 0));
            if (herramienta.esDiferente(String.valueOf(productoEditar.getCodigo_barra()), txtCodigobarra.getText())) {
                exitenciaProducto = daoP.evaluarExistenciaCB(txtCodigobarra.getText());

            };
            if (herramienta.esDiferente(String.valueOf(productoEditar.getNombre()), txtNombreProducto.getText())) {
                exitenciaProducto = daoP.evaluarExistenciaNombre(txtNombreProducto.getText());
            }
            ;
            if (!exitenciaProducto) {
                productoEditar.setCodigo_barra(txtCodigobarra.getText());
                productoEditar.setNombre(txtNombreProducto.getText());
                productoEditar.setFecha_vencimiento( herramienta.cambiarFechaDateSql(btnFechaV.getDate()));
                productoEditar.setId_proveedor((int) jtProveedor.getValueAt(filaSelecionadaProveedor, 0));
                productoEditar.setPrecio(Float.parseFloat(txtPracioProducto.getText()));
                productoEditar.setTipo_producto(txtTipoProducto.getText());
                daoP.modificar(productoEditar);
                herramienta.mensaje("Se ha editado correctamente el producto");
                borrarFormulario();
                jtBuscarProducto.setEditable(true);
                refrescarTablas();
            } else {
                herramienta.mensaje("El nombre o código de barra ya está en uso");
            };
        } catch (Exception ex) {
            Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ;
    private void seleccionrFilaProveedor() {
        llenarTablaProveedor(listaProveedorInicial);
        int id_proveedor = (int) jtProducto.getValueAt(filaSelecionadaProducto, 5);
        for (int i = 0; i < jtProveedor.getColumnCount(); i++) {
            if ((int) jtProveedor.getValueAt(i, 0) == id_proveedor) {
                jtProveedor.getSelectionModel().setSelectionInterval(i, i);
            };
        };
    }

    ;
    private void llenarPanelDetalleProveedor() {
        txtDDetalleProvedor.setText((String) jtProveedor.getValueAt(filaSelecionadaProveedor, 4));
        txtDDireccionProveedor.setText("Direccion: " + (String) jtProveedor.getValueAt(filaSelecionadaProveedor, 3));
        txtDNombreProveedor.setText("Nombre: " + (String) jtProveedor.getValueAt(filaSelecionadaProveedor, 1));
        txtDTelefonoProveedor.setText("Telefono: " + (String) jtProveedor.getValueAt(filaSelecionadaProveedor, 2));
    }

    ;
    
    private void llenarPanelDetalleProducto() {
        Proveedor detalleProveedor;
        try {
            detalleProveedor = daoPr.listarUno((int) jtProducto.getValueAt(filaSelecionadaProducto, 5));
            txtPNombreProducto.setText("Nombre: " + (String) jtProducto.getValueAt(filaSelecionadaProducto, 1));
            txtPFechaV.setText("Fecha de vencimiento: " + jtProducto.getValueAt(filaSelecionadaProducto, 2));
            txtPTipoP.setText("Tipo: " + (String) jtProducto.getValueAt(filaSelecionadaProducto, 7));
            txtPnombrePv.setText("Nombre proveedor: " + detalleProveedor.getNombreProveedor());
            txtPTelefonoPv.setText("Teléfono Proveedor: " + detalleProveedor.getTelefonoProveedor());
            txtPDireccionPv.setText("Dirección proveedor: " + detalleProveedor.getDireccionProveedor());
        } catch (Exception ex) {
            Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ;
    private void refrescarTablas() {
        try {
            listaProductoInicial = daoP.listarproducto();
            listaProveedorInicial = daoPr.listar();
        } catch (Exception ex) {
            Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarTabla(listaProductoInicial);
        llenarTablaProveedor(listaProveedorInicial);
    }

    ;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVenta = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        jpProveedorInfo = new javax.swing.JPanel();
        pnlDetalleProveedor = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtDNombreProveedor = new javax.swing.JLabel();
        txtDDireccionProveedor = new javax.swing.JLabel();
        txtDTelefonoProveedor = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDDetalleProvedor = new javax.swing.JTextArea();
        pnlDetalleProducto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtPNombreProducto = new javax.swing.JLabel();
        txtPnombrePv = new javax.swing.JLabel();
        txtPDireccionPv = new javax.swing.JLabel();
        txtPTelefonoPv = new javax.swing.JLabel();
        txtPFechaV = new javax.swing.JLabel();
        txtPTipoP = new javax.swing.JLabel();
        btnEditarProducto = new javax.swing.JButton();
        jpAgregarProdcuto = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtBuscarProducto = new javax.swing.JTextField();
        jlCantidad = new javax.swing.JLabel();
        txtCantidadAgregar = new javax.swing.JTextField();
        jlFvProducto = new javax.swing.JLabel();
        btnFV = new com.toedter.calendar.JDateChooser();
        jlPrecio = new javax.swing.JLabel();
        txtPrecioAgregar = new javax.swing.JTextField();
        btbAgregarStock = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpAccion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlCompra = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnFechaV = new com.toedter.calendar.JDateChooser();
        txtCantidad = new javax.swing.JTextField();
        txtCodigobarra = new javax.swing.JTextField();
        txtTipoProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioCompra = new javax.swing.JTextField();
        txtPracioProducto = new javax.swing.JTextField();
        btnNuevoProducto = new javax.swing.JButton();
        btnAgregarProveedor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtProveedor = new javax.swing.JTable();
        btnEditarProveedor = new javax.swing.JButton();
        jtBuscarProveedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1050, 575));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
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

        jpProveedorInfo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Detalles del proveedor");

        txtDNombreProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtDNombreProveedor.setText("Nombre:");

        txtDDireccionProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtDDireccionProveedor.setText("Dirección:");

        txtDTelefonoProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtDTelefonoProveedor.setText("Teléfono:");

        jLabel15.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Detalle:");

        txtDDetalleProvedor.setBackground(new java.awt.Color(240, 240, 240));
        txtDDetalleProvedor.setColumns(20);
        txtDDetalleProvedor.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtDDetalleProvedor.setRows(5);
        jScrollPane3.setViewportView(txtDDetalleProvedor);

        javax.swing.GroupLayout pnlDetalleProveedorLayout = new javax.swing.GroupLayout(pnlDetalleProveedor);
        pnlDetalleProveedor.setLayout(pnlDetalleProveedorLayout);
        pnlDetalleProveedorLayout.setHorizontalGroup(
            pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDDireccionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                        .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        pnlDetalleProveedorLayout.setVerticalGroup(
            pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetalleProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDNombreProveedor)
                    .addGroup(pnlDetalleProveedorLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDTelefonoProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDDireccionProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Detalles del producto");

        txtPNombreProducto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtPNombreProducto.setText("Nombre:");

        txtPnombrePv.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtPnombrePv.setText("Nombre proveedor:");

        txtPDireccionPv.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtPDireccionPv.setText("Dirección proveedor:");

        txtPTelefonoPv.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtPTelefonoPv.setText("Teléfono proveedor:");

        txtPFechaV.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtPFechaV.setText("Fecha vencimiento:");

        txtPTipoP.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        txtPTipoP.setText("Tipo:");

        javax.swing.GroupLayout pnlDetalleProductoLayout = new javax.swing.GroupLayout(pnlDetalleProducto);
        pnlDetalleProducto.setLayout(pnlDetalleProductoLayout);
        pnlDetalleProductoLayout.setHorizontalGroup(
            pnlDetalleProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPDireccionPv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPTelefonoPv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDetalleProductoLayout.createSequentialGroup()
                        .addGroup(pnlDetalleProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPnombrePv, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPFechaV, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDetalleProductoLayout.setVerticalGroup(
            pnlDetalleProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPNombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPFechaV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPTipoP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPnombrePv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPTelefonoPv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPDireccionPv)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpProveedorInfoLayout = new javax.swing.GroupLayout(jpProveedorInfo);
        jpProveedorInfo.setLayout(jpProveedorInfoLayout);
        jpProveedorInfoLayout.setHorizontalGroup(
            jpProveedorInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedorInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDetalleProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalleProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpProveedorInfoLayout.setVerticalGroup(
            jpProveedorInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedorInfoLayout.createSequentialGroup()
                .addGroup(jpProveedorInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetalleProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDetalleProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnEditarProducto.setText("Editar producto");
        btnEditarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarProductoMouseClicked(evt);
            }
        });
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Search_32px_2.png"))); // NOI18N

        jtBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        jtBuscarProducto.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jtBuscarProducto.setForeground(new java.awt.Color(153, 153, 153));
        jtBuscarProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 51, 51)));
        jtBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscarProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtBuscarProductoFocusGained(evt);
            }
        });
        jtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarProductoKeyReleased(evt);
            }
        });

        jlCantidad.setBackground(new java.awt.Color(255, 255, 255));
        jlCantidad.setText("Cantidad:");

        txtCantidadAgregar.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidadAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadAgregarActionPerformed(evt);
            }
        });

        jlFvProducto.setBackground(new java.awt.Color(255, 255, 255));
        jlFvProducto.setText("Fecha vencimiento");

        jlPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jlPrecio.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jlPrecio.setText("Precio de compra:");

        txtPrecioAgregar.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioAgregarActionPerformed(evt);
            }
        });

        btbAgregarStock.setText("Agregar");
        btbAgregarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAgregarStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAgregarProdcutoLayout = new javax.swing.GroupLayout(jpAgregarProdcuto);
        jpAgregarProdcuto.setLayout(jpAgregarProdcutoLayout);
        jpAgregarProdcutoLayout.setHorizontalGroup(
            jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgregarProdcutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFvProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btbAgregarStock, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpAgregarProdcutoLayout.setVerticalGroup(
            jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgregarProdcutoLayout.createSequentialGroup()
                .addGroup(jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAgregarProdcutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlFvProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCantidadAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtBuscarProducto))
                            .addGroup(jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btbAgregarStock))))
                    .addGroup(jpAgregarProdcutoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpAgregarProdcutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(btnFV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditarProducto))
                    .addComponent(jpProveedorInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAgregarProdcuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAgregarProdcuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpProveedorInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        jpAccion.setBackground(new java.awt.Color(255, 255, 255));
        jpAccion.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jpAccion.setText("Agregar nuevo producto");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código barra");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo producto");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio venta unidad");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de vencimiento");

        jlCompra.setBackground(new java.awt.Color(255, 255, 255));
        jlCompra.setText("Precio de compra total");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre ");

        btnFechaV.setBackground(new java.awt.Color(204, 204, 204));

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setForeground(new java.awt.Color(102, 102, 102));

        txtCodigobarra.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigobarra.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigobarra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigobarraFocusGained(evt);
            }
        });
        txtCodigobarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigobarraKeyReleased(evt);
            }
        });

        txtTipoProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtTipoProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTipoProductoFocusGained(evt);
            }
        });
        txtTipoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipoProductoKeyReleased(evt);
            }
        });

        txtNombreProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreProductoFocusGained(evt);
            }
        });
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyReleased(evt);
            }
        });

        txtPrecioCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioCompra.setForeground(new java.awt.Color(102, 102, 102));

        txtPracioProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtPracioProducto.setForeground(new java.awt.Color(102, 102, 102));

        btnNuevoProducto.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevoProducto.setText("Agregar");
        btnNuevoProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoProductoMouseClicked(evt);
            }
        });

        btnAgregarProveedor.setText("Agregar proveedor");
        btnAgregarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarProveedorMouseClicked(evt);
            }
        });

        jtProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtProveedor);

        btnEditarProveedor.setText("Editar proveedor");
        btnEditarProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarProveedorMouseClicked(evt);
            }
        });

        jtBuscarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        jtBuscarProveedor.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jtBuscarProveedor.setForeground(new java.awt.Color(153, 153, 153));
        jtBuscarProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(255, 51, 51)));
        jtBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscarProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtBuscarProveedorFocusGained(evt);
            }
        });
        jtBuscarProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarProveedorKeyReleased(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Search_32px_2.png"))); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarProveedor)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnFechaV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPracioProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTipoProducto, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigobarra, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(btnCancelar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnNuevoProducto))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAccion)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigobarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPracioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFechaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevoProducto)
                        .addComponent(btnCancelar))
                    .addComponent(jtBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProveedor)
                    .addComponent(btnAgregarProveedor))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpVentaLayout.setVerticalGroup(
            jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jpVenta, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoProductoMouseClicked
        filaSeleccionadaProveedor = jtProveedor.getSelectedRow();
        boolean celdaVacia = herramienta.esVacio(txtCodigobarra.getText())
                || //evaluando si una de la celdass esta vacio
                herramienta.esVacio(txtTipoProducto.getText())
                || herramienta.esVacio(txtNombreProducto.getText())
                || herramienta.esVacio(txtPracioProducto.getText());

        //buscar en la base de datos para ver si es unico
        if (!celdaVacia && btnFechaV.getDate() != null) {//lo mismo 
            if (filaSeleccionadaProveedor != -1) {//lo mismo
                if (btnNuevoProducto.getText().equals("Agregar")) {//para agregar
                    if (!herramienta.esVacio(txtPrecioCompra.getText()) && !herramienta.esVacio(txtCantidad.getText())) {
                        agregarProducto();

                    } else {
                        herramienta.mensaje("Llene todos los campos");
                    };

                } else {
                    try {
                        editarProducto();

                    } catch (ParseException ex) {
                        Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
            } else {
                herramienta.mensaje("Seleccione un preevedor");
            };
        } else {
            herramienta.mensaje("Llene todos los campos 1");
        };
        //refrescando las tablas

    }//GEN-LAST:event_btnNuevoProductoMouseClicked

    private void jtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarProductoKeyReleased

    }//GEN-LAST:event_jtBuscarProductoKeyReleased

    private void jtBuscarProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarProveedorKeyReleased
        buscarProveedor(jtBuscarProveedor);
    }//GEN-LAST:event_jtBuscarProveedorKeyReleased

    private void btnEditarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProveedorMouseClicked
        UIProveedor j = new UIProveedor(usuario, recuperarDatosTablaProveedor());
        j.setVisible(true);

    }//GEN-LAST:event_btnEditarProveedorMouseClicked

    private void txtCodigobarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigobarraKeyReleased

    }//GEN-LAST:event_txtCodigobarraKeyReleased

    private void txtTipoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoProductoKeyReleased


    }//GEN-LAST:event_txtTipoProductoKeyReleased

    private void txtNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyReleased


    }//GEN-LAST:event_txtNombreProductoKeyReleased

    private void btnAgregarProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarProveedorMouseClicked
        UIProveedor i = new UIProveedor(usuario);
        i.setVisible(true);
    }//GEN-LAST:event_btnAgregarProveedorMouseClicked

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed

    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        borrarFormulario();
        jtBuscarProducto.setEditable(true);
        llenarTablaProveedor(listaProveedorInicial); //quitando la seleecion
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCodigobarraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigobarraFocusGained
        if (btnNuevoProducto.getText().equals("Agregar")) {
            herramienta.fitrarBusqueda(txtCodigobarra, jtProducto);
        };
    }//GEN-LAST:event_txtCodigobarraFocusGained

    private void txtTipoProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoProductoFocusGained
        if (btnNuevoProducto.getText().equals("Agregar")) {
            herramienta.fitrarBusqueda(txtTipoProducto, jtProducto);
        };

    }//GEN-LAST:event_txtTipoProductoFocusGained

    private void txtNombreProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreProductoFocusGained
        if (btnNuevoProducto.getText().equals("Agregar")) {
            herramienta.fitrarBusqueda(txtNombreProducto, jtProducto);
        };

    }//GEN-LAST:event_txtNombreProductoFocusGained

    private void jtBuscarProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtBuscarProductoFocusGained
        if (btnNuevoProducto.getText().equals("Agregar")) {
            herramienta.fitrarBusqueda(jtBuscarProducto, jtProducto);
        };

    }//GEN-LAST:event_jtBuscarProductoFocusGained

    private void jtBuscarProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtBuscarProveedorFocusGained
        herramienta.fitrarBusqueda(jtBuscarProveedor, jtProveedor);
    }//GEN-LAST:event_jtBuscarProveedorFocusGained

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void btbAgregarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAgregarStockActionPerformed

        if (!herramienta.esVacio(txtCantidadAgregar.getText()) && !herramienta.esVacio(txtPrecioAgregar.getText())) {
            if (herramienta.esPunto(txtPrecioAgregar.getText()) < 2) {

                com.setCamtidadComprada(Integer.parseInt(txtCantidadAgregar.getText()));
                com.setFechaCompra(herramienta.fechaHoy());
                com.setIdProducto((int) jtProducto.getValueAt(filaSelecionadaProducto, 0));
                com.setIdUsuario(usuario.getId_modificar());
                com.setPrecioTotalCompra(Float.parseFloat(txtPrecioAgregar.getText()));
                try {
                    if (btnFV.getDate() != null) {
                        daoP.acctualizarFechaVencimiento(herramienta.cambiarFechaDateSql(btnFV.getDate()), (int) jtProducto.getValueAt(filaSelecionadaProducto, 0));
                    };//actualizar fecha de vencimiento
                    daoC.registrar(com);
                    herramienta.mensaje("Se agregó correctamente el producto");
                    listaProductoInicial = daoP.listarproducto();
                    txtCantidadAgregar.setText(null);
                    txtPrecioAgregar.setText(null);
                    jtBuscarProducto.setText(null);
                    llenarTabla(listaProductoInicial);
                } catch (Exception ex) {
                    Logger.getLogger(UIProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                herramienta.mensaje("Caracter invalido en precio compra");
            };

        } else {
            herramienta.mensaje("Llene todos los campos");
        };

    }//GEN-LAST:event_btbAgregarStockActionPerformed

    private void txtCantidadAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadAgregarActionPerformed

    private void btnEditarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProductoMouseClicked

        btnNuevoProducto.setText("Editar");
        jtBuscarProducto.setEditable(false);//desactivando busqueda
        //desapariciendo la los campos de precio compra
        txtPrecioCompra.setVisible(false);
        jlCompra.setVisible(false);
        //fin
        //desapareciendo los campos de catidad
        txtCantidad.setVisible(false);
        jLabel4.setVisible(false);
        //fin
        productoEditar.setCodigo_barra(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 4)));
        txtCodigobarra.setText(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 4)));
        
        productoEditar.setNombre(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 1)));
        txtNombreProducto.setText(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 1)));
        
        productoEditar.setPrecio((float) jtProducto.getValueAt(filaSelecionadaProducto, 6));
        txtPracioProducto.setText(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 6)));
        
        productoEditar.setTipo_producto(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 7)));
        txtTipoProducto.setText(String.valueOf(jtProducto.getValueAt(filaSelecionadaProducto, 7)));
        
        productoEditar.setFecha_vencimiento((java.sql.Date) jtProducto.getValueAt(filaSelecionadaProducto, 2));
        btnFechaV.setDate((Date) jtProducto.getValueAt(filaSelecionadaProducto, 2));
        //id del producto
        productoEditar.setCodigo((int) jtProducto.getValueAt(filaSelecionadaProducto, 0));
        seleccionrFilaProveedor();
    }//GEN-LAST:event_btnEditarProductoMouseClicked

    private void txtPrecioAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbAgregarStock;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private com.toedter.calendar.JDateChooser btnFV;
    private com.toedter.calendar.JDateChooser btnFechaV;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlCantidad;
    private javax.swing.JLabel jlCompra;
    private javax.swing.JLabel jlFvProducto;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JLabel jpAccion;
    private javax.swing.JPanel jpAgregarProdcuto;
    private javax.swing.JPanel jpProveedorInfo;
    private javax.swing.JPanel jpVenta;
    private javax.swing.JTextField jtBuscarProducto;
    private javax.swing.JTextField jtBuscarProveedor;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTable jtProveedor;
    private javax.swing.JPanel pnlDetalleProducto;
    private javax.swing.JPanel pnlDetalleProveedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadAgregar;
    private javax.swing.JTextField txtCodigobarra;
    private javax.swing.JTextArea txtDDetalleProvedor;
    private javax.swing.JLabel txtDDireccionProveedor;
    private javax.swing.JLabel txtDNombreProveedor;
    private javax.swing.JLabel txtDTelefonoProveedor;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JLabel txtPDireccionPv;
    private javax.swing.JLabel txtPFechaV;
    private javax.swing.JLabel txtPNombreProducto;
    private javax.swing.JLabel txtPTelefonoPv;
    private javax.swing.JLabel txtPTipoP;
    private javax.swing.JLabel txtPnombrePv;
    private javax.swing.JTextField txtPracioProducto;
    private javax.swing.JTextField txtPrecioAgregar;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtTipoProducto;
    // End of variables declaration//GEN-END:variables
}
