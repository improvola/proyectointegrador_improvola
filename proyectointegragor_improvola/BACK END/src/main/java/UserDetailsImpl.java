/package com.portfolio.imp.Security.Service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.portfolio.imp.Security.Entity.UsuarioPrincipal;
import com.portfolio.imp.Security.Entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UserDetailsImpl implements UserDetailsService
{
    @Autowired
    UsuarioService usuarioService;
    
    public UserDetails loadUserByUsername(final String nombreUsuario) throws UsernameNotFoundException {
        final Usuario usuario = this.usuarioService.getByNombreUsuario(nombreUsuario).get();
        return (UserDetails)UsuarioPrincipal.build(usuario);
    }
}