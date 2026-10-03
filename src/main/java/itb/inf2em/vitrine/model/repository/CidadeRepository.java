package itb.inf2em.vitrine.model.repository;

import itb.inf2em.vitrine.model.entity.Categoria;
import itb.inf2em.vitrine.model.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
