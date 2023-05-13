package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;

@Repository
public interface FilterHistoryRepository extends JpaRepository<TutorHistoricEntity, Long> {
}
