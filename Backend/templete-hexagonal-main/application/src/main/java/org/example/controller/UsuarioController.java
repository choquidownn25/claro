package org.example.controller;

import org.exemple.data.UsuarioDTO;
import org.exemple.data.request.UsuarioDTORequest;
import org.exemple.data.request.UsuarioDTORequestUpdate;
import org.exemple.data.response.UsuarioDTOResponse;
import org.exemple.ports.api.UsuarioServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioServicePort usuarioServicePort;

    public UsuarioController(UsuarioServicePort usuarioServicePort) {
        this.usuarioServicePort = usuarioServicePort;
    }
    @PostMapping("/add")
    public ResponseEntity<UsuarioDTOResponse> addUsuario(@RequestBody UsuarioDTORequest usuarioDTORequest){
        UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioDTOResponse = usuarioServicePort.addUsuario(usuarioDTORequest);
        if(usuarioDTOResponse != null) {
            return new ResponseEntity<UsuarioDTOResponse>(usuarioDTOResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<UsuarioDTOResponse>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping ("/update")
    public ResponseEntity<UsuarioDTOResponse> updateUsuario(@RequestBody UsuarioDTORequestUpdate usuarioDTORequest){
        UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioDTOResponse = usuarioServicePort.updateUsuario(usuarioDTORequest);
        if(usuarioDTOResponse != null) {
            return new ResponseEntity<UsuarioDTOResponse>(usuarioDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<UsuarioDTOResponse>(usuarioDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<UsuarioDTO>> getUsuario( ){
        List<UsuarioDTO> listUsuarioDTOResponse = new ArrayList<>();
        listUsuarioDTOResponse = usuarioServicePort.getUsuariosList();
        if(listUsuarioDTOResponse != null) {
            return new ResponseEntity<List<UsuarioDTO>>(listUsuarioDTOResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<UsuarioDTO>>(listUsuarioDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UsuarioDTOResponse> getByIdUsuario(@PathVariable Integer id){
        UsuarioDTOResponse usuarioDTOResponse = new UsuarioDTOResponse();
        usuarioDTOResponse = usuarioServicePort.getUsuarioDTOById(id);
        if(usuarioDTOResponse != null) {
            return new ResponseEntity<UsuarioDTOResponse>(usuarioDTOResponse, HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<UsuarioDTOResponse>(usuarioDTOResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        usuarioServicePort.removeUsuario(id);
    }
}
