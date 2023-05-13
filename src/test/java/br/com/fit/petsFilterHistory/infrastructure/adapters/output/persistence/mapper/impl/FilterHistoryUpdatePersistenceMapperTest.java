package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
import br.com.fit.petsFilterHistory.domain.model.AnimalCharacteristics;
import br.com.fit.petsFilterHistory.domain.model.SearchSpecification;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.factory.FilterHistoricEntityFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricRecordFactory;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;


@ExtendWith(SpringExtension.class)
class FilterHistoryUpdatePersistenceMapperTest {

	@InjectMocks
	FilterHistoryUpdatePersistenceMapper mapper;
	
	private TutorHistoric record; 
	
	private TutorHistoricEntity entity; 
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		record = FilterHistoricRecordFactory.buildRecordeMock();
		entity = FilterHistoricEntityFactory.buildEntityMock();
	}
	

	@Test
	void shouldTutorFilterToEntityEithSucess() {
		Assertions.assertDoesNotThrow(() -> {
			mapper.tutorFilterToEntity(record, entity);
			Assertions.assertNotNull(record);
			Assertions.assertNotNull(entity);
			Assertions.assertEquals(record.getUserName(), entity.getUserName());
		});
	}
	
	
	@Test
	void shouldMapperRequestEntityWithSucess() {
		var searchSpecification = new SearchSpecification(); 
		var animalCharacteristic = new AnimalCharacteristics();
		
		animalCharacteristic.setPetType(PetType.PASSARO);
		animalCharacteristic.setSex(Gender.M);
		animalCharacteristic.setAge("1 ano");
		animalCharacteristic.setCastrated(Answer.SIM);
		animalCharacteristic.setVaccinated(Answer.SIM);
		animalCharacteristic.setDeficiency(Answer.SIM);
		animalCharacteristic.setPortType(PorType.GRANDE);
	
		record.setUserName("BatmanEhBruce");
		record.getFilterList().get(0).setId(1L);
		record.getFilterList().get(0).getAnimalCharacteristics().setPetType(PetType.GATO);
		record.getFilterList().get(0).getAnimalCharacteristics().setSex(Gender.F);
		record.getFilterList().get(0).getAnimalCharacteristics().setAge("2 Anos");
		record.getFilterList().get(0).getAnimalCharacteristics().setCastrated(Answer.NAO);
		record.getFilterList().get(0).getAnimalCharacteristics().setVaccinated(Answer.NAO);
		record.getFilterList().get(0).getAnimalCharacteristics().setDeficiency(Answer.NAO);
		record.getFilterList().get(0).getAnimalCharacteristics().setPortType(PorType.MEDIO);
		
		searchSpecification.setAnimalCharacteristics(animalCharacteristic);

		record.getFilterList().add(searchSpecification);
		
		Assertions.assertDoesNotThrow(() -> {
			mapper.tutorFilterToEntity(record, entity);
			Assertions.assertEquals("BatmanEhBruce", entity.getUserName());
			Assertions.assertEquals(PetType.GATO, entity.getFilterList().get(0).getAnimalCharacteristics().getPetType());
			Assertions.assertEquals(PetType.PASSARO, entity.getFilterList().get(1).getAnimalCharacteristics().getPetType());
		});
	}
	
}
