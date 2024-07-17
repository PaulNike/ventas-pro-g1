package com.codigo.msventaspro.service;

import com.codigo.msventaspro.entities.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioService {
    UserDetailsService userDetailService();
    List<Usuario> getUsuarios();
}
