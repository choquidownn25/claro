package org.exemple.data.response;

import lombok.*;
import org.exemple.data.UsuarioDTO;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTOResponse {
    private List<UsuarioDTO> listUsuario;
    private Message message;
}
