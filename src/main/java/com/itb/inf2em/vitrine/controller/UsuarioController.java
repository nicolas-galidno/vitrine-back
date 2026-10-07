package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Usuario;
import com.itb.inf2em.vitrine.model.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;



    @GetMapping
    public ResponseEntity <List<Usuario>> findAll() {

        return ResponseEntity.ok(usuarioServices.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        Usuario novo = usuarioServices.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> FindById(@PathVariable String id){
        try{
            return ResponseEntity.ok(usuarioServices.findById(Long.parseLong(id)));
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
                            "message", "Usuário não encontrada com o id:" + id

                    )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable String id, @RequestBody Usuario usuario){
        try{
            return ResponseEntity.ok(usuarioServices.update(Long.parseLong(id), usuario));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error", "Bad Request",
                            "message", "Erro de formatação para o id:" + id
                    )
            );
        }catch (RuntimeException e){
            return ResponseEntity.status(404).body(
                    Map.of(
                            "status", 404,
                            "error", "Not found",
                            "message", "Usuário não encontrada com o id:" + id

                    )
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable String id){
        try{
            usuarioServices.delete(Long.parseLong(id));
            return ResponseEntity.ok().body(
                    Map.of(
                            "status", 200,
                            "message",
                            "Usuário excluído com sucesso!")
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
                            "message", "Usuário não encontrado com o id:" + id

                    )
            );
        }
    }
}
