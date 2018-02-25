package com.telopresto.service.articulos.controller;

import com.telopresto.service.articulos.domain.Item;
import com.telopresto.service.articulos.domain.ItemValuation;
import com.telopresto.service.articulos.service.ValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class Valoraciones {


    private ValuationService valuationService;

    @Autowired
    public Valoraciones(ValuationService valuationService) {
        this.valuationService = valuationService;
    }

    @PostMapping("/valoraciones")
    public ItemValuation createValoracion(@Valid @RequestBody ItemValuation itemValuation){
        return this.valuationService.createItemValuation(itemValuation);
    }

    @GetMapping("/valoraciones")
    public ResponseEntity<?> getValoracionesByItemId(@RequestParam("itemId") Item item) {
        return ResponseEntity.ok(valuationService.findAllById(item));
    }

}
