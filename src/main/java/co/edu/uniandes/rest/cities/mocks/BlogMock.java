/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 *
 * @author js.sosa10
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;



import co.edu.uniandes.rest.cities.dtos.BlogDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
public class BlogMock {
     // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
	
	// listado de ciudades
    private static ArrayList<BlogDTO> blogs;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public BlogMock() {

    	if (blogs == null) {
            blogs  = new ArrayList<>();
            blogs.add(new BlogDTO(1L, "Cien años de soledad","este blog es de literatura colombiana"));
            blogs.add(new BlogDTO(2L, "El jugador","blog de discuición de la obra"));
            blogs.add(new BlogDTO(3L, "Crimen y castigo","blog de spoilers"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de blogs");
    	logger.info("blogs" + blogs );
    }    
    
	/**
	 * Obtiene el listado de bibliotecas. 
	 * @return lista de ciudades
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<BlogDTO> getBlogs() throws CityLogicException {
    	if (blogs == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	
    	logger.info("retornando todas los blogs ");
    	return blogs;
    }

 

    /**
     * Agrega una biblioteca a la lista.
     * @param newBiblioteca biblioteca a adicionar
     * @throws CityLogicException cuando ya existe una bibloteca con el id suministrado
     * @return biblioteca agregada
     */
    public BlogDTO createBlog(BlogDTO newBlog) throws CityLogicException {
    	logger.info("recibiendo solicitud de agregar blog " + newBlog);
    	
    	// la nueva ciudad tiene id ?
    	if ( newBlog.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (BlogDTO blog : blogs) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(blog.getId(), newBlog.getId())){
	            	logger.severe("Ya existe una blog con ese id");
	                throw new CityLogicException("Ya existe una blog con ese id");
	            }
	        }
	        
	    // la nueva ciudad no tiene id ? 
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id para el nuevo blog");
    		long newId = 1;
	        for (BlogDTO blog : blogs) {
	            if (newId <= blog.getId()){
	                newId =  blog.getId() + 1;
	            }
	        }
	        newBlog.setId(newId);
    	}
    	
        // agrega la ciudad
    	logger.info("agregando blog " + newBlog);
        blogs.add(newBlog);
        return newBlog;
    }
    /**
	 * Obtiene el listado de bibliotecas. 
         * @param id del blog buscado
	 * @return lista de ciudades
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public BlogDTO getBlog(Long id) throws CityLogicException {
    	if (blogs == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	
    	logger.info("retornando el blog buscado ");
    	for (BlogDTO blog : blogs) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(id, blog.getId())){
                        logger.severe("el blog");
                        return blog;
                    }
                    
                  }
        logger.severe("Error interno: el blog no existe.");
    		throw new CityLogicException("Error interno: el blo no existe."); 
        
    }

}
