/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.api;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;
import java.util.List;

/**
 *
 * @author nd.munoz10
 */
public interface IBlogLogic 
{
    public List<BlogEntity> getBlogs();
    public BlogEntity getBlog(Long id);
    public BlogEntity createBlog(BlogEntity entity) throws Exception;
    public BlogEntity updateBlog(BlogEntity entity);
    public void deleteBlog(Long id);

    public BlogEntity getBlog(BlogEntity entity);
    
}
