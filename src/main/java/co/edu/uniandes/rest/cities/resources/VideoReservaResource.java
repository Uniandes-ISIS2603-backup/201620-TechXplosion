/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.dtos.ReservaDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.ReservaMock;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("video/{idVideo: \\d+}/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @author js.numpaque10
 */
public class VideoReservaResource {
    
    ReservaMock reservaMock = new ReservaMock();
    
    /**
    * Retorna una lista de reservas asociadas a un video dado.
    * @param id El id del libro del cual se desean obtener las reservas.
    * @return La lista de reservas que se deseaba obtener.
    * @throws CityLogicException 
    */
    @GET
    public List<ReservaDTO> getReservaPorVideo(@PathParam("idVideo")Long idVideo) throws CityLogicException 
    {
        return reservaMock.getReservaPorRecurso(idVideo);
    }
    
    /**
     * Actualiza una instancia de la entidad Reserva.
     * @param id Id de la instancia que se quiere actualizar.
     * @param reservaMod La instancia de Reserva actualizada.
     * @return La instancia de Reserva actualizada.
     * @throws CityLogicException Si la lista de reservas es vacía, si no hay una reserva con el id dado o si el path y el id de la reserva no coinciden.
    */
    @PUT
    @Path("{id: \\d+}")
    public ReservaDTO updateReserva(@PathParam("idVideo") Long idVideo, @PathParam("id") Long id , ReservaDTO reservaMod) throws CityLogicException
    {
        return reservaMock.updateReserva(id, reservaMod);
    }

    /**
     * Elimina los datos de una reserva
     *
     * @param id identificador de la reserva a eliminar
     * @throws CityLogicException cuando no existe una reserva con el id dado.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("idVideo") Long idVideo, @PathParam("id") Long id) throws CityLogicException {
        reservaMock.deleteReserva(id);
    }
    
}
