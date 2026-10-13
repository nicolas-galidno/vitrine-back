package com.itb.inf2em.vitrine.model.services;

import com.itb.inf2em.vitrine.model.entity.EmpresaTelefone;
import com.itb.inf2em.vitrine.model.entity.Telefone;
import com.itb.inf2em.vitrine.model.repository.EmpresaTelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaTelefoneService {
    @Autowired
    private EmpresaTelefoneRepository empresaTelefoneRepository;

    public List<EmpresaTelefone> findAll(){
        return empresaTelefoneRepository.findAll();
    }

    public EmpresaTelefone save(EmpresaTelefone telefone){
        return empresaTelefoneRepository.save(telefone);
    }

    public EmpresaTelefone findById(Long id){
        return empresaTelefoneRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Usuario não encontrado" + id));
    }

    public EmpresaTelefone update(long l, EmpresaTelefone telefone){
        EmpresaTelefone empresaTelefoneExistente = findById(telefone.getId());
        Telefone telefoneExistente = telefone.getTelefone();
        empresaTelefoneExistente.setTelefone(telefone.getTelefone());
        telefoneExistente.setDdd(telefoneExistente.getDdd());
        telefoneExistente.setNumero(telefoneExistente.getNumero());
        empresaTelefoneExistente.setEmpresa(telefone.getEmpresa());
        return empresaTelefoneRepository.save(empresaTelefoneExistente);
    }

    public void delete(Long id) {
        if (findById(id) != null) {
            empresaTelefoneRepository.deleteById(id);
        }
    }
}
