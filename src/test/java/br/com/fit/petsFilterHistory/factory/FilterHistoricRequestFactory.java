package br.com.fit.petsFilterHistory.factory;

import java.util.ArrayList;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.AnimalCharacteristicsRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.SearchSpecificationRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.TutorHistoricRequest;

public class FilterHistoricRequestFactory {
	
	
	public static TutorHistoricRequest buildRequestMock() {
		var filterHistoricObj = new TutorHistoricRequest(); 
		var searchSpecification = new SearchSpecificationRequest(); 
		var animalCharacteristic = new AnimalCharacteristicsRequest();
		
		animalCharacteristic.setPetType(PetType.CACHORRO);
		animalCharacteristic.setSex(Gender.M);
		animalCharacteristic.setAge("2 Meses");
		animalCharacteristic.setCastrated(Answer.SIM);
		animalCharacteristic.setVaccinated(Answer.SIM);
		animalCharacteristic.setDeficiency(Answer.NAO);
		animalCharacteristic.setPortType(PorType.GRANDE);
		
		searchSpecification.setAnimalCharacteristics(animalCharacteristic);
		
		filterHistoricObj.setUserName("BruceNaoEhBatman");
		filterHistoricObj.setFilterList(new ArrayList<>());
		filterHistoricObj.getFilterList().add(searchSpecification);
		
		return filterHistoricObj; 
	}

}
