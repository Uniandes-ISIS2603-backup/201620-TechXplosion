/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import java.util.List;

/**
 *
 * @author nd.munoz10
 */
public interface IVideoLogic 
{
    public List<VideoEntity> getVideos();
    public VideoEntity getVideo(Long id);
    public List<VideoEntity> getVideoPorUsuario(Long idUsuario);
    public VideoEntity createVideo(VideoEntity entity) throws Exception;
    public VideoEntity updateVideo(VideoEntity entity);
    public void deleteVideo(Long id);

    public VideoEntity getVideo(VideoEntity entity);
    
}
