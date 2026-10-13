package com.itb.inf2em.vitrine.model.repository;

import com.itb.inf2em.vitrine.model.entity.EmpresaTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaTelefoneRepository extends JpaRepository<EmpresaTelefone, Long> {

}
