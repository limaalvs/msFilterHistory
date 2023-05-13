package br.com.fit.petsFilterHistory.factory;

import java.util.ArrayList;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
import br.com.fit.petsFilterHistory.domain.model.AnimalCharacteristics;
import br.com.fit.petsFilterHistory.domain.model.SearchSpecification;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;


public class FilterHistoricRecordFactory {
	public static TutorHistoric buildRecordeMock() {
		var filterHistoricRespObj =new TutorHistoric();
		var searchSpecification = new SearchSpecification(); 
		var animalCharacteristic = new AnimalCharacteristics();
		
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
