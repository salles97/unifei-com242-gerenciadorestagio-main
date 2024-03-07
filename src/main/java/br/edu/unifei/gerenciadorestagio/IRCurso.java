package br.edu.unifei.gerenciadorestagio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRCurso extends JpaRepository<MCurso, Long> {
    Page<MInstituto> findByInstitutoId(long institutoId, Pageable pageable);
    Optional<MInstituto> findByIdAndInstitutoId(Long id, Long institutoId);
}
