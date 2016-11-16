/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.MedioPagoDTO;
import co.edu.uniandes.rest.cities.dtos.MedioPagoDetailDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.techxplosion.bibliotecas.api.IMedioPagoLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import java.util.ArrayList;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 * Clase que represnta el recurso MedioPago, que cumple con la arquitectura REST de la aplicación
 * @author js.sosa10
 */
@Path("medioPagos")
@Produces("application/json")
public class MedioPagoResource 
{
    @Inject
    private IMedioPagoLogic medioPagoLogic;
    
    private List<MedioPagoDetailDTO> listEntity2DTO(List<MedioPagoEntity> entityList) 
    {
        List<MedioPagoDetailDTO> list = new ArrayList<>();
        for (MedioPagoEntity entity : entityList) 
        {
            list.add(new MedioPagoDetailDTO(entity));
        }
        return list;
    } 
    
    /**
     * Obtiene el listado de MedioPagos.
     * @return lista de MedioPagos
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<MedioPagoDetailDTO> getMedioPagos() throws CityLogicException 
    {
        return listEntity2DTO(medioPagoLogic.getMedioPagos());
    }

   
    /**
     * Agrega una MedioPago
     * @param pMedioPago  MedioPago  a agregar
     * @return datos del MedioPago  a agregar
     * @throws CityLogicException cuando ya existe un MedioPago con el id
     * suministrado
     */
    @POST
     public MedioPagoDTO createAlquiler(MedioPagoDetailDTO pMedioPago) throws CityLogicException, Exception 
    {
        return new MedioPagoDetailDTO(medioPagoLogic.createMedioPago(pMedioPago.toEntity()));
    }
    
    /**
     * obtiene la infomacion del MedioPago identificado con el id.
     * @param id del MedioPago a buscar.
     * @return el MedioPago identificado con el id.
     * @throws CityLogicException cunado no existe un MedioPago con ese id.
     */
    @GET
    @Path("{id: \\d+}")
    public MedioPagoDetailDTO  getMedioPago( @PathParam("id") Long id) throws CityLogicException 
    {
        return new MedioPagoDetailDTO( medioPagoLogic.getMedioPago(id));
    }

    /**
     * elimina el MedioPago identificado con el id.
     * @param id identificador del MedioPago a eliminar.
     * @throws CityLogicException si el MedioPago no identificado con ese id no existe.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteMedioPago( @PathParam("id") Long id) throws CityLogicException 
    {
       medioPagoLogic.deleteMedioPago(id);
    }

    /**
     * Actualiza la información del MedioPago identificado con el id.
     * @param id identificador asociado al MedioPago a actualizar
     * @param newMedioPago objeto con la nueva información del MedioPago
     * @return el MedioPago identificado con el id.
     * @throws CityLogicException si el MedioPago con el id dado no existe.
     */
    @PUT
    public MedioPagoDetailDTO updateAlquiler(@PathParam("id") Long id,  MedioPagoDetailDTO nueva) throws CityLogicException
    {
        MedioPagoEntity entity = nueva.toEntity();
        entity.setId(id);
        return new MedioPagoDetailDTO(medioPagoLogic.updateMedioPago(entity));
    }
}
