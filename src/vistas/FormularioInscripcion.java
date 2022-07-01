/*
    FormularioInscripcion
 */
package vistas;

import data.*;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo3_LabI
 */
public class FormularioInscripcion extends javax.swing.JInternalFrame {

    private final ArrayList<Inscripcion> listaInscripcion;
    private final ArrayList<Materia> listaMaterias;
    private final InscripcionData cursadaData;
    private final MateriaData materiaData;
    private ArrayList<Alumno> listaAlumnos;
    private final AlumnoData alumnoData;
    private final DefaultTableModel modelo;

    /**
     * Crea nuevo FormularioInscripcion
     */
    public FormularioInscripcion(Conexion conexion) {
        initComponents();

        alumnoData = new AlumnoData(conexion);
        listaAlumnos = (ArrayList<Alumno>) alumnoData.obtenerAlumnos();
        cargaAlumnos();
        modelo = new DefaultTableModel();
        armaCabeceraTabla();

        cursadaData = new InscripcionData(conexion);

        listaInscripcion = (ArrayList) cursadaData.obtenerInscripciones();

        materiaData = new MateriaData(conexion);
        listaMaterias = (ArrayList) materiaData.obtenerMateria();

        listaAlumnos = (ArrayList) alumnoData.obtenerAlumnos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tMaterias = new javax.swing.JTable();
        rbInscriptas = new javax.swing.JRadioButton();
        rbNoInscriptas = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btInscribir = new javax.swing.JButton();
        btAnular = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("FORMULARIO DE INSCRIPCION");

        cbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnosActionPerformed(evt);
            }
        });

        jLabel2.setText("ALUMNO");

        tMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tMaterias);

        rbInscriptas.setText("Inscriptas");
        rbInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInscriptasActionPerformed(evt);
            }
        });

        rbNoInscriptas.setText("No Inscriptas");
        rbNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoInscriptasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("LISTADO DE MATERIAS");

        btInscribir.setText("Inscribir");
        btInscribir.setEnabled(false);
        btInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInscribirActionPerformed(evt);
            }
        });

        btAnular.setText("Anular Inscripción");
        btAnular.setEnabled(false);
        btAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnularActionPerformed(evt);
            }
        });

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(rbInscriptas)
                                .addGap(18, 18, 18)
                                .addComponent(rbNoInscriptas)
                                .addGap(106, 106, 106)))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(125, 125, 125))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btInscribir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbInscriptas)
                    .addComponent(rbNoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInscribir)
                    .addComponent(btAnular)
                    .addComponent(btSalir))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInscriptasActionPerformed
        // TODO add your handling code here:
        rbNoInscriptas.setSelected(false);
        cargaDatosInscriptas();
        btAnular.setEnabled(true);
        btInscribir.setEnabled(false);
    }//GEN-LAST:event_rbInscriptasActionPerformed

    private void rbNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoInscriptasActionPerformed
        // TODO add your handling code here:

        rbInscriptas.setSelected(false);
        cargaDatosNoInscriptas();
        btAnular.setEnabled(false);
        btInscribir.setEnabled(true);
    }//GEN-LAST:event_rbNoInscriptasActionPerformed

    private void btInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInscribirActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada = tMaterias.getSelectedRow();

        if (filaSeleccionada != -1) {

            Alumno a = (Alumno) cbAlumnos.getSelectedItem();

            int idMateria = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            String nombreMateria = (String) modelo.getValueAt(filaSeleccionada, 1);
            int año = (Integer) modelo.getValueAt(filaSeleccionada, 2);
            Materia m = new Materia(idMateria, nombreMateria, año, true);

            Inscripcion c = new Inscripcion(m, a, 0);

            cursadaData.agregarInscripcion(c);

            borraFilasTabla();
            cargaDatosNoInscriptas();
        }
    }//GEN-LAST:event_btInscribirActionPerformed

    private void btAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnularActionPerformed
        // TODO add your handling code here:

        int filaSeleccionada = tMaterias.getSelectedRow();
        if (filaSeleccionada != -1) {

            Alumno a = (Alumno) cbAlumnos.getSelectedItem();

            int idMateria = (Integer) modelo.getValueAt(filaSeleccionada, 0);

            cursadaData.eliminarInscripcion(a.getIdAlumno(), idMateria);
            borraFilasTabla();
            cargaDatosInscriptas();
        }

    }//GEN-LAST:event_btAnularActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void cbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnosActionPerformed
        // TODO add your handling code here:
        borraFilasTabla();
    }//GEN-LAST:event_cbAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnular;
    private javax.swing.JButton btInscribir;
    private javax.swing.JButton btSalir;
    private javax.swing.JComboBox<Alumno> cbAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbInscriptas;
    private javax.swing.JRadioButton rbNoInscriptas;
    private javax.swing.JTable tMaterias;
    // End of variables declaration//GEN-END:variables
  private void cargaDatosNoInscriptas() {

        borraFilasTabla();
        //Llenar filas

        Alumno seleccionado = (Alumno) cbAlumnos.getSelectedItem();

        ArrayList<Materia> lista = (ArrayList) cursadaData.materiasNoIncriptoAlumno(seleccionado);

        for (Materia m : lista) {

            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getYear()});

        }

    }

    private void cargaDatosInscriptas() {

        borraFilasTabla();
        //Llenar filas

        Alumno seleccionado = (Alumno) cbAlumnos.getSelectedItem();

        ArrayList<Materia> lista = (ArrayList) cursadaData.materiasInscriptoAlumno(seleccionado);

        for (Materia m : lista) {

            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getYear()});
        }
    }

    private void armaCabeceraTabla() {

        //Titulos de Columnas
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Nombre");
        columnas.add("Año");
        for (Object it : columnas) {

            modelo.addColumn(it);
        }
        tMaterias.setModel(modelo);
    }

    private void borraFilasTabla() {
        if (modelo != null) {
            int a = modelo.getRowCount() - 1;

            for (int i = a; i >= 0; i--) {

                modelo.removeRow(i);
            }
        }
    }

    private void cargaAlumnos() {
        //Carga las materias al ComboBox
        Collections.sort(listaAlumnos, new Comparator<Alumno>() {
            @Override
            public int compare(Alumno t, Alumno t1) {
                return t.getApellido().compareTo(t1.getApellido());
            }
        });
        for (Alumno item : listaAlumnos) {
            cbAlumnos.addItem(item);
        }

    }

}
