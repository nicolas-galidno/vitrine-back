package com.itb.inf2em.vitrine.controller;

import com.itb.inf2em.vitrine.model.entity.Cidade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cidade")
public class CidadeController {

    List<Cidade> cidade = new ArrayList<>();

    @GetMapping
    public List<Cidade> findAll() {
        return cidade;
    }
}