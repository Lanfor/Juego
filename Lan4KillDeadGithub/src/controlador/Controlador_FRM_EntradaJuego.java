/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Hilo_Espera;
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
                fRM_EntradaJuego.hide();
            break;
            case "Acerca De":
                fRM_EntradaJuego.mostrarMensaje(
                        "EN EL PLANETA COCHOCHOMBO HA SURGIDO UNA EPIDEMIA DE ZOMBIES\n"
                      + "DONDE ESTOS QUIEREN COMERCE LOS PARTE DE LOS HABITANTES DEL\n"
                      + "SU OBJETIVO ES COMER CEREBROS YA QUE ELLOS, ZOMBIENTONTOS, PERO\n"
                      + " AÚN QUEDA UNA ESPERANZA, TÚ TIENES LAS HABILIDADES NECERIAS PARA\n"
                      + "DESTRUIRLOS CON EL FRANCOTIRADOR, VAMOS HASLO POR COCHOCHOMBO");
            break;
            case "Sonido":
                fRM_EntradaJuego.cambiarEstadoMusica();
            break;
        }
    }
    
}
