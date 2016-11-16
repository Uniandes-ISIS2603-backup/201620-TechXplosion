/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import java.util.List;

/**
 *
 * @author sa.pardo10
 */
public interface IMedioPagoLogic 
{
    public List<MedioPagoEntity> getMedioPago();
    public MedioPagoEntity getMedioPago(Long id);
    public MedioPagoEntity createMedioPago(MedioPagoEntity entity) throws Exception;
    public MedioPagoEntity updateMedioPago(MedioPagoEntity entity);
    public void deleteMedioPago(Long id);
}
