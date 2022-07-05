/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.AlumnoData;
import data.Conexion;
import data.InscripcionData;
import data.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author william
 */
public class CargarNotas extends javax.swing.JInternalFrame {
    private final DefaultTableModel modelo;
    private final InscripcionData cursadaData;
    private final AlumnoData alumnoData;
    private final MateriaData materiaData;
    private ArrayList<Materia> listaMateria;
    /**
     * Creates new form CargarNotas
     */
    public CargarNotas(Conexion conexion) {
        initComponents();
        alumnoData = new AlumnoData(conexion);
        cursadaData = new InscripcionData(conexion);
        materiaData = new MateriaData(conexion);
        listaMateria = (ArrayList<Materia>) materiaData.obtenerMateria();
        cargarMaterias();
        modelo = new DefaultTableModel();
        CabeceraTabla();
        listaMateria= (ArrayList) materiaData.obtenerMateria();
        btnModNota.setEnabled(false);
        txfNotas.setEnabled(false);
        //if(jtblAlumnos.getSelectedColumn()){
         //   btnModNota.setEnabled(true);
           // txfNotas.setEnabled(true);
        //}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAlumnos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnModNota = new javax.swing.JButton();
        txfNotas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        cbxMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMateriasActionPerformed(evt);
            }
        });

        jtblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblAlumnos);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAlumnos.setText("Buscar");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnModNota.setText("Nota");
        btnModNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModNotaActionPerformed(evt);
            }
        });

        jLabel1.setText("Cargar Notas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAlumnos)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnModNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAlumnos)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModNota)
                    .addComponent(txfNotas))
                .addGap(1, 1, 1)
                .addComponent(btnSalir)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cbxMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMateriasActionPerformed
        // TODO add your handling code here:
        borraFilasTabla();
    }//GEN-LAST:event_cbxMateriasActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        // TODO add your handling code here:
        cargarAlumnos();
            btnModNota.setEnabled(false);
            txfNotas.setEnabled(false);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void jtblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblAlumnosMouseClicked
        // TODO add your handling code here:
        if(jtblAlumnos.getSelectedColumn()>-1){
            btnModNota.setEnabled(true);
            txfNotas.setEnabled(true);
        }
    }//GEN-LAST:event_jtblAlumnosMouseClicked

    private void btnModNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModNotaActionPerformed
        // TODO add your handling code here:
        try{
        int id=(int) (modelo.getValueAt(jtblAlumnos.getSelectedRow(),0));
        Alumno alum=alumnoData.obtenerAlumnoXId(id);
        double nota=(double) Double.parseDouble(txfNotas.getText());
        Materia mat=(Materia)cbxMaterias.getSelectedItem();
        cursadaData.modificarNota(alum, mat, nota);
        cargarAlumnos();
        JOptionPane.showMessageDialog(this, "Nota cargada con exito");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error al Cargar la nota"+ex);
        }
    }//GEN-LAST:event_btnModNotaActionPerformed


     private void CabeceraTabla() {

        //Titulos de Columnas
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Apellido");
        columnas.add("Nombre");
        columnas.add("Dni");
        columnas.add("Nota");
        for (Object it : columnas) {

            modelo.addColumn(it);
        }
        jtblAlumnos.setModel(modelo);
    }
     private void cargarMaterias() {
        for(Materia item:listaMateria){
            cbxMaterias.addItem(item);
        }
    }
    private void borraFilasTabla() {
        if (modelo != null) {
            int a = modelo.getRowCount() - 1;

            for (int i = a; i >= 0; i--) {

                modelo.removeRow(i);
            }
        }
    }
    private void cargarAlumnos(){
        borraFilasTabla();
        try{
        Materia selecc = (Materia) cbxMaterias.getSelectedItem();
        ArrayList<Alumno> alumno = (ArrayList) cursadaData.verInscriptosEn(selecc.getIdMateria());
        for (Alumno alum : alumno) {
            modelo.addRow(new Object[]{alum.getIdAlumno(), alum.getNombre(), alum.getApellido(),alum.getDni(),cursadaData.getNota(alum.getIdAlumno(), selecc.getIdMateria())});
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error al cargar los alumnos en la tabla: "+ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnModNota;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Materia> cbxMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblAlumnos;
    private javax.swing.JTextField txfNotas;
    // End of variables declaration//GEN-END:variables
}
