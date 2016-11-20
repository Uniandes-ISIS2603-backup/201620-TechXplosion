/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.LibroDTO;
import co.edu.uniandes.rest.cities.dtos.LibroDetailDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.techxplosion.bibliotecas.api.ILibroLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
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
import javax.ws.rs.core.MediaType;
/**
 *
 * @author jc.sanchez16
 */
@Path("libros")
@Produces(MediaType.APPLICATION_JSON)
public class LibrosResource {


    @Inject
    private ILibroLogic libroLogic;
            
            
    private List<LibroDetailDTO> listEntity2DTO(List<LibroEntity> entityList) 
   {
        List<LibroDetailDTO> list = new ArrayList<>();
        for (LibroEntity entity : entityList) {
            list.add(new LibroDetailDTO(entity));
        }
        return list;
    } 
    /**
     * Obtiene el listado de libros.
     *
     * @return lista de libros
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<LibroDetailDTO> getLibros() throws CityLogicException {
        return listEntity2DTO(libroLogic.getLibros());
    }

   
    /**
     * Agrega un libro
     *
     * @param libro  libro  a agregar
     * @return datos del  libro  a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public LibroDTO  createLibro( LibroDetailDTO libro ) throws  Exception {
        return new LibroDetailDTO (libroLogic.createLibro(libro.toEntity()));
    }
    /**
     * obtiene la infomacion del libro identificado con el id.
     * @param id del libro a buscar.
     * @return el libro identificada con el id.
     * @throws CityLogicException cunado no existe un libro con ese id.
     */
    @GET
    @Path("{id: \\d+}")
    public LibroDTO  getLibro( @PathParam("id") Long id) throws Exception {
        return new LibroDetailDTO(libroLogic.getLibro(id));
    }
     /**
     * elimina el libro identificada con el id.
     * @param id identificador del libro a eliminar.
     * @throws CityLogicException si el libro no identificado con ese id no existe.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteLibro( @PathParam("id") Long id) throws Exception {
        libroLogic.deleteLibro(id);
    }

    /**
     * Actualiza la información del libro identificada con el id.
     * @param id identificador asociado al libro a actualizar
     * @param newLibro objeto con la nueva información del libro
     * @return el libro identificado con el id.
     * @throws CityLogicException si el libro con el id dado no existe.
     */
    @PUT
    @Path("{id: \\d+}")
    public LibroDTO updateLibro(@PathParam("id") Long id, LibroDTO newLibro) throws CityLogicException
    {
        LibroEntity entity = newLibro.toEntity();
        entity.setId(id);
        return new LibroDetailDTO(libroLogic.updateLibro(entity));
    } 
}

