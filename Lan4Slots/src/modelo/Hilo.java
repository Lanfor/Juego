package modelo;

import vista.FRM_Casino;


/**
 *
 * @author Lanfor
 */
public class Hilo extends  Thread
{
    FRM_Casino ventana;
    int tiempo=0;
    public Hilo(FRM_Casino ventana) 
    {
        this.ventana=ventana;
    }
    
    public void run()
    {
        while (true) 
        {
            if(!this.isInterrupted())
            {
                try 
                {
                    this.sleep(500);
                    moverFiguras();
                    
                } catch (Exception e) 
                {
                    System.err.println("Hubo en error en el hilo de ejecucion run: "+e.getCause());
                }
            }
            
        }
    }
    
    public void moverFiguras()
    {
        if(tiempo<7)
            ventana.cambiarFigura1();
        if(tiempo<9)
            ventana.cambiarFigura2();
        if(tiempo<11)
            ventana.cambiarFigura3();
        if(tiempo<13)
        {
          ventana.cambiarFigura4();
          tiempo++;
        }
        else
        {
            tiempo=0;
            ventana.verificarJugada();
            ventana.calculos();
            this.stop();
        }
    }
}
