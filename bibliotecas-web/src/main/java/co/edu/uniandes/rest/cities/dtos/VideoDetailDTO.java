/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.*;
import com.gs.collections.impl.list.fixed.ArrayAdapter;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nd.munoz10
 */
@XmlRootElement
public class VideoDetailDTO extends VideoDTO 
{
    private List<AlquilerDTO> alquiler = new ArrayList<AlquilerDTO>();
    private List<ReservaDTO> reserva = new ArrayList<ReservaDTO>();
    private BibliotecaDTO biblioteca;
    
    public VideoDetailDTO()
    {
        super();
    }
    
    public VideoDetailDTO(VideoEntity entity)
    {
        super(entity);
        List<AlquilerEntity> alquilerList = entity.getAlquileres();
        for (AlquilerEntity lib : alquilerList)
        {
            this.alquiler.add(new AlquilerDTO(lib));
        }
        List<ReservaEntity> reservaList = entity.getReservas();
        for (ReservaEntity vid : reservaList)
        {
            this.reserva.add(new ReservaDTO(vid));
        }
        biblioteca = new BibliotecaDTO(entity.getBiblioteca());
    }
    
    @Override
    public VideoEntity toEntity()
    {
        VideoEntity entity = super.toEntity();
        
       List<AlquilerDTO> alquilerList = this.getAlquiler();
        for (AlquilerDTO alq : alquilerList)
        {
            entity.getAlquileres().add(alq.toEntity());
        }
        
        List<ReservaDTO> reservaList = this.getReserva();
        for (ReservaDTO res : reservaList) 
        {
            entity.getReservas().add(res.toEntity());
        }
        entity.setBibliotecas(biblioteca.toEntity());
        System.out.println(biblioteca + " HOLAAAAAAA");
       
        return entity;
    }
    
    public List<ReservaDTO> getReserva()
    {
        return reserva;
    }
    public List<AlquilerDTO> getAlquiler()
    {
        return alquiler;
    }
    public BibliotecaDTO getBiblioteca()
    {
        return biblioteca;
    }
    
     public void setReserva(List<ReservaDTO> reserva)
    {
        this.reserva = reserva;
    }
    public void setAlquiler(List<AlquilerDTO> alquiler)
    {
        this.alquiler = alquiler;
    }
    public void setBiblioteca(BibliotecaDTO biblioteca)
    {
        this.biblioteca = biblioteca;
    }
    
  
}
