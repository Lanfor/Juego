package modelo;

import vista.FRM_VentanaJuego;

/**
 *
 * @author Lanfor
 */
public class Hilo extends  Thread
{
    FRM_VentanaJuego ventana;
    int tiempo=0, timeMusic=0;
    public boolean corre=false;
    public Hilo(FRM_VentanaJuego ventana) 
    {
        this.ventana=ventana;
    }
    
    public void run()
    {
        while (true) 
        {
            try 
            {
                this.sleep(100);
                System.out.println("hilo");
                if(corre)
                {
                    ventana.moverZombies();
                    aumentarTiempo();
                }
            } catch (Exception e) 
            {
                System.err.println("Hubo en error en el hilo de ejecucion run: "+e.getCause());
            }
            
        }
    }
    
    public void aumentarTiempo()
    {
        
        if(tiempo==20)
        {
            ventana.timer();
            tiempo=0;
        }
            tiempo++;
    }
}
