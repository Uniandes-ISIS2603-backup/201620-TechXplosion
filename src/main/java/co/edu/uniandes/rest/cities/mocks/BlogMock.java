/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 * Mock del recurso Blog (Mock del servicio REST) 
 * @author js.sosa10
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import co.edu.uniandes.rest.cities.dtos.BlogDTO;
import co.edu.uniandes.rest.cities.dtos.LibroCompletoDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
public class BlogMock {
     // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(BlogMock.class.getName());	
	// listado de blogs
    private static ArrayList<BlogDTO> blogs;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public BlogMock() {

    	if (blogs == null) {
            blogs  = new ArrayList<>();
            blogs.add(new BlogDTO(1L, "Cien años de soledad","este blog es de literatura colombiana","comentario1"));
            blogs.add(new BlogDTO(2L, "El jugador","blog de discuición de la obra","comentario2"));
            blogs.add(new BlogDTO(3L, "Crimen y castigo","blog de spoilers","comentario3"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de blogs");
    	logger.info("blogs" + blogs );
    }    
    
	/**
	 * Obtiene el listado de blogs. 
	 * @return lista de blogs
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<BlogDTO> getBlogs(Long isbn) throws CityLogicException {
    	if (blogs == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	
    	logger.info("retornando todos los blogs ");
    	return blogs;
    }

 

    /**
     * Agrega un blog a la lista.
     * @param newBlog blog a adicionar
     * @throws CityLogicException cuando ya existe un blog con el id suministrado
     * @return blog agregado
     */
    public BlogDTO createBlog(Long isbn,BlogDTO newBlog) throws CityLogicException {
    	logger.info("recibiendo solicitud de agregar blog " + newBlog);
    	
    	// el nuevo blog tiene id ?
    	if ( newBlog.getId() != null ) {
	    	// busca el blog con el id suministrado
	        for (BlogDTO blog : blogs) {
	        	// si existe un blog con ese id
	            if (Objects.equals(blog.getId(), newBlog.getId())){
	            	logger.severe("Ya existe una blog con ese id");
	                throw new CityLogicException("Ya existe una blog con ese id");
	            }
	        }
	        
	    // el nuevo blog no tiene id ? 
    	} else {

    		// genera un id para el blog
    		logger.info("Generando id para el nuevo blog");
    		long newId = 1;
	        for (BlogDTO blog : blogs) {
	            if (newId <= blog.getId()){
	                newId =  blog.getId() + 1;
	            }
	        }
	        newBlog.setId(newId);
    	}
    	
        // agrega el blog
    	logger.info("agregando blog " + newBlog);
        blogs.add(newBlog);
        return newBlog;
    }
    /**
	 * Obtiene el listado de blogs. 
         * @param id del blog buscado
	 * @return blog con el id suministrado
	 * @throws CityLogicException cuando no existe la lista en memoria o no existe el blog 
	 */    
    public BlogDTO getBlog(Long isbn,Long id) throws CityLogicException {
    	if (blogs == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	
    	logger.info("retornando el blog buscado ");
    	for (BlogDTO blog : blogs) {
	        	// si existe un blog  con ese id
	            if (Objects.equals(id, blog.getId())){
                        logger.severe("el blog buscado: "+blog);
                        return blog;
                    }
                    
                  }
        logger.severe("Error interno: el blog no existe.");
    		throw new CityLogicException("Error interno: el blog no existe."); 
        
    }
    /**
     * elimina el blog con el id suministrado de la lista.
     * @param id identificador del blog a eliminar
     * @throws CityLogicException si la lista no existe o el blog con el id dado no existe
     */
    public void deleteBlog(Long isbn,Long id)throws CityLogicException{
        if (blogs == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	boolean existe =false;
    	logger.info("buscando el blog con el id: "+id);
    	for (BlogDTO blog : blogs) {
	        	// si existe un blog con ese id
	            if (Objects.equals(id, blog.getId())){
                        logger.severe("existe el blog con id: "+id);
                        blogs.remove(blog);
                        existe=true;
                        logger.severe("se borro el blog con id: "+id);
                        break;
                    }
                    
                  }
        if(!existe){
            logger.severe("Error interno: el blog no existe.");
            throw new CityLogicException("Error interno: el blog no existe."); 
        }
       
    }
    /**
     * actualiza la informacion del blog con el id suministrado. 
     * @param id identificador del blog a actualizar.
     * @param newBlog objeto con la nueva infomación dle blog.
     * @return el blog actualizado.
     * @throws CityLogicException si la lista de blogs no existe o el blog con el id dado no existe.
     */
     public BlogDTO updateBlog(Long isbn,Long id,BlogDTO newBlog) throws CityLogicException {
    	if (blogs == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	
    	logger.info("retornando el blog buscado ");
    	for (BlogDTO blog : blogs) {
	        	// si existe un blog con ese id
	            if (Objects.equals(id, blog.getId())){
                        logger.severe("el blog");
                        blogs.remove(blog);
                        blogs.add(newBlog);
                        return newBlog;
                    }
                    
                  }
        logger.severe("Error interno: el blog no existe.");
    		throw new CityLogicException("Error interno: el blog no existe."); 
        
    }
     public List<BlogDTO> updateBolgsLibro(Long id, List<BlogDTO> updateBlogs) throws CityLogicException{
         logger.info("recibiendo la solicitud de modificar los blogs del del libro "+id);
         LibroMock lbm = LibroMock.getInstance();
         LibroCompletoDTO  libro= lbm.getLibro(id);
         libro.setBlogs(updateBlogs);
         return updateBlogs;
     }
     public List<BlogDTO> getBlogsLibro(Long id) throws CityLogicException{
         LibroMock lbm = LibroMock.getInstance();
         LibroCompletoDTO libro = lbm.getLibro(id);
         return libro.getBlogs();
     }

}
