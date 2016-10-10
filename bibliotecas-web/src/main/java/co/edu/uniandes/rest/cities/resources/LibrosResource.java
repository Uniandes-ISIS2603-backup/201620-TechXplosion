/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.LibroDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.LibroMock;


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
 * @author jc.sanchez16
 */
@Path("libros")
@Produces("application/json")
public class LibrosResource {



    LibroMock libroLogic = new LibroMock();

    /**
     * Obtiene el listado de libros.
     *
     * @return lista de libros
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<LibroDTO> getLibros() throws CityLogicException {
        return libroLogic.getLibros();
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
    public LibroDTO  createLibro( LibroDTO  libro ) throws CityLogicException {
        return libroLogic.createLibro(libro);
    }
    /**
     * obtiene la infomacion del libro identificado con el isbn.
     * @param isbn del libro a buscar.
     * @return el libro identificada con el isbn.
     * @throws CityLogicException cunado no existe un libro con ese isbn.
     */
    @GET
    @Path("{id: \\d+}")
    public LibroDTO  getLibro( @PathParam("id") Long id) throws CityLogicException {
        return libroLogic.getLibro(id);
    }
     /**
     * elimina el libro identificada con el isbn.
     * @param isbn identificador del libro a eliminar.
     * @throws CityLogicException si el libro no identificado con ese isbn no existe.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteLibro( @PathParam("id") Long id) throws CityLogicException {
        libroLogic.deleteLibro(id);
    }

    /**
     * Actualiza la información del libro identificada con el isbn.
     * @param isbn identificador asociado al libro a actualizar
     * @param newLibro objeto con la nueva información del libro
     * @return el libro identificado con el isbn.
     * @throws CityLogicException si el libro con el isbn dado no existe.
     */
    @PUT
    @Path("{id: \\d+}")
    public LibroDTO updateLibro(@PathParam("id") Long id, LibroDTO newLibro) throws CityLogicException{
        return libroLogic.updateLibro(id, newLibro);
    } 
}

