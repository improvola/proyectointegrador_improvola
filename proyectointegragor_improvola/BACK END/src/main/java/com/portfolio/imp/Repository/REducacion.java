/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.imp.Repository;

import com.portfolio.imp.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}

package com.portfolio.imp.Repository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.portfolio.imp.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>
{
    Optional<Educacion> findByNombreE(final String nombreE);
    
    boolean existsByNombreE(final String nombreE);
}