/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problemadni;

import com.mycompany.problemadni.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alex
 */
public class Tenis {
    static boolean flag = false;
    static Scanner teclado = new Scanner(System.in);
    static int opcion;
    static PersistentHashMap datos = new PersistentHashMap();
    static ArrayList<String> dnis;
    
    public static void main (String args[]){
        while (flag == false){
            System.out.println("Menú");
            System.out.println("--------------\n");
            System.out.println("1- Crear novo socio");
            System.out.println("2- Modificar socio");
            System.out.println("3- Baixa de socio");
            System.out.println("4- Listado");
            System.out.println("5- Sair\n");
            try{
            opcion = Integer.parseInt(teclado.nextLine());
            } catch (Exception ex){
            }
            
            switch (opcion){
                case 1:
                    novoCliente();
                    break;
                case 2:
                    modificaCliente();
                    break;
                case 3: 
                    
                    try{
                        System.out.println("Baixa de cliente");
                        System.out.println("-------------------------\n");
                        System.out.println("Introduzca DNI");
                        String dnitemp = teclado.nextLine(); 
                        if (!checkCadena(dnitemp,"[KLMZXYklmzxy]?[0-9]{7,8}[A-Za-z]")){
                            throw new Exception ("DNI non válido");
                        }
                        if (datos.getCliente(dnitemp)==null){
                            throw new Exception ("DNI non existe");
                        }
                        Cliente persona = datos.getCliente(dnitemp);
                        persona.setActivo(false);
                        datos.save(persona);
                        System.out.println("Cliente dado de baixa");
                        
                    } catch (Exception ex){
                        System.out.println("Dato no válido: "+ex.getMessage());
                    }
                    
                    
                    break;
                case 4: 
                    dnis = datos.getDni();
                    System.out.println("Lista de DNIS grabados");
                    for (String i:dnis){
                        System.out.println(i);
                        Cliente persona = datos.getCliente(i);
                        //System.out.println("activo: "+persona.isActivo());
                    }    
                    dnis.clear();
                   
                    break;
                case 5:
                    flag = true;
                    //-------------Prueba
                    Cliente pepe = datos.getCliente("36137782K");
                    System.out.println(pepe.getNome());
                    //-------------
                    
                    
                    break;
                default:
                    System.out.println("Opción non válida");
            }
            
            
            
            
        }
        
        
        
    }
    
    public static void novoCliente (){

    String dni, nombre, apellidos, direccion, email, ccc;
    boolean bucle = false;    
    double telefono;
                
        while(bucle == false){
            try{
                System.out.println("Creación de un nuevo cliente");
                System.out.println("-------------------------\n");
                System.out.println("Introduzca DNI");
                dni = teclado.nextLine(); 
                if (!checkCadena(dni,"[KLMZXYklmzxy]?[0-9]{7,8}[A-Za-z]")){
                    throw new Exception ("DNI error");
                }
                System.out.println("Introduzca nombre");
                nombre = teclado.nextLine(); 
                System.out.println("Introduzca apellidos");
                apellidos = teclado.nextLine(); 
                System.out.println("Introduzca dirección");
                direccion = teclado.nextLine(); 
                System.out.println("Introduzca email");
                email = teclado.nextLine(); 
                System.out.println("Introduzca ccc");
                ccc = teclado.nextLine(); 
                if (!checkCadena(ccc,"[0-9]{20}")){
                    throw new Exception ("CCC error");
                }
                System.out.println("Introduzca teléfono");
                telefono = Double.parseDouble(teclado.nextLine()); 
                datos.save(new Cliente(dni, nombre, apellidos, direccion, telefono, email, ccc));
                bucle = true;
            }
            catch (Exception ex){
                System.out.println("Dato no válido: "+ex.getMessage());
            }
        }
        
        

        
    }
    
    public static void modificaCliente (){

    String dni, nombre, apellidos, direccion, email, ccc;
    boolean bucle = false;    
    double telefono;
    Cliente cloaded;    
    String temp;
    
        while(bucle == false){
            try{
                System.out.println("Modificación dun cliente");
                System.out.println("-------------------------\n");
                System.out.println("Introduzca DNI");
                dni = teclado.nextLine(); 
                if (!checkCadena(dni,"[KLMZXYklmzxy]?[0-9]{7,8}[A-Za-z]")){
                    throw new Exception ("DNI non válido");
                }
                if (datos.getCliente(dni)==null){
                    throw new Exception ("DNI non existe");
                }
                cloaded = datos.getCliente(dni);
                System.out.println("Introduza nombre ou deixar en blanco para non modificar");
                temp = teclado.nextLine();
                if (!temp.equals("")) cloaded.setNome(temp);
                
                System.out.println("Introduza apelidos ou deixar en blanco para non modificar");
                temp = teclado.nextLine();
                if (!temp.equals("")) cloaded.setApelidos(temp);
                
                System.out.println("Introduza dirección ou deixar en blanco para non modificar");
                temp = teclado.nextLine();
                if (!temp.equals("")) cloaded.setDireccion(temp);
                
                System.out.println("Introduza email ou deixar en blanco para non modificar");
                temp = teclado.nextLine();
                if (!temp.equals("")) cloaded.setEmail(temp);

                System.out.println("Introduza ccc ou deixar en blanco para non modificar");
                temp = teclado.nextLine();
                if (!temp.equals("")) {
                    if (!checkCadena(temp,"[0-9]{20}")){
                        throw new Exception ("CCC error");
                    }                   
                    cloaded.setCcc(temp);
                }
                
                
                System.out.println("Introduza teléfono ou deixar en blanco para non modificar");
                temp = teclado.nextLine(); 
                if (!temp.equals("")) cloaded.setTelefono(Double.parseDouble(temp));
                datos.update(cloaded);
                bucle = true;
            }
            catch (Exception ex){
                System.out.println("Dato no válido: "+ex.getMessage());
            }
        }
        
        

        
    }
    
    public static boolean checkCadena(String cadenaacheck, String cadenapatron){
            Pattern pDNI=Pattern.compile(cadenapatron);
            Matcher mDNI=pDNI.matcher(cadenaacheck);
            if (mDNI.matches())
            {
                return true;
            } else {
                return false;
            }

        }        
    
    
}
