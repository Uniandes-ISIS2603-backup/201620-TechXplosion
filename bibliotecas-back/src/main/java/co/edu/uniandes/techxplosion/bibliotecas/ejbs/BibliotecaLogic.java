/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IBibliotecaLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.BibliotecaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author sa.pardo10
 */
@Stateless
public class BibliotecaLogic implements IBibliotecaLogic
{

    @Inject
    private BibliotecaPersistence persistence;
    
    @Override
    public List<BibliotecaEntity> getBibliotecas() 
    {
        return persistence.findAll();
    }

    @Override
    public BibliotecaEntity getBiblioteca(Long id) 
    {
        return persistence.find(id); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public BibliotecaEntity createBiblioteca(BibliotecaEntity entity) 
    {
        
            persistence.create(entity);
        
        return entity;
    }

    @Override
    public BibliotecaEntity updateBiblioteca(BibliotecaEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteBiblioteca(Long id) 
    {
        persistence.delete(id);
    }

    @Override
    public BibliotecaEntity getBibliotecaByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LibroEntity> getLibros(Long idBiblioteca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LibroEntity getLibro(Long idBiblioteca, Long idLibro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LibroEntity getLibroByName(Long idBiblioteca, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LibroEntity addLibro(Long idBiblioteca, LibroEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LibroEntity replaceLibro(Long idBiblioteca, LibroEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LibroEntity> replaceLibros(Long idBiblioteca, List<LibroEntity> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLibro(Long idBiblioteca, Long idLibro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int numberOfLibros(Long idBiblioteca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
