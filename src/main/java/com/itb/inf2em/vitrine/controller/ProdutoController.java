package com.itb.inf2em.vitrine.controller;


import com.itb.inf2em.vitrine.model.entity.Produto;
import com.itb.inf2em.vitrine.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto){
        Produto novo = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> FindById(@PathVariable String id){
        try{
            return ResponseEntity.ok(produtoService.findById(Long.parseLong(id)));
        } catch(NumberFormatException e){
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
                            "message", "Produto não encontrada com o id:" + id

                    )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable String id, @RequestBody Produto produto) {
        try {
            return ResponseEntity.ok(produtoService.update(Long.parseLong(id), produto));
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
                            "message", "Produto não encontrada com o id:" + id

                    )
            );
        }
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<Object> deleteProduto(@PathVariable String id){
            try{
                produtoService.delete(Long.parseLong(id));
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
                                "error", "Bad Request",
                                "message", "Erro de formatação para o id:" + id
                        )
                );
            } catch (RuntimeException e){
                return ResponseEntity.status(404).body(
                        Map.of(
                                "status", 404,
                                "error", "Not found",
                                "message", "Produto não encontrada com o id:" + id

                        )
                );
            }
    }
}

