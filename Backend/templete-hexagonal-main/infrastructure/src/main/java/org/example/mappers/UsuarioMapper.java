package org.example.mappers;


import org.example.entity.Usuario;
import org.exemple.data.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE= Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO usuarioDTOToUsuario (Usuario usuario);
    Usuario usuarioToUsuario (UsuarioDTO usuarioDTO);
    List<Usuario> usuariosListToUsuarioDTO (List<UsuarioDTO> usuariosdtosDTO);
    List<UsuarioDTO> usuariosListDTOToUsuario (List<Usuario> usuarios);

}
