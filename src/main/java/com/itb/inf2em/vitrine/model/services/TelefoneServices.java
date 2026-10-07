package com.itb.inf2em.vitrine.model.services;

import com.itb.inf2em.vitrine.model.entity.Telefone;
import com.itb.inf2em.vitrine.model.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServices {
    @Autowired
    private TelefoneRepository telefoneRepository;

    public List<Telefone> findAll(){
        return telefoneRepository.findAll();
    }

    public Telefone save(Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public Telefone findById(Long id){
        return telefoneRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Usuario não encontrado" + id));
    }

    public Telefone update(long l, Telefone telefone){
        Telefone telefoneExistente = findById(telefone.getId());
        telefoneExistente.setDdd(telefone.getDdd());
        telefoneExistente.setEmpresa(telefone.getEmpresa());
        telefoneExistente.setUsuario(telefone.getUsuario());
        telefoneExistente.setNumero(telefone.getNumero());
        return telefoneRepository.save(telefoneExistente);
    }

    public void delete(Long id){
        Telefone telefone = findById(id);
        telefoneRepository.deleteById(id);
    }
}
