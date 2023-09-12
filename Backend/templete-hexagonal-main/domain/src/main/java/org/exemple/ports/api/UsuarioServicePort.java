package org.exemple.ports.api;

import org.exemple.data.UsuarioDTO;
import org.exemple.data.request.UsuarioDTORequest;
import org.exemple.data.request.UsuarioDTORequestUpdate;
import org.exemple.data.response.UsuarioDTOResponse;

import java.util.List;

public interface UsuarioServicePort {
    UsuarioDTOResponse addUsuario(UsuarioDTORequest usuarioDTORequest);
    UsuarioDTOResponse updateUsuario(UsuarioDTORequestUpdate usuarioDTORequest);
    void removeUsuario(Integer id);
    List<UsuarioDTO> getUsuariosList();
    UsuarioDTOResponse getUsuarioDTOById(Integer id);

}
