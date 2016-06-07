package vista;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Hilo;
import modelo.Record;

public class FRM_VentanaJuego extends javax.swing.JFrame 
{
    AudioClip disparo;

    Hilo hilo;
    int tiempo=0;
    int puntajePartida=0;
    int campo=0, perdidas=5;
    int nivel=5, muertes=0;
    boolean pause=true;
    FRM_EntradaJuego fRM_EntradaJuego;
    
    public FRM_VentanaJuego(FRM_EntradaJuego fRM_EntradaJuego) 
    {
        initComponents();
        setSize(jl_Fondo.getSize());
        setResizable(false);
        setLocationRelativeTo(this);
        this.fRM_EntradaJuego=fRM_EntradaJuego;
        hilo=new Hilo(this);
        hilo.start();
    }
    public void moverZombies()
    {
        //Mover Zombie1
        if(jl_Zombie1.getX()+92<jl_Fondo.getX())
        {
            jl_Zombie1.setLocation(jl_Fondo.getWidth(),jl_Zombie1.getY());
            perdidas--;
        }
        else
            jl_Zombie1.setLocation(jl_Zombie1.getX()-(nivel), jl_Zombie1.getY());
        //Mover Zombie2
        if(jl_Zombie2.getX()+95<jl_Fondo.getX())
        {
            jl_Zombie2.setLocation(jl_Fondo.getWidth()+10,jl_Zombie2.getY());
            perdidas--;
        }
        else
            jl_Zombie2.setLocation(jl_Zombie2.getX()-(nivel), jl_Zombie2.getY());
        
        verificarBarraVida();
    }
    
    public void verificarBarraVida()
    {
        if(perdidas>=0)
        {
            jl_BarraVida.setIcon(new ImageIcon(getClass().getResource("/img/barraVida"+perdidas+".png")));
        }
        else
        {
            if(perdidas<0)
            {
                JOptionPane.showMessageDialog(this, "", "Game Over", JOptionPane.OK_CANCEL_OPTION, new ImageIcon(getClass().getResource("/img/gameOver.jpg")));
                
                Record record=new Record(JOptionPane.showInputDialog("Digita tu Nombre:"), puntajePartida+"");
                fRM_EntradaJuego.controlador_FRM_EntradaJuego.metodosRecord.agregarRecord(record);
                fRM_EntradaJuego.controlador_FRM_EntradaJuego.metodosRecord.ordenar(fRM_EntradaJuego);
                hilo.corre=false;
                this.hide();
            }
        }
    }
    public void verificarMuerte()
    {
        //Muerte Zombie1
        if(jl_Mira.getX()+90>jl_Zombie1.getX()+5 && jl_Mira.getX()+90<jl_Zombie1.getX()+60 && jl_Zombie1.isVisible() && jl_Mira.getY()+90>jl_Zombie1.getY()+3 && jl_Mira.getY()+90<jl_Zombie1.getY()+60)
        {
            jl_Zombie1.setLocation(jl_Fondo.getWidth()+15,jl_Zombie1.getY());
            muertes++;
            puntaje();
        }
        // Muerte Zombie2
        if(jl_Mira.getX()+90>jl_Zombie2.getX()+2 && jl_Mira.getX()+90<jl_Zombie2.getX()+40 && jl_Zombie2.isVisible() && jl_Mira.getY()+90>jl_Zombie2.getY()+70 && jl_Mira.getY()+90<jl_Zombie2.getY()+110)
        {
            jl_Zombie2.setLocation(jl_Fondo.getWidth()+25,jl_Zombie2.getY());
            muertes++;
            puntaje();
        }
        
        if(muertes>=3)
        {
            nivel++;
            muertes=0;
        }
            
    }
    
    public void setcampoJuego(int campo)
    {
        System.out.println("Campo de juego:" +campo);
        if(campo==1)
        this.jl_Fondo.setIcon(new ImageIcon(getClass().getResource("/img/fondo.png")));
        else
            this.jl_Fondo.setIcon(new ImageIcon(getClass().getResource("/img/fondo1.jpg")));
            
    }
    public void timer()
    {
        String digitos="00000";
        digitos=digitos+tiempo;
        digitos=digitos.substring(digitos.length()-5, digitos.length());
        jl_PrimerNumero.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(4)+".png")));
        jl_SegundoNumero.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(3)+".png")));
        jl_TercerNumero.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(2)+".png")));
        jl_CuartoNumero.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(1)+".png")));
        jl_QuintoNumero.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(0)+".png")));
        tiempo++;
    }
    public void puntaje()
    {
        puntajePartida++;
        String digitos="0";
        digitos=digitos+puntajePartida;
        digitos=digitos.substring(digitos.length()-2, digitos.length());
        jl_CantPuntaje1.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(1)+".png")));
        jl_CantPuntaje2.setIcon(new ImageIcon(getClass().getResource("/img/"+digitos.charAt(0)+".png")));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Mira = new javax.swing.JLabel();
        jl_Zombie1 = new javax.swing.JLabel();
        jl_Zombie2 = new javax.swing.JLabel();
        jl_Fondo = new javax.swing.JLabel();
        panel_Barra = new javax.swing.JPanel();
        jl_BarraVida = new javax.swing.JLabel();
        jl_TercerNumero = new javax.swing.JLabel();
        jl_PrimerNumero = new javax.swing.JLabel();
        jl_SegundoNumero = new javax.swing.JLabel();
        jl_CuartoNumero = new javax.swing.JLabel();
        jl_QuintoNumero = new javax.swing.JLabel();
        jl_Vida = new javax.swing.JLabel();
        jl_Tiempo = new javax.swing.JLabel();
        jl_Puntaje = new javax.swing.JLabel();
        jl_CantPuntaje1 = new javax.swing.JLabel();
        jl_CantPuntaje2 = new javax.swing.JLabel();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_Mira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mira.gif"))); // NOI18N
        getContentPane().add(jl_Mira, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 170, 160));

        jl_Zombie1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zombie1.png"))); // NOI18N
        getContentPane().add(jl_Zombie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 260, 90, 140));

        jl_Zombie2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Zombie2.gif"))); // NOI18N
        getContentPane().add(jl_Zombie2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 60, -1, 140));

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(jl_Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1200, 440));

        panel_Barra.setBackground(new java.awt.Color(0, 0, 0));
        panel_Barra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_BarraVida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barraVida5.png"))); // NOI18N

        jl_TercerNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N

        jl_PrimerNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N

        jl_SegundoNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N

        jl_CuartoNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N

        jl_QuintoNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N

        jl_Vida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_Vida.setForeground(new java.awt.Color(0, 153, 0));
        jl_Vida.setText("     Vida");
        jl_Vida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_Tiempo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_Tiempo.setForeground(new java.awt.Color(0, 153, 0));
        jl_Tiempo.setText("   Tiempo");
        jl_Tiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_Puntaje.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jl_Puntaje.setForeground(new java.awt.Color(0, 153, 0));
        jl_Puntaje.setText("   Puntaje");
        jl_Puntaje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_CantPuntaje1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jl_CantPuntaje1.setForeground(new java.awt.Color(255, 255, 255));
        jl_CantPuntaje1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N
        jl_CantPuntaje1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_CantPuntaje2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0.png"))); // NOI18N
        jl_CantPuntaje2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panel_BarraLayout = new javax.swing.GroupLayout(panel_Barra);
        panel_Barra.setLayout(panel_BarraLayout);
        panel_BarraLayout.setHorizontalGroup(
            panel_BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BarraLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jl_Tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_QuintoNumero)
                .addGap(0, 0, 0)
                .addComponent(jl_CuartoNumero)
                .addGap(0, 0, 0)
                .addComponent(jl_TercerNumero)
                .addGap(0, 0, 0)
                .addComponent(jl_SegundoNumero)
                .addGap(0, 0, 0)
                .addComponent(jl_PrimerNumero)
                .addGap(53, 53, 53)
                .addComponent(jl_Vida, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_BarraVida)
                .addGap(50, 50, 50)
                .addComponent(jl_Puntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_CantPuntaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_CantPuntaje1)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        panel_BarraLayout.setVerticalGroup(
            panel_BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BarraLayout.createSequentialGroup()
                .addGroup(panel_BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_QuintoNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_CuartoNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_TercerNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_SegundoNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_PrimerNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_Vida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_CantPuntaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_CantPuntaje1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_Tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jl_Puntaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(panel_BarraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_BarraVida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel_Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.out.println(evt.getKeyCode());
        
        if(evt.getKeyCode()==27)
           if(hilo.corre)
           {
               hilo.corre=false;
               this.setTitle("PAUSE");
           }
            else
           {
               hilo.corre=true;
               this.setTitle("");
           }
           
        if(evt.getKeyCode()==39)
            jl_Mira.setLocation(jl_Mira.getX()+3,jl_Mira.getY());
        if(evt.getKeyCode()==37)
            jl_Mira.setLocation(jl_Mira.getX()-3,jl_Mira.getY());
        if(evt.getKeyCode()==38)
            jl_Mira.setLocation(jl_Mira.getX(),jl_Mira.getY()-3);
        if(evt.getKeyCode()==40)
           jl_Mira.setLocation(jl_Mira.getX(),jl_Mira.getY()+3);
        if(evt.getKeyCode()==32)
        {
            disparo=newAudioClip(getClass().getResource("/music/Disparo seco.wav"));
            disparo.play();
            verificarMuerte();
        }
        
    }//GEN-LAST:event_formKeyPressed

    public void inicializarValores()
    {
        tiempo=0;
        puntajePartida=0;
        jl_CantPuntaje1.setIcon(new ImageIcon(getClass().getResource("/img/0.png")));
        jl_CantPuntaje2.setIcon(new ImageIcon(getClass().getResource("/img/0.png")));
        campo=0; perdidas=5;
        nivel=15;
         hilo.corre=true;
        setcampoJuego(fRM_EntradaJuego.getCampo());
    }
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        jl_Mira.setLocation(evt.getLocationOnScreen().x-175, evt.getLocationOnScreen().y-270);
    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        disparo=newAudioClip(getClass().getResource("/music/Disparo seco.wav"));
        disparo.play();
        verificarMuerte();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_BarraVida;
    private javax.swing.JLabel jl_CantPuntaje1;
    private javax.swing.JLabel jl_CantPuntaje2;
    private javax.swing.JLabel jl_CuartoNumero;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JLabel jl_Mira;
    private javax.swing.JLabel jl_PrimerNumero;
    private javax.swing.JLabel jl_Puntaje;
    private javax.swing.JLabel jl_QuintoNumero;
    private javax.swing.JLabel jl_SegundoNumero;
    private javax.swing.JLabel jl_TercerNumero;
    private javax.swing.JLabel jl_Tiempo;
    private javax.swing.JLabel jl_Vida;
    private javax.swing.JLabel jl_Zombie1;
    private javax.swing.JLabel jl_Zombie2;
    private javax.swing.JPanel panel_Barra;
    // End of variables declaration//GEN-END:variables
}
