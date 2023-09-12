package org.exemple.service;

import org.exemple.data.UsuarioDTO;
import org.exemple.data.request.UsuarioDTORequest;
import org.exemple.data.request.UsuarioDTORequestUpdate;
import org.exemple.data.response.Message;
import org.exemple.data.response.UsuarioDTOResponse;
import org.exemple.mapper.UsuarioRequestMapper;
import org.exemple.ports.api.UsuarioServicePort;
import org.exemple.ports.spi.UsuarioPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioServicePort {
    private final UsuarioPersistencePort usuarioPersistencePort;
    @Autowired
    public UsuarioServiceImpl(UsuarioPersistencePort usuarioPersistencePort) {
        this.usuarioPersistencePort = usuarioPersistencePort;
    }


    @Override
    public UsuarioDTOResponse addUsuario(UsuarioDTORequest usuarioDTORequest) {
        UsuarioDTOResponse response=new UsuarioDTOResponse();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Message message=new Message();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
        if(usuarioDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            //Se agrega dato
            UsuarioDTO usuarioDTOs = UsuarioRequestMapper.INSTANCE.usuarioDTOToUsuarioDTORequestUpdate(usuarioDTORequest);;
            usuarioDTOs.setFechaRegistro(new Date());
            if (usuarioDTOs.getNombre().length()>10 ||usuarioDTOs.getApellido().length()>10){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            UsuarioDTO usuarioInsert = usuarioPersistencePort.addUsuario(usuarioDTOs);
            if(usuarioInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                usuarioDTOList.add(usuarioInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListUsuario(usuarioDTOList);
            }
        }
        return response;
    }

    @Override
    public UsuarioDTOResponse updateUsuario(UsuarioDTORequestUpdate usuarioDTORequest) {
        UsuarioDTOResponse response=new UsuarioDTOResponse();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Message message=new Message();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
        if(usuarioDTORequest == null ){
            message.setEcho (StringResponse.ErrorSAVETICKET.getName());
            message.setCode( StringResponse.ErrorSAVETICKET.getCode());
            response.setMessage( message);

        } else {
            UsuarioDTO usuarioDTOs = UsuarioRequestMapper.INSTANCE.usuarioDTOToUsuarioDTORequestToUsuarioDTO(usuarioDTORequest);
            usuarioDTOs.setFechaRegistro(new Date());
            if (usuarioDTOs.getNombre().length() > 10 ||usuarioDTOs.getApellido().length() > 10){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }
            UsuarioDTO usuarioInsert = usuarioPersistencePort.updateUsuario(usuarioDTOs);
            if(usuarioInsert == null){
                message.setEcho (StringResponse.ErrorSAVETICKET.getName());
                message.setCode( StringResponse.ErrorSAVETICKET.getCode());
                response.setMessage( message);
            }else{
                usuarioDTOList.add(usuarioInsert);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListUsuario(usuarioDTOList);
            }
        }
        return response;
    }

    @Override
    public void removeUsuario(Integer id) {
        try {
            usuarioPersistencePort.getUsuariosByUsuario(id);
        }catch (Exception e){
            throw new RuntimeException( "Error " + e.getMessage());
        }
    }

    @Override
    public List<UsuarioDTO> getUsuariosList() {
        return usuarioPersistencePort.getUsuariosList();
    }

    @Override
    public UsuarioDTOResponse getUsuarioDTOById(Integer id) {
        UsuarioDTOResponse response=new UsuarioDTOResponse();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Message message=new Message();
        List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
        usuarioDTO = usuarioPersistencePort.getUsuariosByUsuario(id);
        if(usuarioDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYTICKET.getName());
            message.setCode( StringResponse.ErrorNOHAYTICKET.getCode());
            response.setMessage( message);
        }else {
            usuarioDTOList.add(usuarioDTO);
            message.setEcho (StringResponse.MOSTRARTICKET.getName());
            message.setCode( StringResponse.MOSTRARTICKET.getCode());
            response.setMessage( message);
            response.setListUsuario(usuarioDTOList);
        }
        return response;
    }
}
