/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

import co.edu.uniandes.rest.cities.dtos.VideoDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mock del recurso Bibliotecas (Mock del servicio REST) 
 * @author nd.munoz10
 */
public class VideoMock 
{
    /**
     * Objeto que representa los logs de las operaciones realizadas.
     */
    private final static Logger logger = Logger.getLogger(VideoMock.class.getName());
    
    /**
     * Atributo que modela la lista de videos.
     */
    private static ArrayList<VideoDTO> videos;
    
    /**
     * Clase que inicializa el administrador de videos.
     */
    public VideoMock()
    {
        if (videos == null) 
        {
            videos = new ArrayList<>();
        }
    }
    
    /**
     * Método que retorna una lista de videos.
     * @return List lista con los videos.
     * @throws CityLogicException Excepción si la lista de videos no existe.
     */
    public List<VideoDTO> getVideos()throws CityLogicException
    {
        if(videos == null)
        {
            logger.severe("Error interno: lista de libros  no existe.");
    		throw new CityLogicException("Error interno: lista de libros  no existe.");
        }
        return videos;
    }
    
    /**
     * Método que se encarga de crear y añadir a la lista un video dado por parámetro.
     * @param newVideo Video que va a ser creado y añadido a la lista.
     * @return VideoDTO video creado y agregado a la lista.
     * @throws CityLogicException Excepción si ya existe un video con el mismo nombre.
     */
    public VideoDTO createVideo(VideoDTO newVideo)throws CityLogicException
    {
        logger.info("Recibiendo solicitud de agregar video " + newVideo.getNombre());

        if(newVideo.getId() != null )
        {
            for (VideoDTO video : videos) 
            {
                if (Objects.equals(video.getId(), newVideo.getId()))
                {
	            	logger.severe("Ya existe un video con ese id");
	                throw new CityLogicException("Ya existe un video con ese id");
	        }
            }
        }
        else
        {
            logger.info("Generando id para el nuevo video");
    		long newID= 0000001;
	        for (VideoDTO video : videos) 
                {
	            if (newID <= video.getId())
                    {
	                newID =  video.getId()+ 1;
	            }
	        }
	        newVideo.setId(newID);
        }
    	logger.info("Agregando video " + newVideo);
        videos.add(newVideo);
        return newVideo;
    }
    
    /**
     * Método que retorna un video con un id dado por parámetro.
     * @param id id del video que se quiere encontrar.
     * @return VideoDTO video con el id dado por parámetro.
     * @throws CityLogicException Excepción si la lista de videos no ha sido inicializada o si el video no fue encontrado.
     */
    public VideoDTO getVideo(Long id)throws CityLogicException
    {
        if(videos == null)
        {
            logger.severe("La lista de libros no ha sido inicializada.");
	                throw new CityLogicException("La lista de libros no ha sido inicializada.");
        }
        for (int i = 0; i < videos.size(); i++)
        {
            VideoDTO actual = videos.get(i);
            if(Objects.equals(actual.getId(), id))
            {
                return actual;
            }
        }
        logger.severe("No existe un video con ese id.");
	throw new CityLogicException("No existe un video con ese id.");
    }
    
    /**
     * Método que se encarda de eliminar un video de la lista con un id dado por parámetro.
     * @param id id del video que se quiere eliminar.
     * @throws CityLogicException Excepción si la lista de videos no ha sido inicializada o si el video con el id dado por parámetro no existe.
     */
    public void delete(Long id)throws CityLogicException
    {
        if(videos == null)
        {
            logger.severe("La lista de libros no ha sido inicializada.");
	                throw new CityLogicException("La lista de libros no ha sido inicializada.");
        }
        for (int i = 0; i < videos.size(); i++)
        {
            VideoDTO actual = videos.get(i);
            if(Objects.equals(actual.getId(), id))
            {
                logger.info("El video fue eliminado con éxito.");
                videos.remove(actual);
                return;
            }
        }
        logger.severe("No existe un video con ese id.");
	throw new CityLogicException("No existe un video con ese id.");
    }
    
    /**
     * Método que se encarda de cambiar la información de un video específico con información específica.
     * @param id id del video del cual se le quiere cambiar la información.
     * @param newVideo información del video que va a reemplazar al video antiguo.
     * @return VideoDTO video luego de ser actualizado.
     * @throws CityLogicException Excepción si la lista de videos no ha sido inicializada, si el id nuevo ya lo tiene algún otro video de la lista
     * o si el video que se quiere actualizar no existe.
     */
    public VideoDTO updateVideo(Long id, VideoDTO newVideo) throws CityLogicException 
    {
    	if (videos == null) 
        {
    		logger.severe("Error interno: lista de videos no existe.");
    		throw new CityLogicException("Error interno: lista de videos no existe.");    		
    	}
    	
    	 int pos = -1;
         for (int i = 0; i < videos.size(); i++) 
            {
                if(Objects.equals(videos.get(i).getId(), id))
                {
                    pos = i;
                }
                else if(Objects.equals(videos.get(i).getId(), newVideo.getId()))
                {
                    logger.info("El video con el id: " +  newVideo.getId() + " ya está en uso.");
                    throw new CityLogicException("Error interno: el video con el id: " +  newVideo.getId() + " ya está en uso.");
                }
            }
         
         if(pos != -1)
         {
             logger.info("El video fue cambiado");
             videos.set(pos, newVideo);
             return newVideo;
         }
        logger.severe("Error interno: el video con el id: " +  newVideo.getId() + " no existe.");
    	throw new CityLogicException("Error interno: el video con el id: " +  newVideo.getId() + " no existe.");
    }
}
