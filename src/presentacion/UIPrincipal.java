
package presentacion;
import AppPackage.AnimationClass;

public class UIPrincipal extends javax.swing.JFrame {
    
    public void cerrarUIPrincipal(){
        this.dispose();
    }
    public UIPrincipal() {
        initComponents(); 
        this.setLocationRelativeTo(null); //para que aparesca en el centro 
    }
    
    public UIPrincipal(boolean stV) {
        initComponents(); 

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMenu = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlInternet = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpMenu.setBackground(new java.awt.Color(255, 255, 255));
        jpMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jpMenu.setForeground(new java.awt.Color(255, 255, 255));
        jpMenu.setPreferredSize(new java.awt.Dimension(1050, 575));
        jpMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpMenuMouseDragged(evt);
            }
        });
        jpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpMenuMousePressed(evt);
            }
        });
        jpMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Expand_Arrow_32px.png"))); // NOI18N
        btnMinimizar.setBorder(null);
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jpMenu.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 40, 30));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Multiply_32px.png"))); // NOI18N
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jpMenu.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 40, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/medicine.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 210, 190));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/logistics.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 210, 190));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/buy.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jpMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 210, 190));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/Home.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 210, 190));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/statistics.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 210, 190));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/money.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 210, 190));

        jLabel1.setBackground(new java.awt.Color(255, 99, 71));
        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 99, 71));
        jLabel1.setText("Proveedor");
        jpMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, -1, -1));

        jTextField1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(187, 187, 187));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 99, 71)));
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpMenu.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 210, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Search_32px_2.png"))); // NOI18N
        jpMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 40, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Menu_32px.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jpMenu.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jlInternet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlInternet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/img/icons8_Globe_32px.png"))); // NOI18N
        jpMenu.add(jlInternet, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 100, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 99, 71));
        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 99, 71));
        jLabel10.setText("Inicio");
        jpMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 99, 71));
        jLabel11.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 99, 71));
        jLabel11.setText("Venta");
        jpMenu.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 99, 71));
        jLabel12.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 99, 71));
        jLabel12.setText("Producto");
        jpMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 99, 71));
        jLabel13.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 99, 71));
        jLabel13.setText("Reporte");
        jpMenu.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 99, 71));
        jLabel14.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 99, 71));
        jLabel14.setText("Personal");
        jpMenu.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        getContentPane().add(jpMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
      
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        
        AnimationClass internet = new AnimationClass();
        internet.jLabelXRight(-40, 30, 10, 5, jlInternet);
        //para que vuelva  su posicion original 
        
        AnimationClass internett = new AnimationClass();
        internett.jLabelXRight(30, -40, 10, 5, jlInternet);
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        
    }//GEN-LAST:event_jLabel5MouseClicked
    int xx,yy;
    private void jpMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpMenuMousePressed
        xx=evt.getX();
        yy=evt.getY();
    }//GEN-LAST:event_jpMenuMousePressed

    private void jpMenuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpMenuMouseDragged
        int x= evt.getXOnScreen();
        int y= evt.getYOnScreen();
        
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jpMenuMouseDragged

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        
    }//GEN-LAST:event_btnCerrarMouseClicked
    
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlInternet;
    private javax.swing.JPanel jpMenu;
    // End of variables declaration//GEN-END:variables
}
