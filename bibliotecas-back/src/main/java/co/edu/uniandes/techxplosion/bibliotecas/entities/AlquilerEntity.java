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
 * @author sa.pardo10
 */
@Entity
public class AlquilerEntity extends BaseEntity implements Serializable
{ 
   @ManyToOne
   @PodamExclude
   private LibroEntity libro;
   @ManyToOne
   @PodamExclude
   private VideoEntity video;
   @ManyToOne
   @PodamExclude
   private UsuarioEntity usuario;
   private String fechaAlquiler;
   private String fechaDevolucion;
    
   public LibroEntity getLibro()
   {
       return libro;
   }
   public VideoEntity getVideo()
   {
       return video;
   }
   public UsuarioEntity getUsuario()
   {
       return usuario;
   }
   public void setUsuario(UsuarioEntity usu)
   {
       usuario=usu;
   }
   public void setVideo(VideoEntity vid)
   {
       video=vid;
   }
   public void setLibro(LibroEntity lib)
   {
       libro=lib;
   }
   public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
     public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
