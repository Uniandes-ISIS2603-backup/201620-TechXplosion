/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IAlquilerLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.AlquilerPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author sa.pardo10
 */
@Stateless
public class AlquilerLogic implements IAlquilerLogic
{

    @Inject
    private AlquilerPersistence persistence;
    
    @Override
    public List<AlquilerEntity> getAlquileres() 
    {
        return persistence.findAll();
    }

    @Override
    public AlquilerEntity getAlquiler(Long id) 
    {
        return persistence.find(id); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public AlquilerEntity createAlquiler(AlquilerEntity entity) throws Exception 
    {
//        AlquilerEntity alreadyExist = getAlquiler(entity.getId());
//        if (alreadyExist != null) {
//            throw new Exception("Ya existe un alquiler con ese id");
//        } else
        {
            persistence.create(entity);
        }
        return entity;
    }

    @Override
    public AlquilerEntity updateAlquiler(AlquilerEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteAlquiler(Long id) 
    {
        persistence.delete(id);
    }
    
}
