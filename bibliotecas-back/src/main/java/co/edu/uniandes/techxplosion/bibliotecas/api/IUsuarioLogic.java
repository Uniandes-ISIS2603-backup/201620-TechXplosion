/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 *
 * @author jm.rodriguez11
 */

public interface IUsuarioLogic 
{
    public List<AlquilerEntity> getAlquileres(Long usuarioId);
    public List<ReservaEntity> getReservas(Long usuarioId);
    public UsuarioEntity getUsuario(Long usuarioId);
    public List<UsuarioEntity> getUsuarios();
    public UsuarioEntity createUsuario(UsuarioEntity entity) throws Exception;
    
    public UsuarioEntity updateUsuario(UsuarioEntity entity) ;
    public void deleteUsuario(Long id);  
   public List<MedioPagoEntity> getMedioPago();
   
    
   
}
