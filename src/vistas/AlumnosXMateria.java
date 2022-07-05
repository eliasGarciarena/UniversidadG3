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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class AlumnosXMateria extends javax.swing.JInternalFrame {
    /**
     * Creates new form AlumnosXMateria
     */
    private final InscripcionData cursadaData;
    private final AlumnoData alumnoData;
    private final MateriaData materiaData;
    private ArrayList<Materia> listaMateria;
    private DefaultTableModel model;
    public AlumnosXMateria(Conexion conexion) {
        initComponents();
        cursadaData =new InscripcionData(conexion);
        alumnoData =new AlumnoData(conexion);
        materiaData=new MateriaData(conexion);
        listaMateria=materiaData.obtenerMateria();
        model=new DefaultTableModel();
        CabeceraTabla();
        cargarMaterias();
        cargarAlumnos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxMaterias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblAlumnosXMateria = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        cbxMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMateriasActionPerformed(evt);
            }
        });

        jtblAlumnosXMateria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblAlumnosXMateria);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Alumnos segùn Materia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel1)))))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMateriasActionPerformed
        // TODO add your handling code here:
        cargarAlumnos();
    }//GEN-LAST:event_cbxMateriasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    private void borraFilasTabla() {
        if (model != null) {
            int a = model.getRowCount() - 1;

            for (int i = a; i >= 0; i--) {

                model.removeRow(i);
            }
        }
    }
    
     private void cargarMaterias() {
        for(Materia item:listaMateria){
            cbxMaterias.addItem(item);
        }
    }
     
         private void cargarAlumnos(){
        borraFilasTabla();
        try{
        Materia selecc = (Materia) cbxMaterias.getSelectedItem();
        ArrayList<Alumno> alumno = (ArrayList) cursadaData.verInscriptosEn(selecc.getIdMateria());
        for (Alumno alum : alumno) {
            model.addRow(new Object[]{alum.getIdAlumno(), alum.getNombre(), alum.getApellido(),alum.getDni(),cursadaData.getNota(alum.getIdAlumno(), selecc.getIdMateria())});
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error al cargar los alumnos en la tabla: "+ex);
        }
    }
        private void CabeceraTabla() {

        //Titulos de Columnas
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Apellido");
        columnas.add("Nombre");
        columnas.add("Dni");
        for (Object it : columnas) {
            model.addColumn(it);
        }
        jtblAlumnosXMateria.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Materia> cbxMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblAlumnosXMateria;
    // End of variables declaration//GEN-END:variables
}
