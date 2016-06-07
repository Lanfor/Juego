/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Lanfor
 */
public class MetodosRecord 
{
    ArrayList<Record> array;
    ArchivoRecords archivoRecords;
    public MetodosRecord()
    {
        array=new ArrayList<Record>();
        archivoRecords=new ArchivoRecords();
        array=archivoRecords.leerInformacionCompleta();
    }
    
    public void escribirSobreArchivo()
    {
        archivoRecords.crearArchivo();
        ordenar();
        for (int i = 0; i < array.size(); i++) 
        {
            if(i<5)
            {
                archivoRecords.escribirInformacionEnElArchivo(array.get(i));
            }
            else
                break;
        }
    }
    
    public void agregarRecord(Record record)
    {
        array.add(record);
    }
    
    public String ordenar()
    {
        String[] record=new String[2];
        String msj="";
        Record aux=null;
        for (int i = 0; i < array.size(); i++) 
        {
            for (int j = 0; j < array.size()-1; j++) 
            {
                if(Integer.parseInt(array.get(j).getRecord())<Integer.parseInt(array.get(j+1).getRecord()))
                {
                    aux= array.get(j+1);
                    array.set(j+1, array.get(j));
                    array.set(j, aux);
                }
            }
        }
        for (int i = 0; i < array.size(); i++) 
        {
            if(i<5)
            {
                msj+=(i+1)+". "+array.get(i).getNombre()+"  $"+array.get(i).getRecord()+"\n";
            }
            else
            {
                array.remove(i);
            }
        }
        return msj;
    }
}
