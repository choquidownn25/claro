package org.exemple.ports.spi;

import org.exemple.data.UsuarioDTO;

import java.util.List;

public interface UsuarioPersistencePort {
    UsuarioDTO addUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO);
    void removeUsuario(Integer id);
    List<UsuarioDTO> getUsuariosList();
    UsuarioDTO getUsuariosByUsuario(Integer id);
}
