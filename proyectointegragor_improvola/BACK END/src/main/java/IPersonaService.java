
package com.portfolio.imp.Interface;

import com.portfolio.imp.Entity.Persona;
import java.util.List;

public interface IPersonaService
{
    List<Persona> getPersona();
    
    void savePersona(final Persona persona);
    
    void deletePersona(final Long id);
    
    Persona findPersona(final Long id);
}