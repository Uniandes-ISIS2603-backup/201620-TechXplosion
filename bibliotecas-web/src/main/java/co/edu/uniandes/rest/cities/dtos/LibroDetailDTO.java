/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LibroDetailDTO extends LibroDTO 
{
    private BibliotecaDTO biblioteca;
    private List<AlquilerDTO> alquileres = new ArrayList();
    private List<BlogDTO> blogs = new ArrayList();
    private List<ReservaDTO> reservas = new ArrayList();
    
    public LibroDetailDTO()
    {
        super();
    }
    
    public LibroDetailDTO(LibroEntity entity)
    {
        super(entity);
        if (entity.getBiblioteca()!= null) {
            this.biblioteca = new BibliotecaDTO(entity.getBiblioteca());
        }
    }
    
    @Override
    public LibroEntity toEntity()
    {
        
        LibroEntity entity = super.toEntity();
        if (this.getBiblioteca() != null) {
            entity.setBiblioteca(this.getBiblioteca().toEntity());
        }
        
        return entity;
    }

    public BibliotecaDTO getBiblioteca() 
    {
       return biblioteca;
    }
    public List<AlquilerDTO> getAlquileres()
    {
        return alquileres;
    }
    public List<ReservaDTO> getReservas()
    {
        return reservas;
    }
    public List<BlogDTO> getBlogs()
    {
        return blogs;
    }
    
    public void setBiblioteca(BibliotecaDTO biblioteca)
    {
        this.biblioteca = biblioteca;
    }
    public void setAlquileres(List<AlquilerDTO> alquileres)
    {
        this.alquileres= alquileres;
    }
    public void setReservas(List<ReservaDTO> reservas)
    {
        this.reservas= reservas;
    }
    public void setBlogs(List<BlogDTO> blogs)
    {
        this.blogs= blogs;
    }
  
}
