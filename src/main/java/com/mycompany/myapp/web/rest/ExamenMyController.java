package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Avion;
import com.mycompany.myapp.domain.Vuelo;
import com.mycompany.myapp.service.AvionMyServiceExamen;
import com.mycompany.myapp.service.VueloMyServiceExamen;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExamenMyController {

    AvionMyServiceExamen avionMyServiceExamen;
    VueloMyServiceExamen vueloMyServiceExamen;

    //Generamos el constructor con los dos métodos
    public ExamenMyController(AvionMyServiceExamen avionMyServiceExamen, VueloMyServiceExamen vueloMyServiceExamen) {
        this.avionMyServiceExamen = avionMyServiceExamen;
        this.vueloMyServiceExamen = vueloMyServiceExamen;
    }

    //Métrica 1
    @GetMapping("/avion")
    public ResponseEntity<Optional<Avion>> getAvionMasViejo() {
        return ResponseEntity.ok(avionMyServiceExamen.getAvionMasViejo());
    }

    //Métrica 2
    @GetMapping("/vuelo/pilotos")
    public ResponseEntity<Page<Vuelo>> findByPiloto_Dni(
        @RequestParam String dni,
        @org.springdoc.api.annotations.ParameterObject Pageable pageable
    ) {
        if (validarDni(dni)) {
            return ResponseEntity.ok(vueloMyServiceExamen.findByPiloto_Dni(dni, pageable));
        }
        return new ResponseEntity("No encontrado", HttpStatus.BAD_REQUEST);
    }

    //Métrica 3
    @GetMapping("/vuelo/tripulantes")
    public ResponseEntity<Long> countByTripulantes_Dni(@RequestParam String dni) {
        if (validarDni(dni)) {
            return ResponseEntity.ok(vueloMyServiceExamen.countByTripulantes_Dni(dni));
        }
        return new ResponseEntity("No encontrado", HttpStatus.BAD_REQUEST);
    }

    //Validación de que el dni sea correcto
    public boolean validarDni(String dni) {
        if (dni.matches("[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]")) {
            return true;
        }
        return false;
    }
}
