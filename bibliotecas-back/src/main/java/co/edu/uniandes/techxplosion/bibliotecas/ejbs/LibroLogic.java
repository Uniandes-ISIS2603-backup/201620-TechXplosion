/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.ILibroLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.AlquilerEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.VideoEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.LibroPersistence;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.VideoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LibroLogic implements ILibroLogic
{

    @Inject
    private LibroPersistence persistence;
    
    @Override
    public List<LibroEntity> getLibros() 
    {
        return persistence.findAll();
    }

    @Override
    public LibroEntity getLibro(Long id) 
    {
         return persistence.find(id);
    }

    @Override
    public LibroEntity getLibroPorNombre(String name) 
    {
        return persistence.findByName(name);
    }

    @Override
    public LibroEntity createLibro(LibroEntity entity) throws Exception 
    {       
       //LibroEntity alreadyExist = getLibro(entity.getId());
       // if (alreadyExist != null) {
         //   throw new Exception("Ya existe un libro con ese id");
        //} else
       // {
            persistence.create(entity);
       // }
        return entity; 
    }

    @Override
    public LibroEntity updateLibro(LibroEntity entity) 
    {
       return persistence.update(entity);
    }

    @Override
    public void deleteLibro(Long id) 
    {
       persistence.delete(id);
    }

    
}
