
package com.portfolio.imp.Repository;

import java.util.Optional;
import com.portfolio.imp.Entity.hys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rhys extends JpaRepository<hys, Integer>
{
    Optional<hys> findByNombre(final String nombre);
    
    boolean existsByNombre(final String nombre);
}