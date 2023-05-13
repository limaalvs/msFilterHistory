package br.com.fit.petsFilterHistory.factory;

import java.util.ArrayList;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.AnimalCharacteristicsEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.SearchSpecificationEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;

public class FilterHistoricEntityFactory {
	
	
	public static TutorHistoricEntity buildEntityMock() {
		var entityObj = new TutorHistoricEntity();
		var searchSpecification = new SearchSpecificationEntity(); 
		var animalCharacteristic = new AnimalCharacteristicsEntity();
		
		animalCharacteristic.setId(1L);
		animalCharacteristic.setPetType(PetType.CACHORRO);
		animalCharacteristic.setSex(Gender.M);
		animalCharacteristic.setAge("2 Meses");
		animalCharacteristic.setCastrated(Answer.SIM);
		animalCharacteristic.setVaccinated(Answer.SIM);
		animalCharacteristic.setDeficiency(Answer.NAO);
		animalCharacteristic.setPortType(PorType.GRANDE);
		
		searchSpecification.setId(1L);
		searchSpecification.setAnimalCharacteristics(animalCharacteristic);
		
		entityObj.setFilterList(new ArrayList<>());
		entityObj.setId(1L);
		entityObj.setUserName("BruceNaoEhBatman");
		entityObj.getFilterList().add(searchSpecification);
		
		return entityObj; 
	}
}
