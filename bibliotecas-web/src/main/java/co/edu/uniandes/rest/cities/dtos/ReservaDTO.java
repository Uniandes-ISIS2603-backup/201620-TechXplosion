/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author js.numpaque10
 */
@XmlRootElement
public class ReservaDTO {

    private Long id;
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
     * Crea un objeto ReservaDTO a partir de un objeto ReservaEntity.
     *
     * @param entity Entidad ReservaEntity desde la cual se va a crear el nuevo
     * objeto.
     * 
     */
    public ReservaDTO(ReservaEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.fechaSolicitud = entity.getFechaSolicitud();
        }
    }
    
    /**
     * Convierte un objeto ReservaDTO a ReservaEntity.
     *
     * @return Nueva objeto ReservaEntity.
     * 
     */
    public ReservaEntity toEntity() {
        ReservaEntity entity = new ReservaEntity();
        entity.setId(this.getId());
        entity.setFechaSolicitud(this.getFechaSolicitud());
        return entity;
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


}
