
package com.portfolio.imp.Interface;

import com.portfolio.imp.Entity.Persona;
import java.util.List;


/**
 *
 * @author Melanie
 */
public interface IPersonaService {
    //Traigo persona
    public List<Persona> getPersona();
    
    //Guardo objeto tipo persona
    public void savePersona(Persona persona);
    
    //Delete objeto - buscams por id
    public void deletePersona(Long id);
    
    //Buscar persona por id
    public Persona findPersona(Long id);
    
}
