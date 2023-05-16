
package com.portfolio.imp.Security.Service;

import com.portfolio.imp.Security.Entity.Rol;
import java.util.Optional;
import com.portfolio.imp.Security.Enums.RolNombre;
import org.springframework.beans.factory.annotation.Autowired;
import com.portfolio.imp.Security.Repository.iRolRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService
{
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(final RolNombre rolNombre) {
        return this.irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(final Rol rol) {
        this.irolRepository.save((Object)rol);
    }
}
