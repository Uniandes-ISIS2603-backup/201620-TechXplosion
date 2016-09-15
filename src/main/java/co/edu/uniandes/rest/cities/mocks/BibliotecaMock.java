/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 *Mock del recurso Bibliotecas (Mock del servicio REST) 
 * @author js.sosa10
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.uniandes.rest.cities.dtos.BibliotecaDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
public class BibliotecaMock {
    // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(BibliotecaMock.class.getName());
	
	// listado de bibliotecaes
    private static ArrayList<BibliotecaDTO> bibliotecas;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public BibliotecaMock() {

    	if (bibliotecas == null) {
            bibliotecas = new ArrayList<>();
            bibliotecas.add(new BibliotecaDTO(1L, "Nacional"));
            bibliotecas.add(new BibliotecaDTO(2L, "Distrital"));
            bibliotecas.add(new BibliotecaDTO(3L, "Comunal"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de bibliotecas");
    	logger.info("bibliotecas" + bibliotecas );
    }    
    
	/**
	 * Obtiene el listado de bibliotecas. 
	 * @return lista de bibliotecas
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<BibliotecaDTO> getBibliotecas() throws CityLogicException {
    	if (bibliotecas == null) {
    		logger.severe("Error interno: lista de bibliotecas  no existe.");
    		throw new CityLogicException("Error interno: lista de bibliotecas  no existe.");    		
    	}
    	
    	logger.info("retornando todas las bibliotecas ");
    	return bibliotecas;
    }

 

    /**
     * Agrega una biblioteca a la lista.
     * @param newBiblioteca biblioteca a adicionar
     * @throws CityLogicException cuando ya existe una bibloteca con el id suministrado
     * @return biblioteca agregada
     */
    public BibliotecaDTO createBiblioteca(BibliotecaDTO newBiblioteca) throws CityLogicException {
    	logger.info("recibiendo solicitud de agregar biblioteca " + newBiblioteca);
    	
    	// la nueva biblioteca tiene id ?
    	if ( newBiblioteca.getId() != null ) {
	    	// busca la biblioteca con el id suministrado
	        for (BibliotecaDTO biblioteca : bibliotecas) {
	        	// si existe una biblioteca con ese id
	            if (Objects.equals(biblioteca.getId(), newBiblioteca.getId())){
	            	logger.severe("Ya existe una biblioteca con ese id");
	                throw new CityLogicException("Ya existe una biblioteca con ese id");
	            }
	        }
	        
	    // la nueva biblioteca no tiene id ? 
    	} else {

    		// genera un id para la biblioteca
    		logger.info("Generando id paa la nueva biblioteca");
    		long newId = 1;
	        for (BibliotecaDTO biblioteca : bibliotecas) {
	            if (newId <= biblioteca.getId()){
	                newId =  biblioteca.getId() + 1;
	            }
	        }
	        newBiblioteca.setId(newId);
    	}
    	
        // agrega la biblioteca
    	logger.info("agregando biblioteca " + newBiblioteca);
        bibliotecas.add(newBiblioteca);
        return newBiblioteca;
    }
    /**
	 * Obtiene el listado de bibliotecas. 
         * @param id dla biblioteca buscado
	 * @return lista de bibliotecas
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public BibliotecaDTO getBiblioteca(Long id) throws CityLogicException {
    	if (bibliotecas == null) {
    		logger.severe("Error interno: lista de bibliotecas  no existe.");
    		throw new CityLogicException("Error interno: lista de bibliotecas no existe.");    		
    	}
    	
    	logger.info("retornando la biblioteca buscado ");
    	for (BibliotecaDTO bib : bibliotecas) {
	        	// si existe una biblioteca con ese id
	            if (Objects.equals(id, bib.getId())){
                        logger.severe("la biblioteca");
                        return bib;
                    }
                    
                  }
        logger.severe("Error interno: la biblioteca no existe.");
    		throw new CityLogicException("Error interno: el blo no existe."); 
        
    }
    /**
     * elimina la biblioteca con el id suministrado de la lista.
     * @param id identificador de la biblioteca a eliminar
     * @throws CityLogicException si la lista no existe o la biblioteca con el id dado no existe
     */
    public void deleteBiblioteca(Long id)throws CityLogicException{
        if (bibliotecas == null) {
    		logger.severe("Error interno: lista de bibliotecas  no existe.");
    		throw new CityLogicException("Error interno: lista de bibliotecas no existe.");    		
    	}
    	boolean existe =false;
    	logger.info("buscando la biblioteca con el id: "+id);
    	for (BibliotecaDTO biblioteca : bibliotecas) {
	        	// si existe un biblioteca con ese id
	            if (Objects.equals(id, biblioteca.getId())){
                        logger.severe("existe la biblioteca con id: "+id);
                        bibliotecas.remove(biblioteca);
                        existe=true;
                        logger.severe("se borro la biblioteca con id: "+id);
                        break;
                    }
                    
                  }
        if(!existe){
            logger.severe("Error interno: la biblioteca no existe.");
            throw new CityLogicException("Error interno: la biblioteca no existe."); 
        }
       
    }
    /**
     * actualiza la informacion de la biblioteca con el id suministrado. 
     * @param id identificador de la biblioteca a actualizar.
     * @param newBiblioteca objeto con la nueva infomación dle biblioteca.
     * @return la biblioteca actualizada.
     * @throws CityLogicException si la lista de bibliotecas no existe o la biblioteca con el id dado no existe.
     */
     public BibliotecaDTO updateBiblioteca(Long id,BibliotecaDTO newBiblioteca) throws CityLogicException {
    	if (bibliotecas == null) {
    		logger.severe("Error interno: lista de bibliotecas  no existe.");
    		throw new CityLogicException("Error interno: lista de bibliotecas no existe.");    		
    	}
    	
    	logger.info("retornando la biblioteca buscada ");
    	for (BibliotecaDTO biblioteca : bibliotecas) {
	        	// si existe un biblioteca con ese id
	            if (Objects.equals(id, biblioteca.getId())){
                        logger.severe("la biblioteca con el id: "+id);
                        bibliotecas.remove(biblioteca);
                        bibliotecas.add(newBiblioteca);
                        return newBiblioteca;
                    }
                    
                  }
        logger.severe("Error interno: la biblioteca no existe.");
    		throw new CityLogicException("Error interno: la biblioteca no existe."); 
        
    }

}
