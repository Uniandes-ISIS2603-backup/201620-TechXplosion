/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 *
 * @author js.numpaque10
 */

import co.edu.uniandes.rest.cities.dtos.ReservaDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaMock {
    
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(ReservaMock.class.getName());
    // Listado de Reservas
    private static ArrayList<ReservaDTO> reservas;
    
    /**
     * Constructor
     */
    public ReservaMock()
    {
     	if (reservas == null) {
            reservas = new ArrayList<>();
            reservas.add(new ReservaDTO(1L,1L,1L,"01-01-2016"));
            reservas.add(new ReservaDTO(2L,2L,2L,"01-02-2016"));
            reservas.add(new ReservaDTO(3L,3L,3L,"01-03-2016"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de reservas");
    	logger.info("reservas" + reservas );  	
    }
    
    /**
     * Obtiene el listado de reservas.
     * @return Lista de reservas
     * @throws CityLogicException Cuando la listas de reservas no ha sido inicializada.
     */
    public List<ReservaDTO> getReservas() throws CityLogicException
    {
        if (reservas==null)
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
        }
        else
        {
            logger.info("Retornando todas las reservas. ");
            return reservas;
        }
    }
    
   /**
    * Agrega una nueva reserva a la lista.
    * @param nuevaReserva Reserva a adicionar.
    * @return La reserva que se ha adicionado.
    * @throws CityLogicException Cuando hay una reserva existente con el id suministrado.
    */
    public ReservaDTO createReserva( ReservaDTO nuevaReserva ) throws CityLogicException
    {
        logger.info("Recibiendo solicitud de agregar nueva reserva. " + nuevaReserva);
        if (nuevaReserva.getId() != null)
        {
            for (ReservaDTO reserva : reservas)
            {
                if (Objects.equals(reserva.getId(),nuevaReserva.getId()))
                {
                    logger.severe(("Ya existe una reserva con ese id. "));
                    throw new CityLogicException("Ya existe una reserva con ese id. ");
                }
            }
        }
        else
        {
            logger.info("Generando id para la nueva Reserva. ");
            long newId = 1;
	        for (ReservaDTO reserva : reservas) {
	            if (newId <= reserva.getId()){
	                newId =  reserva.getId() + 1;
	            }
	        }
	        nuevaReserva.setId(newId);
        }
        logger.info("Agregando reserva " + nuevaReserva);
        reservas.add(nuevaReserva);
        return nuevaReserva;
    }
    
    /**
     * Retorna un reserva con un id dado.
     * @param id El id de la reserva que se dea obtener
     * @return La reserva que se deseaba obtener.
     * @throws CityLogicException En caso de no haber una reserva con el ida dado o que la lista de reservas sea vacía.
     */
    public ReservaDTO getReserva(Long id) throws CityLogicException
    {
        if (reservas==null)
        {
            logger.severe("Error: La lista de reservas está vacia. ");
            throw new CityLogicException("Error: La lista de reservas esta vacia. ");
        }
        else
        {
            for (ReservaDTO reserva : reservas)
            {
                if (reserva.getId().equals(id))
                {
                    return reserva;
                }
            }
                
        }
        logger.severe("No se encontro una reserva con el id dado.");
        throw new CityLogicException("No se encontro una reserva con el id dado.");
    }
        
    /**
     * Elimina un recurso dado de la lista de reservas.
     * @param id El id del recurso que se desea eliminar.
     * @throws CityLogicException Si no encuentra un recurso con el id dado o si la lista de reservas está vacía.
     */
    public void deleteReserva (Long id) throws CityLogicException
    {
        boolean isIdInArray = false;
        if (reservas==null)
        {
            logger.severe("Error: La lista de reservas esta vacia ");
            throw new CityLogicException("Error: La lista de reservas esta vacia. ");
        }
        else
        {
            for (ReservaDTO reserva : reservas) {
	        	// si existe una reserva con ese id
	            if (Objects.equals(id, reserva.getId())){
                        logger.severe("Existe la reserva con id: "+id);
                        reservas.remove(reserva);
                        isIdInArray=true;
                        logger.severe("Se borro la reserva con id: "+id);
                        break;
                    }
                    
                  }               
        }
        if (!isIdInArray)
        {
            logger.severe("No se encontro una reserva con el id dado.");
            throw new CityLogicException("No se encontro una reserva con el id dado.");
        }

    }
    
    /**
     * Actualiza una instancia de la entidad Reserva.
     * @param id Id de la instancia que se quiere actualizar.
     * @param reservaMod La instancia de Reserva actualizada.
     * @return La instancia de Reserva actualizada.
     * @throws CityLogicException Si la lista de reservas es vacía, si no hay una reserva con el id dado o si el path y el id de la reserva no coinciden.
     */
    public ReservaDTO updateReserva(Long id , ReservaDTO reservaMod) throws CityLogicException
    {
        if (reservas==null)
        {
            logger.severe("Error: La lista de reservas esta vacia ");
            throw new CityLogicException("Error: La lista de reservas esta vacia. ");
        }
        else if( id != reservaMod.getId())
        {
            logger.severe("El id del path y de la reserva a modificar no coinciden.");
            throw new CityLogicException("El id del path y de la reserva a modificar no coinciden.");          
        }
        else
        {
            for (int i = 0 ; i < reservas.size() ; i++)
            {
                if (reservas.get(i).getId() == id )
                {
                    reservas.set(i, reservaMod);
                    return reservaMod;
                }
            }       
        }
        logger.severe("No se encontro una reserva con el id dado.");
        throw new CityLogicException("No se encontro una reserva con el id dado.");
    }
    
    
}

