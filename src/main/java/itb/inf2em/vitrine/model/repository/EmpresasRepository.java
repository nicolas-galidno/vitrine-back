package itb.inf2em.vitrine.model.repository;

import itb.inf2em.vitrine.model.entity.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long> {
}
