package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.factory.FilterHistoricEntityFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricRecordFactory;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl.FilterHistoryMapper;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl.FilterHistoryUpdatePersistenceMapper;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.repository.FilterHistoryRepository;

class FilterHistoryPersistenceAdapterTest {

	@InjectMocks
	FilterHistoryPersistenceAdapter filterHistoryPersistenceAdapter;

	@Mock
	FilterHistoryMapper filterHistoryMapper; 
	
	@Mock
	FilterHistoryUpdatePersistenceMapper updateMapper;
	
	@Mock
	FilterHistoryRepository repository; 
	
	
	private TutorHistoric record; 
	
	private TutorHistoricEntity entity;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		record = FilterHistoricRecordFactory.buildRecordeMock();
		entity = FilterHistoricEntityFactory.buildEntityMock(); 
	}
	
	@Test
	void shouldSaveFilterHistoryWithSucess() {
		doReturn(entity).when(filterHistoryMapper).tutorRecordToEntity(record);
		doReturn(entity).when(repository).save(any());
		doReturn(record).when(filterHistoryMapper).entityToTutorHistoricRecord(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			var recordResponse = filterHistoryPersistenceAdapter.saveFilterHistory(record);
			Assertions.assertNotNull(recordResponse);
		});
	}
	
	@Test
	void shouldFindByIdWithSucess() {
		doReturn(Optional.of(entity)).when(repository).findById(any());
		doReturn(record).when(filterHistoryMapper).entityToTutorHistoricRecord(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			filterHistoryPersistenceAdapter.getTutorHistoricById(1L);
		});
	}
	
	@Test 
	void shouldFindAllWithSucess() {
		var entityList = new ArrayList<TutorHistoricEntity>();
		var recordList = new ArrayList<TutorHistoric>();
		
		entityList.add(entity);
		recordList.add(record);
		
		doReturn(entityList).when(repository).findAll();
		doReturn(recordList).when(filterHistoryMapper).entitieslistToFilterResponseList(entityList);
		
		
		Assertions.assertDoesNotThrow(() -> {
			var recordResponse = filterHistoryPersistenceAdapter.getAllTutorHistorics();
			Assertions.assertNotNull(recordResponse);
			Assertions.assertEquals(recordList.size(), recordResponse.size());
		});
	}
	
	@Test
	void shouldNotFindByInvalidId() {
		assertThrows(ResponseStatusException.class, () -> {
			filterHistoryPersistenceAdapter.getTutorHistoricById(3L);
		});
	}
	
	@Test
	void shouldNotFindAnyInfos() {
		var entityList = new ArrayList<TutorHistoricEntity>();
		var recordList = new ArrayList<TutorHistoric>();
		
		assertThrows(ResponseStatusException.class, () -> {
			filterHistoryPersistenceAdapter.getAllTutorHistorics();
		});
	}
	
	
	@Test
	void shouldDeleteByIdWithSucess() {
		Assertions.assertDoesNotThrow(() -> {
			filterHistoryPersistenceAdapter.deleteTutorHistoricById(3L);
		});
	}
	
	
	@Test
	void shoulUpdateEntityWithSucess() {
		doReturn(Optional.of(entity)).when(repository).findById(any());
		doReturn(entity).when(repository).save(any());
		doReturn(record).when(filterHistoryMapper).entityToTutorHistoricRecord(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			filterHistoryPersistenceAdapter.updateTutorHistoricById(1L, record);
		});
	}
	
	
	@Test
	void shouldNotFindByInvalidIdToUpdate() {
		assertThrows(ResponseStatusException.class, () -> {
			filterHistoryPersistenceAdapter.updateTutorHistoricById(1L, record);
		});
	}
	
	@Test
	void shouldNotFindByInvalidIdEntityNull() {
		Optional<TutorHistoricEntity> entiyObj = Optional.of(new TutorHistoricEntity());

		doReturn(entiyObj).when(repository).findById(any());
		doReturn(entity).when(repository).save(any());
		doReturn(record).when(filterHistoryMapper).entityToTutorHistoricRecord(any());
		
		Assertions.assertDoesNotThrow(() -> {
			filterHistoryPersistenceAdapter.updateTutorHistoricById(1L, record);
		});
	}
}
