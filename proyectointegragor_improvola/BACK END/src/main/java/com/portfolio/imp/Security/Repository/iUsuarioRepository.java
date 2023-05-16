

/**
 *
 * @author Melanie
 */

package com.portfolio.imp.Security.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.portfolio.imp.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>
{
    Optional<Usuario> findByNombreUsuario(final String nombreUsuario);
    
    boolean existsByNombreUsuario(final String nombreUsuario);
    
    boolean existsByEmail(final String email);
}