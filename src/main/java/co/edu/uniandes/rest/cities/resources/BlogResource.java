/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.BlogDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.BlogMock;


import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
/**
 *
 * @author js.sosa10
 */
@Path("blogs")
@Produces("application/json")
public class BlogResource {
    BlogMock blogLogic = new BlogMock();

    /**
     * Obtiene el listado de Blogs.
     *
     * @return lista de blogs
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<BlogDTO> getBlogs() throws CityLogicException {
        return blogLogic.getBlogs();
    }

   
    /**
     * Agrega una blog
     *
     * @param blog  blog  a agregar
     * @return datos del blog  a agregar
     * @throws CityLogicException cuando ya existe un blog con el id
     * suministrado
     */
    @POST
    public BlogDTO  createBlog( BlogDTO  blog) throws CityLogicException {
        return blogLogic.createBlog(blog);
    }
}
