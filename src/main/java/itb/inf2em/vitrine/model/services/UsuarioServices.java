package itb.inf2em.vitrine.model.services;

import itb.inf2em.vitrine.model.entity.Usuario;
import itb.inf2em.vitrine.model.repository.UsuarioRepository;
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
}

