/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Control.Control;
import Control.ModeloTabla;
import javax.swing.UIManager;

/**
 *
 * @author 133739 - 116462
 */
public class FrmAmanteMusica extends javax.swing.JFrame {

    /**
     *
     */
    public FrmAmanteMusica() {
        initComponents();
        centrarVentana();

        //Verificando la conexion a la base de datos.
        Control.crearConexion();

        //Generando la tabla de canciones.
        ModeloTabla mt = Control.getTablaCanciones();

        tablaDatos.setModel(mt.getModelo());
        tituloTabla.setText(mt.getTitulo());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        tituloTabla = new javax.swing.JLabel();
        botonCerrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuCancionesBotonAñadir = new javax.swing.JMenuItem();
        menuCancionesBotonActualizar = new javax.swing.JMenuItem();
        menuCancionesBotonEliminar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuPeliculasBotonAgregar = new javax.swing.JMenuItem();
        menuPeliculasBotonActualizar = new javax.swing.JMenuItem();
        menuPeliculasBotonEliminar = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuGenerosBotonAgregar = new javax.swing.JMenuItem();
        menuGenerosActualizar = new javax.swing.JMenuItem();
        menuGenerosBotonEliminar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuConsultarBotonPeliculas = new javax.swing.JMenuItem();
        menuConsultarBotonCanciones = new javax.swing.JMenuItem();
        menuConsultarBotonGeneros = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Amante de Musica ");

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "opcion ", "opcion 1 ", "opcion 2", "opcion 3"
            }
        ));
        tablaDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaDatos.setEnabled(false);
        tablaDatos.setGridColor(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tablaDatos);

        tituloTabla.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tituloTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/process.png"))); // NOI18N
        tituloTabla.setText("Tabla");

        botonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/info.png"))); // NOI18N
        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        jMenu1.setText("Catalago");

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/add.png"))); // NOI18N
        jMenu3.setText("Canciones");

        menuCancionesBotonAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/accept.png"))); // NOI18N
        menuCancionesBotonAñadir.setText("Agregar");
        menuCancionesBotonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCancionesBotonAñadirActionPerformed(evt);
            }
        });
        jMenu3.add(menuCancionesBotonAñadir);

        menuCancionesBotonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/refresh.png"))); // NOI18N
        menuCancionesBotonActualizar.setText("Actualizar..");
        menuCancionesBotonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCancionesBotonActualizarActionPerformed(evt);
            }
        });
        jMenu3.add(menuCancionesBotonActualizar);

        menuCancionesBotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/delete.png"))); // NOI18N
        menuCancionesBotonEliminar.setText("Eliminar..");
        menuCancionesBotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCancionesBotonEliminarActionPerformed(evt);
            }
        });
        jMenu3.add(menuCancionesBotonEliminar);

        jMenu1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/add.png"))); // NOI18N
        jMenu4.setText("Peliculas");

        menuPeliculasBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/accept.png"))); // NOI18N
        menuPeliculasBotonAgregar.setText("Agregar..");
        menuPeliculasBotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPeliculasBotonAgregarActionPerformed(evt);
            }
        });
        jMenu4.add(menuPeliculasBotonAgregar);

        menuPeliculasBotonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/refresh.png"))); // NOI18N
        menuPeliculasBotonActualizar.setText("Actualizar..");
        menuPeliculasBotonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPeliculasBotonActualizarActionPerformed(evt);
            }
        });
        jMenu4.add(menuPeliculasBotonActualizar);

        menuPeliculasBotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/delete.png"))); // NOI18N
        menuPeliculasBotonEliminar.setText("Eliminar..");
        menuPeliculasBotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPeliculasBotonEliminarActionPerformed(evt);
            }
        });
        jMenu4.add(menuPeliculasBotonEliminar);

        jMenu1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/add.png"))); // NOI18N
        jMenu5.setText("Generos");

        menuGenerosBotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/accept.png"))); // NOI18N
        menuGenerosBotonAgregar.setText("Agregar..");
        menuGenerosBotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGenerosBotonAgregarActionPerformed(evt);
            }
        });
        jMenu5.add(menuGenerosBotonAgregar);

        menuGenerosActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/refresh.png"))); // NOI18N
        menuGenerosActualizar.setText("Actualizar..");
        menuGenerosActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGenerosActualizarActionPerformed(evt);
            }
        });
        jMenu5.add(menuGenerosActualizar);

        menuGenerosBotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/delete.png"))); // NOI18N
        menuGenerosBotonEliminar.setText("Eliminar..");
        menuGenerosBotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGenerosBotonEliminarActionPerformed(evt);
            }
        });
        jMenu5.add(menuGenerosBotonEliminar);

        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");

        menuConsultarBotonPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/next.png"))); // NOI18N
        menuConsultarBotonPeliculas.setText("Peliculas");
        menuConsultarBotonPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarBotonPeliculasActionPerformed(evt);
            }
        });
        jMenu2.add(menuConsultarBotonPeliculas);

        menuConsultarBotonCanciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/next.png"))); // NOI18N
        menuConsultarBotonCanciones.setText("Canciones");
        menuConsultarBotonCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarBotonCancionesActionPerformed(evt);
            }
        });
        jMenu2.add(menuConsultarBotonCanciones);

        menuConsultarBotonGeneros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diseñosmedio/next.png"))); // NOI18N
        menuConsultarBotonGeneros.setText("Generos");
        menuConsultarBotonGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarBotonGenerosActionPerformed(evt);
            }
        });
        jMenu2.add(menuConsultarBotonGeneros);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tituloTabla)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(botonCerrar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuCancionesBotonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCancionesBotonAñadirActionPerformed
        Control.agregarCancion();
        menuConsultarBotonCancionesActionPerformed(evt);
    }//GEN-LAST:event_menuCancionesBotonAñadirActionPerformed

    private void menuGenerosBotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGenerosBotonAgregarActionPerformed
        Control.agregarGenero();
        menuConsultarBotonGenerosActionPerformed(evt);
    }//GEN-LAST:event_menuGenerosBotonAgregarActionPerformed

    private void menuGenerosBotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGenerosBotonEliminarActionPerformed
        Control.eliminarGenero();
        menuConsultarBotonGenerosActionPerformed(evt);
    }//GEN-LAST:event_menuGenerosBotonEliminarActionPerformed

    private void menuGenerosActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGenerosActualizarActionPerformed
        Control.actualizarGenero();
        menuConsultarBotonGenerosActionPerformed(evt);
    }//GEN-LAST:event_menuGenerosActualizarActionPerformed

    private void menuCancionesBotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCancionesBotonActualizarActionPerformed
        Control.actualizarCancion();
        menuConsultarBotonCancionesActionPerformed(evt);
    }//GEN-LAST:event_menuCancionesBotonActualizarActionPerformed

    private void menuCancionesBotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCancionesBotonEliminarActionPerformed
        Control.eliminarCancion();
        menuConsultarBotonCancionesActionPerformed(evt);
    }//GEN-LAST:event_menuCancionesBotonEliminarActionPerformed

    private void menuConsultarBotonGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarBotonGenerosActionPerformed
        ModeloTabla mt = Control.getTablaGeneros();

        tablaDatos.setModel(mt.getModelo());
        tituloTabla.setText(mt.getTitulo());
    }//GEN-LAST:event_menuConsultarBotonGenerosActionPerformed

    private void menuConsultarBotonCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarBotonCancionesActionPerformed
        ModeloTabla mt = Control.getTablaCanciones();

        tablaDatos.setModel(mt.getModelo());
        tituloTabla.setText(mt.getTitulo());
    }//GEN-LAST:event_menuConsultarBotonCancionesActionPerformed

    private void menuPeliculasBotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPeliculasBotonAgregarActionPerformed
        // TODO add your handling code here:
        Control.agregarPelicula();
        menuConsultarBotonPeliculasActionPerformed(evt);
    }//GEN-LAST:event_menuPeliculasBotonAgregarActionPerformed

    private void menuConsultarBotonPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarBotonPeliculasActionPerformed
        // TODO add your handling code here:
        ModeloTabla mt = Control.getTablaPeliculas();

        tablaDatos.setModel(mt.getModelo());
        tituloTabla.setText(mt.getTitulo());
    }//GEN-LAST:event_menuConsultarBotonPeliculasActionPerformed

    private void menuPeliculasBotonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPeliculasBotonActualizarActionPerformed
        // TODO add your handling code here:
        Control.actualizarPeliculas();
        menuConsultarBotonPeliculasActionPerformed(evt);
    }//GEN-LAST:event_menuPeliculasBotonActualizarActionPerformed

    private void menuPeliculasBotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPeliculasBotonEliminarActionPerformed
        // TODO add your handling code here:
        Control.eliminarPelicula();
        menuConsultarBotonPeliculasActionPerformed(evt);
    }//GEN-LAST:event_menuPeliculasBotonEliminarActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_botonCerrarActionPerformed

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAmanteMusica().setVisible(true);
            }
        });
    }

    private void centrarVentana() {
        setLocationRelativeTo(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuCancionesBotonActualizar;
    private javax.swing.JMenuItem menuCancionesBotonAñadir;
    private javax.swing.JMenuItem menuCancionesBotonEliminar;
    private javax.swing.JMenuItem menuConsultarBotonCanciones;
    private javax.swing.JMenuItem menuConsultarBotonGeneros;
    private javax.swing.JMenuItem menuConsultarBotonPeliculas;
    private javax.swing.JMenuItem menuGenerosActualizar;
    private javax.swing.JMenuItem menuGenerosBotonAgregar;
    private javax.swing.JMenuItem menuGenerosBotonEliminar;
    private javax.swing.JMenuItem menuPeliculasBotonActualizar;
    private javax.swing.JMenuItem menuPeliculasBotonAgregar;
    private javax.swing.JMenuItem menuPeliculasBotonEliminar;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JLabel tituloTabla;
    // End of variables declaration//GEN-END:variables
}
