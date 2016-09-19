
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.dtos.AlquilerDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.AlquilerMock;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("usuario/{idUsuario: \\d+}/alquileres")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

/**
 *
 * @auth nd.munoz10
 */
public class RecursoAlquilerResource
{
    
    AlquilerMock alquilerMock = new AlquilerMock();

    /**
    * Retorna una lista de alquileres asociadas a un recurso dado.
     * @param idAlquiler id del alquiler que se desea.
    * @return La lista de alquileres que se desea obtener.
    * @throws CityLogicException Si el alquiler que se busca no existe o la lista de alquileres no existe.
    */
    @GET
    @Path("{idAlquiler: \\d+}")
    public AlquilerDTO getAlquilerPorUsuario(@PathParam("idAlquiler")Long idAlquiler) throws CityLogicException 
    {
        return alquilerMock.getAlguilerUsuario(idAlquiler);
    }

    /**
     * Elimina los datos de un alquiler.
     *
     * @param id identificador del alquiler a eliminar.
     * @throws CityLogicException cuando no existe un alquiler con el id
     * suministrado
     */
    @DELETE
    @Path("{idAlquiler: \\d+}")
    public void deleteAlquilerUsuario(@PathParam("idAlquiler") Long id) throws CityLogicException 
    {
        alquilerMock.deleteAlquilerUsuario(id);
    }
    
    /**
     * Actualiza una alquiler con un id dado.
     *
     * @param idUsuario usuario del cual se va a modificar un alquiler.
     * @param id Id de la instancia que se quiere actualizar.
     * @param alquiler alquiler que va a ser modificado.
     * @return La instancia de Reserva actualizada.
     * @throws CityLogicException Si la lista de alquileres está vacía, si no hay
     * un alquiler con el id dado o si el path y el id del alquiler no
     * coinciden.
     */
    @PUT
    @Path("{id: \\d+}")
    public AlquilerDTO updateAlquilerUsuario(@PathParam("idUsuario") Long idUsuario, @PathParam("id") Long id, AlquilerDTO alquiler) throws CityLogicException {
        return alquilerMock.updateAlquilerUsuario(idUsuario, id, alquiler);
    }
    
}
