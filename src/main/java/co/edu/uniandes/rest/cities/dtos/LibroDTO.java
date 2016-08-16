/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

/**
 * Clase que guarda la informacíon de una biblioteca
 * @author js.sosa10
 */
public class LibroDTO {
    public final static boolean VIRTUAL=true;
    public final static boolean FISICO=false;
    private Long isbn;
    private String nombre;
    private String editorial;
    private String autor;
    private int edicion;
    private boolean tipo;

    /**
     * Constructor por defecto
     */
    public LibroDTO() {
	}

    /**
     * Constructor con parámetros.
     * @param isbn codico unico del libro
     * @param nombre Titulo del libro
     * @param editorial nombre de la empresa que promociona el libro
     * @param autor Nombre de  la persona que hizo el libro
     * @param edicion Numero de la edicion
     * @param tipo Si es virtual o fisico
     */
    public LibroDTO(Long isbn,String nombre, String editorial, String autor, int edicion, boolean tipo) {
		super();
		this.isbn = isbn;
                this.nombre=nombre;
		this.editorial = editorial;
                this.autor=autor;
                this.edicion=edicion;
                this.tipo=tipo;
	}

    /**
     * @return el isbn del libro
     */
    public Long getIsbn() {
        return isbn;
    }

    /**
     * @param isbn el isbn a actualizar.
     */
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    /**
     * @return el nombre de la biblioteca.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param name el nombre de la biblioteca a actualizar.
     */
    public void setNombre(String name) {
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
     * @param edicion la edicion a actualizar.
     */
    public void setEdicion(int edicion) {
        this.editorial = editorial;
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
    public void setEditorial(boolean tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Convierte el objeto a una cadena
     * @return la cadena que represnta el objeto
     */
    @Override
    public String toString() {
        String tip = getTipo()?"Virtual":"Fisico";
    	return "{ ISBN : " + getIsbn()+ ", Nombre : \"" + getNombre() + "\", Autor : \"" + getAutor() + "\", Editorial : \"" + getEditorial() + "\", Editorial : " + getEditorial()+ ", Tipo : \"" + tip + "\"}" ;  
    } 
}
