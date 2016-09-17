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
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author js.numpaque10
 */
@Path("usuarios/{idUsuario \\d+}/reservas")
@Produces("application/json")
@Consumes("application/json")
public class ReservaResource {
    
    ReservaMock reservaMock = new ReservaMock();
    
    /**
     * Obtiene el listado de reservas
     * @return Lista de reservas
     * @throws CityLogicException 
     */
    @GET
    public List<ReservaDTO> getReservas(@PathParam("idUsuario")Long idUsuario) throws CityLogicException
    {
        return reservaMock.getReservas(idUsuario);
    }
    
    /**
     * Retorna una reserva con un id dado
     * @param id El id de la reserva que se desea obtener
     * @return La reserva que se deseaba obtener
     * @throws CityLogicException En caso de no haber una reserva con el ida dado o que la lista de reservas sea vacía.
     */
    @GET
    @Path("{id: \\d+}")
    public ReservaDTO getReserva(@PathParam("idUsuario")Long idUsuario,@PathParam("id") Long id) throws CityLogicException 
    {
        return reservaMock.getReserva(idUsuario,id);
    }
        
    /**
     * Agrega una reserva
     * @param nuevaReserva Reserva a agregar.
     * @return La reserva agregada.
     * @throws CityLogicException Cuando ya hay una reserva con el mismo id.
     */
    @POST
    public ReservaDTO createReserva(@PathParam("idUsuario")Long idUsuario,ReservaDTO nuevaReserva) throws CityLogicException
    {
        return reservaMock.createReserva(idUsuario,nuevaReserva);
    }
    
    /**
     * Elimina un recurso dado de la lista de reservas.
     * @param id El id del recurso que se desea eliminar.
     * @throws CityLogicException Si no encuentra un recurso con el id dado o si la lista de reservas está vacía.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("idUsuario")Long idUsuario,@PathParam("id") Long id) throws CityLogicException
    {
      reservaMock.deleteReserva(idUsuario,id);
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
    public ReservaDTO updateReserva(@PathParam("idUsuario")Long idUsuario,@PathParam("id") Long id ,ReservaDTO reservaMod) throws CityLogicException
    {
        return reservaMock.updateReserva(idUsuario, id, reservaMod);
    }
    
}
