package com.telopresto.service.articulos.controller;

import com.telopresto.service.articulos.domain.Item;
import com.telopresto.service.articulos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class Articulos {


    private ItemService itemService;

    @Autowired
    public Articulos(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/articulos")
    List<Item> retrieveItems() {
        return  itemService.findAll();
    }

    @PostMapping("/articulos")
    public Item createArticulo(@Valid @RequestBody Item item){
        return this.itemService.createItem(item);
    }

    @GetMapping("/articulos/{id}")
    public ResponseEntity<?> getArticuloById(@PathVariable("id") Long id) {
        return itemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



}
