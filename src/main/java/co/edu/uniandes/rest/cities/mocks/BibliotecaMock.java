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
	private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
	
	// listado de ciudades
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
	 * @return lista de ciudades
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
    	
    	// la nueva ciudad tiene id ?
    	if ( newBiblioteca.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (BibliotecaDTO biblioteca : bibliotecas) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(biblioteca.getId(), newBiblioteca.getId())){
	            	logger.severe("Ya existe una biblioteca con ese id");
	                throw new CityLogicException("Ya existe una biblioteca con ese id");
	            }
	        }
	        
	    // la nueva ciudad no tiene id ? 
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		long newId = 1;
	        for (BibliotecaDTO biblioteca : bibliotecas) {
	            if (newId <= biblioteca.getId()){
	                newId =  biblioteca.getId() + 1;
	            }
	        }
	        newBiblioteca.setId(newId);
    	}
    	
        // agrega la ciudad
    	logger.info("agregando ciudad " + newBiblioteca);
        bibliotecas.add(newBiblioteca);
        return newBiblioteca;
    }
    /**
	 * Obtiene el listado de bibliotecas. 
         * @param id del blog buscado
	 * @return lista de ciudades
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public BibliotecaDTO getBiblioteca(Long id) throws CityLogicException {
    	if (bibliotecas == null) {
    		logger.severe("Error interno: lista de blogs  no existe.");
    		throw new CityLogicException("Error interno: lista de blogs no existe.");    		
    	}
    	
    	logger.info("retornando el blog buscado ");
    	for (BibliotecaDTO bib : bibliotecas) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(id, bib.getId())){
                        logger.severe("el blog");
                        return bib;
                    }
                    
                  }
        logger.severe("Error interno: el blog no existe.");
    		throw new CityLogicException("Error interno: el blo no existe."); 
        
    }

}
