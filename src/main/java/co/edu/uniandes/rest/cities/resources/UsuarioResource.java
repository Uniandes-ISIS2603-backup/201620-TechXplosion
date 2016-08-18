/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;


import co.edu.uniandes.rest.cities.dtos.UsuarioDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.CityLogicMock;
import co.edu.uniandes.rest.cities.mocks.UsuarioMock;
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
 * @author jm.rodriguez11
 */
@Path("usuarios")
@Produces("application/json")
public class UsuarioResource 
{
    UsuarioMock UsuarioLogic = new UsuarioMock();

    /**
     * Obtiene el listado de usuarios
     *
     * @return lista de usuarios
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<UsuarioDTO> getUsuarios() throws CityLogicException 
    {
        return UsuarioLogic.getUsuarios();
    }

   
    /**
     * Agrega una usuario
     *
     * @param usuario usuario a agregar
     * @return 
     * @throws CityLogicException cuando ya existe uno con el id
     * suministrado
     */
    @POST
    public UsuarioDTO createUsuario(UsuarioDTO usuario) throws CityLogicException 
    {
        return UsuarioLogic.createUsuario(usuario);
    }
    
    /**
     * Elimina el usuario con el id dado
     * @param id del usuario a eliminar
     * @throws CityLogicException si el usuario con el id dado no existe
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteUsuario( @PathParam("id") Long id) throws CityLogicException 
    {
        System.out.println("Hola");
        UsuarioLogic.deleteUsuario(id);
    }
    
    /**
     * Retorna la información del usuario buscado por id
     * @param id del usuario buscado
     * @return usuario  con el id dado
     * @throws CityLogicException cunado no existe un usuario con el id dado
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO  getUsuario( @PathParam("id") Long id) throws CityLogicException 
    {
        return UsuarioLogic.getUsuario(id);
    }
    /**
     * Actualiza la informacion de un usuario con un id dado
     * @param id 
     * @param nueva objeto con la informacion para actualizar
     * @return usuario
     * @throws CityLogicException si el usuario con el id dado no existe
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateUsuario(@PathParam("id") Long id,  UsuarioDTO nueva) throws CityLogicException
    {
        return UsuarioLogic.updateUsuario(id, nueva);
    }
    
    
    
    
}
