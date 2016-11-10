/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.entities;

import java.io.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author js.sosa10
 */
@Entity
public class BlogEntity extends BaseEntity implements Serializable{
   @PodamExclude 
   @ManyToOne
   private LibroEntity libro;
   private String descripcion;
   private String contenido;
   /**
    * Obtiene el atributo libro.
    * @return atributo libro.
    */
   public LibroEntity getLibro(){
       return libro;
   }
   /**
    * Establece el valor del atributo libro.
    * @param libro nuevo valor del atributo libro.
    */
   public void setLibro(LibroEntity libro){
       this.libro=libro;
   }
   /**
    * Obtiene el atributo descripcion.
    * @return atributo descripcion.
    */
   public String getDescripcion(){
       return descripcion;
   }
   /**
    * Establece el valor del atributo descripcion.
    * @param descripcion nuevo valor del atributo descripcion.
    */
   public void setDescripcion(String descripcion){
       this.descripcion=descripcion;
   }
   /**
    * Obtiene el valor del atributo contenido.
    * @return atributo contenido.
    */
   public String getContenido(){
       return contenido;
   }
   /**
    * Establece el valor del atributo contenido.
    * @param contenido nuevo valor del atributo contenido.
    */
   public void setContenido(String contenido){
       this.contenido=contenido;
   }

 
}
