
package com.portfolio.imp.Repository;

import com.portfolio.imp.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
/**
 *
 * @author Melanie
 */
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
