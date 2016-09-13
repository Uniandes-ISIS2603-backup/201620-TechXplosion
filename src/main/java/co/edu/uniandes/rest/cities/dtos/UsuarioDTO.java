/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import java.util.Date;

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
     * Atributo que modela la fecha
     * 
     */
    //private Date fechaNacimiento;
    /**
     * Atributo que modela la multa
     */
    //private boolean estaMultado;
    /**
     * Atributo que modela la fdireccion
     */
    //private String direccionEnvio;
    /**
     * Atributo que modela el apellido
     */
    //private String apellido;
    
    
    /**
     * Constructor de la clase
     * @param pId
     * @param pNombre
     */
    public UsuarioDTO(Long pId, String pNombre)
    {
        id=pId;
       nombre = pNombre;
       //fechaNacimiento = pDate;
       //direccionEnvio = direccion;
       //apellido = Apellido;
       //estaMultado = false;
    }
    /**
     * Constructor vacio
     */
    public UsuarioDTO()
    {
        
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
     * Cambia la fecha de  nac
     * @param pFecha nueva fecha de nac
     */
    public void setFechaNacimiento(Date pFecha)
    {
        //fechaNacimiento = pFecha;
    }
        /**
     * retorna la fecha de nacimiento
     * @return     
     */
    public Date getFechaNacimiento()
    {
        //return fechaNacimiento ;
        return null;
    }
    /**
     * Dice si esta o no multado
     * @return true si esta vencido, false de lo contrario
     */
    public boolean estaMultado()
    {
        //return estaMultado;
        return false;
    }
    
    /**
     * Cambia el estado de la variable 
     */
    public void setMulta()
    {
        //estaMultado = !estaMultado;
    }
    
    /**
     * Retorna un string representando el objeto
     * @return 
     */
    @Override
    public String toString()
    {
        return "{ id: "+id+", Nombre: "+nombre+"}";
    }
    
     /**
     * Da el apellido
     * @return apellido
     */
    public String getAp()
    {
        //return apellido;
        return null;
    }
    
        /**
     * modifica el apellido
     * @param n
     */
    public void setAp(String n)
    {
         //apellido = n;
    }
    
    
        /**
     * obtiene la direccion
     * @return direccion
     */
    public String getDireccion()
    {
        //return direccionEnvio;
        return null;
    }
    
        /**
     * modifica la direccion
     * @param n
     *
     */
    public void setdireccion(String n)
    {
         //direccionEnvio= n;
    }
}
