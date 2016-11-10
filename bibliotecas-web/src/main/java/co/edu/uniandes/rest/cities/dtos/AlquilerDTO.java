/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;


import co.edu.uniandes.techxplosion.bibliotecas.entities.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sa.pardo10
 */
@XmlRootElement
public class AlquilerDTO {

    /**
     * Atributo que modela el id del objeto
     */
    private Long id;
    /**
     * Atributo que modela el id del usuario que realizo el alquiler
     */
    private Long idUsuario;
    /**
     * Atributo que modela el id del recurso que se alquila
     */
    private Long idLibro;
    private Long idVideo;

    
    /**
     * Atributo que modela la fecha en la que se realizo el alquiler
     */
    private String fechaAlquiler;
    /**
     * Atributo que modela la fecha maxima en la que se debe devolver el recurso
     */
    private String fechaDevolucion;
    /**
     * Atributo que modela si el alquiler ya entro en vencimiento o no
     */
    private boolean estaVencido;
    
    private String name;        

    /**
     * Constructor de la clase
     *
     */
    public AlquilerDTO(AlquilerEntity entity) 
    {
        if (entity != null) 
        {
        id = entity.getId();
        idUsuario = entity.getUsuario().getId();
        idLibro = entity.getLibro().getId();
        idVideo = entity.getVideo().getId();
        fechaAlquiler = entity.getFechaAlquiler();
        fechaDevolucion = entity.getFechaDevolucion();
        estaVencido = false;
        }
    }

    public AlquilerEntity toEntity()
    {
        AlquilerEntity entity = new AlquilerEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        return entity;
    }
    
    /**
     * Constructor vacio
     */
    public AlquilerDTO() {
        /**
         * Constructor vacio
         */
    }

    /**
     * Da el id del objeto
     *
     * @return id del objeto
     */
    public Long getId() {
        return id;
    }

    /**
     * Cambia el id del objeto
     *
     * @param pId nuevo id del objeto
     */
    public void setId(Long pId) {
        id = pId;
    }

    /**
     * Da el id del usuario
     *
     * @return id del usuario
     */
    public Long getUsuario() {
        return idUsuario;
    }

    /**
     * Cambia el id del usuario
     *
     * @param pIdUsuario nuevo id del usuario
     */
    public void setUsuario(Long pUsuario) {
        idUsuario = pUsuario;
    }

   public Long getLibro() {
        return idLibro;
    }

    public void setLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Long idVideo) {
        this.idVideo = idVideo;
    }

  

    /**
     * Da la fecha de alquiler del recurso
     *
     * @return fecha de alquiler del recurso
     */
    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    /**
     * Cambia la fecha en que se alquilo el recurso
     *
     * @param pFechaAlquiler nueva fecha de alquiler del recurso
     */
    public void setFechaAlquiler(String pFechaAlquiler) {
        fechaAlquiler = pFechaAlquiler;
    }

    /**
     * Da la fecha de devolucion maxima del recurso
     *
     * @return fecha de devolucion maxima del recurso
     */
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Cambia la fecha de devolucion maxima del recurso
     *
     * @param pFechaDevolucion nueva fecha de devolucion maxima del recurso
     */
    public void setFechaDevolucion(String pFechaDevolucion) {
        fechaDevolucion = pFechaDevolucion;
    }

    /**
     * Dice si esta o no vencido el alquiler
     *
     * @return true si esta vencido, false de lo contrario
     */
    public boolean estaVencido() {
        return estaVencido;
    }

    /**
     * Cambia el estado de la variable estaVencido. Si es true, ahora sera false
     * y lo mismo en el sentido contrario
     */
    public void setOppEstaVencido() {
        estaVencido = !estaVencido;
    }

    /**
     * Retorna un string representando el objeto
     * @return 
     */
    @Override
    public String toString() {
        return "{ id: " + id + ", idUsuario: " + idUsuario + ", idRecurso: " + idLibro + "}";
    }

}
