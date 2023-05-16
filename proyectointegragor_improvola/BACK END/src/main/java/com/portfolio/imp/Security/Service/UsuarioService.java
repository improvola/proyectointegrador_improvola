/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.imp.Security.Service;

import com.portfolio.imp.Security.Entity.Usuario;
import com.portfolio.imp.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}

package com.portfolio.imp.Security.Service;

/**
 *
 * @author Melanie
 */

import com.portfolio.imp.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.portfolio.imp.Security.Repository.iUsuarioRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService
{
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(final String nombreUsuario) {
        return this.iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(final String nombreUsuario) {
        return this.iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(final String email) {
        return this.iusuarioRepository.existsByEmail(email);
    }
    
    public void save(final Usuario usuario) {
        this.iusuarioRepository.save((Object)usuario);
    }
}