/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;


/**
 *
 * @author js.numpaque10
 */
public class ReservaDTO {

    private Long id;
    private Long idUsuario;
    private Long idRecurso;
    private String fechaSolicitud;

    /**
     * Constructor por defecto
     */
    public ReservaDTO() {
        /**
     * Constructor por defecto
     */
    }

    /**
     *
     * @param id Identificador de la reserva.
     * @param idUsuario Identificador de quien realiza la reserva.
     * @param idRecurso Identificador del recurso reservado.
     * @param fechaSolicitud Fecha de reserva.
     */
    public ReservaDTO(Long id, Long idUsuario, Long idRecurso, String fechaSolicitud) {
        super();
        this.id = id;
        this.idUsuario = idUsuario;
        this.idRecurso = idRecurso;
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * @return El id de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El id de la reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El id del usuario que hizo la reserva.
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario El id del usuario que hizo la reserva.
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return El id del recurso que fue reservado.
     */
    public Long getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso El id del recurso que fue reservado.
     */
    public void setIdRecurso(Long idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * @return Fecha de solicitud de la reserva.
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * @param fechaSolicitud Fecha de solicitud de la reserva.
     */
    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    /**
     * Convierte el objeto a una cadena
     * @return string
     */
    @Override
    public String toString() {
        return "{ id: " + getId() + ", idUsuario : \"" + getIdUsuario() + "\"" + ", idRecurso : \"" + getIdRecurso() + "\"" + ", fechaSolicitud : \"" + getFechaSolicitud() + "\"}";
    }

}
