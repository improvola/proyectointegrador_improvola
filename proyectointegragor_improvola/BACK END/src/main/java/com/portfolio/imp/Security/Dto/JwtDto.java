
package com.portfolio.imp.Security.Dto;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class JwtDto
{
    private String token;
    private String bearer;
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;
    
    public JwtDto(final String token, final String nombreUsuario, final Collection<? extends GrantedAuthority> authorities) {
        this.bearer = "Bearer";
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.authorities = authorities;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public String getBearer() {
        return this.bearer;
    }
    
    public void setBearer(final String bearer) {
        this.bearer = bearer;
    }
    
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    
    public void setAuthorities(final Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}