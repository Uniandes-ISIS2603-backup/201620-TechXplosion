/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;
/**
 *
 * @author jm.rodriguez11
 */
public class UsuarioDTO 
{
    /**
     * Atributo que modela el id del objeto
     */
    private Long id;
    /**
     * Atributo que modela el nombre del usuario
     */
    private String nombre;    
    /**
     * Constructor de la clase
     * @param pId
     * @param pNombre
     */
    public UsuarioDTO(Long pId, String pNombre)
    {
        id=pId;
       nombre = pNombre;
    }
    /**
     * Constructor vacio
     */
    public UsuarioDTO()
    {
     /**
     * Constructor vacio
     */
    }
    
    /**
     * Da el id del objeto
     * @return id del objeto
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Cambia el id del objeto
     * @param pId nuevo id del objeto
     */
    public void setId(Long pId)
    {
        id = pId;
    }
    
    /**
     * Da el inombre del usuario
     * @return nombre del usuario
     */
    public String getName()
    {
        return nombre;
    }
    
        /**
     * pone el nombre del usuario
     *  @param n
     * 
     */
    public void setName(String n)
    {
         nombre = n;
    }    
    /**
     * Retorna un string representando el objeto
     * @return 
     */
    @Override
    public String toString()
    {
        if(id == null)
        {
            id = 0L;
        }
        return "{ id: "+id+", Nombre: "+nombre+"}";
    }
}
