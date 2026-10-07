package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Telefone;
import com.itb.inf2em.vitrine.model.repository.TelefoneRepository;
import com.itb.inf2em.vitrine.model.services.TelefoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneServices telefoneServices;

    @GetMapping
    public ResponseEntity<List<Telefone>> findAll() {

        return ResponseEntity.ok(telefoneServices.findAll());
    }

    @PostMapping
    public ResponseEntity<Telefone> salvarTelefone(@RequestBody Telefone telefone) {
        Telefone newTelefone = telefoneServices.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTelefone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(telefoneServices.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "o Id informado não é válido:" + id
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", 404,
                            "error", "Not found",
                            "message", "Telefone não encontrado com o id:" + id

                    )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelefone(@PathVariable String id, @RequestBody Telefone telefone) {
        try {
            return ResponseEntity.ok(telefoneServices.update(Long.parseLong(id), telefone));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Erro de formatação para o id:" + id
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", 404,
                            "error", "Not found",
                            "message", "Telefone não encontrado com o id:" + id

                    )
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelefone(@PathVariable String id) {
        try {
            telefoneServices.delete(Long.parseLong(id));
            return ResponseEntity.ok().body(
                    Map.of(
                            "status", 200,
                            "message",
                            "Empresa excluído com sucesso!")
            );
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Erro de formatação para o id:" + id
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", 404,
                            "error", "Not found",
                            "message", "Telefone não encontrado com o id:" + id

                    )
            );
        }


    }
}

