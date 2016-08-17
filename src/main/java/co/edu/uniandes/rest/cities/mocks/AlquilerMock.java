/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

import co.edu.uniandes.rest.cities.dtos.AlquilerDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mock de la clase Alquiler (Servicio REST)
 * @author sa.pardo10
 */


public class AlquilerMock 
{

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
	
    // listado de alquileres
    private static ArrayList<AlquilerDTO> alquileres;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public AlquilerMock() {

    	if (alquileres == null) {
            alquileres = new ArrayList<>();
            alquileres.add(new AlquilerDTO(0,1,0,new Date(0), new Date(1000000)));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de alquileres");
    	logger.info("alquileres" + alquileres );
    }    
    
	/**
	 * Obtiene el listado de alquileres del sistema. 
	 * @return lista de alquileres
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public ArrayList<AlquilerDTO> getAlquileres() throws CityLogicException 
    {
    	if (alquileres == null) 
        {
    		logger.severe("Error interno: lista de alquileres  no existe.");
    		throw new CityLogicException("Error interno: lista de alquileres  no existe.");    		
    	}
    	
    	logger.info("retornando todos los alquileres");
    	return alquileres;
    }

 

    /**
     * Agrega un alquiler la lista.
     * @param nuevo nuevo alquilar para agregar a la lista
     * @throws CityLogicException cuando ya existe un alquiler con el id suministrado
     * @return alquiler agregado
     */
    public AlquilerDTO createAlquiler(AlquilerDTO nuevo) throws CityLogicException 
    {
    	logger.info("recibiendo solicitud de agregar alquiler " + nuevo);
    	
            for (AlquilerDTO alquiler: alquileres)
            {
                if (Objects.equals(alquiler.getId(), nuevo.getId()))
                {
                    logger.severe("Ya existe un alquiler con ese id");
                    throw new CityLogicException("Ya existe un alquiler con ese id");
                }
            }
    	
    	logger.info("agregando el alquiler:  " + nuevo);
        alquileres.add(nuevo);
        return nuevo;
    }
    /**
	 * Obtiene el alquiler buscado por Id. 
         * @param id del alquiler buscado
	 * @return alquiler con el id dado por parametro
	 * @throws CityLogicException cuando no existe el alquiler en el programa 
	 */    
    public AlquilerDTO getAlquiler(Long id) throws CityLogicException
    {
    	if (alquileres == null) 
        {
    		logger.severe("Error interno: lista de alquileres no existe.");
    		throw new CityLogicException("Error interno: lista de alquileres no existe.");    		
    	}
    	
    	logger.info("retornando el alquiler buscado ");
    	for (AlquilerDTO alquiler: alquileres) 
        {
            if (Objects.equals(id, alquiler.getId()))
            {
                return alquiler;

            }
                    
        }
        logger.severe("Error interno: el alquiler buscado no existe.");
    	throw new CityLogicException("Error interno: el alquiler buscado no existe."); 
        
    }
    /**
     * elimina el alquiler con el id suministrado de la lista.
     * @param id identificador del alquiler a eliminar
     * @throws CityLogicException si la lista no existe o el alquiler con el id dado no existe
     */
    public void deleteAlquiler(Long id)throws CityLogicException{
        if (alquileres == null) 
        {
    		logger.severe("Error interno: lista de alquileres no existe.");
    		throw new CityLogicException("Error interno: lista de alquileres no existe.");    		
    	}
    	boolean encontrado = false;
    	for (int i = 0 ; i < alquileres.size() && !encontrado;i++) 
        {
            AlquilerDTO alquiler = alquileres.get(i);
	            if (Objects.equals(id, alquiler.getId()))
                    {
                        alquileres.remove(alquiler);
                        encontrado=true;
                        logger.severe("se borro el alquiler con id: "+id);
                        
                    }
                    
                  }
        if(!encontrado)
        {
            logger.severe("Error interno: el alquiler no existe.");
            throw new CityLogicException("Error interno: el alquiler no existe."); 
        }
       
    }
    /**
     * actualiza la informacion del alquiler con el id suministrado. 
     * @param id identificador del alquiler a actualizar.
     * @param nueva objeto con nueva información del alquiler
     * @return el alquiler actualizado
     * @throws CityLogicException si la lista de alquileres no esta inicializado, o no se encuentra el alquiler por ese id
     */
     public AlquilerDTO updateAlquiler(Long id,AlquilerDTO nueva) throws CityLogicException 
     {
    	if (alquileres == null) 
        {
    		logger.severe("Error interno: lista de alquileres no existe.");
    		throw new CityLogicException("Error interno: lista de alquileres no existe.");    		
    	}
    	
    	for (AlquilerDTO alquiler : alquileres) 
        {
	            if (Objects.equals(id, alquiler.getId()))
                    {
                        alquileres.remove(alquiler);
                        alquileres.add(nueva);
                        return nueva;
                    }
                    
        }
        logger.severe("Error interno: el alquiler no existe.");
    	throw new CityLogicException("Error interno: el alquiler no existe."); 
        
    }

}


