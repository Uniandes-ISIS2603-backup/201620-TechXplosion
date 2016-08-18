/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 *Mock del recurso Libro (Mock del servicio REST) 
 * @author jc.sanchez16
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.uniandes.rest.cities.dtos.LibroDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
public class LibroMock {
    // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
	
	// listado de libros
    private static ArrayList<LibroDTO> libros;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public LibroMock() {

    	if (libros == null) {
            libros = new ArrayList<>();
            libros.add(new LibroDTO((Long.parseLong("0000001")), "Cien años de soledad", "createSpace", "Gabriel Garcia Marquez", 2, false));
            libros.add(new LibroDTO((Long.parseLong("0000002")), "El jugador", "akal", "Fiodor M.", 4, true));
            libros.add(new LibroDTO((Long.parseLong("0000003")), "Crimen y castigo", "Encuentro", "Jose Cabrera", 0, false));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de bibliotecas");
    	logger.info("Libros" + libros );
    }    
    
	/**
	 * Obtiene el listado de libros. 
	 * @return lista de libros
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<LibroDTO> getLibros() throws CityLogicException {
    	if (libros == null) {
    		logger.severe("Error interno: lista de libros  no existe.");
    		throw new CityLogicException("Error interno: lista de libros  no existe.");    		
    	}
    	
    	logger.info("retornando todas los libros ");
    	return libros;
    }

 

    /**
     * Agrega un libro a la lista.
     * @param newLibro libro a adicionar
     * @throws CityLogicException cuando ya existe una bibloteca con el id suministrado
     * @return libro agregada
     */
    public LibroDTO createLibro(LibroDTO newLibro) throws CityLogicException {
    	logger.info("recibiendo solicitud de agregar libro " + newLibro);
    	
    	// el nuevo libro tiene isbn ?
    	if ( newLibro.getIsbn() != null ) {
	    	// busca la biblioteca con el ismn suministrado
	        for (LibroDTO libro : libros) {
	        	// si existe una biblioteca con ese isbn
	            if (Objects.equals(libro.getIsbn(), newLibro.getIsbn())){
	            	logger.severe("Ya existe un libro con ese ISBN");
	                throw new CityLogicException("Ya existe un libro con ese ISBN");
	            }
	        }
	        
	    // el nuevo libro no tiene isbn ? 
    	} else {

    		// genera un id para el libro
    		logger.info("Generando isbn para el nuevo libro");
    		long newISBN= 0000001;
	        for (LibroDTO libro : libros) {
	            if (newISBN <= libro.getIsbn()){
	                newISBN =  libro.getIsbn()+ 1;
	            }
	        }
	        newLibro.setIsbn(newISBN);
    	}
    	
        // agrega el libro
    	logger.info("agregando libro " + newLibro);
        libros.add(newLibro);
        return newLibro;
    }
    /**
	 * Obtiene el libro. 
         * @param isbn del libro buscado
	 * @return libro
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public LibroDTO getLibro(Long isbn) throws CityLogicException {
    	if (libros == null) {
    		logger.severe("Error interno: lista de libros  no existe.");
    		throw new CityLogicException("Error interno: lista de libros no existe.");    		
    	}
    	
    	logger.info("retornando la biblioteca buscado ");
    	for (LibroDTO libro : libros) {
	        	// si existe una biblioteca con ese id
	            if (Objects.equals(isbn, libro.getIsbn())){
                        logger.severe("el libro");
                        return libro;
                    }
                    
                  }
        logger.severe("Error interno: el libro no existe.");
    		throw new CityLogicException("Error interno: el libro no existe."); 
        
    }
    /**
     * elimina el libro con el isbn suministrado de la lista.
     * @param isbn identificador del libro a eliminar
     * @throws CityLogicException si la lista no existe o el libro con el isbn dado no existe
     */
    public void deleteLibro(Long isbn)throws CityLogicException{
        if (libros == null) {
    		logger.severe("Error interno: lista de libros  no existe.");
    		throw new CityLogicException("Error interno: lista de libros no existe.");    		
    	}
    	boolean existe =false;
    	logger.info("buscando el libro con el isbnd: "+isbn);
    	for (LibroDTO libro : libros) {
	        	// si existe un biblioteca con ese id
	            if (Objects.equals(isbn, libro.getIsbn())){
                        logger.severe("existe el libro con isbn: "+isbn);
                        LibroMock.libros.remove(libro);
                        existe=true;
                        logger.severe("se borro el libro con isbn: "+isbn);
                        break;
                    }
                    
                  }
        if(!existe){
            logger.severe("Error interno: el libro no existe.");
            throw new CityLogicException("Error interno: el libro no existe."); 
        }
       
    }
    /**
     * actualiza la informacion del libro con el id suministrado. 
     * @param isbn identificador del libro a actualizar.
     * @param newLibro objeto con la nueva infomación dle libro.
     * @return el libro actualizada.
     * @throws CityLogicException si la lista de libros no existe o el libro con el isbn dado no existe.
     */
     public LibroDTO updateLibro(Long isbn,LibroDTO newLibro) throws CityLogicException {
    	if (libros == null) {
    		logger.severe("Error interno: lista de libros  no existe.");
    		throw new CityLogicException("Error interno: lista de libros no existe.");    		
    	}
    	
    	logger.info("retornando el libro buscada ");
    	for (LibroDTO libro : libros) {
	        	// si existe un biblioteca con ese id
	            if (Objects.equals(isbn, libro.getIsbn())){
                        logger.severe("el libro con el isbn: "+isbn);
                        libros.remove(libro);
                        libros.add(newLibro);
                        return newLibro;
                    }
                    
                  }
        logger.severe("Error interno: el libro no existe.");
    		throw new CityLogicException("Error interno: el libro no existe."); 
        
    }

}
