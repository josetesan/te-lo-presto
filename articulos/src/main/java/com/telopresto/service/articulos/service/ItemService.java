package com.telopresto.service.articulos.service;

import com.telopresto.service.articulos.dao.ItemRepository;
import com.telopresto.service.articulos.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private EventService eventService;


    @Autowired
    public ItemService(ItemRepository itemRepository, EventService eventService) {
        this.itemRepository = itemRepository;
        this.eventService = eventService;
    }

    public Optional<Item> findById(Long id) {

        return this.itemRepository.findById(id);

    }

    public List<Item> findAll() {

        return this.itemRepository.findAll();

    }

    @Transactional
    public Item createItem(@Valid Item item) {

        final Item theItem = this.itemRepository.save(item);
        this.eventService.createItem(theItem);
        return theItem;

    }
}
