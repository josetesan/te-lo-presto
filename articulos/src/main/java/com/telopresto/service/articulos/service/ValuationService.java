package com.telopresto.service.articulos.service;

import com.telopresto.service.articulos.dao.ValuationRepository;
import com.telopresto.service.articulos.domain.Item;
import com.telopresto.service.articulos.domain.ItemValuation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ValuationService {

    private ValuationRepository valuationRepository;


    @Autowired
    public ValuationService(ValuationRepository valuationRepository) {
        this.valuationRepository = valuationRepository;
    }

    public Optional<ItemValuation> findById(Long id) {

        return this.valuationRepository.findById(id);

    }

    public List<ItemValuation> findAllById(Item item) {

        return this.valuationRepository.findAllByItem(item);

    }

    @Transactional
    public ItemValuation createItemValuation(@Valid ItemValuation item) {
        return this.valuationRepository.save(item);
    }

    public ItemValuation findByNewest(Item item) {
        return this.valuationRepository
                .findByItemOrderByValuationDateDesc(item)
                .get(0);
    }
}
