/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Lanfor
 */
public class ArchivoRecords 
{
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    public void crearArchivo()
    {
        try 
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("record.dat"));
            System.out.println("Archivo Creado");
        } catch (Exception e) 
        {
            System.err.println("Error al crear el archivo "+e.getMessage());
        }
        
    }
    public void escribirInformacionEnElArchivo(Record record)
    {
        try 
        {
            archivoSalida.writeObject(record);
            System.out.println("Se escribío el archivo de la forma correcta");
        } catch (Exception e) {
            System.err.println("Error al escribir en el Archivo "+e.getMessage());
        }
    }
    public ArrayList<Record> leerInformacionCompleta()
    {
        ArrayList<Record> arrayRecord=new ArrayList<Record>();
        try 
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("record.dat"));
            while (true)
            {
                arrayRecord.add((Record)archivoEntrada.readObject( ));
            }
        } catch (Exception e) 
        {
            System.err.println("Fin del archivo: "+e.getMessage());
        }
        return arrayRecord;
    }
}
