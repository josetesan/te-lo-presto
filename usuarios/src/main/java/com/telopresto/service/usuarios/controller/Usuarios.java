package com.telopresto.service.usuarios.controller;

import com.telopresto.service.usuarios.domain.Usuario;
import com.telopresto.service.usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class Usuarios {


    private UserService userService;

    @Autowired
    public Usuarios(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usuarios")
    List<Usuario> retrieveUsuarios() {
        return  userService.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario){
        return this.userService.createUser(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @GetMapping("/usuarios")
    List<Usuario> retrieveUsuariosByPostalCode(@RequestParam("postalCode") String postalCode) {
        return userService.findByPostalCode(postalCode);
    }

}
