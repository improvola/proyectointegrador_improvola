
package com.portfolio.imp.Security.Entity;

/**
 *
 * @author Melanie
 */

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import com.portfolio.imp.Security.RolNombre;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Rol
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    public Rol() {
    }
    
    public Rol(final RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public RolNombre getRolNombre() {
        return this.rolNombre;
    }
    
    public void setRolNombre(final RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}