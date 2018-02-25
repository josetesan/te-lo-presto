package com.telopresto.service.usuarios.service;

import com.telopresto.service.usuarios.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private KafkaTemplate kafkaTemplate;

    private static final String TOPIC_USER_CREATE = "createUser";
    private static final String TOPIC_USER_MODIFY = "modifyUser";

    @Autowired
    public EventService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void createUser(final Usuario usuario) {
        this.kafkaTemplate.send(TOPIC_USER_CREATE,usuario.getId(), usuario);
    }

    public void modifyUser(final Usuario usuario) {
        this.kafkaTemplate.send(TOPIC_USER_MODIFY, usuario.getId(),usuario);
    }
}
