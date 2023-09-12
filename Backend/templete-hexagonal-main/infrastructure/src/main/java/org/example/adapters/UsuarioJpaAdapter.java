package org.example.adapters;

import org.example.entity.Usuario;
import org.example.mappers.UsuarioMapper;
import org.example.repository.UsuarioRepository;
import org.exemple.data.UsuarioDTO;
import org.exemple.ports.spi.UsuarioPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioJpaAdapter implements UsuarioPersistencePort {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UsuarioDTO addUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioToUsuario(usuarioDTO);
        Usuario response = usuarioRepository.save(usuario);
        UsuarioDTO usuariosDTO = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(response);
        return usuariosDTO;
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioToUsuario(usuarioDTO);
        Usuario response = usuarioRepository.save(usuario);
        UsuarioDTO usuariosDTO = UsuarioMapper.INSTANCE.usuarioDTOToUsuario(response);
        return usuariosDTO;
    }

    @Override
    public void removeUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDTO> getUsuariosList() {
        List<Usuario>usuarioList=usuarioRepository.findAll();
        return UsuarioMapper.INSTANCE.usuariosListDTOToUsuario(usuarioList);
    }

    @Override
    public UsuarioDTO getUsuariosByUsuario(Integer id) {
        //Encuentra el registro
        Optional<Usuario> usuarioId=usuarioRepository.findById(id);
        if (usuarioId.isPresent()) {
            return UsuarioMapper.INSTANCE.usuarioDTOToUsuario(usuarioId.get());
        }
        return null;
    }
}
