package com.proyecto.ComercianteEspacial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.ComercianteEspacial.dto.JwtAuthenticationResponse;
import com.proyecto.ComercianteEspacial.dto.LoginDTO;
import com.proyecto.ComercianteEspacial.dto.UserRegistrationDTO;
import com.proyecto.ComercianteEspacial.model.Usuario;
import com.proyecto.ComercianteEspacial.repository.UsuarioRepository;



@Service
public class AuthenticationService{

        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private JwtService jwtService;
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private PasswordEncoder passwordEncoder;
        
        public JwtAuthenticationResponse login(LoginDTO request) {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(request.getNombre(), request.getpassword()));
                Usuario usuario = usuarioRepository.findByNombre(request.getNombre())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
                String jwt = jwtService.generateToken(usuario);
                return new JwtAuthenticationResponse(jwt, usuario.getNombre(), usuario.getRol());
        }
        public JwtAuthenticationResponse signup(UserRegistrationDTO request) {
        Usuario user = new Usuario(
                request.getNombre(),
                passwordEncoder.encode(request.getPassword()),
                request.getRol(),
                null);
        usuarioRepository.save(user);
        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt, user.getNombre(), user.getRol());
        }
}
