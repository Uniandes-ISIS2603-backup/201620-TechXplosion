/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IReservaLogic;
import co.edu.uniandes.techxplosion.bibliotecas.api.IUsuarioLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.UsuarioEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.ReservaPersistence;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.UsuarioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.numpaque10
 */

@Stateless
public class ReservaLogic implements IReservaLogic {
    
    @Inject
    private ReservaPersistence persistence;
    
    @Override
    public List<ReservaEntity> getReservas() 
    {
        return persistence.findAll();
    }

    @Override
    public ReservaEntity getReserva(Long id) 
    {
        return persistence.find(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<ReservaEntity> getReservasPorVideo(Long idVideo) {
        return persistence.findAllByVideo(idVideo);
    }
    
    @Override
    public List<ReservaEntity> getReservasPorLibro(Long idLibro) {
        return persistence.findAllByLibro(idLibro);
    }
    
    @Override
    public List<ReservaEntity> getReservasPorUsuario(Long idUsuario) {
        return persistence.findAllByUsuario(idUsuario);
    }



    @Override
    public ReservaEntity createReserva(ReservaEntity entity) throws Exception 
    {
        ReservaEntity alreadyExist = getReserva(entity.getId());
        if (alreadyExist != null) {
            throw new Exception("Ya existe una reserva con ese id");
        } else
        {
            persistence.create(entity);
        }
        return entity;
    }

    @Override
    public ReservaEntity updateReserva(ReservaEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteReserva(Long id) 
    {
        persistence.delete(id);
    }

}
