
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

@Path("libro/{idLibro: \\d+}/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @author js.numpaque10
 */
public class RecursoReservaResource {
    
    ReservaMock reservaMock = new ReservaMock();

    /**
    * Retorna una lista de reservas asociadas a un recurso dado.
    * @param id El id del recurso que se desea obtener.
    * @return La lista de reservas que se deseaba obtener.
    * @throws CityLogicException 
    */
    @GET
    public List<ReservaDTO> getReservaPorRecurso(@PathParam("idRecurso")Long idRecurso) throws CityLogicException 
    {
        return reservaMock.getReservaPorRecurso(idRecurso);
    }

    /**
     * Elimina los datos de una reserva
     *
     * @param id identificador de el author a eliminar
     * @throws BookLogicException cuando no existe un author con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReservaRecurso(@PathParam("id") Long id) throws CityLogicException {
        
    }
    
}
