/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_EntradaJuego;
import java.util.ArrayList;

/**
 *
 * @author Lanfor
 */
public class FRM_EntradaJuego extends javax.swing.JFrame {

    Controlador_FRM_EntradaJuego controlador_FRM_EntradaJuego;
    public FRM_EntradaJuego() {
        initComponents();
        setLocationRelativeTo(this);
        controlador_FRM_EntradaJuego=new Controlador_FRM_EntradaJuego(this);
//        agregarEventos();
    }

//    public  void agregarEventos()
//    {
//        //this.panel_EntradaJuego1.agregarEventos(controlador_FRM_EntradaJuego);
//    }
//    public void cambiarEstadoMusica()
//    {
//        //this.panel_EntradaJuego1.cambiarEstadoMusica();
//    }
//    public String getNivel()
//    {
//        //return this.panel_EntradaJuego1.getNivel();
//    }
//    
//    public int getCampo()
//    {
//        return this.panel_EntradaJuego1.getCampo();
//    }
//    
//    public void reproducirMusica()
//    {
//        this.panel_EntradaJuego1.reproducirMusica();
//    }
//    
//    
//    public void gane(int puntos, int nivel)
//    {
//        this.panel_EntradaJuego1.gane(puntos, nivel);
//    }
//    
//    public void setPuntos(int puntos)
//    {
//        panel_EntradaJuego1.setPuntos(puntos);
//    }
//    
//    public int getPuntos()
//    {
//        return this.panel_EntradaJuego1.getPuntos();
//    }
//    
//    public void limpiarTabla()
//    {
//        this.panel_EntradaJuego1.limpiarTabla();
//    }
//    
//    public void colocarMejoresRecords(String[] record)
//    {
//        this.panel_EntradaJuego1.colocarMejoresRecords(record);
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_EntradaJuego1 = new vista.Panel_EntradaJuego();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel_EntradaJuego1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        controlador_FRM_EntradaJuego.metodosRecord.escribirSobreArchivo();
    }//GEN-LAST:event_formWindowClosing

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_EntradaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_EntradaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_EntradaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_EntradaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_EntradaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Panel_EntradaJuego panel_EntradaJuego1;
    // End of variables declaration//GEN-END:variables
}
