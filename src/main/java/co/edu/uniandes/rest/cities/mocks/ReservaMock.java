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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaMock {
    
    // Objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
    // Listado de Reservas
    private static ArrayList<ReservaDTO> reservas;
    
    /**
     * Constructor
     */
    public ReservaMock()
    {
    	
        reservas = new ArrayList<>();
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de reservas");
    	logger.info("reservas " + reservas );
    }
    
    /**
     * Obtiene el listado de reservas.
     * @return Lista de reservas
     * @throws CityLogicException Cuando la listas de reservas no ha sido inicializada.
     */
    public List<ReservaDTO> getReservas() throws CityLogicException
    {
        if (reservas.isEmpty())
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
            logger.info("Generando id para la nueva ciudad. ");
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
     * Obtiene las reservas hechas en una fecha dada
     * @param fechaSolicitud Fecha por la cual se desea buscar una nueva reserva.
     * @return La lista de reservas hechas en la fecha dada.
     * @throws CityLogicException En caso de no haber reservas para esa fecha o que la lista de reservas este vacia.
     */
    public List<ReservaDTO> getReservasPorFecha(Date fechaSolicitud) throws CityLogicException
    {
        ArrayList <ReservaDTO> reservasPorFecha = new ArrayList<>();
        if (reservas.isEmpty())
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
        }
        else
        {
            for (ReservaDTO reserva : reservas)
            {
                if (reserva.getFechaSolicitud().equals(fechaSolicitud))
                {
                    reservasPorFecha.add(reserva);
                }
            }
                
        }
        if (reservasPorFecha.isEmpty())
        {
            logger.severe("No hay reservas hechas en esa fecha.");
            throw new CityLogicException("No hay reservas para esa fecha.");
        }
        else
        {
            return reservasPorFecha;
        }
    }
    
    /**
     * Retorna un reserva con un id dado.
     * @param id El id de la reserva que se dea obtener
     * @return La reserva que se deseaba obtener.
     * @throws CityLogicException En caso de no haber una reserva con el ida dado o que la lista de reservas sea vacía.
     */
    public ReservaDTO getReserva(Long id) throws CityLogicException
    {
        if (reservas.isEmpty())
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
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
        logger.severe("No se encontró una reserva con el id dado.");
        throw new CityLogicException("No se encontró una reserva con el id dado.");
    }
    /**
     * Obtiene las reservas que tiene un recurso en especifico.
     * @param idRecurso El id del recurso del cual queremos obtener sus reservas.
     * @return Lista de reservas que tiene un recurso dado.
     * @throws CityLogicException En caso de que no hayan reservas para ese recurso o que la lista de reservas esté vacía.
     */
    public ArrayList<ReservaDTO> getReservasPorRecurso(Long idRecurso) throws CityLogicException
    {
        ArrayList <ReservaDTO> reservasPorRecurso = new ArrayList<>();
        if (reservas.isEmpty())
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
        }
        else
        {
            for (ReservaDTO reserva : reservas)
            {
                if (reserva.getIdRecurso().equals(idRecurso))
                {
                    reservasPorRecurso.add(reserva);
                }
            }
                
        }
        if (reservasPorRecurso.isEmpty())
        {
            logger.severe("No hay reservas hechas en esa fecha.");
            throw new CityLogicException("No hay reservas para esa fecha.");
        }
        else
        {
            return reservasPorRecurso;
        }
    }
    
    /**
     * Obtiene las reservas que tiene un usuario en especifico.
     * @param idUsuario El id del usuario del cual queremos obtener sus reservas.
     * @return Lista de reservas que tiene un usuario dado.
     * @throws CityLogicException En caso de que no hayan reservas para ese usuario o que la lista de reservas esté vacía.
     */
    public ArrayList<ReservaDTO> getReservasPorUsuario(Long idUsuario) throws CityLogicException
    {
        ArrayList <ReservaDTO> reservasPorUsuario = new ArrayList<>();
        if (reservas.isEmpty())
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
        }
        else
        {
            for (ReservaDTO reserva : reservas)
            {
                if (reserva.getIdUsuario().equals(idUsuario))
                {
                    reservasPorUsuario.add(reserva);
                }
            }
                
        }
        if (reservasPorUsuario.isEmpty())
        {
            logger.severe("No hay reservas hechas en esa fecha.");
            throw new CityLogicException("No hay reservas para esa fecha.");
        }
        else
        {
            return reservasPorUsuario;
        }
    }
    
    /**
     * Elimina un recurso dado de la lista de reservas.
     * @param id El id del recurso que se desea eliminar.
     * @throws CityLogicException Si no encuentra un recurso con el id dado o si la lista de reservas está vacía.
     */
    public void deleteReserva (Long id) throws CityLogicException
    {
        boolean isIdInArray = false;
        if (reservas.isEmpty())
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
        }
        else
        {
            for (ReservaDTO reserva : reservas)
            {
                if (reserva.getId().equals(id))
                {
                    isIdInArray = true;
                    reservas.remove(reserva);
                    break;
                }
            }
                
        }
        if (isIdInArray == false )
        {
            logger.severe("No se encontró una reserva con el id dado.");
            throw new CityLogicException("No se encontró una reserva con el id dado.");
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
        if (reservas.isEmpty())
        {
            logger.severe("Error: La lista de reservas está vacía ");
            throw new CityLogicException("Error: La lista de reservas está vacía. ");
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
        logger.severe("No se encontró una reserva con el id dado.");
        throw new CityLogicException("No se encontró una reserva con el id dado.");
    }
    
    
}

