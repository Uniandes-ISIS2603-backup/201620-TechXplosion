/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IMedioPagoLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.MedioPagoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author sa.pardo10
 */
public class MedioPagoLogic implements IMedioPagoLogic
{
    @Inject
    private MedioPagoPersistence persistence;

    @Override
    public List<MedioPagoEntity> getMedioPagos() 
    {
        return persistence.findAll();
    }

    @Override
    public MedioPagoEntity getMedioPago(Long id) 
    {
        return persistence.find(id);
    }

    @Override
    public MedioPagoEntity createMedioPago(MedioPagoEntity entity) throws Exception 
    {
        MedioPagoEntity alreadyExist = getMedioPago(entity.getId());
        if (alreadyExist != null) 
        {
            throw new Exception("Ya existe un MedioPago con ese id");
        } 
        else
        {
            persistence.create(entity);
        }
        return entity;
    }

    @Override
    public MedioPagoEntity updateMedioPago(MedioPagoEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteMedioPago(Long id) 
    {
        persistence.delete(id);
    }
    
    
    
}
