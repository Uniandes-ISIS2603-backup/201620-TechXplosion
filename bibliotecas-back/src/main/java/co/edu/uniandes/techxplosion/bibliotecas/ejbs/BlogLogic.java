/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.ejbs;

import co.edu.uniandes.techxplosion.bibliotecas.api.IBlogLogic;
import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;
import co.edu.uniandes.techxplosion.bibliotecas.persistence.BlogPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author nd.munoz10
 */
@Stateless
public class BlogLogic implements IBlogLogic
{

    @Inject
    private BlogPersistence persistence;
    
    @Override
    public List<BlogEntity> getBlogs() 
    {
        return persistence.findAll();
    }

    @Override
    public BlogEntity getBlog(Long id) 
    {
         return persistence.find(id); 
    }

    @Override
    public BlogEntity createBlog(BlogEntity entity) throws Exception 
    {
         BlogEntity alreadyExist = getBlog(entity.getId());
        if (alreadyExist != null) 
        {
            throw new Exception("Ya existe un blog con ese id");
        } else
        {
            persistence.create(entity);
        }
        return entity;
    }

    @Override
    public BlogEntity updateBlog(BlogEntity entity) 
    {
        return persistence.update(entity);
    }

    @Override
    public void deleteBlog(Long id) 
    {
        persistence.delete(id);
    }

    @Override
    public BlogEntity getBlog(BlogEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
