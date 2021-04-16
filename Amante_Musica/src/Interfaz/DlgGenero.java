package Interfaz;

import Fachadas.IFachada;
import Tablas.Genero;
import java.awt.event.ItemEvent;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class DlgGenero extends javax.swing.JDialog {

    /*
    @author 133739 - 116462
    */
    
    //Las acciones que permite este dlg.
    public static final String A_ACEPTAR = "ACEPTAR",

    /**
     *
     */
    A_CANCELAR = "CANCELAR";

    //Los comandos que permite este dlg.
    public static final String CMD_AGREGAR = "AGREGAR",

    /**
     *
     */
    CMD_ACTUALIZAR = "ACTUALIZR",

    /**
     *
     */
    CMD_ELIMINAR = "ELIMINAR";

    //La accion que se selecciono.
    private String accion;
    //La instruccion que se quiere hacer con este dialogo.
    private String comando = "";
    //La clave antigua del genero que se quiere actualizar.
    private String claveAntigua;

    /**
     * Crea un nuevo dialogo para obtener datos de un genero.
     *
     * @param parent
     * @param  modal
     * @param comando
     * @param fachada
     */
    public DlgGenero(java.awt.Frame parent, boolean modal, String comando, IFachada fachada) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        this.comando = comando;

        //Aqui vamos a cambiar cosas del Dlg si es que se ocupan.
        verificarComando(fachada);
        setVisible(true);
    }

    /**
     * Llena los campos de texto con los datos del genero.
     *
     * @param genero
     */
    private void verificarComando(IFachada fachada) {
        String textoBoton = "";

        if (comando.equalsIgnoreCase(CMD_AGREGAR)) {
            comboBoxSelectGenero.setEnabled(false);
            jlabelSeleccionarGenero.setText("..");

            textoBoton = "Agregar";
        } //En estos casos, se deshabilitaran los campos hasta que se haya
        //seleccionado el genero que se quiere tratar.
        else if (comando.equalsIgnoreCase(CMD_ELIMINAR)) {
            textoBoton = "Eliminar";
            jlabelSeleccionarGenero.setText("Seleccione el genero que desea eliminar.");

            //Si se va a eliminar algo, vamos a deshabilitar los campos de texto
            //y cambiar el texto del boton a lo que se deba cambiar.
            setEnabledCampos(false);

            //Llenamos el comboBox con todos los generos que se hayan creado anteriormente.
            construirComboBox(fachada);
        } else if (comando.equalsIgnoreCase(CMD_ACTUALIZAR)) {
            textoBoton = "Actualizar";
            jlabelSeleccionarGenero.setText("Seleccione el genero que desea actualizar.");

            setEnabledCampos(false);
            construirComboBox(fachada);
        }

        botonAceptar.setText(textoBoton);
    }

    private void construirComboBox(IFachada fachada) {
        try {
            //Obtenemos la lista de generos disponibles.
            Vector listaGeneros = fachada.consultaGeneros();

            //Convertimos a string los generos.
            Vector generos = new Vector();

            for (int i = 0; i < listaGeneros.size(); i++) {
                Genero genero = (Genero) listaGeneros.get(i);

                String clave = genero.getCveGenero();
                String nombre = genero.getNombre();
                String tipo = String.valueOf(genero.getTipoMedio());

                String añadir = clave + " / " + nombre + " / " + tipo;
                generos.add(añadir);
            }

            //Agregamos los generos al comboBox.
            ComboBoxModel model = new DefaultComboBoxModel(generos);

            //Le ponemos el modelo a este comboBox.
            comboBoxSelectGenero.setModel(model);
            comboBoxSelectGenero.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error obteniendo los generos.");
            e.printStackTrace();

            accion = A_CANCELAR;
            dispose();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoTextoCveGenero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoTextoNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoTextoTipoMedio = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jlabelSeleccionarGenero = new javax.swing.JLabel();
        comboBoxSelectGenero = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dialogo Genero");

        jLabel1.setText("CveGenero");

        campoTextoCveGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoCveGeneroKeyPressed(evt);
            }
        });

        jLabel2.setText("Nombre");

        campoTextoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoNombreKeyPressed(evt);
            }
        });

        jLabel3.setText("Tipo Medio");

        campoTextoTipoMedio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoTipoMedioKeyPressed(evt);
            }
        });

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/delete.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/accept.png"))); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        jlabelSeleccionarGenero.setText("..");

        comboBoxSelectGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSelectGeneroItemStateChanged(evt);
            }
        });
        comboBoxSelectGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSelectGeneroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addComponent(jlabelSeleccionarGenero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(campoTextoNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoTextoCveGenero, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboBoxSelectGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, 214, Short.MAX_VALUE)
                        .addComponent(campoTextoTipoMedio)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelSeleccionarGenero)
                    .addComponent(comboBoxSelectGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoCveGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoTextoTipoMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se
     * pueden introducir, ya que en la base de datos tienen un rango especifico.
     * Aqui la clave solo puede ser de maximo 11 caracteres.
     *
     * @param evt Action event for this Java Component.
     */
    private void campoTextoTipoMedioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoTipoMedioKeyPressed
        if (campoTextoTipoMedio.getText().length() > 0) {
            campoTextoTipoMedio.setText(campoTextoTipoMedio.getText().substring(0, 0));
        }
    }//GEN-LAST:event_campoTextoTipoMedioKeyPressed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (!getCveGenero().isEmpty() && !getNombre().isEmpty() && !String.valueOf(getTipoMedio()).isEmpty()) {
            accion = A_ACEPTAR;
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Uno de los campos esta vacio.");
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        accion = A_CANCELAR;
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se
     * pueden introducir, ya que en la base de datos tienen un rango especifico.
     * Aqui la clave solo puede ser de maximo 11 caracteres.
     *
     * @param evt Action event for this Java Component.
     */
    private void campoTextoCveGeneroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoCveGeneroKeyPressed
        if (campoTextoCveGenero.getText().length() > 7) {
            campoTextoCveGenero.setText(campoTextoCveGenero.getText().substring(0, 6));
        }
    }//GEN-LAST:event_campoTextoCveGeneroKeyPressed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se
     * pueden introducir, ya que en la base de datos tienen un rango especifico.
     * Aqui la clave solo puede ser de maximo 11 caracteres.
     *
     * @param evt Action event for this Java Component.
     */
    private void campoTextoNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoNombreKeyPressed
        if (campoTextoNombre.getText().length() > 20) {
            campoTextoNombre.setText(campoTextoNombre.getText().substring(0, 19));
        }
    }//GEN-LAST:event_campoTextoNombreKeyPressed

    /**
     * Un listener para el comboBox para cuando se seleccione un item de la
     * lista. Al pasar esto, se llenaran los campos con los datos del genero
     * seleccionado.
     *
     * @param evt
     */
    private void comboBoxSelectGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSelectGeneroItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String datosGenero = (String) evt.getItem();
            llenarCampos(datosGenero);

            if (!comando.equalsIgnoreCase(CMD_ELIMINAR)) {
                setEnabledCampos(true);
            }
        }
    }//GEN-LAST:event_comboBoxSelectGeneroItemStateChanged

    private void comboBoxSelectGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelectGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSelectGeneroActionPerformed

    /**
     * Llena los campos de texto desde la string dada.
     *
     * @param datosGenero Los datos del genero compactado.
     */
    private void llenarCampos(String datosGenero) {
        String cveGenero = datosGenero.substring(0, datosGenero.indexOf("/") - 1);
        String nombre = datosGenero.substring(datosGenero.indexOf("/") + 2, datosGenero.lastIndexOf("/") - 1);
        String tipoMedio = datosGenero.substring(datosGenero.lastIndexOf("/") + 2);

        claveAntigua = cveGenero;

        campoTextoCveGenero.setText(cveGenero);
        campoTextoNombre.setText(nombre);
        campoTextoTipoMedio.setText(tipoMedio);
    }

    /**
     * Deshabilita o Habilita los campos de texto para que no se pueda escribir
     * en ellos.
     */
    private void setEnabledCampos(boolean value) {
        campoTextoCveGenero.setEditable(value);
        campoTextoNombre.setEditable(value);
        campoTextoTipoMedio.setEditable(value);
    }

    /**
     *
     * @return
     */
    public String getClaveAntigua() {
        return claveAntigua;
    }

    /**
     *
     * @return
     */
    public String getCveGenero() {
        return campoTextoCveGenero.getText();
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return campoTextoNombre.getText();
    }

    /**
     *
     * @return
     */
    public char getTipoMedio() {
        return campoTextoTipoMedio.getText().charAt(0);
    }

    /**
     *
     * @return
     */
    public String getAccion() {
        return accion;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoTextoCveGenero;
    private javax.swing.JTextField campoTextoNombre;
    private javax.swing.JTextField campoTextoTipoMedio;
    private javax.swing.JComboBox comboBoxSelectGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlabelSeleccionarGenero;
    // End of variables declaration//GEN-END:variables
}
