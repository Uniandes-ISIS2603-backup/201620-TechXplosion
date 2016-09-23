/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;


import co.edu.uniandes.rest.cities.dtos.UsuarioDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Mock de la clase Alquiler (Servicio REST)
 * @author jm.rodriguez11
 */


public class UsuarioMock 
{

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(UsuarioMock.class.getName());
	
    // listado de usuarios
    private static ArrayList<UsuarioDTO> usuarios;

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public UsuarioMock() {

    	if (usuarios == null) {
            usuarios = new ArrayList<>();
            Date nueva = new Date();
            usuarios.add(new UsuarioDTO(156L, "JuanMa"));
        }
        
    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);
    	
    	// muestra información 
    	logger.info("Inicializa la lista de usuarios");
    	logger.info("usuarios" + usuarios );
    }    
    
	/**
	 * Obtiene el listado de usuarios del sistema. 
	 * @return lista
	 * @throws CityLogicException
	 */    
    public ArrayList<UsuarioDTO> getUsuarios() throws CityLogicException 
    {
    	if (usuarios == null) 
        {
    		logger.severe("Error interno: lista de usuarios no existe.");
    		throw new CityLogicException("Error interno: lista de usuarios  no existe.");    		
    	}
    	
    	logger.info("retornando todos los usuarios");
    	return usuarios;
    }

 

    /**
     * Agrega un usuario
     * @param nuevo
     * @throws CityLogicException 
     * @return usuario
     */
    public UsuarioDTO createUsuario(UsuarioDTO nuevo) throws CityLogicException 
    {
    	logger.info("recibiendo solicitud de agregar Usuario " + nuevo);
    	
            for (UsuarioDTO usuario: usuarios)
            {
                if (Objects.equals(usuario.getId(), nuevo.getId()))
                {
                    logger.severe("Ya existe un usuario con ese id");
                    throw new CityLogicException("Ya existe un usuario con ese id");
                }
            }
    	
    	logger.info("agregando el usuario:  " + nuevo);
        usuarios.add(nuevo);
        return nuevo;
    }
    /**
	 * Obtiene el usuario buscado por Id. 
         * @param id usuario
	 * @return usuario con el id dado por parametro
	 * @throws CityLogicException cuando no existe el usuario en el programa 
	 */    
    public UsuarioDTO getUsuario(Long id) throws CityLogicException
    {
    	if (usuarios == null) 
        {
    		logger.severe("Error interno: lista de usuarios no existe.");
    		throw new CityLogicException("Error interno: lista de usuarios no existe.");    		
    	}
    	
    	logger.info("retornando el usuario buscado ");
    	for (UsuarioDTO usuario: usuarios) 
        {
            if (Objects.equals(id, usuario.getId()))
            {
                return usuario;

            }
                    
        }
        logger.severe("Error interno: el usuario buscado no existe.");
    	throw new CityLogicException("Error interno: el usuario buscado no existe."); 
        
    }
    /**
     * elimina el usuario con el id suministrado de la lista.
     * @param id identificador del usuario a eliminar
     * @throws CityLogicException si la lista no existe o el user
     */
    public void deleteUsuario(Long id)throws CityLogicException{
        logger.severe("Listo para borrar usuario");
        if (usuarios == null) 
        {
    		logger.severe("Error interno: lista de usuarios no existe.");
    		throw new CityLogicException("Error interno: lista de usuarios no existe.");    		
    	}
    	boolean encontrado = false;
    	for (int i = 0 ; i < usuarios.size() && !encontrado;i++) 
        {
            UsuarioDTO usuario = usuarios.get(i);
	            if (Objects.equals(id, usuario.getId()))
                    {
                        usuarios.remove(usuario);
                        encontrado=true;
                        logger.severe("se borro el usuario con id: "+id);
                        
                    }
                    
                  }
        if(!encontrado)
        {
            logger.severe("Error interno: el usuario no existe.");
            throw new CityLogicException("Error interno: el usuario no existe."); 
        }
       
    }
    /**
     * actualiza la informacion del usr 
     * @param id identificador del usr
     * @param nueva objeto con nueva información del usr
     * @return el usr 
     * @throws CityLogicException si la lista de usr no es valida
     */
     public UsuarioDTO updateUsuario(Long id,UsuarioDTO nueva) throws CityLogicException 
     {
    	if (usuarios == null) 
        {
    		logger.severe("Error interno: lista de usuarios no existe.");
    		throw new CityLogicException("Error interno: lista de usuarios no existe.");    		
    	}
    	
    	for (UsuarioDTO usuario: usuarios) 
        {
	            if (Objects.equals(id, usuario.getId()))
                    {
                        usuarios.remove(usuario);
                        usuarios.add(nueva);
                        return nueva;
                    }
                    
        }
        logger.severe("Error interno: el usuario no existe.");
    	throw new CityLogicException("Error interno: el usuario no existe."); 
        
    }

}


