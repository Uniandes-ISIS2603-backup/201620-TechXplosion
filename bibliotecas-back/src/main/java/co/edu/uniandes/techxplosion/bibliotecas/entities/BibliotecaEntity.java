/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.entities;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author js.sosa10
 */
@Entity
public class BibliotecaEntity extends BaseEntity implements Serializable{
   @PodamExclude 
   @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
   private List<LibroEntity>libros=new ArrayList();
   @PodamExclude 
   @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
   private List<VideoEntity>videos=new ArrayList();
   @PodamExclude 
   @OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
   private List<UsuarioEntity>usuarios=new ArrayList();
   public List<LibroEntity> getLibros(){
       return libros;
   }
   public void setLibros(List<LibroEntity> libros){
       this.libros=libros;
   }
   public List<VideoEntity> getVideos(){
       return videos;
   }
   public void setVideos(List<VideoEntity> videos){
       this.videos=videos;
   }
   public List<UsuarioEntity> getUsuarios(){
       return usuarios;
   }
   public void setUsuarios(List<UsuarioEntity> ususarios){
       this.usuarios=ususarios;
   }
}
