/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
   private LibroEntity libro=new LibroEntity();
   @ManyToOne
   private VideoEntity video=new VideoEntity();
   @ManyToOne
   private UsuarioEntity usuario=new UsuarioEntity();
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
}
