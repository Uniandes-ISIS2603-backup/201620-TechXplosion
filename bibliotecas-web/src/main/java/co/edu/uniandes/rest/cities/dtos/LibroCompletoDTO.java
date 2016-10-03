/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js.sosa10
 */
public class LibroCompletoDTO extends LibroDTO{
    private List<BlogDTO> blogs =new ArrayList<>();
    /**
     * Constructor vacio
     */
    public LibroCompletoDTO(){
     /**
     * Constructor vacio
     */
    }

   
    /**
     * Constuctor que recibe como parametros los valores asociados al libro
     * @param isbn del libro
     * @param nombre del libro
     * @param editorial del libro
     * @param autor nombre del autor
     * @param edicion numero de la edicion del libro
     * @param tipo atributo booleano que define si el libro es electronico o no
     */
    public LibroCompletoDTO(Long isbn, String nombre, String editorial, String autor, int edicion, boolean tipo){
        super(isbn,nombre,editorial,autor,edicion,tipo);
    }
    /**
     * constructos que recibe como parametro el DTO de un libro
     * @param libro 
     */
    public LibroCompletoDTO(LibroDTO libro){
        super(libro.getIsbn(),libro.getNombre(),libro.getEditorial(),libro.getAutor(),libro.getEdicion(),libro.getTipo());
    }
    /**
     * metodo que retorna la lista de blogs del libro
     * @return blogs 
     */
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

    @Override
    public String toString() {
        return super.toString()+" ,Blogs\"" + getBlogs().toString();
    }
    
}
