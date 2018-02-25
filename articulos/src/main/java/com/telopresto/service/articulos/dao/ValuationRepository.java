package com.telopresto.service.articulos.dao;

import com.telopresto.service.articulos.domain.Item;
import com.telopresto.service.articulos.domain.ItemValuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "valuations", path = "valuations")
public interface ValuationRepository extends JpaRepository<ItemValuation,Long> {


    List<ItemValuation> findAllByItem(Item item);

    List<ItemValuation> findByItemOrderByValuationDateDesc(Item item);

}
