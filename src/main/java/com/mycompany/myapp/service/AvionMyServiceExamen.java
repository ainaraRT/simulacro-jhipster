package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Avion;
import com.mycompany.myapp.repository.AvionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Añadimos las etiquetas necesarias para que funcione
@Service
public class AvionMyServiceExamen {

    //Inyectamos el repositorio de Avion
    @Autowired
    AvionRepository avionRepository;

    public Optional<Avion> getAvionMasViejo() {
        //Devuelve la búsqueda de la Query
        return avionRepository.findFirstByOrderByEdadDesc();
    }
}
