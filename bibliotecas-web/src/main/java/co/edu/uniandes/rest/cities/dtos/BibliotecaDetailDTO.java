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

@XmlRootElement
public class BibliotecaDetailDTO extends BibliotecaDTO 
{
    private List<VideoDTO> videos = new ArrayList();
    private List<LibroDTO> libros = new ArrayList();
    private List<UsuarioDTO>usuarios = new ArrayList();
    
    public BibliotecaDetailDTO()
    {
        super();
    }
    
    public BibliotecaDetailDTO(BibliotecaEntity entity)
    {
        super(entity);
        List<LibroEntity> librosList = entity.getLibros();
        for (LibroEntity lib : librosList) {
            this.libros.add(new LibroDTO(lib));
        }
        List<VideoEntity> videoList = entity.getVideos();
        for (VideoEntity vid : videoList) {
            this.videos.add(new VideoDTO(vid));
        }
        List<UsuarioEntity> usuarioList = entity.getUsuarios();
        for(UsuarioEntity usu: usuarioList){
            this.usuarios.add(new UsuarioDTO(usu));
        }
    }
    
    @Override
    public BibliotecaEntity toEntity()
    {        
        BibliotecaEntity entity = super.toEntity();
       List<LibroDTO> librosList = this.getLibros();
        for (LibroDTO lib : librosList) {
            entity.getLibros().add(lib.toEntity());
        }
        List<VideoDTO> videoList = this.getVideos();
        for (VideoDTO vid : videoList) {
            entity.getVideos().add(vid.toEntity());
        }
        List<UsuarioDTO> usuarioList = this.getUsuarios();
        for(UsuarioDTO usu: usuarioList){
            entity.getUsuarios().add(usu.toEntity());
        }        
        return entity;
    }
    public List<VideoDTO> getVideos()
    {
        return videos;
    }
    public List<LibroDTO> getLibros()
    {
        return libros;
    }
    public List<UsuarioDTO> getUsuarios()
    {
        return usuarios;
    }
    
     public void getVideos(List<VideoDTO> videos)
    {
        this.videos = videos;
    }
    public void getLibros(List<LibroDTO> libros)
    {
        this.libros= libros;
    }
    public void getUsuarios(List<UsuarioDTO> usuarios)
    {
        this.usuarios= usuarios;
    }
  
}
