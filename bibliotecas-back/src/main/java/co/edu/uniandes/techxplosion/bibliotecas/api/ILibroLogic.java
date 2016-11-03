/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.LibroEntity;
import java.util.List;

public interface ILibroLogic 
{
    public List<LibroEntity> getLibros();
    public LibroEntity getLibro(Long id);
    public LibroEntity getLibroPorNombre(String name);
    public LibroEntity createLibro(LibroEntity entity) throws Exception;
    public LibroEntity updateLibro(LibroEntity entity);
    public void deleteLibro(Long id);
}
