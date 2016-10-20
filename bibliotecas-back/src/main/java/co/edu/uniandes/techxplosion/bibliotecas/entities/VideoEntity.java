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
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author nd.munoz10
 */
@Entity
public class VideoEntity extends BaseEntity implements Serializable
{
   @PodamExclude
   @ManyToOne
   private BibliotecaEntity biblioteca;
   
   @PodamExclude 
   @OneToMany(mappedBy="video",cascade=CascadeType.ALL,orphanRemoval=true)
   private List<AlquilerEntity>alquileres=new ArrayList();
   
   @PodamExclude 
   @OneToMany(mappedBy="video",cascade=CascadeType.ALL,orphanRemoval=true)
   private List<ReservaEntity>reservas=new ArrayList();
   
   public BibliotecaEntity getBiblioteca()
   {
       return biblioteca;
   }
   
   public List<AlquilerEntity> getAlquileres()
   {
       return alquileres;
   }
   public void setAlquileres(List<AlquilerEntity> alquileres)
   {
       this.alquileres = alquileres;
   }
   public List<ReservaEntity> getReservas()
   {
       return reservas;
   }
   public void setReserva(List<ReservaEntity> reservas)
   {
       this.reservas = reservas;
   }
   public List<AlquilerEntity> getAlquiler()
   {
       return alquileres;
   }
}
