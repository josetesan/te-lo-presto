package com.telopresto.service.usuarios.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Data
@Entity(name = "usuarios")
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String credential;
    private String postalCode;
    private String birthdate;


}
