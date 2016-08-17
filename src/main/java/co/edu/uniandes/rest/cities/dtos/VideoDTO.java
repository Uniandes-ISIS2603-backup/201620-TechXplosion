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
    public static final boolean VIRTUAL = true;
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
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public double getDuracion()
    {
        return duracion;
    }
    
    public void setDuracion(double duracion)
    {
        this.duracion = duracion;
    }
    
    public boolean getTipo()
    {
        return tipo;
    }
    
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
