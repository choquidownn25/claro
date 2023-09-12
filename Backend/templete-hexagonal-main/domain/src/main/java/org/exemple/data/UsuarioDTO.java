package org.exemple.data;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaRegistro;
}
