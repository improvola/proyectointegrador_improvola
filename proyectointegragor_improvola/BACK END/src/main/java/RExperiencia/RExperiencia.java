package com.portfolio.imp.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.portfolio.imp.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer>
{
    Optional<Experiencia> findByNombreE(final String nombreE);
    
    boolean existsByNombreE(final String nombreE);
}