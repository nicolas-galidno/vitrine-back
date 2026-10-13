package com.itb.inf2em.vitrine.model.services;


import com.itb.inf2em.vitrine.model.entity.Usuario;
import com.itb.inf2em.vitrine.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        usuario.setCodStatus(true);
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado" + id));
    }

    public Usuario update(Long id, Usuario usuario){
        Usuario usuarioExistente = findById(usuario.getId());
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setTelefone(usuario.getTelefone());
        usuarioExistente.setCodStatus(true);
        return usuarioRepository.save(usuarioExistente);
    }

    public void delete(Long id) {
        if (findById(id) != null) {
            usuarioRepository.deleteById(id);
        }
    }
}

