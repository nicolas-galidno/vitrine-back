package itb.inf2em.vitrine.controller;

import itb.inf2em.vitrine.model.entity.Usuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    List<Usuarios> usuario = new ArrayList<>();

    @GetMapping
    public List<Usuarios> findAll() {
        return usuario;
    }
}
