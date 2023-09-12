package org.exemple.mapper;

import org.exemple.data.UsuarioDTO;
import org.exemple.data.request.UsuarioDTORequest;
import org.exemple.data.request.UsuarioDTORequestUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioRequestMapper {
    UsuarioRequestMapper INSTANCE = Mappers.getMapper(UsuarioRequestMapper.class);
    //UsuarioDTORequestUpdate usuarioDTORequestToUsuarioDTO(UsuarioDTO usuarioDTO);
    UsuarioDTO usuarioDTOToUsuarioDTORequestUpdate(UsuarioDTORequest usuarioDTORequestUpdate);
    UsuarioDTO usuarioDTOToUsuarioDTORequestToUsuarioDTO(UsuarioDTORequestUpdate usuarioDTORequestToUsuarioDTO);
}
