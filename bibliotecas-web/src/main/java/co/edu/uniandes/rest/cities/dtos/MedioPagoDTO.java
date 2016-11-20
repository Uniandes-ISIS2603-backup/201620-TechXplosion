/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;

/**
 * Clase que guarda la información de un medio de pago.
 *
 * @author js.sosa10
 */
public class MedioPagoDTO {

    private Long id;
    private String tipo;
    private int numero;
    private int numeroSeguridad;

    /**
     * Constructor por defecto
     */
    public MedioPagoDTO() {
         /**
     * Constructor por defecto
     */
    }

    /**
     * Constructor con parametros
     *
     * @param id el id del medio de pago
     * @param tipo el tipo de medio de pago
     * @param numero el numero del medio de pago
     * @param numeroSeguridad el numero de seguridad del medio de pago
     */
    public MedioPagoDTO(Long id, String tipo, int numero, int numeroSeguridad) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
        this.numeroSeguridad = numeroSeguridad;
    }

    public MedioPagoDTO(MedioPagoEntity entity)
    {
        if (entity != null) 
        {
                this.tipo = entity.getName();
                this.id = entity.getId();
        }
    }
    
    public MedioPagoEntity toEntity()
    {
        MedioPagoEntity entity = new MedioPagoEntity();
        entity.setId(this.id);
        entity.setName(this.tipo);
        return entity;
    }
    /**
     * metodo que retorna el id del medio de pago
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * metodo para actualizar el id del medio de pago
     *
     * @param id ,el nuevo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * metodo para retornar el tipo del medio de pago
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo para actualizar el tipoo de medio de pago
     *
     * @param tipo tipo de medio de pago
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * metodo para retornar el numero del medio de pago
     *
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * metodo para actualizar el numero del medio de pago
     *
     * @param numero numero de identifiacion del medio de pago
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * metodo para retornar el numero de seguridad del medio de pago
     *
     * @return numeroSeguridad
     */
    public int getNumeroSeguridad() {
        return numeroSeguridad;
    }

    /**
     * metodo para actualizar el numero de seguridad del medio de pago
     *
     * @param numeroSeguridad codigo de seguridad
     */
    public void setNumeroSeguridad(int numeroSeguridad) {
        this.numeroSeguridad = numeroSeguridad;
    }

    /**
     * Convierte el objeto a una cadena de caracteres.
     *
     * @return la cadena de caracteres que represnta el objeto
     */
    @Override
    public String toString() {
        return "{id : " + id + ", tipo : \"" + tipo + "\" , numero : " + numero + ", numeroSeguridad :" + numeroSeguridad + "}";
    }

}
