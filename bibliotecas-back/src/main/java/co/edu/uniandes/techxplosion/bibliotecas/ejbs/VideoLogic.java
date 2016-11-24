/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IVideoLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.VideoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author nd.munoz10
 */
@Stateless
public class VideoLogic implements IVideoLogic
{

    @Inject
    private VideoPersistence persistence;
    
    @Override
    public List<VideoEntity> getVideos() 
    {
        return persistence.findAll();
    }

    @Override
    public VideoEntity getVideo(Long id) 
    {
         return persistence.find(id); 
    }

    @Override
    public List<VideoEntity> getVideoPorUsuario(Long idUsuario) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VideoEntity createVideo(VideoEntity entity) throws Exception 
    {
//         VideoEntity alreadyExist = getVideo(entity.getId());
//        if (alreadyExist != null) 
//        {
//            throw new Exception("Ya existe un video con ese id");
//        } else
        {
            persistence.create(entity);
        }
        return entity;
    }

    @Override
    public VideoEntity updateVideo(VideoEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteVideo(Long id) 
    {
        persistence.delete(id);
    }

    @Override
    public VideoEntity getVideo(VideoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
