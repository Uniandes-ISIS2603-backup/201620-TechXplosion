/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.resources;
import co.edu.uniandes.rest.cities.dtos.BibliotecaDTO;
import co.edu.uniandes.rest.cities.exceptions.CityLogicException;
import co.edu.uniandes.rest.cities.mocks.BibliotecaMock;


import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
/**
 *
 * @author js.sosa10
 */
@Path("bibliotecas")
@Produces("application/json")
public class BibliotecaResource {



    BibliotecaMock bibLogic = new BibliotecaMock();

    /**
     * Obtiene el listado de Bibliotecas.
     *
     * @return lista de bibliotecas
     * @throws CityLogicException excepción retornada por la lógica
     */
    @GET
    public List<BibliotecaDTO> getBibliotecas() throws CityLogicException {
        return bibLogic.getBibliotecas();
    }

   
    /**
     * Agrega una biblioteca
     *
     * @param biblioteca  biblioteca  a agregar
     * @return datos de la  biblioteca  a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id
     * suministrado
     */
    @POST
    public BibliotecaDTO  createBiblioteca( BibliotecaDTO  biblioteca ) throws CityLogicException {
        return bibLogic.createBiblioteca(biblioteca);
    }
}

