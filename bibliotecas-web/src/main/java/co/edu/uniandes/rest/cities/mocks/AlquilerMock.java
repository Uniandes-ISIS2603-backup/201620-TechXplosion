/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

import co.edu.uniandes.rest.cities.dtos.AlquilerDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import java.util.ArrayList;
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
    private static final Logger logger = Logger.getLogger(AlquilerMock.class.getName());
	
    // listado de alquileres
    private static ArrayList<AlquilerDTO> alquileres;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public AlquilerMock() {

    	if (alquileres == null) {
            alquileres = new ArrayList<>();
            alquileres.add(new AlquilerDTO(0L,1,0,"8/5/2016", "16/5/2016"));
            alquileres.add(new AlquilerDTO(1L,1,0,"9/5/2016", "20/5/2016"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de alquileres");
    	logger.log(Level.INFO, "alquileres{0}", alquileres);
    }    
    
	/**
	 * Obtiene el listado de alquileres del sistema. 
	 * @return lista de alquileres
	 * @throws CityLogicException cuando no existe la lista en memoria  
	 */    
    public List<AlquilerDTO> getAlquileres() throws CityLogicException 
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
    	logger.log(Level.INFO, "recibiendo solicitud de agregar alquiler {0}", nuevo);
    	if(nuevo.getId()!=null)
        {
            for (AlquilerDTO alquiler: alquileres)
            {
                if (Objects.equals(alquiler.getId(), nuevo.getId()))
                {
                    logger.severe("Ya existe un alquiler con ese id");
                    throw new CityLogicException("Ya existe un alquiler con ese id");
                }
            }
 	
        }
        else {

    		// genera un id para la biblioteca
    		logger.info("Generando id para el nuevo alquiler");
    		long newId = 1;
	        for (AlquilerDTO alquiler : alquileres) {
	            if (newId <= alquiler.getId()){
	                newId =  alquiler.getId() + 1;
	            }
	        }
	        nuevo.setId(newId);
    	}
    logger.log(Level.INFO, "agregando el alquiler:  {0}", nuevo);
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
                        logger.log(Level.SEVERE, "se borro el alquiler con id: {0}", id);
                        
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
     
     /**
     * Retorna un alquiler con un id dado.
     * @param id El id del alquiler que se dea obtener
     * @return El alquiler que se desea obtener.
     * @throws CityLogicException En caso de no haber un alquiler con el id dado o que la lista de alquileres sea vacía.
     */
    public AlquilerDTO getAlguilerUsuario(Long id) throws CityLogicException
    {
        if (alquileres == null)
        {
            logger.severe("Error: La lista de alquileres está vacia. ");
            throw new CityLogicException("Error: La lista de alquileres esta vacia. ");
        }
        else
        {
            for (AlquilerDTO alquiler : alquileres)
            {
                if (alquiler.getId().equals(id))
                {
                    return alquiler;
                }
            }
                
        }
        logger.severe("No se encontro un alquiler con el id dado.");
        throw new CityLogicException("No se encontro un alquiler con el id dado.");
    }
    
     /**
     * Elimina un alquiler dado de la lista de alquileres.
     * @param id El id del alquiler que se desea eliminar.
     * @throws CityLogicException Si no encuentra un recurso con el id dado o si la lista de reservas está vacía.
     */
    public void deleteAlquilerUsuario (Long id) throws CityLogicException
    {
        if (alquileres == null)
        {
            logger.severe("Error: La lista de alquileres esta vacia ");
            throw new CityLogicException("Error: La lista de alquileres esta vacia. ");
        }
        else
        {
            for (AlquilerDTO alquiler : alquileres) 
            {
	            if (Objects.equals(id, alquiler.getId()))
                    {
                        logger.log(Level.SEVERE, "Existe el alquiler con id: {0}", id);
                        alquileres.remove(alquiler);
                        logger.log(Level.SEVERE, "Se borro el alquiler con id: {0}", id);
                        return;
                    }
                    
            }
            logger.severe("No se encontro un alquiler con el id dado.");
            throw new CityLogicException("No se encontro un alquiler con el id dado.");
        }
       

    }
    
    /**
     * Actualiza una instancia de un alquiler.
     * @param idUsuario
     * @param id Id del alquiler que se quiere actualizar.
     * @param alquiler
     * @return La instancia del alquiler actualizada.
     * @throws CityLogicException Si la lista de alquileres es vacía, si no hay una reserva con el id dado o si el path y el id de la alquiler no coinciden.
     */
    public AlquilerDTO updateAlquilerUsuario(Long idUsuario, Long id , AlquilerDTO alquiler) throws CityLogicException
    {
        if (alquileres==null)
        {
            logger.severe("Error: La lista de alquileres está vacia ");
            throw new CityLogicException("Error: La lista de alquileres está vacia. ");
        }
        else if( !Objects.equals(id, alquiler.getId()))
        {
            logger.severe("El id del path y de la alquileres a modificar no coinciden.");
            throw new CityLogicException("El id del path y de la reserva a modificar no coinciden.");          
        }
        else
        {
            for (int i = 0 ; i < alquileres.size() ; i++)
            {
                if (Objects.equals(alquileres.get(i).getId(), id) )
                {
                    alquileres.set(i, alquiler);
                    return alquiler;
                }
            }       
        }
        logger.severe("No se encontro un alquiler con el id dado.");
        throw new CityLogicException("No se encontro un alquiler con el id dado.");
    }

}


