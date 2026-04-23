package br.com.cpet.backend.repositories;

import br.com.cpet.backend.entities.Sobre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreRepository extends JpaRepository<Sobre, Long> {

}