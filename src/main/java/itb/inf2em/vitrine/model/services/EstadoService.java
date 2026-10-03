package itb.inf2em.vitrine.model.services;

import itb.inf2em.vitrine.model.entity.Estado;
import itb.inf2em.vitrine.model.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll(){
        return estadoRepository.findAll();
    }

    public Estado save(Estado estado){
        return estadoRepository.save(estado);
    }
}
