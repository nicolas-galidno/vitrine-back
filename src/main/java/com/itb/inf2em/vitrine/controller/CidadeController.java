package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Cidade;
import com.itb.inf2em.vitrine.model.entity.Empresas;
import com.itb.inf2em.vitrine.model.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeService;


    @GetMapping
    public ResponseEntity<List<Cidade>> listarTodos() {

        return ResponseEntity.ok(cidadeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> FindById(@PathVariable String id){
        try{
            return ResponseEntity.ok(cidadeService.findById((int) Long.parseLong(id)));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "o Id informado não é válido:" + id
                    )
            );
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", 404,
                            "error", "Not found",
                            "message", "Cidade não encontrada com o id:" + id

                    )
            );
        }
    }
}