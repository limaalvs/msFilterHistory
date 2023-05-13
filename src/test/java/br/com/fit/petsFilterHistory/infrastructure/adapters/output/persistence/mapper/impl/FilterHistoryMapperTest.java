package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;
import br.com.fit.petsFilterHistory.factory.*;

@ExtendWith(SpringExtension.class)
class FilterHistoryMapperTest {

	@InjectMocks
	FilterHistoryMapper filterHistoryMapper;
	
	private TutorHistoric record; 
	
	private TutorHistoricEntity entity; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		record = FilterHistoricRecordFactory.buildRecordeMock();
		entity = FilterHistoricEntityFactory.buildEntityMock();
	}

	@Test
	void shouldConvertRecordToEntityWithSucess() {
		Assertions.assertDoesNotThrow(() -> {			
			var entityObj = filterHistoryMapper.tutorRecordToEntity(record);
			
			Assertions.assertNotNull(entityObj);
			Assertions.assertEquals(entityObj.getUserName(), record.getUserName());
		});
	}
	
	

	@Test
	void shouldConvertEntityToRecord() {
		Assertions.assertDoesNotThrow(() -> {
			var recordObj = filterHistoryMapper.entityToTutorHistoricRecord(entity);
			Assertions.assertNotNull(recordObj);
			Assertions.assertEquals(entity.getUserName(), recordObj.getUserName());
		});
	}
	
	

	@Test
	void shouldConvertEntityListToRecordList() {
		var entityList = new ArrayList<TutorHistoricEntity>();
		
		entityList.add(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			var recordList = filterHistoryMapper.entitieslistToFilterResponseList(entityList);
			Assertions.assertNotNull(recordList);
			Assertions.assertEquals(entityList.size(), recordList.size());
		});
	}
}
