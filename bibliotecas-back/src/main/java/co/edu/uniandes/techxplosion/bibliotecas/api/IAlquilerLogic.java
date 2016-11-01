/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import java.util.List;

/**
 *
 * @author sa.pardo10
 */
public interface IAlquilerLogic 
{
    public List<AlquilerEntity> getAlquileres();
    public AlquilerEntity getAlquiler(Long id);
    public List<AlquilerEntity> getAlquilerPorUsuario(Long idUsuario);
    public AlquilerEntity createAlquiler(AlquilerEntity entity) throws Exception;
    public AlquilerEntity updateAlquiler(AlquilerEntity entity);
    public void deleteAlquiler(Long id);
    
}
