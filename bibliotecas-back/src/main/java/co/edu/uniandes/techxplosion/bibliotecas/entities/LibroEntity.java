/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author 
 */
@Entity
public class LibroEntity extends BaseEntity implements Serializable{
    
    @ManyToOne
    private BibliotecaEntity biblioteca;
    
    @PodamExclude
    @OneToMany(mappedBy="libro", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<BlogEntity> blogs = new ArrayList(); 
    
    @PodamExclude
    @OneToMany(mappedBy="libro", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<BlogEntity> reservas = new ArrayList(); 
    
    public BibliotecaEntity getBiblioteca() 
    {
        return biblioteca;
    }
    public void setBiblioteca(BibliotecaEntity biblioteca) 
    {
        this.biblioteca = biblioteca;
    }
    public List<BlogEntity> getBlogs() 
    {
        return blogs;
    }
    public void setBlogs(List<BlogEntity> blogs) 
    {
        this.blogs = blogs;
    }
    public List<BlogEntity> getReservas() 
    {
        return reservas;
    }
    public void setReservas(List<BlogEntity> reservas) 
    {
        this.reservas = reservas;
    }
}
