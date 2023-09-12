package org.example.configuration;

import org.example.adapters.UsuarioJpaAdapter;
import org.exemple.ports.api.UsuarioServicePort;
import org.exemple.ports.spi.UsuarioPersistencePort;
import org.exemple.service.UsuarioServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    public UsuarioPersistencePort usuarioPersistencePort(){
        return  new UsuarioJpaAdapter();
    }
    @Bean
    public UsuarioServicePort usuarioServicePort(){ return new UsuarioServiceImpl(usuarioPersistencePort());
    }
}
