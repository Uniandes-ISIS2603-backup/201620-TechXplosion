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
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;

/**
 *
 * @author jm.rodriguez11
 */
@Entity
public class UsuarioEntity extends BaseEntity implements Serializable{
    
   @PodamExclude 
   @OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
   private List<ReservaEntity>reservas=new ArrayList();
   
   @PodamExclude 
   @OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
   private List<AlquilerEntity>alquileres=new ArrayList();
   
   @PodamExclude 
   @OneToMany(mappedBy="usuario",cascade=CascadeType.ALL,orphanRemoval=true)
   private List<MedioPagoEntity>mediosDePago=new ArrayList();
   
    
   private String nombre;
   private String address;
  
   
   public String getName(){
       return nombre;
   }
   public void setNombre(String nombre){
       this.nombre=nombre;
   }

   public String getAddress(){
       return address;
   }
   public void setAddress(String address){
       this.address=address;
   }

   
   
   public List<ReservaEntity> getReservas(){
       return reservas;
   }
   
   public List<MedioPagoEntity> getMedioPago(){
       return mediosDePago;
   }
   
   public void setReservas(List<ReservaEntity> reserva){
       this.reservas=reserva;
   }
    
   public List<AlquilerEntity> getAlquileres(){
       return alquileres;
   }
   public void setAlquileres(List<AlquilerEntity> alquileres){
       this.alquileres=alquileres;
   }
   
    public void setMediosDePago(List<MedioPagoEntity> medios){
       this.mediosDePago =medios;
   }
 
}
