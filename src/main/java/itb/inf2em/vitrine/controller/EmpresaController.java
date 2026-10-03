package itb.inf2em.vitrine.controller;

import itb.inf2em.vitrine.model.entity.Empresas;
import itb.inf2em.vitrine.model.services.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping( "/api/v1/empresas")
public class EmpresaController {

    @Autowired
    private EmpresasService empresasService;


    @GetMapping
    public ResponseEntity<List<Empresas>> listarTodos() {

        return ResponseEntity.ok(empresasService.findAll());
    }

    @PostMapping
    public ResponseEntity<Empresas> salvarEmpresas(@RequestBody Empresas empresas) {

        Empresas novo = empresasService.save(empresas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }


}
