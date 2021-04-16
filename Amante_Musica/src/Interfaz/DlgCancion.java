
package Interfaz;

import Fachadas.IFachada;
import static Interfaz.DlgGenero.CMD_ELIMINAR;
import Tablas.Cancion;
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
public class DlgCancion extends javax.swing.JDialog {
    
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
    public DlgCancion(java.awt.Frame parent, boolean modal, String comando, IFachada fachada) {
        super(parent, modal);
        
        this.comando = comando;
        this.fachada = fachada;
        
        initComponents();
        setLocationRelativeTo(null);
        
        //Construimos el comboBox de generos.
        construirComboBoxGeneros();
        
        //Verificamos el comando.
        verificarComando();
        //Mostramos el dialogo.
        setVisible(true);
    }
    
    /**
     * Construimos el ComboBox que contendra todos los generos que estan disponibles dentro
     * de la base de datos.
     * 
     * @param fachada La fachada que se utilizara para obtener datos de la base de datos.
     */
    private void construirComboBoxGeneros(){
        try{
            //Obtenemos la lista de generos disponibles.
            Vector listaGeneros = fachada.consultaGeneros();
            
            //Convertimos a string los generos.
            Vector generos = new Vector();
            
            for(int i = 0; i < listaGeneros.size(); i++){
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
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error obteniendo los generos.");
            e.printStackTrace();
            
            accion = A_CANCELAR;
            dispose();
        }
    }
    /**
     * Crea la lista de canciones a escojerse.
     * 
     * @param fachada La conexion hacia la base de datos.
     */
    private void construirComboBoxCanciones(IFachada fachada){
        try{
            //Obtenemos la lista de generos disponibles.
            Vector listaCanciones = fachada.consultaCanciones();
            
            //Convertimos a string las canciones.
            Vector canciones = new Vector();
            
            for(int i = 0; i < listaCanciones.size(); i++){
                Cancion cancion = (Cancion) listaCanciones.get(i);
                
                String clave = cancion.getClave();
                String titulo = cancion.getTitulo();
                
                String añadir = clave + " / " + titulo;
                canciones.add(añadir);
            }
            
            //Agregamos las canciones al comboBox.
            ComboBoxModel model = new DefaultComboBoxModel(canciones);
            
            //Le ponemos el modelo a este comboBox.
            comboBoxSeleccionarCancion.setModel(model);
            comboBoxSeleccionarCancion.setSelectedIndex(-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error obteniendo las canciones.");
            e.printStackTrace();
            
            accion = A_CANCELAR;
            dispose();
        }
    }
    /**
     * Llena los campos de texto con los datos de la cancion.
     * @param genero 
     */
    private void verificarComando(){
        String textoBoton = "";
        
        if(comando.equalsIgnoreCase(CMD_AGREGAR)){
            comboBoxSeleccionarCancion.setEnabled(false);
            jlabelSeleccionarCancion.setText("..");
            
            textoBoton = "Agregar";
        }
        //En estos casos, se deshabilitaran los campos hasta que se haya
        //seleccionado la cancion que se quiere tratar.
        else if(comando.equalsIgnoreCase(CMD_ELIMINAR)){
            textoBoton = "Eliminar";
            jlabelSeleccionarCancion.setText("Seleccione la cancion que desea eliminar.");
            
            //Si se va a eliminar algo, vamos a deshabilitar los campos de texto
            //y cambiar el texto del boton a lo que se deba cambiar.
            setEnabledCampos(false);
            
            //Llenamos el comboBox con todos las canciones que se hayan creado anteriormente.
            construirComboBoxCanciones(fachada);
        }
        else if(comando.equalsIgnoreCase(CMD_ACTUALIZAR)){
            textoBoton = "Actualizar";
            jlabelSeleccionarCancion.setText("Seleccione la cancion que desea actualizar.");
            
            setEnabledCampos(false);
            construirComboBoxCanciones(fachada);
        }
        
        botonAceptar.setText(textoBoton);
    }
    
    /**
     * Llena los textBox con los datos de la cancion.
     * @param cancion La cancion donde se obtendran los datos a llenar.
     */
    private void llenarCampos(String datosCancion){
        try{
            Cancion cancionTemporal = new Cancion(datosCancion.substring(0, datosCancion.indexOf("/")-1));
            Cancion cancion = fachada.obten(cancionTemporal);
            
            claveAntigua = cancionTemporal.getClave();
            
            campoTextoClave.setText(cancion.getClave());
            campoTextoTitulo.setText(cancion.getTitulo());
            campoTextoInterprete.setText(cancion.getInterprete());
            campoTextoFecha.setText(cancion.getFecha().toString());
            campoTextoDuracion.setText(String.valueOf(cancion.getDuracion()));
            campoTextoAutor.setText(cancion.getAutor());
            campoTextoAlbum.setText(cancion.getAlbum());
            
            for(int i = 0; i < comboBoxGenero.getItemCount(); i++){
                String claveGenero = (String) comboBoxGenero.getItemAt(i);
                claveGenero = claveGenero.substring(0, claveGenero.indexOf("/") -1);
                
                if(cancion.getGenero().getCveGenero().equalsIgnoreCase(claveGenero)){
                    comboBoxGenero.setSelectedIndex(i);
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hubo un error actualizando." + e.getMessage());
            accion = A_CANCELAR;
            dispose();
        }
    }
    
    /**
     * Deshabilita o Habilita los campos de texto.
     * 
     * @param value Si se quiere habilitar o deshabilitar.
     */
    private void setEnabledCampos(boolean value){
        campoTextoTitulo.setEnabled(value);
        campoTextoInterprete.setEnabled(value);
        campoTextoFecha.setEnabled(value);
        campoTextoDuracion.setEnabled(value);
        campoTextoClave.setEnabled(value);
        campoTextoAutor.setEnabled(value);
        campoTextoAlbum.setEnabled(value);
        comboBoxGenero.setEnabled(value);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoTextoTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxGenero = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        campoTextoInterprete = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoTextoAutor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoTextoAlbum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoTextoDuracion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoTextoFecha = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        campoTextoClave = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jlabelSeleccionarCancion = new javax.swing.JLabel();
        comboBoxSeleccionarCancion = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Titulo");

        campoTextoTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoTituloKeyPressed(evt);
            }
        });

        jLabel2.setText("CveGenero");

        jLabel3.setText("Interpete");

        campoTextoInterprete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoInterpreteKeyPressed(evt);
            }
        });

        jLabel4.setText("Autor");

        campoTextoAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoAutorKeyPressed(evt);
            }
        });

        jLabel5.setText("Album");

        campoTextoAlbum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoAlbumKeyPressed(evt);
            }
        });

        jLabel6.setText("Duracion");

        campoTextoDuracion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTextoDuracionFocusLost(evt);
            }
        });
        campoTextoDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoDuracionKeyPressed(evt);
            }
        });

        jLabel7.setText("Fecha");

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

        jLabel8.setText("Clave");

        campoTextoClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTextoClaveFocusLost(evt);
            }
        });
        campoTextoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoClaveActionPerformed(evt);
            }
        });
        campoTextoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoTextoClaveKeyPressed(evt);
            }
        });

        comboBoxSeleccionarCancion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxSeleccionarCancionItemStateChanged(evt);
            }
        });
        comboBoxSeleccionarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSeleccionarCancionActionPerformed(evt);
            }
        });

        jLabel9.setText("DD/MM/AÑO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoTextoAutor)
                                        .addGap(54, 54, 54))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jlabelSeleccionarCancion)
                                            .addComponent(comboBoxSeleccionarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)))
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoTextoTitulo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTextoInterprete)
                            .addComponent(comboBoxGenero, 0, 150, Short.MAX_VALUE)
                            .addComponent(campoTextoAlbum))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoTextoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(campoTextoFecha))
                                .addGap(113, 113, 113))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel9)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelSeleccionarCancion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSeleccionarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoTextoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoTextoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(campoTextoInterprete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTextoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(campoTextoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoTextoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if(!campoTextoTitulo.getText().isEmpty() && !campoTextoInterprete.getText().isEmpty() && !campoTextoFecha.getText().isEmpty() &&
           !campoTextoClave.getText().isEmpty() && !campoTextoAlbum.getText().isEmpty() && !campoTextoAutor.getText().isEmpty() &&
           !campoTextoDuracion.getText().isEmpty() && comboBoxGenero.getSelectedItem() != null){
            accion = A_ACEPTAR;
            dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Uno de los campos esta vacios.");
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        accion = A_CANCELAR;
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se pueden introducir, 
     * ya que en la base de datos tienen un rango especifico. Aqui la clave solo puede ser de
     * maximo 11 caracteres.
     * 
     * @param evt Action event for this Java Component.
     */
    private void campoTextoClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoClaveKeyPressed
        String clave = campoTextoClave.getText();
        clave = clave.replaceAll("\\D+", "");
        
        if(clave.length() > 11){
            clave = clave.substring(0, 10);
            campoTextoClave.setText(clave);
        }
    }//GEN-LAST:event_campoTextoClaveKeyPressed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se pueden introducir, 
     * ya que en la base de datos tienen un rango especifico. Aqui la clave solo puede ser de
     * maximo 11 caracteres.
     * 
     * @param evt Action event for this Java Component.
     */
    private void campoTextoTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoTituloKeyPressed
        String titulo = campoTextoTitulo.getText();
        
        if(titulo.length() > 35){
            titulo = titulo.substring(0, 34);
            campoTextoTitulo.setText(titulo);
        }
    }//GEN-LAST:event_campoTextoTituloKeyPressed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se pueden introducir, 
     * ya que en la base de datos tienen un rango especifico. Aqui la clave solo puede ser de
     * maximo 11 caracteres.
     * 
     * @param evt Action event for this Java Component.
     */
    private void campoTextoInterpreteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoInterpreteKeyPressed
        String interprete = campoTextoInterprete.getText();
        
        if(interprete.length() > 35){
            interprete = interprete.substring(0, 34);
            campoTextoInterprete.setText(interprete);
        }
    }//GEN-LAST:event_campoTextoInterpreteKeyPressed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se pueden introducir, 
     * ya que en la base de datos tienen un rango especifico. Aqui la clave solo puede ser de
     * maximo 11 caracteres.
     * 
     * @param evt Action event for this Java Component.
     */
    private void campoTextoAutorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoAutorKeyPressed
        String autor = campoTextoAutor.getText();
        
        if(autor.length() > 35){
            autor = autor.substring(0, 34);
            campoTextoAutor.setText(autor);
        }
    }//GEN-LAST:event_campoTextoAutorKeyPressed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se pueden introducir, 
     * ya que en la base de datos tienen un rango especifico. Aqui la clave solo puede ser de
     * maximo 11 caracteres.
     * 
     * @param evt Action event for this Java Component.
     */
    private void campoTextoAlbumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoAlbumKeyPressed
        String album = campoTextoAlbum.getText();
        
        if(album.length() > 35){
            album = album.substring(0, 34);
            campoTextoAlbum.setText(album);
        }
    }//GEN-LAST:event_campoTextoAlbumKeyPressed
    /**
     * Se usa un listener para el Campo de texto para delimitar los datos que se pueden introducir, 
     * ya que en la base de datos tienen un rango especifico. Aqui la clave solo puede ser de
     * maximo 11 caracteres.
     * 
     * @param evt Action event for this Java Component.
     */
    private void campoTextoDuracionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTextoDuracionKeyPressed
        String duracion = campoTextoDuracion.getText();
        
        if(duracion.length()>11){
            duracion = duracion.substring(0,10);
            campoTextoDuracion.setText(duracion);
        }
    }//GEN-LAST:event_campoTextoDuracionKeyPressed

    /**
     * Se llama cuando el usuario de click afuera de este componente.
     * Al pasar esto se eliminaran el resto de las letras que se hayan quedado dentro
     * del campo de texto.
     * 
     * @param evt 
     */
    private void campoTextoDuracionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTextoDuracionFocusLost
        String duracion = campoTextoDuracion.getText();
        duracion = duracion.replaceAll("\\D+", "");
        campoTextoDuracion.setText(duracion);
    }//GEN-LAST:event_campoTextoDuracionFocusLost

    /**
     * Se llama cuando el usuario de click afuera de este componente.
     * Al pasar esto se eliminaran el resto de las letras que se hayan quedado dentro
     * del campo de texto.
     * 
     * @param evt 
     */
    private void campoTextoClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTextoClaveFocusLost
        String duracion = campoTextoClave.getText();
        duracion = duracion.replaceAll("\\D+", "");
        campoTextoClave.setText(duracion);
    }//GEN-LAST:event_campoTextoClaveFocusLost
    /**
     * Un listener para el comboBox para cuando se seleccione un item de la lista.
     * Al pasar esto, se llenaran los campos con los datos del genero seleccionado.
     * 
     * @param evt 
     */
    private void comboBoxSeleccionarCancionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxSeleccionarCancionItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String datosCancion = (String) evt.getItem();
            llenarCampos(datosCancion);
            
            if(!comando.equalsIgnoreCase(CMD_ELIMINAR))
                setEnabledCampos(true);
        }
    }//GEN-LAST:event_comboBoxSeleccionarCancionItemStateChanged

    private void campoTextoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTextoClaveActionPerformed

    private void comboBoxSeleccionarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSeleccionarCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSeleccionarCancionActionPerformed

    /**
     * Retorna la clave del genero que se selecciono dentro del comboBox.
     * 
     * @return La clave del genero seleccionado. 
     */
    public String getClaveGenero(){ 
        String clave = String.valueOf(comboBoxGenero.getSelectedItem());
        clave = clave.substring(0, clave.indexOf("/")-1);
        
        return clave;
    }
    
    //Getters

    /**
     *
     * @return
     */
    public String getAccion(){ return accion; }  

    /**
     *
     * @return
     */
    public String getClaveAntigua(){ return claveAntigua; }

    /**
     *
     * @return
     */
    public String getFecha(){ return campoTextoFecha.getText(); }

    /**
     *
     * @return
     */
    public String getClave(){ return campoTextoClave.getText(); }

    /**
     *
     * @return
     */
    public String getAutor(){ return campoTextoAutor.getText(); }

    /**
     *
     * @return
     */
    public String getAlbum(){ return campoTextoAlbum.getText(); }

    /**
     *
     * @return
     */
    public String getTitulo(){ return campoTextoTitulo.getText(); }

    /**
     *
     * @return
     */
    public String getInterprete(){ return campoTextoInterprete.getText(); }

    /**
     *
     * @return
     */
    public String getDuracion(){ return campoTextoDuracion.getText(); }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoTextoAlbum;
    private javax.swing.JTextField campoTextoAutor;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoDuracion;
    private javax.swing.JTextField campoTextoFecha;
    private javax.swing.JTextField campoTextoInterprete;
    private javax.swing.JTextField campoTextoTitulo;
    private javax.swing.JComboBox comboBoxGenero;
    private javax.swing.JComboBox comboBoxSeleccionarCancion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlabelSeleccionarCancion;
    // End of variables declaration//GEN-END:variables
}
