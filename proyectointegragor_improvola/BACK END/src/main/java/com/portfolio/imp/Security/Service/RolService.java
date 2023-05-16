/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.imp.Security.Service;

import com.portfolio.imp.Security.Entity.Rol;
import com.portfolio.imp.Security.Enums.RolNombre;
import com.portfolio.imp.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}

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
