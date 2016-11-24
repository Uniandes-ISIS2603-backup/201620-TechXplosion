/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa la información de un video.
 *
 * @author nd.munoz10
 */
@XmlRootElement
public class VideoDTO {

    /**
     * Constante que representa si un video es virtual.
     */
    public static final String VIRTUAL = "Virtual";

    /**
     * Constante que representa si un video es físico.
     */
    public static final String FISICO = "Físico";

    /**
     * Atributo que modela el nombre de un video.
     */
    private String name;

    /**
     * Atributo que modela el id de un libro.
     */
    private Long id;

    /**
     * Atributo que modela la duracion del video en minutos.
     */
    private double duracion;

    /**
     * Atributo que modela el tipo del video.
     */
    private String tipo;

    public VideoDTO() {
        /**
         * Constructor vacio
         */
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre nombre del video.
     * @param id identificador del video.
     * @param duracion duracion del video dado en minutos.
     * @param tipo tipo del video, false si es físico, true si es virtual.
     */
    public VideoDTO(String nombre, Long id, double duracion, String tipo) {
        this.name = nombre;
        this.id = id;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    /**
     * Metodo que devuelve el nombre del video.
     *
     * @return nombre del video.
     */
    public String getNombre() {
        return name;
    }

    /**
     * Metodo que actualiza el nombre del video.
     *
     * @param nombre nombre del nuevo video.
     */
    public void setNombre(String nombre) {
        this.name = nombre;
    }

    /**
     * Metodo que devuelve el id del video.
     *
     * @return id del video.
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que actualiza el id del video.
     *
     * @param id id del nuevo video.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que devuelve la duración del video.
     *
     * @return duracion del video.
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * Metodo que actualiza la duración del video.
     *
     * @param duracion duración del nuevo video.
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo que devuelve el tipo del video.
     *
     * @return tipo del video.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo que actualiza el tipo del video.
     *
     * @param tipo duración del nuevo video.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public VideoDTO(VideoEntity entity) 
    {
        if (entity != null) 
        {
        id = entity.getId();
        name = entity.getName();
        duracion = entity.getDuracion();
        tipo = entity.getTipo();
        }
    }
    
     public VideoEntity toEntity()
    {
        VideoEntity entity = new VideoEntity();
        entity.setId(this.id);
        entity.setNombre(this.name);
        entity.setDuracion(this.duracion);
        entity.setTipo(this.tipo);
        return entity;
    }

    /**
     * Convierte el objeto a una cadena.
     *
     * @return la cadena que representa el objeto.
     */
    @Override
    public String toString() {
        return "{ NOMBRE : \"" + getNombre() + "\"" + "ID : \"" + getId() + "\"" + " DURACION : " + getDuracion() + ", TIPO : \"" + getTipo() + "\"}";
    }
}
