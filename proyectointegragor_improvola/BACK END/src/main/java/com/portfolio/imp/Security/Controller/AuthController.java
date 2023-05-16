

package com.portfolio.imp.Security.Controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.portfolio.imp.Security.Dto.JwtDto;
import com.portfolio.imp.Security.Dto.LoginUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Set;
import com.portfolio.imp.Security.RolNombre;
import com.portfolio.imp.Security.Entity.Rol;
import java.util.HashSet;
import com.portfolio.imp.Security.Entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import com.portfolio.imp.Security.Dto.NuevoUsuario;
import com.portfolio.imp.Security.jwt.JwtProvider;
import com.portfolio.imp.Security.Service.RolService;
import com.portfolio.imp.Security.Service.UsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/auth" })
@CrossOrigin(origins = { "https://impfrontend.web.app", "http://localhost:4200" })
public class AuthController
{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping({ "/nuevo" })
    public ResponseEntity<?> nuevo(@Valid @RequestBody final NuevoUsuario nuevoUsuario, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("ERROR! Mail invalido o datos incorrectos"), HttpStatus.BAD_REQUEST);
        }
        if (this.usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (this.usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Ese email ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
        }
        final Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(), this.passwordEncoder.encode((CharSequence)nuevoUsuario.getPassword()));
        final Set<Rol> roles = new HashSet<Rol>();
        roles.add(this.rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(this.rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);
        this.usuarioService.save(usuario);
        return (ResponseEntity<?>)new ResponseEntity((Object)new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping({ "/login" })
    public ResponseEntity<JwtDto> login(@Valid @RequestBody final LoginUsuario loginUsuario, final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return (ResponseEntity<JwtDto>)new ResponseEntity((Object)new Mensaje("ERROR! Campos incorrectos"), HttpStatus.BAD_REQUEST);
        }
        final Authentication authentication = this.authenticationManager.authenticate((Authentication)new UsernamePasswordAuthenticationToken((Object)loginUsuario.getNombreUsuario(), (Object)loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwt = this.jwtProvider.generateToken(authentication);
        final UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        final JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return (ResponseEntity<JwtDto>)new ResponseEntity((Object)jwtDto, HttpStatus.OK);
    }
}
