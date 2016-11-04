/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.ReservaEntity;
import java.util.List;

/**
 *
 * @author js.numpaque10
 */
public interface IReservaLogic {
    
    public List<ReservaEntity> getReservas();
    public ReservaEntity getReserva(Long id);
    public ReservaEntity createReserva(ReservaEntity entity) throws Exception;
    public ReservaEntity updateReserva(ReservaEntity entity);
    public void deleteReserva(Long id);
    
}
