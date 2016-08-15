/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

/**
 *Clase que guarda la información de un medio de pago.
 * @author js.sosa10
 */
public class MedioPagoDTO {
    private Long id;
    private String tipo;
    private int numreo;
    private int numeroSeguridad;
/**
 * Constructor por defecto
 */
    public MedioPagoDTO() {
    }
/**
 * Constructor con parametros
 * @param id el id del medio de pago
 * @param tipo el tipo de medio de pago
 * @param numreo el numero del medio de pago
 * @param numeroSeguridad el numero de seguridad del medio de pago
 */
    public MedioPagoDTO(Long id, String tipo, int numreo, int numeroSeguridad) {
        this.id = id;
        this.tipo = tipo;
        this.numreo = numreo;
        this.numeroSeguridad = numeroSeguridad;
    }
/**
 * metodo que retorna el id del medio de pago
 * @return id
 */
    public Long getId() {
        return id;
    }
/**
 * metodo para actualizar el id del medio de pago
 * @param id ,el nuevo id
 */
    public void setId(Long id) {
        this.id = id;
    }
/**
 * metodo para retornar el tipo del medio de pago
 * @return tipo
 */
    public String getTipo() {
        return tipo;
    }
/**
 * metodo para actualizar el tipoo de medio de pago
 * @param tipo 
 */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/**
 * metodo para retornar el numero del medio de pago
 * @return numero
 */
    public int getNumreo() {
        return numreo;
    }
/**
 * metodo para actualizar el numero del medio de pago
 * @param numreo 
 */
    public void setNumreo(int numreo) {
        this.numreo = numreo;
    }
/**
 * metodo para retornar el numero de seguridad del medio de pago
 * @return numeroSeguridad
 */
    public int getNumeroSeguridad() {
        return numeroSeguridad;
    }
/**
 * metodo para actualizar el numero de seguridad del medio de pago
 * @param numeroSeguridad 
 */
    public void setNumeroSeguridad(int numeroSeguridad) {
        this.numeroSeguridad = numeroSeguridad;
    }

   /**
     * Convierte el objeto a una cadena de caracteres.
     * @return la cadena de caracteres que represnta el objeto
     */
    @Override
    public String toString() {
        return  "{id : " + id + ", tipo : \"" + tipo + "\" , numreo : " + numreo + ", numeroSeguridad :" + numeroSeguridad + "}";
    }

   
    
}
