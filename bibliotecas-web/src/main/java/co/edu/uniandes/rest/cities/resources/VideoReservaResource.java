/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.dtos.ReservaDTO;
import co.edu.uniandes.rest.cities.dtos.ReservaDetailDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.techxplosion.bibliotecas.api.IReservaLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("videos/{idVideo: \\d+}/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @author js.numpaque10
 */
public class VideoReservaResource {
    
        
    @Inject 
    private IReservaLogic reservaLogic;
    
        /**
     * Convierte una lista de ReservaEntity a una lista de ReservaDetailDTO.
     *
     * @param entityList Lista de ReservaEntity a convertir.
     * @return Lista de ReservaDetailDTO convertida.
     *
     */
    private List<ReservaDetailDTO> listEntity2DTO(List<ReservaEntity> entityList) {
        List<ReservaDetailDTO> list = new ArrayList<>();
        for (ReservaEntity entity : entityList) {
            list.add(new ReservaDetailDTO(entity));
        }
        return list;
    }    
    

    /**
    * Retorna una lista de reservas asociadas a un video dado.
    * @param idVideo El id del libro del cual se desean obtener las reservas.
    * @return La lista de reservas que se deseaba obtener.
    * @throws CityLogicException 
    */
    @GET
    public List<ReservaDetailDTO> getReservaPorVideo(@PathParam("idVideo")Long idVideo) throws CityLogicException 
    {
        return listEntity2DTO(reservaLogic.getReservasByVideo(idVideo));
    }
    
    /**
     * Actualiza una instancia de la entidad Reserva.
     * @param idVideo
     * @param id Id de la instancia que se quiere actualizar.
     * @param reservaMod La instancia de Reserva actualizada.
     * @return La instancia de Reserva actualizada.
     * @throws CityLogicException Si la lista de reservas es vacía, si no hay una reserva con el id dado o si el path y el id de la reserva no coinciden.
    */
    @PUT
    @Path("{id: \\d+}")
    public ReservaDTO updateReserva(@PathParam("idVideo") Long idVideo, @PathParam("id") Long id , ReservaDTO reservaMod) throws CityLogicException
    {
        ReservaEntity entity = reservaMod.toEntity();
        entity.setId(id);
        return new ReservaDetailDTO(reservaLogic.updateReserva(entity));
    }

    /**
     * Elimina los datos de una reserva
     *
     * @param idVideo
     * @param id identificador de la reserva a eliminar
     * @throws CityLogicException cuando no existe una reserva con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("idVideo") Long idVideo, @PathParam("id") Long id) throws CityLogicException 
    {
        reservaLogic.deleteReserva(id);
    }
    
}
