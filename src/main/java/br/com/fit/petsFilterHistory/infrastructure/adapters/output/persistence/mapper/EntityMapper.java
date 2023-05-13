package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;

public interface EntityMapper {
	TutorHistoricEntity tutorRecordToEntity(TutorHistoric record);
	TutorHistoric entityToTutorHistoricRecord(TutorHistoricEntity entity);
	List<TutorHistoric> entitieslistToFilterResponseList(List<TutorHistoricEntity> entityList);
}
