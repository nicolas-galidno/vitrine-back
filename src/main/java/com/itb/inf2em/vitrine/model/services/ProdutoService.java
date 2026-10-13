package com.itb.inf2em.vitrine.model.services;

import com.itb.inf2em.vitrine.model.entity.Produto;
import com.itb.inf2em.vitrine.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){return produtoRepository.findAll();}

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado com o id: " + id));
    }

    public Produto update(Long id,Produto produto){
        Produto produtoExistente = findById(id);
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setDescricao(produto.getDescricao());
        return produtoRepository.save(produtoExistente);
    }

    public void delete(Long id){
        if(findById(id) != null){
            produtoRepository.deleteById(id);
        }
    }
}
