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
    private final static Logger logger = Logger.getLogger(CityLogicMock.class.getName());
    
    /**
     * Atributo que modela la lista de videos.
     */
    private ArrayList<VideoDTO> videos;
    
    public VideoMock()
    {
        videos = new ArrayList<VideoDTO>();
        videos.add(new VideoDTO("El Arte de la Guerra - Sun Tzu", Long.parseLong("0000001"), 90, true));
        videos.add(new VideoDTO("El Abrazo de la Serpiente", Long.parseLong("0000002"), 120, false));
        videos.add(new VideoDTO("", Long.parseLong("0000003"), 180, true));
        
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de videos.");
    	logger.info("Libros" + videos );
    }
    
    public List<VideoDTO> getVideos()throws CityLogicException
    {
        if(videos == null)
        {
            logger.severe("Error interno: lista de libros  no existe.");
    		throw new CityLogicException("Error interno: lista de libros  no existe.");
        }
        return videos;
    }
    
    public VideoDTO createVideo(VideoDTO newVideo)throws CityLogicException
    {
        logger.info("Recibiendo solicitud de agregar video " + newVideo.getNombre());

        if(newVideo.getId() != null )
        {
            for (VideoDTO video : videos) 
            {
                if (Objects.equals(video.getNombre(), newVideo.getNombre()))
                {
	            	logger.severe("Ya existe un video con ese nombre");
	                throw new CityLogicException("Ya existe un video con ese nombre");
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
                if(videos.get(i).getId() == id)
                {
                    pos = i;
                }
                else if(videos.get(i).getId() == newVideo.getId())
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
