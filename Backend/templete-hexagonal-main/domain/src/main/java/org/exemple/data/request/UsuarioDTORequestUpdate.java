package org.exemple.data.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTORequestUpdate {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
}
