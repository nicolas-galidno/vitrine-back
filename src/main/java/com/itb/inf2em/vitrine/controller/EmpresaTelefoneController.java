package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.EmpresaTelefone;
import com.itb.inf2em.vitrine.model.services.EmpresaTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/empresa/telefone")
public class EmpresaTelefoneController {

    @Autowired
    private EmpresaTelefoneService empresaTelefoneService;

    @GetMapping
    public ResponseEntity<List<EmpresaTelefone>> findAll() {

        return ResponseEntity.ok(empresaTelefoneService.findAll());
    }

    @PostMapping
    public ResponseEntity<EmpresaTelefone> salvarTelefone(@RequestBody EmpresaTelefone telefone) {
        EmpresaTelefone newTelefone = empresaTelefoneService.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTelefone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(empresaTelefoneService.findById(Long.parseLong(id)));
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
    public ResponseEntity<Object> updateTelefone(@PathVariable String id, @RequestBody EmpresaTelefone telefone) {
        try {
            return ResponseEntity.ok(empresaTelefoneService.update(Long.parseLong(id), telefone));
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
            empresaTelefoneService.delete(Long.parseLong(id));
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

