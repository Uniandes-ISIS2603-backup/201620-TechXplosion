/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

/**
 * Clase que representa la información de un video.
 * @author nd.munoz10
 */
public class VideoDTO 
{
    /**
     * Constante que representa si un video es virtual.
     */
    public static final boolean VIRTUAL = true;
    
    /**
     * Constante que representa si un video es físico.
     */
    public static final boolean FISICO = false;
    
    /**
     * Atributo que modela el nombre de un video.
     */
    private String nombre;
    
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
    private boolean tipo;
    
    public VideoDTO()
    {
        
    }
    
    /**
     * Constructor con parámetros.
     * @param nombre nombre del video.
     * @param id identificador del video.
     * @param duracion duracion del video dado en minutos.
     * @param tipo tipo del video, false si es físico, true si es virtual.
     */
    public VideoDTO(String nombre, Long id, double duracion, boolean tipo)
    {
        this.nombre = nombre;
        this.id = id;
        this.duracion = duracion;
        this.tipo = tipo;
    }
    
    /**
     * Metodo que devuelve el nombre del video.
     * @return nombre del video.
     */
    public String getNombre()
    {
        return nombre;
    }
    
     /**
     * Metodo que actualiza el nombre del video.
     * @param nombre nombre del nuevo video.
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
     /**
     * Metodo que devuelve el id del video.
     * @return id del video.
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Metodo que actualiza el id del video.
     * @param id id del nuevo video.
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    
    /**
     * Metodo que devuelve la duración del video.
     * @return duracion del video.
     */
    public double getDuracion()
    {
        return duracion;
    }
    
    /**
     * Metodo que actualiza la duración del video.
     * @param duracion duración del nuevo video.
     */
    public void setDuracion(double duracion)
    {
        this.duracion = duracion;
    }
    
    /**
     * Metodo que devuelve el tipo del video.
     * @return tipo del video.
     */
    public boolean getTipo()
    {
        return tipo;
    }
    
    /**
     * Metodo que actualiza el tipo del video.
     * @param tipo duración del nuevo video.
     */
    public void setTipo(boolean tipo)
    {
        this.tipo = tipo;
    }
    
    /**
     * Convierte el objeto a una cadena.
     * @return la cadena que representa el objeto.
     */
    @Override
    public String toString() 
    {
    	return "{ NOMBRE : \"" + getNombre() + "\"" + "ID : \"" + getId() + "\"" + " DURACION : " + getDuracion()+ ", TIPO : \"" + getTipo() + "\"}" ;  
    } 
}
