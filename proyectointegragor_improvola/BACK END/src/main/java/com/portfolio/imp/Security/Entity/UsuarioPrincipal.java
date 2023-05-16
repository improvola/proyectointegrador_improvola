
package com.portfolio.imp.Security.Entity;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails
{
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
    public UsuarioPrincipal(final String nombre, final String nombreUsuario, final String email, final String password, final Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static UsuarioPrincipal build(final Usuario usuario) {
        final List<GrantedAuthority> authorities;
        authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect((Collector<? super Object, ?, List<GrantedAuthority>>)Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities); 
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getUsername() {
        return this.nombreUsuario;
    }
    
    public boolean isAccountNonExpired() {
        return true;
    }
    
    public boolean isAccountNonLocked() {
        return true;
    }
    
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    public boolean isEnabled() {
        return true;
    }
}