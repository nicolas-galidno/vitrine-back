package itb.inf2em.vitrine.controller;

import itb.inf2em.vitrine.model.entity.Empresas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping( "/api/v1/empresas")
public class EmpresaController {

   List<Empresas> empresas = new ArrayList<Empresas>();

    @GetMapping
    public List<Empresas> findAll() {

        Empresas e1 = new Empresas();
        e1.setNome("Pizzaria do Fredao");
        e1.setCategoria("Pizzaria");
        e1.setNicho("Alimentacao");
        empresas.add(e1);

        Empresas e2 = new Empresas();
        e2.setNome("Tech Solutions");
        e2.setCategoria("Tecnologia");
        e2.setNicho("Desenvolvimento de Software");
        empresas.add(e2);

        return empresas;
    }



}
