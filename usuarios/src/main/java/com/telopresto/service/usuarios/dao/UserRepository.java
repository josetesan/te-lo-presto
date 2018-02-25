package com.telopresto.service.usuarios.dao;

import com.telopresto.service.usuarios.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<Usuario,Long> {


    List<Usuario> findByPostalCode(@Param("postalCode") String postalCode);

}
