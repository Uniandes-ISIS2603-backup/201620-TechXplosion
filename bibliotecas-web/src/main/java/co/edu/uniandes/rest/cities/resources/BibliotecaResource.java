/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.BibliotecaDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.BibliotecaMock;


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
 * @author js.sosa10
 */
@Path("bibliotecas")
@Produces("application/json")
public class BibliotecaResource {



    BibliotecaMock bibliotecaLogic = new BibliotecaMock();

    /**
     * Obtiene el listado de Bibliotecas.
     *
     * @return lista de bibliotecas
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<BibliotecaDTO> getBibliotecas() throws CityLogicException {
        return bibliotecaLogic.getBibliotecas();
    }

   
    /**
     * Agrega una biblioteca
     *
     * @param biblioteca  biblioteca  a agregar
     * @return datos de la  biblioteca  a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public BibliotecaDTO  createBiblioteca( BibliotecaDTO  biblioteca ) throws CityLogicException {
        return bibliotecaLogic.createBiblioteca(biblioteca);
    }
    /**
     * obtiene la infomacion de la biblioteca identificado con el id.
     * @param id de la biblioteca a buscar.
     * @return la biblioteca identificada con el id.
     * @throws CityLogicException cunado no existe una biblioteca con ese id.
     */
    @GET
    @Path("{id: \\d+}")
    public BibliotecaDTO  getBiblioteca( @PathParam("id") Long id) throws CityLogicException {
        return bibliotecaLogic.getBiblioteca(id);
    }
     /**
     * elimina la biblioteca identificada con el id.
     * @param id identificador de la biblioteca a eliminar.
     * @throws CityLogicException si la biblioteca no identificado con ese id no existe.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteBiblioteca( @PathParam("id") Long id) throws CityLogicException {
        bibliotecaLogic.deleteBiblioteca(id);
    }

    /**
     * Actualiza la información dla biblioteca identificada con el id.
     * @param id identificador asociado a la biblioteca a actualizar
     * @param newBiblioteca objeto con la nueva información dla biblioteca
     * @return la biblioteca identificado con el id.
     * @throws CityLogicException si la biblioteca con el id dado no existe.
     */
    @PUT
    @Path("{id: \\d+}")
    public BibliotecaDTO updateBiblioteca(@PathParam("id") Long id, BibliotecaDTO newBiblioteca) throws CityLogicException{
        return bibliotecaLogic.updateBiblioteca(id, newBiblioteca);
    }
}

