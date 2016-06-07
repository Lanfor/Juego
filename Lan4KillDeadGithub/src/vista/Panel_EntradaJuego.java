/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_EntradaJuego;
import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lanfor
 */
public class Panel_EntradaJuego extends javax.swing.JPanel {

    ImageIcon imagenSonido;
    AudioClip musica;
    Controlador_FRM_EntradaJuego controlador;
    int puntos=0;
    DefaultTableModel modelo;
    public Panel_EntradaJuego() {
        initComponents();
        musica= newAudioClip(getClass().getResource("/music/canción expedientes secreto x.wav"));
        //musica.loop();
        imagenSonido=(ImageIcon)btn_Sonido.getIcon();
        modelo=new DefaultTableModel();
        colocarTitulosTabla();
    }
    
    public void colocarTitulosTabla()
    {
        tbl_Puntuaciones.setModel(modelo);
        String[] titulos={"Nombre","Puntuación"};
        modelo.setColumnIdentifiers(titulos);
        
    }
    public void agregarEventos(Controlador_FRM_EntradaJuego controlador)
    {
        this.controlador=controlador;
        btn_Jugar.addActionListener(controlador);
        btn_Salir.addActionListener(controlador);
        btn_AcercaDe.addActionListener(controlador);
        btn_Sonido.addActionListener(controlador);
    }
    public void cambiarEstadoMusica()
    {
        if(imagenSonido.equals(btn_Sonido.getIcon()))
        {
            btn_Sonido.setIcon(new ImageIcon(getClass().getResource("/img/SonidoOFF.png")));
            musica.stop();
        }
        else
        {
            btn_Sonido.setIcon(imagenSonido);
            //musica.loop();
        }
            
    }
    public String getNivel()
    {
        return ""+jcb_NivelJuego.getSelectedItem();
    }
    public int getCampo()
    {
        return (int)jcb_CampoJuego.getSelectedIndex()+1;
    }
    public void reproducirMusica()
    {
        musica.play();
    }
    
    public void gane(int puntos, int nivel)
    {
        this.puntos+=puntos;
        jcb_NivelJuego.setSelectedIndex(nivel);
    }
    
     public void setPuntos(int puntos)
    {
        this.puntos=puntos;
    }
    
    public int getPuntos()
    {
        return puntos;
    }
    
    public void limpiarTabla()
    {
        while(0<modelo.getRowCount())
        {
            modelo.removeRow(0);
        }
    }
    
    public void colocarMejoresRecords(String[] records)
    {
       modelo.addRow(records);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_TituloEntrada = new javax.swing.JLabel();
        jl_MejorPuntuacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Puntuaciones = new javax.swing.JTable();
        jl_NivelJuego = new javax.swing.JLabel();
        btn_Jugar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        jl_CampoJuego = new javax.swing.JLabel();
        btn_AcercaDe = new javax.swing.JButton();
        btn_Sonido = new javax.swing.JButton();
        jcb_NivelJuego = new javax.swing.JComboBox<>();
        jcb_CampoJuego = new javax.swing.JComboBox<>();
        jl_FondoEntrada = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_TituloEntrada.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jl_TituloEntrada.setForeground(new java.awt.Color(102, 255, 255));
        jl_TituloEntrada.setText("   The Land 4 Kill Dead");
        jl_TituloEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jl_TituloEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 460, -1));

        jl_MejorPuntuacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_MejorPuntuacion.setForeground(new java.awt.Color(51, 204, 255));
        jl_MejorPuntuacion.setText("Mejores Puntuaciones");
        add(jl_MejorPuntuacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        tbl_Puntuaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Puntuación"
            }
        ));
        jScrollPane1.setViewportView(tbl_Puntuaciones);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 380, 100));

        jl_NivelJuego.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_NivelJuego.setForeground(new java.awt.Color(51, 204, 255));
        jl_NivelJuego.setText("Nivel de Juego");
        add(jl_NivelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        btn_Jugar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_Jugar.setForeground(new java.awt.Color(51, 204, 255));
        btn_Jugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pistola.gif"))); // NOI18N
        btn_Jugar.setText("Jugar");
        add(btn_Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 160, 50));

        btn_Salir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_Salir.setForeground(new java.awt.Color(102, 204, 255));
        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir.gif"))); // NOI18N
        btn_Salir.setText("Salir");
        add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 160, 50));

        jl_CampoJuego.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_CampoJuego.setForeground(new java.awt.Color(51, 204, 255));
        jl_CampoJuego.setText("Campo de Juego");
        add(jl_CampoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        btn_AcercaDe.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_AcercaDe.setForeground(new java.awt.Color(51, 204, 255));
        btn_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_AcercaDe.setText("Acerca De");
        add(btn_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 160, -1));

        btn_Sonido.setBackground(new java.awt.Color(255, 255, 255));
        btn_Sonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SonidoON.png"))); // NOI18N
        btn_Sonido.setActionCommand("Sonido");
        add(btn_Sonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 50, 50));

        jcb_NivelJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fácil", "Medio", "Dificil", "NigthMare" }));
        add(jcb_NivelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 110, -1));

        jcb_CampoJuego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        add(jcb_CampoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 110, -1));

        jl_FondoEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/entradaJuego.jpg"))); // NOI18N
        add(jl_FondoEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 360));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AcercaDe;
    private javax.swing.JButton btn_Jugar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_Sonido;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcb_CampoJuego;
    private javax.swing.JComboBox<String> jcb_NivelJuego;
    private javax.swing.JLabel jl_CampoJuego;
    private javax.swing.JLabel jl_FondoEntrada;
    private javax.swing.JLabel jl_MejorPuntuacion;
    private javax.swing.JLabel jl_NivelJuego;
    private javax.swing.JLabel jl_TituloEntrada;
    private javax.swing.JTable tbl_Puntuaciones;
    // End of variables declaration//GEN-END:variables
}
