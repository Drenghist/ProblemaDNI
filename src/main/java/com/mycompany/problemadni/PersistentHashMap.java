/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problemadni;

import com.mycompany.problemadni.Cliente;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilidades.Serializator;

/**
 *
 * @author Alex
 */
public class PersistentHashMap {
    protected HashMap <String, Cliente> datos = new HashMap <>();
    RandomAccessFile ras;
    Cliente ctemp;
    
    PersistentHashMap (){
        //--------------------
        File f = new File("Socios.dat"); 
        if (f.exists()){
            try{
            ras=new RandomAccessFile("Socios.dat","r");
            ras.seek(0);
            while (ras.length()>ras.getFilePointer()){
                ctemp = Serializator.unserialize(ras.readUTF());
                datos.put(ctemp.getkey(),ctemp);
            } 
            ras.close();
            }catch (Exception ex){
                System.out.println("Erro o cargar o ficheiro");
            }
            
        }
        
        //--------------------
        
    }
    
    public void save (Cliente cliente) throws Exception{
        if (datos.get(cliente.getkey())!= null) throw new Exception("O cliente xa existe");
        datos.put(cliente.getkey(), cliente);
        try {
            ras=new RandomAccessFile("Socios.dat","rw");
            ras.setLength(0);
            
            for (String llave:datos.keySet()){
                    ras.writeUTF(Serializator.serialize(datos.get(llave)));
            }
            ras.close();
        } catch (IOException ex) {
            Logger.getLogger(PersistentHashMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
    public void update (Cliente cliente) throws Exception{
        
        if (datos.get(cliente.getkey())== null) throw new Exception("O cliente non existe");
        datos.put(cliente.getkey(), cliente);
        try {
            ras=new RandomAccessFile("Socios.dat","rw");
            ras.setLength(0);
            
            for (String llave:datos.keySet()){
                    ras.writeUTF(Serializator.serialize(datos.get(llave)));
            }
            ras.close();
        } catch (IOException ex) {
            Logger.getLogger(PersistentHashMap.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public Cliente getCliente (String dni){
        return datos.get(dni);
    }
    
    public ArrayList<String> getDni(){
        ArrayList<String> dnis= new ArrayList<>();
        for (String i:datos.keySet()){
            dnis.add(i);
        }
        return dnis;
    }
    
    
}
