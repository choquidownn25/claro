package com.test.infrasture;

import org.example.entity.Usuario;
import org.example.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class TestUsuario {
    @Mock // Create a mock UserRepository
    UsuarioRepository usuarioRepository;
    @BeforeEach
    void setUp() {

    }
    @Test
    void add() {
        Usuario usuario = new Usuario("prueba","prueba",  "prueba@prueba.com", new Date());

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        Usuario result = usuarioRepository.save(usuario);
        assertNotNull(result);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
        System.out.println("test prueba insert : " + usuario.toString());
    }
    @Test
    void update(){
        Usuario usuario = new Usuario("pruebaup","pruebaup",  "pruebaup@prueba.com", new Date());
        usuario.setId(2);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        Usuario result = usuarioRepository.save(usuario);
        assertNotNull(result);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
        System.out.println("test prueba update :" + usuario.toString());
    }
    @Test
    public void list() throws Exception {
        List<Usuario> listUsuario = Arrays.asList(
                new Usuario("prueba1","prueba1",  "prueba1@prueba.com", new Date()),
                new Usuario("prueba2","prueba2",  "prueba2@prueba.com", new Date()),
                new Usuario("prueba3","prueba3",  "prueba3@prueba.com", new Date())
        );
        when(usuarioRepository.findAll()).thenReturn(listUsuario);

        List<Usuario> result = usuarioRepository.findAll();
        assertNotNull(result);
        assertEquals(3, result.size());

        verify(usuarioRepository, times(1)).findAll();
        System.out.println("test prueba list :" + listUsuario.toString());
    }
    @Test
    public void getById() throws Exception {
        int usuarioId = 3;


        Usuario usuario = new Usuario(usuarioId,"pruebabyId","pruebabyId",  "pruebabyId@pruebabyId.com", new Date());

        when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.of(usuario));
        Optional<Usuario> result = usuarioRepository.findById(usuarioId);
        assertNotNull(result);
        verify(usuarioRepository, times(1)).findById(usuarioId);
        System.out.println("test prueba list :" + result.get().toString());
    }
}
