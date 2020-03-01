/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problemadni;

import java.io.Serializable;

/**
 *
 * @author Alex
 */
public class Cliente implements Serializable {
    private String dni;
    private String nome;
    private String apelidos;
    private String direccion;
    private String email;
    private String ccc;
    private double telefono;
    private boolean activo;
    
    public Cliente (String dni, String nome, String apelidos, String direccion, double telefono, String email, String ccc){
        this.dni=dni;
        this.nome=nome;
        this.apelidos=apelidos;
        this.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
        this.ccc=ccc;
        this.activo = true;       
        
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the apelidos
     */
    public String getApelidos() {
        return apelidos;
    }

    /**
     * @param apelidos the apelidos to set
     */
    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ccc
     */
    public String getCcc() {
        return ccc;
    }

    /**
     * @param ccc the ccc to set
     */
    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    /**
     * @return the telefono
     */
    public double getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }
    public String getkey(){
        return this.dni;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
   
    
    
    
}
