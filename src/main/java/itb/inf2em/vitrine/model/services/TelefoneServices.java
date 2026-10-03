package itb.inf2em.vitrine.model.services;

import itb.inf2em.vitrine.model.entity.Telefone;
import itb.inf2em.vitrine.model.repository.TelefoneRepository;
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
        telefone.setCodStatus(true);
        return telefoneRepository.save(telefone);
    }
}
