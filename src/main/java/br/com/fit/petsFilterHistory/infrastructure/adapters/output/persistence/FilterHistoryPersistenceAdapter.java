package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsFilterHistory.application.ports.output.FilterHistoryOutputPort;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl.FilterHistoryMapper;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl.FilterHistoryUpdatePersistenceMapper;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.repository.FilterHistoryRepository;

@Component
public class FilterHistoryPersistenceAdapter implements FilterHistoryOutputPort{
	
	@Autowired
	FilterHistoryMapper filterHistoryMapper; 
	
	@Autowired
	FilterHistoryUpdatePersistenceMapper updateMapper;
	
	@Autowired
	FilterHistoryRepository repository; 
	
	
	@Override
	public TutorHistoric saveFilterHistory(TutorHistoric record) {
		var entity  = filterHistoryMapper.tutorRecordToEntity(record);
		return filterHistoryMapper.entityToTutorHistoricRecord(repository.save(entity));
	}

	@Override
	public TutorHistoric getTutorHistoricById(Long id) {
		var entity = repository.findById(id).orElseThrow( 
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found in database"));
		return filterHistoryMapper.entityToTutorHistoricRecord(entity);
	}

	@Override
	public List<TutorHistoric> getAllTutorHistorics() {
		var entityList = repository.findAll();
		
		if (entityList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Any Users found in database");
		}

		return filterHistoryMapper.entitieslistToFilterResponseList(entityList);
	}

	@Override
	public TutorHistoric updateTutorHistoricById(Long id, TutorHistoric record) {
		var entity = repository.findById(id).orElseThrow( 
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found in database"));

		if (Objects.nonNull(entity)) {
			updateMapper.tutorFilterToEntity(record, entity);
		}
		
		return filterHistoryMapper.entityToTutorHistoricRecord(repository.save(entity));
	}

	@Override
	public void deleteTutorHistoricById(Long id) {
		repository.deleteById(id);
	}

}
