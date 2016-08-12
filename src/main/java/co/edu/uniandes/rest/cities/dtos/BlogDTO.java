/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

/**
 *
 * @author js.sosa10
 */
public class BlogDTO {
    private Long id;
    private String name;
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public BlogDTO() {
	}

    /**
     * Constructor con parámetros.
     * @param id identificador de la Biblioteca
     * @param name nombre de la Biblioteca
     * @param descripcion
     */
    public BlogDTO(Long id,String name ,String descripcion) {
		super();
		this.id = id;
		this.name = name;
                this.descripcion=descripcion;
	}

	/**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
       /**
     * @return la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param name thedescripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Convierte el objeto a una cadena
     * @return la cadena que represnta el objeto
     */
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getName() + ", descripcion : \"" + getDescripcion()+ "\" }";  
    } 
}