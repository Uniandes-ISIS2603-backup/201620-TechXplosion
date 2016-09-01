/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import java.util.Date;

/**
 *
 * @author sa.pardo10
 */
public class AlquilerDTO 
{
    /**
     * Atributo que modela el id del objeto
     */
    private Long id;
    /**
     * Atributo que modela el id del usuario que realizo el alquiler
     */
    private int idUsuario;
    /**
     * Atributo que modela el id del recurso que se alquila
     */
    private int idRecurso;
    /**
     * Atributo que modela la fecha en la que se realizo el alquiler
     */
    private String fechaAlquiler;
    /**
     * Atributo que modela la fecha maxima en la que se debe devolver el recurso
     */
    private String fechaDevolucion;
    /**
     * Atributo que modela si el alquiler ya entro en vencimiento o no
     */
    private boolean estaVencido;
    
    
    /**
     * Constructor de la clase
     * @param pId
     * @param pIdUsuario
     * @param pIdRecurso
     * @param inicio
     * @param fin 
     */
    public AlquilerDTO(Long pId, int pIdUsuario, int pIdRecurso, String inicio, String fin)
    {
        id=pId;
        idUsuario = pIdUsuario;
        idRecurso = pIdRecurso;
        fechaAlquiler = inicio;
        fechaDevolucion = fin;
        estaVencido = false;
    }
    /**
     * Constructor vacio
     */
    public AlquilerDTO()
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
     * Da el id del usuario
     * @return id del usuario
     */
    public int getIdUsuario()
    {
        return idUsuario;
    }
    
    /**
     * Cambia el id del usuario
     * @param pIdUsuario nuevo id del usuario
     */
    public void setIdUsuario(int pIdUsuario)
    {
        idUsuario = pIdUsuario;
    }
    
    /**
     * Da el id del recurso
     * @return id del recurso
     */
    public int getIdRecurso()
    {
        return idRecurso;
    }
    
    /**
     * Cambia el id del recurso
     * @param pIdRecurso nuevo id del recurso
     */
    public void setIdRecurso(int pIdRecurso)
    {
        idRecurso = pIdRecurso;
    }
    
    /**
     * Da la fecha de alquiler del recurso
     * @return fecha de alquiler del recurso
     */
    public String getFechaAlquiler()
    {
        return fechaAlquiler;
    }
    
    /**
     * Cambia la fecha en que se alquilo el recurso
     * @param pFechaAlquiler nueva fecha de alquiler del recurso
     */
    public void setFechaAlquiler(String pFechaAlquiler)
    {
        fechaAlquiler = pFechaAlquiler;
    }
    
    /**
     * Da la fecha de devolucion maxima del recurso
     * @return fecha de devolucion maxima del recurso
     */
    public String getFechaDevolucion()
    {
        return fechaDevolucion;
    }
    
    /**
     * Cambia la fecha de devolucion maxima del recurso
     * @param pFechaDevolucion nueva fecha de devolucion maxima del recurso
     */
    public void setFechaDevolucion(String pFechaDevolucion)
    {
        fechaDevolucion = pFechaDevolucion;
    }
    
    /**
     * Dice si esta o no vencido el alquiler
     * @return true si esta vencido, false de lo contrario
     */
    public boolean estaVencido()
    {
        return estaVencido;
    }
    
    /**
     * Cambia el estado de la variable estaVencido. Si es true, ahora sera false y lo mismo en el sentido contrario
     */
    public void setOppEstaVencido()
    {
        estaVencido = !estaVencido;
    }
    
    /**
     * Retorna un string representando el objeto
     */
    @Override
    public String toString()
    {
        return "{ id: "+id+", idUsuario: "+idUsuario+", idRecurso: "+idRecurso+"}";
    }
    
    
}
