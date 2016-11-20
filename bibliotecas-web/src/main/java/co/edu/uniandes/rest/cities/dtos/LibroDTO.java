/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que guarda la informacíon de un libro
 *
 * @author jc.sanchez16
 */
public class LibroDTO {

    public static final boolean VIRTUAL = true;
    public static final boolean FISICO = false;
    private Long id;
    private String nombre;
    private String editorial;
    private String autor;
    private int edicion;
    private boolean tipo;    
    private List<BlogDTO> blogs =new ArrayList<>();

    /**
     * Constructor por defecto
     */
    public LibroDTO() {
         /**
     * Constructor por defecto
     */
    }

    /**
     * Constructor con parámetros.
     *
     * @param id codico unico del libro
     * @param nombre Titulo del libro
     * @param editorial nombre de la empresa que promociona el libro
     * @param autor Nombre de la persona que hizo el libro
     * @param edicion Numero de la edicion
     * @param tipo Si es virtual o fisico
     */
    public LibroDTO(Long id, String nombre, String editorial, String autor, int edicion, boolean tipo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.edicion = edicion;
        this.tipo = tipo;
    }
    
    public LibroDTO(LibroDTO libro){
        this.id = libro.getId();
        this.nombre = libro.getNombre();
        this.editorial = libro.getEditorial();
        this.autor = libro.getAutor();
        this.edicion = libro.getEdicion();
        this.tipo = libro.getTipo();        
    }
    
    public LibroDTO(LibroEntity entity) 
    {
        if (entity != null) 
        {
                this.nombre = entity.getName();
                this.id = entity.getId();
        }
    }
    /**
     * @return el isbn del libro
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el isbn a actualizar.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre de la biblioteca.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre nombre de la clase
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return la editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial la editorial a actualizar.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return la edicion
     */
    public int getEdicion() {
        return edicion;
    }

    /**
     * @param edicion edicion del libro
     */
    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    /**
     * @return el autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor el autor a actualizar.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return el tipo
     */
    public boolean getTipo() {
        return tipo;
    }

    /**
     * @param tipo el tipo a actualizar.
     */
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
     public List<BlogDTO> getBlogs() {
        return blogs;
    }
     /**
      * Metodo para actualizar a lista de blogs del libro
      * @param blogs nueva lista de blogs
      */
    public void setBlogs(List<BlogDTO> blogs) {
        this.blogs = blogs;
    }
    public LibroEntity toEntity() {
        LibroEntity entity = new LibroEntity();
        entity.setId(this.id);
        entity.setName(this.nombre);
        return entity;
    }
    /**
     * Convierte el objeto a una cadena
     *
     * @return la cadena que represnta el objeto
     */
    @Override
    public String toString() {
        String tip = getTipo() ? "Virtual" : "Fisico";
        return "{ ID : " + getId() + ", Nombre : \"" + getNombre() + "\", Autor : \"" + getAutor() + "\", Editorial : \"" + getEditorial() + "\", Editorial : " + getEditorial() + ", Tipo : \"" + tip + "\"}"+" ,Blogs\"" + getBlogs().toString();
    }
}
