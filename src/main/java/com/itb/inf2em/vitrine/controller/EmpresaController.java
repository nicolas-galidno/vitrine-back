package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Empresas;
import com.itb.inf2em.vitrine.model.services.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


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

    @GetMapping("/{id}")
    public ResponseEntity<Object> FindById(@PathVariable String id){
        try{
            return ResponseEntity.ok(empresasService.findById(Long.parseLong(id)));
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
                            "message", "Empresa não encontrada com o id:" + id

                    )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpresas(@PathVariable String id, @RequestBody Empresas empresas){
        try{
            return ResponseEntity.ok(empresasService.update(Long.parseLong(id), empresas));
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
                            "message", "Empresa não encontrada com o id:" + id

                    )
            );
            }
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpresas(@PathVariable String id){
        try{
            empresasService.delete(Long.parseLong(id));
            return ResponseEntity.ok().body(
                    Map.of(
                            "status", 200,
                            "message",
                            "Produto excluído com sucesso!")
            );
        }catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error", "Not found",
                            "message", "Empresa não encontrada com o id:" + id
                    )
            );
        } catch (RuntimeException e){
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", 404,
                            "error", "Not found",
                            "message", "Empresa não encontrada com o id:" + id

                    )
            );
        }
    }
    }

