
package presentacion;

import control.CambiaPanel;
import dataAccesObject.DAOProductoImpl;
import dataAccesObject.DAOProveedorImpl;
import datos.Producto;
import datos.Proveedor;
import datos.Usuario;
import interfaces.DAOProducto;
import interfaces.DAOProveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UIPrincipal extends javax.swing.JFrame {
    int xx,yy;
    private String tituloTabla="Mary Pharmacy";
    private List<Producto> listaProducto = new ArrayList();
    DAOProducto daoP = new DAOProductoImpl();
    DAOProveedor daoPr = new DAOProveedorImpl();
    Usuario u = new Usuario();
        
    public UIPrincipal(){
        initComponents();
    }
    public UIPrincipal(Usuario us) throws Exception{
        listaProducto = daoP.listar();
        initComponents();
        this.setLocationRelativeTo(null);
        cambiarTitulo("Mary Pharmacy");
        this.setTitle(getTitulo());
        new CambiaPanel(jpPrincipal,new UIInicio());
        if(!us.getCategoria()){//seleccionar que ventanas se va mostrar
            ocultarBoton();
        }
        u.setNombre(us.getNombre());
        u.setCategoria(us.getCategoria());
        u.setId_modificar(us.getId_modificar());
        
    }
    
    
    private String cambiarTitulo(String nuevo_titulo){
        this.tituloTabla=nuevo_titulo;
        return tituloTabla;
    }
    private String getTitulo(){
        return tituloTabla;
    }
    private void ocultarBoton(){    
        this.jbPersonal.setVisible(false);
        this.jbReporte.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JPanel();
        jbInicio = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jbVenta = new javax.swing.JButton();
        jbProducto = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jbReporte = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jbPersonal = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jpToolBar = new javax.swing.JPanel();
        jpPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jpMenu.setBackground(new java.awt.Color(78, 115, 223));
        jpMenu.setPreferredSize(new java.awt.Dimension(100, 700));

        jbInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_inicio_off.png"))); // NOI18N
        jbInicio.setBorder(null);
        jbInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbInicio.setPreferredSize(new java.awt.Dimension(130, 40));
        jbInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_inicio_on.png"))); // NOI18N
        jbInicio.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_inicio_on.png"))); // NOI18N
        jbInicio.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_inicio_on.png"))); // NOI18N
        jbInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbInicioMouseClicked(evt);
            }
        });

        jbVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_venta_off.png"))); // NOI18N
        jbVenta.setBorder(null);
        jbVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbVenta.setPreferredSize(new java.awt.Dimension(130, 40));
        jbVenta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_venta_on.png"))); // NOI18N
        jbVenta.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_venta_on.png"))); // NOI18N
        jbVenta.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_venta_on.png"))); // NOI18N
        jbVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbVentaMouseClicked(evt);
            }
        });

        jbProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_producto_off.png"))); // NOI18N
        jbProducto.setBorder(null);
        jbProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbProducto.setPreferredSize(new java.awt.Dimension(130, 40));
        jbProducto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_producto_on.png"))); // NOI18N
        jbProducto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_producto_on.png"))); // NOI18N
        jbProducto.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_producto_on.png"))); // NOI18N
        jbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbProductoMouseClicked(evt);
            }
        });

        jbReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_reporte_off.png"))); // NOI18N
        jbReporte.setBorder(null);
        jbReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbReporte.setPreferredSize(new java.awt.Dimension(130, 40));
        jbReporte.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_reporte_on.png"))); // NOI18N
        jbReporte.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_reporte_on.png"))); // NOI18N
        jbReporte.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_reporte_on.png"))); // NOI18N
        jbReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbReporteMouseClicked(evt);
            }
        });

        jbPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_personal_off.png"))); // NOI18N
        jbPersonal.setBorder(null);
        jbPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbPersonal.setPreferredSize(new java.awt.Dimension(130, 40));
        jbPersonal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_personal_on.png"))); // NOI18N
        jbPersonal.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_personal_on.png"))); // NOI18N
        jbPersonal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/button_personal_on.png"))); // NOI18N
        jbPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbPersonalMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/logoFarmacia.png"))); // NOI18N

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jbInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        jpToolBar.setBackground(new java.awt.Color(255, 255, 255));
        jpToolBar.setForeground(new java.awt.Color(255, 255, 255));
        jpToolBar.setPreferredSize(new java.awt.Dimension(1200, 30));
        jpToolBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpToolBarMouseDragged(evt);
            }
        });
        jpToolBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpToolBarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jpToolBarLayout = new javax.swing.GroupLayout(jpToolBar);
        jpToolBar.setLayout(jpToolBarLayout);
        jpToolBarLayout.setHorizontalGroup(
            jpToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1173, Short.MAX_VALUE)
        );
        jpToolBarLayout.setVerticalGroup(
            jpToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        jpPrincipal.setMinimumSize(new java.awt.Dimension(100, 100));
        jpPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpPrincipalMouseDragged(evt);
            }
        });
        jpPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpPrincipalMousePressed(evt);
            }
        });
        jpPrincipal.setLayout(new javax.swing.BoxLayout(jpPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addComponent(jpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbVentaMouseClicked
        
        cambiarTitulo("Venta "+u.getNombre());
        this.setTitle(getTitulo());
        new CambiaPanel(jpPrincipal, new UIVenta(u,listaProducto));

    }//GEN-LAST:event_jbVentaMouseClicked

    private void jpPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPrincipalMousePressed
        xx=evt.getX();
        yy=evt.getY();
    }//GEN-LAST:event_jpPrincipalMousePressed

    private void jpPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPrincipalMouseDragged
        
    }//GEN-LAST:event_jpPrincipalMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
// TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void jpToolBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpToolBarMousePressed
        xx=evt.getX();
        yy=evt.getY();
    }//GEN-LAST:event_jpToolBarMousePressed

    private void jpToolBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpToolBarMouseDragged
        int x= evt.getXOnScreen();
        int y= evt.getYOnScreen();

        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jpToolBarMouseDragged

    private void jbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbProductoMouseClicked
        cambiarTitulo("Producto "+u.getNombre());
        this.setTitle(getTitulo());
        try {
            new CambiaPanel(jpPrincipal, new UIProducto(u));
        } catch (Exception ex) {
            Logger.getLogger(UIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbProductoMouseClicked

    private void jbReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbReporteMouseClicked
        cambiarTitulo("Reporte "+u.getNombre());
        this.setTitle(getTitulo());
        try {
            new CambiaPanel(jpPrincipal, new UIReporte());
        } catch (Exception ex) {
            Logger.getLogger(UIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbReporteMouseClicked

    private void jbPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbPersonalMouseClicked
        cambiarTitulo("Personal "+u.getNombre());
        this.setTitle(getTitulo());
        new CambiaPanel(jpPrincipal, new UIPersonal());
    }//GEN-LAST:event_jbPersonalMouseClicked

    private void jbInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbInicioMouseClicked
        cambiarTitulo("Inicio "+u.getNombre());
        this.setTitle(getTitulo());
        new CambiaPanel(jpPrincipal, new UIInicio());
    }//GEN-LAST:event_jbInicioMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton jbInicio;
    private javax.swing.JButton jbPersonal;
    private javax.swing.JButton jbProducto;
    private javax.swing.JButton jbReporte;
    private javax.swing.JButton jbVenta;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpToolBar;
    // End of variables declaration//GEN-END:variables
}
