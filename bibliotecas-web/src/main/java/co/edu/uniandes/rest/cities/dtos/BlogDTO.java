/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;


/**
 * Clase con la infomción de un blog.
 *
 * @author js.sosa10
 */
public class BlogDTO {

    private Long id;
    private String name;
    private String descripcion;
    private String comentarios;

    /**
     * Constructor por defecto
     */
    public BlogDTO() {
        /**
     * Constructor por defecto
     */
    }

    /**
     * Constructor con parámetros.
     *
     * @param id identificador del blog
     * @param name nombre de la Biblioteca
     * @param descripcion descripcion
     * @param comentarios comentarios
     */
    public BlogDTO(Long id, String name, String descripcion, String comentarios) {
        super();
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
    }
    
    public BlogDTO(BlogEntity entity)
    {
        if (entity != null) 
        {
                this.name = entity.getName();
                this.id = entity.getId();
        }
    }

    public BlogEntity toEntity() 
    {
        BlogEntity entity = new BlogEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
    
    
    /**
     * @return el identificador del blog.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre del blog
     */
    public String getName() {
        return name;
    }

    /**
     * @param name, el nombre para actualizar.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return la descripción del blog
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion, la descripcion para actualizar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Convierte el objeto a una cadena de caracteres.
     *
     * @return la cadena de caracteres que represnta el objeto
     */
    @Override
    public String toString() {
        return "{ id : " + getId() + ", name : \"" + getName() + "\", descripcion : \"" + getDescripcion() + "\" }";
    }
}
