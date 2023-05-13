package br.com.fit.petsFilterHistory.factory;

import java.util.ArrayList;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.AnimalCharacteristicsResponse;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.SearchSpecificationResponse;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.TutorHistoricResponse;

public class FilterHistoricResponseFactory {
	
	
	public static TutorHistoricResponse buildResponseMock() {
		var filterHistoricRespObj =new TutorHistoricResponse();
		var searchSpecification = new SearchSpecificationResponse(); 
		var animalCharacteristic = new AnimalCharacteristicsResponse();
		
		animalCharacteristic.setId(1L);
		animalCharacteristic.setPetType(PetType.CACHORRO);
		animalCharacteristic.setSex(Gender.M);
		animalCharacteristic.setAge("2 Meses");
		animalCharacteristic.setCastrated(Answer.SIM);
		animalCharacteristic.setVaccinated(Answer.SIM);
		animalCharacteristic.setDeficiency(Answer.NAO);
		animalCharacteristic.setPortType(PorType.GRANDE);
		
		searchSpecification.setAnimalCharacteristics(animalCharacteristic);
		
		filterHistoricRespObj.setFilterList(new ArrayList<>());
		filterHistoricRespObj.setId(1L);
		filterHistoricRespObj.setUserName("BruceNaoEhBatman");
		filterHistoricRespObj.getFilterList().add(searchSpecification);
		
		return filterHistoricRespObj;		
	}

}
