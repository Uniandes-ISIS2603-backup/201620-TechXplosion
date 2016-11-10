/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jm.rodriguez11
 */
@XmlRootElement
public class UsuarioDetailDTO extends UsuarioDTO 
{
    private List<AlquilerDTO> alquiler = new ArrayList();
    private List<ReservaDTO> reserva = new ArrayList();
    
    public UsuarioDetailDTO()
    {
        super();
    }
    
    public UsuarioDetailDTO(UsuarioEntity entity)
    {
        super(entity);
    }
    
    @Override
    public UsuarioEntity toEntity()
    {
        UsuarioEntity entity = super.toEntity();
        for (int i = 0; i < alquiler.size(); i++) 
        {         
            entity.getAlquileres().add(alquiler.get(i).toEntity());
        }
        for (int i = 0; i < reserva.size(); i++) 
        {         
            entity.getReservas().add(reserva.get(i).toEntity());
        }
        return entity;
    }
    
  
}
