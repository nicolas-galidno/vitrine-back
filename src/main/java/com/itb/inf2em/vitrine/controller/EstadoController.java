package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Estado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {

    List<Estado> estado = new ArrayList<>();

    @GetMapping
    public List<Estado> findAll() {
        return estado;
    }
}
