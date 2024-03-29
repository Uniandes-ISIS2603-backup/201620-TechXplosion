/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;

/**
 * Clase que guarda la informacíon de una biblioteca
 *
 * @author js.sosa10
 */
public class BibliotecaDTO {

    private Long id;
    private String name;

    /**
     * Constructor por defecto
     */
    public BibliotecaDTO() {
        /**
         * Constructor por defecto
         */
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador de la Biblioteca
     * @param name nombre de la Biblioteca
     */
    public BibliotecaDTO(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public BibliotecaDTO(BibliotecaEntity entity) 
    {
        if (entity != null) 
        {
                this.name = entity.getName();
                this.id = entity.getId();
        }
    }
   

    /**
     * @return el id de la biblioteca
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el id a actualizar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre de la biblioteca.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name el nombre de la biblioteca a actualizar.
     */
    public void setName(String name) {
        this.name = name;
    }

    public BibliotecaEntity toEntity() {
        BibliotecaEntity entity = new BibliotecaEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
    /**
     * Convierte el objeto a una cadena
     *
     * @return la cadena que represnta el objeto
     */
    
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\" }";
    }
}
