/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.api.IAlquilerLogic;
import co.edu.uniandes.rest.cities.api.IVideoLogic;
import co.edu.uniandes.rest.cities.dtos.AlquilerDetailDTO;
import co.edu.uniandes.rest.cities.dtos.VideoDTO;
import co.edu.uniandes.rest.cities.dtos.VideoDetailDTO;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.rest.cities.dtos.VideoDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author nd.munoz10
 */
@Path("videos")
@Produces("application/json")
public class VideoResource 
{
      @Inject
    private IVideoLogic videoLogic;

   private List<VideoDetailDTO> listEntity2DTO(List<VideoEntity> entityList) 
   {
        List<VideoDetailDTO> list = new ArrayList<>();
        for (VideoEntity entity : entityList) {
            list.add(new VideoDetailDTO(entity));
        }
        return list;
    } 
      
      /**
     * Obtiene el listado de videos.
     *
     * @return lista de videos
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<VideoDetailDTO> getVideos() throws CityLogicException 
    {
        return listEntity2DTO(videoLogic.getVideos());
    }
    
     /**
     * Agrega un video nuevo
     *
     * @param video  video a agregar
     * @return datos del video a agregar
     * @throws CityLogicException cuando ya existe un video con el id
     * suministrado
     */
    @POST
    public VideoDTO  createVideo( VideoDetailDTO  video ) throws CityLogicException, Exception 
    {
         return new VideoDetailDTO(videoLogic.createVideo(video.toEntity()));
    }
    
    /**
     * Obtiene la infomacion del video identificado con el id.
     * @param id del video a buscar.
     * @return el video identificada con el id.
     * @throws CityLogicException cunado no existe un video con ese id.
     */
    @GET
    @Path("{id: \\d+}")
    public VideoDetailDTO  getVideo( @PathParam("id") Long id) throws CityLogicException 
    {
        return new VideoDetailDTO( videoLogic.getVideo(id));
    }
    
    /**
     * Elimina el video identificado con el id.
     * @param id identificador del video a eliminar.
     * @throws CityLogicException si el video identificado con ese id no existe.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void  deleteVideo( @PathParam("id") Long id) throws CityLogicException 
    {
        videoLogic.deleteVideo(id);
    }
    
     /**
     * Actualiza la información del video identificada con el id.
     * @param id identificador asociado al video a actualizar
     * @param newVideo objeto con la nueva información del video
     * @return el video identificado con el id.
     * @throws CityLogicException si el video con el id dado no existe.
     */
    @PUT
    @Path("{id: \\d+}")
    public VideoDTO updateVideo(@PathParam("id") Long id, VideoDetailDTO newVideo) throws CityLogicException
    {
        VideoEntity entity = newVideo.toEntity();
        entity.setId(id);
        return new VideoDetailDTO(videoLogic.updateVideo(entity));
    }
}
