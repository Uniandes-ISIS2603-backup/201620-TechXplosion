/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IUsuarioLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.UsuarioEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.UsuarioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jm.rodriguez11
 */
@Stateless
public class UsuarioLogic implements IUsuarioLogic
{

    @Inject
    private UsuarioPersistence persistence;
    
    @Override
     public List<ReservaEntity> getReservas(Long usuarioId)
    {
        return persistence.findAllByUsuario( usuarioId);
    }

    @Override
    public List<AlquilerEntity> getAlquileres(Long usuarioId) 
    {
        return persistence.findAllByUser(usuarioId);
    }
    @Override
    public UsuarioEntity getUsuario(Long usuarioId)
    {
        return persistence.find(usuarioId);
    }
    @Override
    public List getUsuarios()
    {
        return persistence.findAll();
    }

    @Override
    public UsuarioEntity createUsuario(UsuarioEntity entity) throws Exception 
    {
        UsuarioEntity alreadyExist = getUsuario(entity.getId());
        if (alreadyExist != null) {
            throw new Exception("Ya existe un Usuario con ese id");
        } else
        {
            persistence.create(entity);
        }
        return entity;
    }

    @Override
    public UsuarioEntity updateUsuario(UsuarioEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteUsuario(Long id) 
    {
        persistence.delete(id);
    }
    @Override
    public List<MedioPagoEntity> getMedioPago()
    {
        List<MedioPagoEntity> ab ;
        ab = new ArrayList<MedioPagoEntity>();
       return  ab;
    }
    
    
    
}
