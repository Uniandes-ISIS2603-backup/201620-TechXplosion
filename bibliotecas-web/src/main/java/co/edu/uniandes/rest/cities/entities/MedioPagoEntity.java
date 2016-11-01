/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.sosa10
 */
@Entity
public class MedioPagoEntity extends BaseEntity implements Serializable{
   @PodamExclude 
   @ManyToOne
   private UsuarioEntity usuario;
   private String tipo;
   private int numero;
   private int numeroSeguridad;
   public UsuarioEntity getUsuario(){
       return usuario;
   }
   public void setUsuario(UsuarioEntity usuario){
       this.usuario=usuario;
   }
   public String getTipo(){
       return tipo;
   }
   public void setTipo(String tipo){
       this.tipo=tipo;
   }
   public int getNumero(){
       return numero;
   }
   public void setNumero(int numero){
        this.numero=numero;
   }
   public int getNumeroSeguridad(){
       return numeroSeguridad;
   }
   public void setNumeroSeguridad(int numeroSeguridad){
       this.numeroSeguridad=numeroSeguridad;
   }
}
