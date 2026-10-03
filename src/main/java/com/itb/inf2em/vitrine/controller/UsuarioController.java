package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    List<Usuario> usuario = new ArrayList<>();

    @GetMapping
    public List<Usuario> findAll() {
        return usuario;
    }
}
