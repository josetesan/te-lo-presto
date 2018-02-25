package com.telopresto.service.usuarios.service;

import com.telopresto.service.usuarios.dao.UserRepository;
import com.telopresto.service.usuarios.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private EventService eventService;


    @Autowired
    public UserService(UserRepository userRepository, EventService eventService) {
        this.userRepository = userRepository;
        this.eventService = eventService;
    }

    public Optional<Usuario> findById(Long id) {

        return this.userRepository.findById(id);

    }

    public List<Usuario> findAll() {

        return this.userRepository.findAll();

    }

    @Transactional
    public Usuario createUser(@Valid Usuario usuario) {

        final Usuario theUsuario = this.userRepository.save(usuario);
        this.eventService.createUser(theUsuario);
        return theUsuario;

    }

    public List<Usuario> findByPostalCode(String postalCode) {
        return this.userRepository.findByPostalCode(postalCode);
    }
}
