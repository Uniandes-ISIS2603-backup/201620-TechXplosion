/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.techxplosion.bibliotecas.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author js.numpaque10
 */
@Entity
public class ReservaEntity extends BaseEntity implements Serializable{
    
    @PodamExclude
    @ManyToOne
    private VideoEntity video;
    @PodamExclude
    @ManyToOne
    private LibroEntity libro;
    @PodamExclude
    @OneToOne
    private UsuarioEntity usuario;
    private String fechaSolicitud;
    
    
    
}
