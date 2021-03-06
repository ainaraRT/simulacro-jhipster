package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Avion;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Avion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AvionRepository extends JpaRepository<Avion, Long>, JpaSpecificationExecutor<Avion> {
    //Métrica 1. Obtener el avión más viejo de la compañía.
    Optional<Avion> findFirstByOrderByEdadDesc();
}
