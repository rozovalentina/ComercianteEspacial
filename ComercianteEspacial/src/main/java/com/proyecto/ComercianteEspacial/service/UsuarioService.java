package com.proyecto.ComercianteEspacial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.ComercianteEspacial.model.Usuario;
import com.proyecto.ComercianteEspacial.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Obtener listado de usuarios
    @Transactional
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    //Obtener listado de usuarios paginable
    @Transactional
    public Page<Usuario> listarUsuariosPaginable(int page, int size){
        Pageable paginable = PageRequest.of(page, size);
        return usuarioRepository.findAll(paginable);
    }

    //Obtener listado de usuario por nave
    @Transactional
    public Page<Usuario> findByNaveId(Long idNave, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return usuarioRepository.findByNaveId(idNave, pageable);
    }

    //Obtener usuario
    public Usuario recuperarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }


    //Guardar usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Eliminar usuario
    @Transactional
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    //Encontrar usuario por nombre
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return usuarioRepository.findByNombre(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            }
        };
    }
}
