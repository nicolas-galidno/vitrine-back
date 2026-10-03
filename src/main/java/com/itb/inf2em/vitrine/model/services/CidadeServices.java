package com.itb.inf2em.vitrine.model.services;

import com.itb.inf2em.vitrine.model.entity.Cidade;
import com.itb.inf2em.vitrine.model.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServices {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    public Cidade save(Cidade cidade){
        return cidadeRepository.save(cidade);
    }
}
