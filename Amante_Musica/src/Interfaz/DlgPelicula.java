/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author 133739 - 116462
 */
import Fachadas.IFachada;
import Tablas.Genero;
import Tablas.Pelicula;
import java.awt.event.ItemEvent;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author javier
 */
public class DlgPelicula extends javax.swing.JDialog {

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
    //La clave antigua de la cancion que se quiere actualizar.
    private String claveAntigua;
    //La fachada conectada a la base de datos.
    private IFachada fachada;

    /**
     *
     * @param parent
     * @param modal
     * @param comando
     * @param fachada
     */
    public DlgPelicula(java.awt.Frame parent, boolean modal, String comando, IFachada fachada) {
        super(parent, modal);

        this.comando = comando;
        this.fachada = fachada;

        initComponents();
        setLocationRelativeTo(null);

        //Construimos el comboBox de generos.
        construirComboBoxGenero();

        //Verificamos el comando.
        verificarComando();
        //Mostramos el dialogo.
        setVisible(true);
    }

    /**
     *
     * @return
     */
    public String getClaveGenero() {
        String clave = String.valueOf(comboBoxGenero.getSelectedItem());
        clave = clave.substring(0, clave.indexOf("/") - 1);

        return clave;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxSeleccionarPelicula = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        comboBoxGenero = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        campoTextoTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoTextoAutor = new javax.swing.JTextField();
        campoTextoAutor1 = new javax.swing.JTextField();
        campoTextoDirector = new javax.swing.JTextField();
        campoTextoDuracion = new javax.swing.JTextField();
        campoTextoFecha = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jlabelSeleccionarPelicula = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboBoxSeleccionarPelicula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSeleccionarPeliculaItemStateChanged(evt);
            }
        });
        comboBoxSeleccionarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSeleccionarPeliculaActionPerformed(evt);
            }
        });

        jLabel1.setText("Clave");

        jLabel2.setText("cveGenero");

        campoTextoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoClaveActionPerformed(evt);
            }
        });

        comboBoxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGeneroActionPerformed(evt);
            }
        });

        jLabel3.setText("Titulo");

        campoTextoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoTituloActionPerformed(evt);
            }
        });

        jLabel4.setText("Director");

        jLabel5.setText("Autor 1");

        jLabel6.setText("Autor 2");

        jLabel7.setText("Duracion");

        jLabel8.setText("Fecha");

        campoTextoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoAutorActionPerformed(evt);
            }
        });

        campoTextoAutor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoAutor1ActionPerformed(evt);
            }
        });

        campoTextoDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoDirectorActionPerformed(evt);
            }
        });

        campoTextoDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoDuracionActionPerformed(evt);
            }
        });

        campoTextoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoFechaActionPerformed(evt);
            }
        });

        botonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/accept.png"))); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/delete.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxSeleccionarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelSeleccionarPelicula))
                        .addGap(311, 311, 311))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoTextoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAceptar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(campoTextoAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoTextoDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoTextoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(campoTextoDuracion))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCancelar)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelSeleccionarPelicula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSeleccionarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(campoTextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(campoTextoDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoTextoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoTextoAutor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoTextoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonAceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSeleccionarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSeleccionarPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSeleccionarPeliculaActionPerformed

    private void campoTextoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoClaveActionPerformed

    private void campoTextoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoTituloActionPerformed

    private void campoTextoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoAutorActionPerformed

    private void campoTextoDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoDuracionActionPerformed

    private void campoTextoDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoDirectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoDirectorActionPerformed

    private void campoTextoAutor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoAutor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoAutor1ActionPerformed

    private void campoTextoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoFechaActionPerformed

    private void comboBoxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxGeneroActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if (!campoTextoAutor1.getText().isEmpty() && !campoTextoTitulo.getText().isEmpty() && !campoTextoDirector.getText().isEmpty() && !campoTextoFecha.getText().isEmpty()
                && !campoTextoClave.getText().isEmpty() && !campoTextoAutor.getText().isEmpty() && !campoTextoAutor.getText().isEmpty()
                && !campoTextoDuracion.getText().isEmpty() && comboBoxGenero.getSelectedItem() != null) {
            accion = A_ACEPTAR;
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Uno de los campos esta vacios.");
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        accion = A_CANCELAR;
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void comboBoxSeleccionarPeliculaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSeleccionarPeliculaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String datosPelicula = (String) evt.getItem();
            llenarCampos(datosPelicula);

            if (!comando.equalsIgnoreCase(CMD_ELIMINAR)) {
                setEnabledCampos(true);
            }
        }

    }//GEN-LAST:event_comboBoxSeleccionarPeliculaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoTextoAutor;
    private javax.swing.JTextField campoTextoAutor1;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoDirector;
    private javax.swing.JTextField campoTextoDuracion;
    private javax.swing.JTextField campoTextoFecha;
    private javax.swing.JTextField campoTextoTitulo;
    private javax.swing.JComboBox<String> comboBoxGenero;
    private javax.swing.JComboBox<String> comboBoxSeleccionarPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jlabelSeleccionarPelicula;
    // End of variables declaration//GEN-END:variables

    private void construirComboBoxPelicula() {
        try {
            //Obtenemos la lista de generos disponibles.
            Vector listaPelicula = fachada.consultaPeliculas();

            //Convertimos a string los generos.
            Vector peliculas = new Vector();

            for (int i = 0; i < listaPelicula.size(); i++) {

                Pelicula pelicula = (Pelicula) listaPelicula.get(i);

                String clave = pelicula.getClave();
                String titulo = pelicula.getTitulo();

                String añadir = clave + " / " + titulo;
                peliculas.add(añadir);
            }

            //Agregamos los generos al comboBox.
            ComboBoxModel model = new DefaultComboBoxModel(peliculas);

            comboBoxSeleccionarPelicula.setModel(model);
            comboBoxSeleccionarPelicula.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error obteniendo los generos.");
            e.printStackTrace();

            accion = A_CANCELAR;
            dispose();
        }
    }

    private void verificarComando() {
        String textoBoton = "";

        if (comando.equalsIgnoreCase(CMD_AGREGAR)) {
            comboBoxSeleccionarPelicula.setEnabled(false);
            jlabelSeleccionarPelicula.setText("..");

            textoBoton = "Agregar";
        } //En estos casos, se deshabilitaran los campos hasta que se haya
        //seleccionado la cancion que se quiere tratar.
        else if (comando.equalsIgnoreCase(CMD_ELIMINAR)) {
            textoBoton = "Eliminar";
            jlabelSeleccionarPelicula.setText("Seleccione la cancion que desea eliminar.");

            //Si se va a eliminar algo, vamos a deshabilitar los campos de texto
            //y cambiar el texto del boton a lo que se deba cambiar.
            setEnabledCampos(false);

            //Llenamos el comboBox con todos las canciones que se hayan creado anteriormente.
            construirComboBoxPelicula();
        } else if (comando.equalsIgnoreCase(CMD_ACTUALIZAR)) {
            textoBoton = "Actualizar";
            jlabelSeleccionarPelicula.setText("Seleccione la cancion que desea actualizar.");

            setEnabledCampos(false);
            construirComboBoxPelicula();
        }

        botonAceptar.setText(textoBoton);
    }

    private void setEnabledCampos(boolean value) {
        campoTextoTitulo.setEnabled(value);
        campoTextoDirector.setEnabled(value);
        campoTextoFecha.setEnabled(value);
        campoTextoDuracion.setEnabled(value);
        campoTextoClave.setEnabled(value);
        campoTextoAutor.setEnabled(value);
        campoTextoAutor1.setEnabled(value);
        comboBoxGenero.setEnabled(value);
    }

    private void llenarCampos(String datosPelicula) {
        try {
            Pelicula peliculaTemporal = new Pelicula(datosPelicula.substring(0, datosPelicula.indexOf("/") - 1));
            Pelicula pelicula = fachada.obten(peliculaTemporal);

            claveAntigua = peliculaTemporal.getClave();

            campoTextoClave.setText(pelicula.getClave());
            campoTextoTitulo.setText(pelicula.getTitulo());
            campoTextoDirector.setText(pelicula.getDirector());
            campoTextoFecha.setText(pelicula.getFecha().toString());
            campoTextoDuracion.setText(String.valueOf(pelicula.getDuracion()));
            campoTextoAutor.setText(pelicula.getAutor1());
            campoTextoAutor1.setText(pelicula.getAutor2());

            for (int i = 0; i < comboBoxGenero.getItemCount(); i++) {
                String claveGenero = (String) comboBoxGenero.getItemAt(i);
                claveGenero = claveGenero.substring(0, claveGenero.indexOf("/") - 1);

                if (pelicula.getGenero().getCveGenero().equalsIgnoreCase(claveGenero)) {
                    comboBoxGenero.setSelectedIndex(i);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hubo un error actualizando." + e.getMessage());
            accion = A_CANCELAR;
            dispose();
        }
    }

    private void construirComboBoxGenero() {
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

            comboBoxGenero.setModel(model);
            comboBoxGenero.setSelectedIndex(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error obteniendo los generos.");
            e.printStackTrace();

            accion = A_CANCELAR;
            dispose();
        }
    }

    /**
     *
     * @return
     */
    public String getAccion() {
        return accion;
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
    public String getFecha() {
        return campoTextoFecha.getText();
    }

    /**
     *
     * @return
     */
    public String getClave() {
        return campoTextoClave.getText();
    }

    /**
     *
     * @return
     */
    public String getAutor1() {
        return campoTextoAutor.getText();
    }

    /**
     *
     * @return
     */
    public String getAutor2() {
        return campoTextoAutor1.getText();
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return campoTextoTitulo.getText();
    }

    /**
     *
     * @return
     */
    public String getDirector() {
        return campoTextoDirector.getText();
    }

    /**
     *
     * @return
     */
    public String getDuracion() {
        return campoTextoDuracion.getText();
    }

}
