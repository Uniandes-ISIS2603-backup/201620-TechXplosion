/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 *Mock del recurso MedioPago (Mock del servicio REST) 
 * @author js.sosa10
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import co.edu.uniandes.rest.cities.dtos.MedioPagoDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
public class MedioPagoMock {
     // objeto para presentar logs de las operaciones
	private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());	
	// listado de MedioPagos
    private static ArrayList<MedioPagoDTO> MedioPagos;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public MedioPagoMock() {

    	if (MedioPagos == null) {
            MedioPagos  = new ArrayList<>();
            MedioPagos.add(new MedioPagoDTO(1L, "credito", 1, 1));
            MedioPagos.add(new MedioPagoDTO(2L, "debito",2,2));
            MedioPagos.add(new MedioPagoDTO(3L, "bitcoins",3,3));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de Medios de Pagos");
    	logger.info("Medios de Pagos" + MedioPagos );
    }    
    
	/**
	 * Obtiene el listado de MedioPagos. 
	 * @return lista de MedioPagos
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<MedioPagoDTO> getMedioPagos() throws CityLogicException {
    	if (MedioPagos == null) {
    		logger.severe("Error interno: lista de MedioPagos  no existe.");
    		throw new CityLogicException("Error interno: lista de MedioPagos no existe.");    		
    	}
    	
    	logger.info("retornando todos los MedioPagos ");
    	return MedioPagos;
    }

 

    /**
     * Agrega un MedioPago a la lista.
     * @param newMedioPago MedioPago a adicionar
     * @throws CityLogicException cuando ya existe un MedioPago con el id suministrado
     * @return MedioPago agregado
     */
    public MedioPagoDTO createMedioPago(MedioPagoDTO newMedioPago) throws CityLogicException {
    	logger.info("recibiendo solicitud de agregar MedioPago " + newMedioPago);
    	
    	// el nuevo MedioPago tiene id ?
    	if ( newMedioPago.getId() != null ) {
	    	// busca el MedioPago con el id suministrado
	        for (MedioPagoDTO MedioPago : MedioPagos) {
	        	// si existe un MedioPago con ese id
	            if (Objects.equals(MedioPago.getId(), newMedioPago.getId())){
	            	logger.severe("Ya existe una MedioPago con ese id");
	                throw new CityLogicException("Ya existe una MedioPago con ese id");
	            }
	        }
	        
	    // el nuevo MedioPago no tiene id ? 
    	} else {

    		// genera un id para el MedioPago
    		logger.info("Generando id para el nuevo MedioPago");
    		long newId = 1;
	        for (MedioPagoDTO MedioPago : MedioPagos) {
	            if (newId <= MedioPago.getId()){
	                newId =  MedioPago.getId() + 1;
	            }
	        }
	        newMedioPago.setId(newId);
    	}
    	
        // agrega el MedioPago
    	logger.info("agregando MedioPago " + newMedioPago);
        MedioPagos.add(newMedioPago);
        return newMedioPago;
    }
    /**
	 * Obtiene el listado de MedioPagos. 
         * @param id del MedioPago buscado
	 * @return MedioPago con el id suministrado
	 * @throws CityLogicException cuando no existe la lista en memoria o no existe el MedioPago 
	 */    
    public MedioPagoDTO getMedioPago(Long id) throws CityLogicException {
    	if (MedioPagos == null) {
    		logger.severe("Error interno: lista de MedioPagos  no existe.");
    		throw new CityLogicException("Error interno: lista de MedioPagos no existe.");    		
    	}
    	
    	logger.info("retornando el MedioPago buscado ");
    	for (MedioPagoDTO MedioPago : MedioPagos) {
	        	// si existe un MedioPago  con ese id
	            if (Objects.equals(id, MedioPago.getId())){
                        logger.severe("el MedioPago buscado: "+MedioPago);
                        return MedioPago;
                    }
                    
                  }
        logger.severe("Error interno: el MedioPago no existe.");
    		throw new CityLogicException("Error interno: el MedioPago no existe."); 
        
    }
    /**
     * elimina el MedioPago con el id suministrado de la lista.
     * @param id identificador del MedioPago a eliminar
     * @throws CityLogicException si la lista no existe o el MedioPago con el id dado no existe
     */
    public void deleteMedioPago(Long id)throws CityLogicException{
        if (MedioPagos == null) {
    		logger.severe("Error interno: lista de MedioPagos  no existe.");
    		throw new CityLogicException("Error interno: lista de MedioPagos no existe.");    		
    	}
    	boolean existe =false;
    	logger.info("buscando el MedioPago con el id: "+id);
    	for (MedioPagoDTO MedioPago : MedioPagos) {
	        	// si existe un MedioPago con ese id
	            if (Objects.equals(id, MedioPago.getId())){
                        logger.severe("existe el MedioPago con id: "+id);
                        MedioPagos.remove(MedioPago);
                        existe=true;
                        logger.severe("se borro el MedioPago con id: "+id);
                        break;
                    }
                    
                  }
        if(!existe){
            logger.severe("Error interno: el MedioPago no existe.");
            throw new CityLogicException("Error interno: el MedioPago no existe."); 
        }
       
    }
    /**
     * actualiza la informacion del MedioPago con el id suministrado. 
     * @param id identificador del MedioPago a actualizar.
     * @param newMedioPago objeto con la nueva infomación dle MedioPago.
     * @return el MedioPago actualizado.
     * @throws CityLogicException si la lista de MedioPagos no existe o el MedioPago con el id dado no existe.
     */
     public MedioPagoDTO updateMedioPago(Long id,MedioPagoDTO newMedioPago) throws CityLogicException {
    	if (MedioPagos == null) {
    		logger.severe("Error interno: lista de MedioPagos  no existe.");
    		throw new CityLogicException("Error interno: lista de MedioPagos no existe.");    		
    	}
    	
    	logger.info("retornando el MedioPago buscado ");
    	for (MedioPagoDTO MedioPago : MedioPagos) {
	        	// si existe un MedioPago con ese id
	            if (Objects.equals(id, MedioPago.getId())){
                        logger.severe("el MedioPago");
                        MedioPagos.remove(MedioPago);
                        MedioPagos.add(newMedioPago);
                        return newMedioPago;
                    }
                    
                  }
        logger.severe("Error interno: el MedioPago no existe.");
    		throw new CityLogicException("Error interno: el MedioPago no existe."); 
        
    }
}
