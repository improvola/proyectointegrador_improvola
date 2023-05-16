

package com.portfolio.imp.Security.Dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario
{
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(final String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
}
