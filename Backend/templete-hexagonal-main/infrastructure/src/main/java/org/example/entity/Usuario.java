package org.example.entity;
import lombok.*;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
/**
 * The persistent class for the usuarios database table.
 *
 */
@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nombre", nullable = false, length = 10)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 10)
    private String apellido;
    @Column(name="email", length = 255)
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_registro")
    private Date fechaRegistro;

}
