
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

@Path("libros/{idLibro: \\d+}/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @author js.numpaque10
 */
public class LibroReservaResource {
    
    ReservaMock reservaMock = new ReservaMock();

    /**
    * Retorna una lista de reservas asociadas a un libro dado.
    * @param id El id del libro del cual se desean obtener las reservas.
    * @return La lista de reservas que se deseaba obtener.
    * @throws CityLogicException 
    */
    @GET
    public List<ReservaDTO> getReservaPorLibro(@PathParam("idLibro")Long idLibro) throws CityLogicException 
    {
        return reservaMock.getReservaPorRecurso(idLibro);
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
    public ReservaDTO updateReserva(@PathParam("idLibro") Long idLibro, @PathParam("id") Long id , ReservaDTO reservaMod) throws CityLogicException
    {
        return reservaMock.updateReserva(id, reservaMod);
    }

    /**
     * Elimina los datos de una reserva
     *
     * @param id identificador de la reserva a eliminar
     * @throws CityLogicException cuando no existe un libro con el id dado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("idLibro") Long idLibro, @PathParam("id") Long id) throws CityLogicException {
        reservaMock.deleteReserva(id);
    }
    
}