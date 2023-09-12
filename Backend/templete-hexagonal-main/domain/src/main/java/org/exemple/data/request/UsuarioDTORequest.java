package org.exemple.data.request;

import lombok.*;

import java.util.Date;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTORequest {
    private String nombre;
    private String apellido;
    private String email;
}
