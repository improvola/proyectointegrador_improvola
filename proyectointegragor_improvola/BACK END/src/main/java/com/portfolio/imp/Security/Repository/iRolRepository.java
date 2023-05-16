/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.portfolio.imp.Security.Repository;

import java.util.Optional;
import com.portfolio.imp.Security.RolNombre;
import org.springframework.stereotype.Repository;
import com.portfolio.imp.Security.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>
{
    Optional<Rol> findByRolNombre(final RolNombre rolNombre);

    public Optional<Rol> findByRolNombre(com.portfolio.imp.Security.Enums.RolNombre rolNombre);

    public void save(Object object);
}