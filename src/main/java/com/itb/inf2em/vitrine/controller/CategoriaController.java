package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    List<Categoria> categorias = new ArrayList<>();

    @GetMapping
    public List<Categoria> findAll() {
        return categorias;
    }
}