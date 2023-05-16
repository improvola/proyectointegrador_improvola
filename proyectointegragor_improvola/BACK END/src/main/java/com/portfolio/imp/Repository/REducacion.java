
package com.portfolio.imp.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.portfolio.imp.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>
{
    Optional<Educacion> findByNombreE(final String nombreE);
    
    boolean existsByNombreE(final String nombreE);
}