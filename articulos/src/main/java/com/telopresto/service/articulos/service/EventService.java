package com.telopresto.service.articulos.service;

import com.telopresto.service.articulos.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private KafkaTemplate kafkaTemplate;

    private static final String TOPIC_USER_CREATE = "createItem";
    private static final String TOPIC_USER_MODIFY = "modifyItem";

    @Autowired
    public EventService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void createItem(final Item item) {
        this.kafkaTemplate.send(TOPIC_USER_CREATE, item.getId(), item);
    }

    public void modifyItem(final Item item) {
        this.kafkaTemplate.send(TOPIC_USER_MODIFY, item.getId(), item);
    }


}
