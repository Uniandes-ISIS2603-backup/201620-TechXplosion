/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.BlogDTO;
import co.edu.uniandes.rest.cities.dtos.BlogDetailDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.techxplosion.bibliotecas.api.IBlogLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;
import java.util.ArrayList;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 * Clase que represnta el recurso blog, que cumple con la arquitectura REST de la aplicación
 * @author js.sosa10
 */
@Path("libros/{isbn: \\d++}/blogs")
@Produces("application/json")
public class BlogResource {
    private IBlogLogic blogLogic ;
    
    
     private List<BlogDetailDTO> listEntity2DTO(List<BlogEntity> entityList) 
   {
        List<BlogDetailDTO> list = new ArrayList<>();
        for (BlogEntity entity : entityList) {
            list.add(new BlogDetailDTO(entity));
        }
        return list;
    } 
    /**
     * Obtiene el listado de Blogs.
     * @param id id
     * @return lista de blogs
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<BlogDetailDTO> getBlogs(@PathParam("id") Long id) throws CityLogicException {
        return  listEntity2DTO(blogLogic.getBlogs());
    }

   
    /**
     * Agrega una blog
     * @param blog  blog  a agregar
     * @return datos del blog  a agregar
     * @throws CityLogicException cuando ya existe un blog con el id
     * suministrado
     */
    @POST
    public BlogDTO  createBlog( BlogDetailDTO  blog) throws CityLogicException, Exception {
        return new BlogDetailDTO (blogLogic.createBlog(blog.toEntity()));
    }
    
    /**
     * obtiene la infomacion del blog identificado con el id.
     * @param id del blog a buscar.
     * @return el blog identificado con el id.
     * @throws CityLogicException cunado no existe un blog con ese id.
     */
    @GET
    @Path("{id: \\d+}")
    public BlogDTO  getBlog(@PathParam("id") Long id) throws CityLogicException {
        return new BlogDetailDTO (blogLogic.getBlog(id)); 
    }

    /**
     * elimina el blog identificado con el id.
     * @param id identificador del blog a eliminar.
     * @throws CityLogicException si el blog no identificado con ese id no existe.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteBlog( @PathParam("id") Long id) throws CityLogicException {
        blogLogic.deleteBlog(id);
    }

    /**
     * Actualiza la información del blog identificado con el id.
     * @param id identificador asociado al blog a actualizar
     * @param newBlog objeto con la nueva información del blog
     * @return el Blog identificado con el id.
     * @throws CityLogicException si el blog con el id dado no existe.
     */
    @PUT
    @Path("{id: \\d+}")
    public BlogDTO updateBlog(@PathParam("id") Long id, BlogDTO newBlog) throws CityLogicException{
        BlogEntity entity = newBlog.toEntity();
        entity.getId();
        return new BlogDetailDTO(blogLogic.updateBlog(entity));
    }
}
