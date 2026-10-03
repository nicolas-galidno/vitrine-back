package com.itb.inf2em.vitrine.model.services;

import com.itb.inf2em.vitrine.model.entity.Categoria;
import com.itb.inf2em.vitrine.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria){
        categoria.setCodStatus(true);
        return categoriaRepository.save(categoria);
    }
}