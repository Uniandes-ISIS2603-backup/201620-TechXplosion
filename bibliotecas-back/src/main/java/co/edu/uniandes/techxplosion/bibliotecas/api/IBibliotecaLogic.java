/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BibliotecaEntity;
import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import java.util.List;

/**
 *
 * @author js.sosa10
 */
public interface IBibliotecaLogic {
    public List<BibliotecaEntity> getBibliotecas();
    public BibliotecaEntity getBiblioteca(Long id);
    public BibliotecaEntity getBibliotecaByName(String name);
    public BibliotecaEntity createBiblioteca(BibliotecaEntity entity);
    public BibliotecaEntity updateBiblioteca(BibliotecaEntity entity);
    public void deleteBiblioteca(Long id);
    public List<LibroEntity> getLibros(Long idBiblioteca);
    public LibroEntity getLibro(Long idBiblioteca, Long idLibro);
    public LibroEntity getLibroByName(Long idBiblioteca,String name);
    public LibroEntity addLibro(Long idBiblioteca,LibroEntity entity);
    public LibroEntity replaceLibro(Long idBiblioteca,LibroEntity entity);
    public List<LibroEntity> replaceLibros(Long idBiblioteca,List<LibroEntity>entities);
    public void removeLibro(Long idBiblioteca,Long idLibro);
    public int numberOfLibros(Long idBiblioteca);
    
}
