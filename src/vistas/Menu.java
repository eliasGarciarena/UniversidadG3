/*
    Menu
 */
package vistas;

import data.AlumnoData;
import data.Conexion;

/**
 *
 * @author Grupo3_LabI
 */
public class Menu extends javax.swing.JFrame {

    private final Conexion conn = new Conexion();;
    private final AlumnoData alumnoData = new AlumnoData(conn);

    /**
     * Crea nuevo Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jcargarNotas = new javax.swing.JMenu();
        jMnCargarNotas = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItemMostrarAlumnos = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        escritorio.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(526, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jMenu5.setText("Archivo");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Salir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Materias");

        jMenuItem2.setText("Formulario de Materia");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Alumnos");

        jMenuItem5.setText("Formulario de Alumno");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Inscripciones");

        jMenuItem3.setText("Gestionar Inscripcion");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuBar1.add(jMenu6);

        jcargarNotas.setText("Carga de Notas");

        jMnCargarNotas.setText("Manipulacion de Notas");
        jMnCargarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnCargarNotasActionPerformed(evt);
            }
        });
        jcargarNotas.add(jMnCargarNotas);

        jMenuBar1.add(jcargarNotas);

        jMenu8.setText("Consultas");

        jMenuItemMostrarAlumnos.setText("Listar Alumnos por Materia");
        jMenuItemMostrarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarAlumnosActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemMostrarAlumnos);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMnCargarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnCargarNotasActionPerformed
        escritorio.removeAll();
        CargarNotas car = new CargarNotas(conn);
        car.setVisible(true);
        escritorio.add(car);
        escritorio.repaint();
        escritorio.moveToFront(car);
    }//GEN-LAST:event_jMnCargarNotasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
        //Borra todo el contenido del canvas
        escritorio.removeAll();
        //Crea nueva vista FormularioMaterias, la muestra y la trae al frente
        FormularioMaterias fm = new FormularioMaterias(conn);
        fm.setVisible(true);
        escritorio.add(fm);
        escritorio.repaint();
        escritorio.moveToFront(fm);

    }// GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
        //Borra todo el contenido del canvas
        escritorio.removeAll();
        //Crea nueva vista FormularioInscripcion, la muestra y la trae al frente
        FormularioInscripcion fm = new FormularioInscripcion(conn);
        fm.setVisible(true);
        escritorio.add(fm);
        escritorio.repaint();
        escritorio.moveToFront(fm);
    }// GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        dispose();
        System.out.println("Hizo clic");
    }// GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();

        FormularioAlumno fa = new FormularioAlumno(conn);
        fa.setVisible(true);
        escritorio.add(fa);
        escritorio.repaint();
        escritorio.moveToFront(fa);
    }// GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemMostrarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmenuItemMostrarAlumnosActionPerformed
        //Obtiene todos los alumnos
        AlumnosXMateria mostrarAlumnosView = new AlumnosXMateria(conn);
        //Borra todo el contenido del canvas
        escritorio.removeAll();
        //Crea nueva vista MostrarAlumnos, la 
        mostrarAlumnosView.setVisible(true);
        escritorio.add(mostrarAlumnosView);
        escritorio.repaint();
        escritorio.moveToFront(mostrarAlumnosView);
    }// GEN-LAST:event_jmenuItemMostrarAlumnosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItemMostrarAlumnos;
    private javax.swing.JMenuItem jMnCargarNotas;
    private javax.swing.JMenu jcargarNotas;
    // End of variables declaration//GEN-END:variables
}
