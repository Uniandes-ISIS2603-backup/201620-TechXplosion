/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.dtos;

import co.edu.uniandes.techxplosion.bibliotecas.entities.BlogEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sa.pardo10
 */
@XmlRootElement
public class BlogDetailDTO extends BlogDTO 
{
    private LibroDTO libro;
    
    public BlogDetailDTO()
    {
        super();
    }
    
    public BlogDetailDTO(BlogEntity entity)
    {
        super(entity);
        libro = new LibroDTO(entity.getLibro());
    }
    @Override
    public BlogEntity toEntity()
    {
        BlogEntity entity = super.toEntity();
        entity.setLibro(libro.toEntity());
        return entity;
                }
    
}
