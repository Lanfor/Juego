/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Controlador_FRM_EntradaJuego;

/**
 *
 * @author Lanfor
 */
public class Hilo_Espera extends Thread
{
    Controlador_FRM_EntradaJuego controlador;
    public int espera=0;
    public Hilo_Espera(Controlador_FRM_EntradaJuego controlador) 
    {
        this.controlador=controlador;
    }
    
    public void run()
    {
        while (true) 
        {
            try 
            {
                sleep(1000);
                
                if(espera==0)
                {
                    controlador.fRM_Espera.setVisible(true);
                    espera++;
                }
                else
                {
                    espera++;
                    if(espera==7)
                    {
                        controlador.fRM_Espera.setVisible(false);
                        controlador.fRM_VentanaJuego.setVisible(true);
<<<<<<< HEAD
                        controlador.fRM_VentanaJuego.inicializarValores();
                        
=======
>>>>>>> origin/master
                        espera=0;
                     stop();
                    }
                }
            } catch (Exception e) 
            {
                System.err.println("Hubo en error en el hilo de ejecucion run: "+e.getMessage());
            }
            
        }
    }
}
