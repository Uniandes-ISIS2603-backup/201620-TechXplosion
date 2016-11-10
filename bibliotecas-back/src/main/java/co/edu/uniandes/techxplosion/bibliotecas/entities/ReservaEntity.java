/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.numpaque10
 */
@Entity
public class ReservaEntity extends BaseEntity implements Serializable{
    
    @PodamExclude
    @ManyToOne
    private VideoEntity video;
    @PodamExclude
    @ManyToOne
    private LibroEntity libro;
    @PodamExclude
    @ManyToOne
    private UsuarioEntity usuario;
    private String fechaSolicitud;
    
    
    /**
     * Obtiene el atributo libro.
     *
     * @return atributo libro.
     *
    */
    public LibroEntity getLibro()
    {
       return libro;
    }
    
    /**
     * Obtiene el atributo video.
     *
     * @return atributo video.
     *
    */
    public VideoEntity getVideo()
    {
       return video;
    }
    /**
     * Obtiene el atributo usuario.
     *
     * @return atributo usuario.
     *
    */
    public UsuarioEntity getUsuario()
    {
       return usuario;
    }
    
    /**
     * Obtiene el atributo fechaSolicitud.
     *
     * @return atributo fechaSolicitud.
     *
    */
    public String getFechaSolicitud()
    {
       return fechaSolicitud;
    }
    
    /**
     * Establece el valor del atributo usuario.
     *
     * @param usuario nuevo valor del atributo
     *
    */
    public void setUsuario(UsuarioEntity pUsuario)
    {
       usuario = pUsuario;
    }
    
    /**
     * Establece el valor del atributo libro.
     *
     * @param libro nuevo valor del atributo
     *
    */
    public void setLibro(LibroEntity pLibro)
    {
       libro = pLibro;
    }
    
    /**
     * Establece el valor del atributo video.
     *
     * @param video nuevo valor del atributo
     *
    */
    public void setVideo(VideoEntity pVideo)
    {
       video = pVideo;
    }
    
    /**
     * Establece el valor del atributo usuario.
     *
     * @param pFechaSolicitud nuevo valor del atributo
     *
    */
    public void setFechaSolicitud(String pFechaSolicitud)
    {
       fechaSolicitud = pFechaSolicitud;
    }
    
    
    
}
