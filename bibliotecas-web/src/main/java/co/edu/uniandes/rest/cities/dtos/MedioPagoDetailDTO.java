/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.MedioPagoEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sa.pardo10
 */
@XmlRootElement
public class MedioPagoDetailDTO extends MedioPagoDTO
{
    private UsuarioDTO usuario;
    
    public MedioPagoDetailDTO()
    {
        super();
    }
    
    public MedioPagoDetailDTO(MedioPagoEntity entity)
    {
        super(entity);
        usuario = new UsuarioDTO(entity.getUsuario());
    }
    @Override
    public MedioPagoEntity toEntity()
    {
        MedioPagoEntity entity = super.toEntity();
        entity.setUsuario(usuario.toEntity());
        return entity;
    }
}
