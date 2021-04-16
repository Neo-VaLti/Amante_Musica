package Interfaz;

import java.awt.event.KeyEvent;

/**
 * Clase que sirve para obtener informacion del host al cual se conectara.
 *
 * @author 133739 - 116462
 */
public class DlgConexion extends javax.swing.JDialog {

    public static final String ACEPTAR = "ACEPTAR",

    /**
     *
     */
    CANCELAR = "CANCELAR";

    private String accion;

    /**
     * Crea un nuevo dialogo de conexion.
     *
     * @param parent
     * @param modal
     */
    public DlgConexion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centrarVentana();
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTextoHost = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        CampoPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conexion MysqlServer");

        jLabel1.setText("Conexion con Base de datos");

        jLabel2.setText("Direccion JDBC:");

        campoTextoHost.setForeground(new java.awt.Color(255, 0, 0));
        campoTextoHost.setText("jdbc:mysql://localhost:3306/amantemusica");
        campoTextoHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoHostActionPerformed(evt);
            }
        });
        campoTextoHost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoHostKeyPressed(evt);
            }
        });

        botonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/accept.png"))); // NOI18N
        botonAceptar.setText("Establecer Conexion");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jLabel3.setText("Contraseña:");

        CampoPassword.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoHost)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 176, Short.MAX_VALUE))
                            .addComponent(jSeparator1)
                            .addComponent(CampoPassword))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoTextoHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CampoPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Destruye esta ventana.
     *
     * @param evt
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        accion = ACEPTAR;
        dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void campoTextoHostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoHostKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            accion = ACEPTAR;
            dispose();
        }
    }//GEN-LAST:event_campoTextoHostKeyPressed

    private void campoTextoHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoHostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoHostActionPerformed

    /**
     * Centra la ventana en el monitor.
     */
    private void centrarVentana() {
        setLocationRelativeTo(null);
    }

    /**
     * Regresa el host que se especifico.
     *
     * @return El host especificado.
     */
    public String getHost() {
        return campoTextoHost.getText();
    }

    /**
     * Regresa el usuario que se especifico.
     *
     * @return El usuario que se especifico.
     */
    public String getUsuario() {
        return "root";
    }

    /**
     * Regresa el password que se especifico.
     *
     * @return El password especificado.
     */
    public String getPassword() {
        return CampoPassword.getText();
    }

    /**
     * Retorna la accion que se selecciono.
     *
     * @return La accion seleccionada.
     */
    public String getAccion() {
        return accion;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CampoPassword;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JTextField campoTextoHost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
