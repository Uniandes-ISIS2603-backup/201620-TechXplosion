/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.entities;
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
   
   private String nombre;
   
   private Long id;
   
   private Double duracion;
   
   private String tipo;
   
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
   
   public String getNombre()
   {
       return nombre;
   }
   
   public Long getId()
   {
       return id;
   }
   
   public Double getDuracion()
   {
       return duracion;
   }
   
   public String getTipo()
   {
       return tipo;
   }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
   
   
}
