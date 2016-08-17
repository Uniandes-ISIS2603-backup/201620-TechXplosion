/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.dtos.AlquilerDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.AlquilerMock;
import co.edu.uniandes.rest.cities.mocks.CityLogicMock;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author sa.pardo10
 */
@Path("alquileres")
@Produces("application/json")
public class AlquilerResource 
{
    AlquilerMock alquilerLogic = new AlquilerMock();

    /**
     * Obtiene el listado de ciudades.
     *
     * @return lista de ciudades
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<AlquilerDTO> getAlquileres() throws CityLogicException 
    {
        return alquilerLogic.getAlquileres();
    }

   
    /**
     * Agrega una ciudad
     *
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public AlquilerDTO createAlquiler(AlquilerDTO alquiler) throws CityLogicException 
    {
        return alquilerLogic.createAlquiler(alquiler);
    }
    
    /**
     * Elimina el alquiler con el id dado
     * @param id del alquiler a eliminar
     * @throws CityLogicException si el alquiler con el id dado no existe
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteAlquiler( @PathParam("id") Long id) throws CityLogicException 
    {
        alquilerLogic.deleteAlquiler(id);
    }
    
    /**
     * Retorna la información del alquiler buscado por id
     * @param id del alquiler buscado
     * @return alquiler con el id dado
     * @throws CityLogicException cunado no existe un alquiler con el id dado
     */
    @GET
    @Path("{id: \\d+}")
    public AlquilerDTO  getAlquiler( @PathParam("id") Long id) throws CityLogicException 
    {
        return alquilerLogic.getAlquiler(id);
    }
    /**
     * Actualiza la informacion de un alquiler con un id dado
     * @param id del alquiler a actualizar
     * @param nueva objeto con la informacion para actualizar
     * @return El alquiler con la nueva informacion
     * @throws CityLogicException si el alquiler con el id dado no existe
     */
    @PUT
    @Path("{id: \\d+}")
    public AlquilerDTO updateAlquiler(@PathParam("id") Long id,  AlquilerDTO nueva) throws CityLogicException
    {
        return alquilerLogic.updateAlquiler(id, nueva);
    }
    
    
    
    
}
