package com.itb.inf2em.vitrine.model.services;

import com.itb.inf2em.vitrine.model.entity.Empresas;
import com.itb.inf2em.vitrine.model.repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresasService {

    @Autowired
    private EmpresasRepository empresasRepository;

    public List<Empresas> findAll() { return empresasRepository.findAll();}

    public Empresas save(Empresas empresas){
        empresas.setCodStatus(true);
        return empresasRepository.save(empresas);
    }

    public Empresas findById(Long id){
        return empresasRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Empresa não encontrada com o id" + id));
    }

    public Empresas update(Long id, Empresas empresas){
        Empresas empresaExistente = findById(id);
        empresaExistente.setNome(empresas.getNome());
        empresaExistente.setCnpj(empresas.getCnpj());
        empresaExistente.setCategoria(empresas.getCategoria());
        empresaExistente.setDescricao(empresas.getDescricao());
        empresaExistente.setEmail(empresas.getEmail());
        empresaExistente.setSenha(empresas.getSenha());
        empresaExistente.setLogradouro(empresas.getLogradouro());
        empresaExistente.setCidade(empresas.getCidade());
        empresaExistente.setCodStatus(empresas.isCodStatus());
        return empresasRepository.save(empresaExistente);
    }

    public void delete(Long id){
        Empresas empresaExistente = findById(id);
        empresasRepository.delete(empresaExistente);
    }
}
