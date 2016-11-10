/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import java.util.List;

/**
 *
 * @author js.numpaque10
 */
public class ReservaDetailDTO extends ReservaDTO {
    
    //relación con cero o un video
    private VideoDTO video;
    
    //relación con cero o una libro
    private LibroDTO libro;
    
    //relación con un usuario
    private UsuarioDTO usuario;
    
    public ReservaDetailDTO(){
        super();
    }
    
    /**
     * Crea un objeto ReservaDetailDTO a partir de un objeto ReservaEntity
     * incluyendo los atributos de ReservaDTO.
     *
     * @param entity Entidad ReservaEntity desde la cual se va a crear el nuevo
     * objeto.
     *
     */
    public ReservaDetailDTO(ReservaEntity entity) {
        super(entity);
        libro = new LibroDTO(entity.getLibro());
        video = new VideoDTO(entity.getVideo());
        usuario = new UsuarioDTO(entity.getUsuario());
    }
    
    /**
     * Convierte un objeto ReservaDetailDTO a ReservaEntity incluyendo los
     * atributos de ReservaDTO.
     *
     * @return objeto ReservaEntity.
     *
     */
    @Override
    public ReservaEntity toEntity() {
        ReservaEntity entity = super.toEntity();
        entity.setLibro(libro.toEntity());
        entity.setVideo(video.toEntity());
        entity.setUsuario(usuario.toEntity());
        return entity;
    }
    
     /**
     * @return el video asociado a la reserva
     */
    public VideoDTO getVideo() {
        return video;
    }

    /**
     * @param video el video a poner
     */
    public void setDepartments(VideoDTO video) {
        this.video = video;
    }
    
    /**
     * @return el libro asociado a la reserva
     */
    public LibroDTO getLibro() {
        return libro;
    }

    /**
     * @param libro el libro a poner
     */
    public void setLibro(LibroDTO libro) {
        this.libro = libro;
    }
    
    /**
     * @return el usuario asociado a la reserva
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * @param usuario el usuario a poner
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
}
