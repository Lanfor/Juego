/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Hilo_Espera;
<<<<<<< HEAD
import modelo.MetodosRecord;
import modelo.Record;
import vista.FRM_EntradaJuego;
import vista.FRM_Espera;
import vista.FRM_VentanaJuego;

public class Controlador_FRM_EntradaJuego implements ActionListener
{
    FRM_EntradaJuego fRM_EntradaJuego;
    public FRM_VentanaJuego fRM_VentanaJuego;
    public FRM_Espera fRM_Espera;
    Hilo_Espera hilo_Espera;
    
    public MetodosRecord metodosRecord;
    
    public Controlador_FRM_EntradaJuego(FRM_EntradaJuego fRM_EntradaJuego)
    {
        metodosRecord=new MetodosRecord();
        this.fRM_EntradaJuego=fRM_EntradaJuego;
        this.fRM_VentanaJuego=new FRM_VentanaJuego(fRM_EntradaJuego);
        this.fRM_Espera=new FRM_Espera();
        fRM_EntradaJuego.limpiarTabla();
        metodosRecord.ordenar(fRM_EntradaJuego);
=======
import vista.FRM_EntradaJuego;
//import modelo.Hilo_Espera;
import modelo.MetodosRecord;
import vista.FRM_Espera;
import vista.FRM_VentanaJuego;
//import modelo.Record;
//import vista.FRM_EntradaJuego;
//import vista.FRM_Espera;
//import vista.FRM_VentanaJuego;

public class Controlador_FRM_EntradaJuego implements ActionListener
{
    FRM_EntradaJuego fRM_EntradaJuego;
    public FRM_VentanaJuego fRM_VentanaJuego;
    public FRM_Espera fRM_Espera;
    Hilo_Espera hilo_Espera;
    
    public MetodosRecord metodosRecord;
    
    public Controlador_FRM_EntradaJuego(FRM_EntradaJuego fRM_EntradaJuego)
    {
        metodosRecord=new MetodosRecord();
        this.fRM_EntradaJuego=fRM_EntradaJuego;
        metodosRecord.ordenar(fRM_EntradaJuego);
        this.fRM_VentanaJuego=new FRM_VentanaJuego(fRM_EntradaJuego);
        this.fRM_Espera=new FRM_Espera();

>>>>>>> origin/master
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "Jugar":
                hilo_Espera=new Hilo_Espera(this);
                hilo_Espera.start();
            break;
            case "Salir":
                System.exit(0);
            break;
            case "Acerca De":
                System.out.println("Acerca De");
            break;
            case "Sonido":
                fRM_EntradaJuego.cambiarEstadoMusica();
            break;
        }
    }
    
}
