package itb.inf2em.vitrine.controller;

import itb.inf2em.vitrine.model.entity.Telefone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/telefone")
public class TelefoneController {

    List<Telefone> telefone = new ArrayList<>();

    @GetMapping
    public List<Telefone> findAll() {
        return telefone;
    }
}
