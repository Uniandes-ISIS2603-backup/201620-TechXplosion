/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;


import co.edu.uniandes.rest.cities.dtos.UsuarioDTO;
import co.edu.uniandes.rest.cities.dtos.UsuarioDetailDTO;
import co.edu.uniandes.techxplosion.bibliotecas.entities.UsuarioEntity;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.techxplosion.bibliotecas.api.IUsuarioLogic;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
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
//@Path("usuarios/{idUsuario: \\d+}/usuarios")
@Path("usuarios")
@Produces("application/json")
public class UsuarioResource 
{
    @Inject
    private IUsuarioLogic usuarioLogic;

   private List<UsuarioDetailDTO> listEntity2DTO(List<UsuarioEntity> entityList) {
        List<UsuarioDetailDTO> list = new ArrayList<>();
        for (UsuarioEntity entity : entityList) {
            list.add(new UsuarioDetailDTO(entity));
        }
        return list;
    } 
    
    /**
     * Obtiene el listado de usuarios.
     *
     * @return lista de usuarios
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<UsuarioDetailDTO> getUsuarios(/**@PathParam("idUsuario")Long idLibro**/) throws CityLogicException 
    {
        return listEntity2DTO(usuarioLogic.getUsuarios());
    }

   
    /**
     * Agrega un usuario
     *
     * @param pUsuario usuario a agregar
     * @return datos del usuario a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public UsuarioDTO createUsuario(UsuarioDetailDTO pUsuario) throws CityLogicException, Exception 
    {
        try
        {
            return new UsuarioDetailDTO(usuarioLogic.createUsuario(pUsuario.toEntity()));
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
        return null;
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
        usuarioLogic.deleteUsuario(id);
    }
    
    /**
     * Retorna la información del usuario buscado por id
     * @param id del usuario buscado
     * @return usuario con el id dado
     * @throws CityLogicException cunado no existe un usuario con el id dado
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDetailDTO  getUsuario( @PathParam("id") Long id) throws CityLogicException 
    {
        return new UsuarioDetailDTO( usuarioLogic.getUsuario(id));
    }
    /**
     * Actualiza la informacion de un usuario con un id dado
     * @param id del usuario a actualizar
     * @param nueva objeto con la informacion para actualizar
     * @return El usuario con la nueva informacion
     * @throws CityLogicException si el usuario con el id dado no existe
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDetailDTO updateUsuario(@PathParam("id") Long id,  UsuarioDetailDTO nueva) throws CityLogicException
    {
        UsuarioEntity entity = nueva.toEntity();
        entity.setId(id);
        return new UsuarioDetailDTO(usuarioLogic.updateUsuario(entity));
    }
    
    
    
    
}
