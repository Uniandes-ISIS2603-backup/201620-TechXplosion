/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sa.pardo10
 */
@XmlRootElement
public class AlquilerDetailDTO extends AlquilerDTO 
{
    private LibroDTO libro ;


    private VideoDTO video ;
    private UsuarioDTO usuario ;
    
    public AlquilerDetailDTO()
    {
        super();
    }
    
    public AlquilerDetailDTO(AlquilerEntity entity)
    {
        super(entity);
        libro = new LibroDTO(entity.getLibro());
        video = new VideoDTO(entity.getVideo());
        usuario = new UsuarioDTO(entity.getUsuario());
    }
    
    @Override
    public AlquilerEntity toEntity()
    {
        AlquilerEntity entity = super.toEntity();
        entity.setLibro(libro.toEntity());
        entity.setVideo(video.toEntity());
        entity.setUsuario(usuario.toEntity());
        return entity;
    }
    
  
}
