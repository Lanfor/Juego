/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Hilo;
import modelo.MetodosRecord;
import modelo.Record;

/**
 *
 * @author Lanfor
 */
public class FRM_Casino extends javax.swing.JFrame {

    Icon[] imagenes;
    int num1, num2, num3, num4,num5;
    String suerte="Mala";
    MetodosRecord metodosRecord;
    public FRM_Casino() {
        initComponents();
        setLocationRelativeTo(null);
        imagenes=new Icon[5];
        metodosRecord=new MetodosRecord();
        cargarImagenes();
    }
    
    public void cargarImagenes()
    {
        imagenes[0]=new ImageIcon(getClass().getResource("/img/figura1.png"));
        imagenes[1]=new ImageIcon(getClass().getResource("/img/figura2.png"));
        imagenes[2]=new ImageIcon(getClass().getResource("/img/figura3.png"));
        imagenes[3]=new ImageIcon(getClass().getResource("/img/figura4.png"));
        imagenes[4]=new ImageIcon(getClass().getResource("/img/figura5.png"));
    }
    
    public void jugar()
    {
        num1= (int)(Math.random()*(4-0+1)+0);
        num2= (int)(Math.random()*(4-0+1)+0);
        num3= (int)(Math.random()*(4-0+1)+0);
        num4= (int)(Math.random()*(4-0+1)+0);
        
           new Hilo(this).start();
    }
    public void cambiarFigura1()
    {
        jl_Figura1.setIcon(imagenes[num1]);
        num1++;
        if(num1==5)
            num1=0;
    }
    public void cambiarFigura2()
    {
        jl_Figura2.setIcon(imagenes[num2]);
        num2++;
        if(num2==5)
            num2=0;
    }
    public void cambiarFigura3()
    {
        jl_Figura3.setIcon(imagenes[num3]);
        num3++;
        if(num3==5)
            num3=0;
    }
    public void cambiarFigura4()
    {
        jl_Figura4.setIcon(imagenes[num4]);
        num4++;
        if(num4==5)
            num4=0;
    }
    
    public  boolean isNumber(String texto)
    {
        boolean number=true;
        char[] text=texto.trim().toCharArray();
        for (char n : text) 
        {
            try{Integer.parseInt(n+"");} catch (Exception e) {number=false; break;}
        }
        return number;
    }
    
    public void iniciar()
    {
        if(txt_MontoInicio.getText().equalsIgnoreCase("") || !isNumber(txt_MontoInicio.getText()))
        {
            JOptionPane.showMessageDialog(this, "Debe colocar correctamente el Monto con el que desea comenzar la apuesta","ERRORR!!!",JOptionPane.ERROR_MESSAGE);
            txt_MontoInicio.setText("");
        }
        else
        {
            btn_Iniciar.setEnabled(false);
            txt_MontoInicio.setEnabled(false);
            btn_Retirar.setEnabled(true);
            txt_Ganancias.setText(txt_MontoInicio.getText());
            btn_Apostar.setEnabled(true);
        }
    }
    
    public void verificarJugada()
    {
//*************************         Si todas son iguales *********************************************************//
        if(jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
        {
            txt_Mensajes.setText("              WOW, ERES EL MEJOR!!!  ");
            suerte="Full";
        }
        else
        {
//************************ Si la primera solo tiene una en común **************************************************//
            if(jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
            {
                txt_Mensajes.setText("            BIEN, SIGUE INTENTANDO!!!  ");
                suerte="Un Par";
            }
            else
            if(jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
            {
                txt_Mensajes.setText("            BIEN, SIGUE INTENTANDO!!!  ");
                suerte="Un Par";
            }
            else
            if(jl_Figura1.getIcon().equals(jl_Figura4.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura3.getIcon()))
            {
                txt_Mensajes.setText("            BIEN, SIGUE INTENTANDO!!!  ");
                suerte="Un Par";
            }
//************************ Si la segunda solo tiene una en común **************************************************//
            else//Hibiese sido mejor hacer la comparación con los numeros resultantes
            if(jl_Figura2.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura2.getIcon().equals(jl_Figura1.getIcon()) &&
               !jl_Figura2.getIcon().equals(jl_Figura4.getIcon()))
                {
                    txt_Mensajes.setText("            BIEN, SIGUE INTENTANDO!!!  ");
                    suerte="Un Par";
                }
                else
                if(jl_Figura2.getIcon().equals(jl_Figura4.getIcon()) && !jl_Figura2.getIcon().equals(jl_Figura1.getIcon()) && !jl_Figura2.getIcon().equals(jl_Figura3.getIcon()))
                {
                    txt_Mensajes.setText("            BIEN, SIGUE INTENTANDO!!!  ");
                    suerte="Un Par";
                }
//************************ Si la tercera solo tiene una en común **************************************************//
            else
                if(jl_Figura3.getIcon().equals(jl_Figura4.getIcon()) && !jl_Figura3.getIcon().equals(jl_Figura1.getIcon()) && !jl_Figura3.getIcon().equals(jl_Figura2.getIcon()))
                {
                    txt_Mensajes.setText("           BIEN, SIGUE INTENTANDO!!!  ");
                    suerte="Un Par";
                }
        }
        
        
//************************ Si la primera tiene dos en común **************************************************//
        if(jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) &&  !jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
        {
            txt_Mensajes.setText("           YEAH, MUUUY CERCA!!!  ");
            suerte="Un trio";
        }
        else
        {
            if(jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && jl_Figura1.getIcon().equals(jl_Figura4.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura2.getIcon()))
            {
                txt_Mensajes.setText("          YEAH, MUUUY CERCA!!!  ");
                suerte="Un trio";
            }
//************************ Si la cuarta tiene dos en común **************************************************//
            else
                if(jl_Figura4.getIcon().equals(jl_Figura1.getIcon()) && jl_Figura4.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura4.getIcon().equals(jl_Figura3.getIcon()))
                {
                    txt_Mensajes.setText("           YEAH, MUUUY CERCA!!!  ");
                    suerte="Un trio";
                }
            else
                if(jl_Figura4.getIcon().equals(jl_Figura2.getIcon()) && jl_Figura4.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura4.getIcon().equals(jl_Figura1.getIcon()))
                {
                    txt_Mensajes.setText("           YEAH, MUUUY CERCA!!!  ");
                    suerte="Un trio";
                }
        }
//****************************** Si hay dos pares **************************************************//
        if(jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && jl_Figura3.getIcon().equals(jl_Figura4.getIcon()))
        {
            if(!jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
            {
                if(!jl_Figura2.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura2.getIcon().equals(jl_Figura4.getIcon()))
                {
                    txt_Mensajes.setText("           YIJA, EXCELENTE JUGADA!!!  ");
                    suerte="Dos Pares";
                }
            }
        }
        else
        {
            if(jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && jl_Figura2.getIcon().equals(jl_Figura4.getIcon()))
            {
                if(!jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
                {
                    if(!jl_Figura3.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura3.getIcon().equals(jl_Figura4.getIcon()))
                    {
                        txt_Mensajes.setText("           YIJA, EXCELENTE JUGADA!!!  ");
                        suerte="Dos Pares";
                    }
                }
            }
            else
                if(jl_Figura1.getIcon().equals(jl_Figura4.getIcon()) && jl_Figura2.getIcon().equals(jl_Figura3.getIcon()))
                {
                    if(!jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura2.getIcon()))
                    {
                        if(!jl_Figura4.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura4.getIcon().equals(jl_Figura2.getIcon()))
                        {
                            txt_Mensajes.setText("           YIJA, EXCELENTE JUGADA!!!  ");
                            suerte="Dos Pares";
                        }
                    }
                }
        }
        if(!jl_Figura1.getIcon().equals(jl_Figura2.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura1.getIcon().equals(jl_Figura4.getIcon()))
            if(!jl_Figura2.getIcon().equals(jl_Figura3.getIcon()) && !jl_Figura2.getIcon().equals(jl_Figura4.getIcon()))
                if(!jl_Figura3.getIcon().equals(jl_Figura4.getIcon()))
                {
                    txt_Mensajes.setText("            MALA SUERTE!!!  ");
                    suerte="Pesimo";
                }
        
    }
    
    public void reiniciarJuego()
    {
        num1=0; num2=0; num3=0; num4=0;num5=0;
        suerte="Mala";
        txt_MontoInicio.setEnabled(true);
        btn_Iniciar.setEnabled(true);
        btn_Girar.setEnabled(false);
        btn_Apostar.setEnabled(false);
        btn_Retirar.setEnabled(false);
        txt_MontoInicio.setText("");
        txt_Ganancias.setText("");
        jl_CantApuesta.setText("0000");
        jl_Figura1.setIcon(new ImageIcon(getClass().getResource("/img/incognitaEdit.jpg")));
        jl_Figura2.setIcon(jl_Figura1.getIcon());
        jl_Figura3.setIcon(jl_Figura1.getIcon());
        jl_Figura4.setIcon(jl_Figura1.getIcon());
    }
    
    public void calculos()
    {
        int cantGanada=Integer.parseInt(txt_Ganancias.getText());
        System.out.println(suerte);
        switch(suerte)
        {
            case "Full":
                cantGanada=Integer.parseInt(txt_Ganancias.getText())+(Integer.parseInt(jl_CantApuesta.getText())*2)+40000;
                System.out.println(cantGanada);
                txt_Ganancias.setText(""+cantGanada);
                break;
            case "Un Par":
                cantGanada=Integer.parseInt(txt_Ganancias.getText())+((Integer.parseInt(jl_CantApuesta.getText()))/2);
                System.out.println(cantGanada);
                txt_Ganancias.setText(""+cantGanada);
                break;
            case "Un trio":
                cantGanada=Integer.parseInt(txt_Ganancias.getText())+(Integer.parseInt(jl_CantApuesta.getText()))+30000;
                System.out.println(cantGanada);
                txt_Ganancias.setText(""+cantGanada);
                break;
            case "Dos Pares":
                cantGanada=Integer.parseInt(txt_Ganancias.getText())+(Integer.parseInt(jl_CantApuesta.getText()));
                System.out.println(cantGanada);
                txt_Ganancias.setText(""+cantGanada);
                break;
            case "Pesimo":
                System.out.println(cantGanada);
                txt_Ganancias.setText(""+cantGanada);
                break;
        }
        jl_CantApuesta.setText("0000");
        btn_Apostar.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_Figura1 = new javax.swing.JLabel();
        jl_Figura2 = new javax.swing.JLabel();
        jl_Figura3 = new javax.swing.JLabel();
        jl_Figura4 = new javax.swing.JLabel();
        btn_Girar = new javax.swing.JButton();
        btn_Retirar = new javax.swing.JButton();
        txt_Ganancias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jl_CantApuesta = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_MontoInicio = new javax.swing.JTextField();
        btn_Iniciar = new javax.swing.JButton();
        txt_Mensajes = new javax.swing.JTextField();
        btn_Apostar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jm_MejoresPuntuaciones = new javax.swing.JMenuItem();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jl_Figura1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incognitaEdit.jpg"))); // NOI18N
        jPanel1.add(jl_Figura1);
        jl_Figura1.setBounds(120, 120, 150, 180);

        jl_Figura2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incognitaEdit.jpg"))); // NOI18N
        jPanel1.add(jl_Figura2);
        jl_Figura2.setBounds(270, 120, 150, 180);

        jl_Figura3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incognitaEdit.jpg"))); // NOI18N
        jPanel1.add(jl_Figura3);
        jl_Figura3.setBounds(420, 120, 150, 180);

        jl_Figura4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incognitaEdit.jpg"))); // NOI18N
        jPanel1.add(jl_Figura4);
        jl_Figura4.setBounds(570, 120, 150, 180);

        btn_Girar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Girar.setForeground(new java.awt.Color(255, 0, 0));
        btn_Girar.setText("Girar");
        btn_Girar.setEnabled(false);
        btn_Girar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GirarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Girar);
        btn_Girar.setBounds(340, 450, 160, 32);

        btn_Retirar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Retirar.setForeground(new java.awt.Color(255, 0, 0));
        btn_Retirar.setText("Retirar");
        btn_Retirar.setEnabled(false);
        btn_Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RetirarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Retirar);
        btn_Retirar.setBounds(640, 390, 140, 32);

        txt_Ganancias.setBackground(new java.awt.Color(0, 0, 0));
        txt_Ganancias.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txt_Ganancias.setForeground(new java.awt.Color(255, 255, 255));
        txt_Ganancias.setText("0000");
        txt_Ganancias.setBorder(null);
        txt_Ganancias.setEnabled(false);
        jPanel1.add(txt_Ganancias);
        txt_Ganancias.setBounds(610, 360, 210, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SlotEditado.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 60, 700, 300);

        jl_CantApuesta.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jl_CantApuesta.setForeground(new java.awt.Color(255, 0, 0));
        jl_CantApuesta.setText("0000");
        jPanel1.add(jl_CantApuesta);
        jl_CantApuesta.setBounds(360, 360, 130, 16);

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Monto de Inicio:  $");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 360, 110, 16);

        txt_MontoInicio.setBackground(new java.awt.Color(0, 0, 0));
        txt_MontoInicio.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_MontoInicio);
        txt_MontoInicio.setBounds(120, 360, 170, 24);

        btn_Iniciar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Iniciar.setForeground(new java.awt.Color(255, 0, 0));
        btn_Iniciar.setText("Iniciar");
        btn_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Iniciar);
        btn_Iniciar.setBounds(120, 400, 110, 32);

        txt_Mensajes.setEditable(false);
        txt_Mensajes.setBackground(new java.awt.Color(255, 0, 0));
        txt_Mensajes.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txt_Mensajes.setForeground(new java.awt.Color(0, 0, 0));
        txt_Mensajes.setText("          Lanfor Mena Montalban");
        txt_Mensajes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txt_Mensajes);
        txt_Mensajes.setBounds(180, 20, 450, 40);

        btn_Apostar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Apostar.setForeground(new java.awt.Color(255, 0, 0));
        btn_Apostar.setText("Apostar");
        btn_Apostar.setEnabled(false);
        btn_Apostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ApostarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Apostar);
        btn_Apostar.setBounds(350, 400, 110, 32);

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Ganancias:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(540, 360, 70, 16);

        jMenu1.setText("Acerda de");

        jMenuItem1.setText("Reglas de Juego");
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Salir");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Historial");

        jm_MejoresPuntuaciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jm_MejoresPuntuaciones.setText("Mejores Puntuaciones");
        jm_MejoresPuntuaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_MejoresPuntuacionesActionPerformed(evt);
            }
        });
        jMenu2.add(jm_MejoresPuntuaciones);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GirarActionPerformed
        btn_Girar.setEnabled(false);
        btn_Apostar.setEnabled(false);
        txt_Mensajes.setText("");
        jugar();
    }//GEN-LAST:event_btn_GirarActionPerformed

    private void btn_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IniciarActionPerformed
        iniciar();
    }//GEN-LAST:event_btn_IniciarActionPerformed

    private void btn_RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetirarActionPerformed
        if(Integer.parseInt(txt_MontoInicio.getText().trim())<Integer.parseInt(txt_Ganancias.getText().trim()))
        {
            int ganancia= Integer.parseInt(txt_Ganancias.getText()) - Integer.parseInt(txt_MontoInicio.getText());
            String nombre=JOptionPane.showInputDialog("Muy Bien\n\nHas obtenido una ganancia de: $"+ganancia+"\n     Registra tu nombre");
            metodosRecord.agregarRecord(new Record(nombre, ganancia+""));
        }
        if(JOptionPane.showConfirmDialog(this,"      Jugaste LAN4SLOTS\nDesa Volver a intentarlo??" ,"Muchas Gracias",JOptionPane.ERROR_MESSAGE)==0)
            {
                reiniciarJuego();
            }
            else
                System.exit(0);
    }//GEN-LAST:event_btn_RetirarActionPerformed

    private void btn_ApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ApostarActionPerformed
        if(Integer.parseInt(txt_Ganancias.getText())>=5000)
        {
            jl_CantApuesta.setText(""+(Integer.parseInt(jl_CantApuesta.getText())+5000));
            txt_Ganancias.setText(""+(Integer.parseInt(txt_Ganancias.getText())-5000));
            btn_Girar.setEnabled(true);
        }
        else
        {
            int respuesta=JOptionPane.showConfirmDialog(this,"Su cantidad de dinero es insuficiente\n\nLa cantidad  minima de apuestas es de $5000\n    Desea Reiniciar el juego" ,"Lo sentimos",JOptionPane.ERROR_MESSAGE);
            if(respuesta==0)
            {
                reiniciarJuego();
            }
            else
                if(respuesta==1)
                    System.exit(0);
            
        }
    }//GEN-LAST:event_btn_ApostarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        metodosRecord.escribirSobreArchivo();
        System.exit(0);
    }//GEN-LAST:event_formComponentHidden

    private void jm_MejoresPuntuacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_MejoresPuntuacionesActionPerformed
        JOptionPane.showMessageDialog(this.jLabel1,metodosRecord.ordenar());
    }//GEN-LAST:event_jm_MejoresPuntuacionesActionPerformed

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
            java.util.logging.Logger.getLogger(FRM_Casino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_Casino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_Casino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_Casino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_Casino().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Apostar;
    public javax.swing.JButton btn_Girar;
    private javax.swing.JButton btn_Iniciar;
    private javax.swing.JButton btn_Retirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jl_CantApuesta;
    private javax.swing.JLabel jl_Figura1;
    private javax.swing.JLabel jl_Figura2;
    private javax.swing.JLabel jl_Figura3;
    private javax.swing.JLabel jl_Figura4;
    private javax.swing.JMenuItem jm_MejoresPuntuaciones;
    private javax.swing.JTextField txt_Ganancias;
    private javax.swing.JTextField txt_Mensajes;
    private javax.swing.JTextField txt_MontoInicio;
    // End of variables declaration//GEN-END:variables
}
