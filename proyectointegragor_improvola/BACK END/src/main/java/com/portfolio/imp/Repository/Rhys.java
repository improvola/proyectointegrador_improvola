/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.imp.Repository;

import com.portfolio.imp.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface Rhys extends JpaRepository<hys, Integer>{
    Optional<hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}

package com.portfolio.imp.Repository;

import java.util.Optional;
import com.portfolio.imp.Entity.hys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rhys extends JpaRepository<hys, Integer>
{
    Optional<hys> findByNombre(final String nombre);
    
    boolean existsByNombre(final String nombre);
}