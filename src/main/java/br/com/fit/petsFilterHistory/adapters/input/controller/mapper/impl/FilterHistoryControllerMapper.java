package br.com.fit.petsFilterHistory.adapters.input.controller.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsFilterHistory.adapters.input.controller.mapper.MapperController;
import br.com.fit.petsFilterHistory.domain.model.AnimalCharacteristics;
import br.com.fit.petsFilterHistory.domain.model.SearchSpecification;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.SearchSpecificationRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.TutorHistoricRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.AnimalCharacteristicsResponse;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.SearchSpecificationResponse;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.TutorHistoricResponse;

@Component
public class FilterHistoryControllerMapper implements MapperController {

	@Override
	public TutorHistoric toTutorHistoricRecord(TutorHistoricRequest request) {
		return this.mappingRecord(request);
	}

	private TutorHistoric mappingRecord(TutorHistoricRequest request) {
		TutorHistoric record = new TutorHistoric().builder().userName(request.getUserName())
				.filterList(this.definesFilterListEntity(request.getFilterList())).build();

		return record;
	}

	private List<SearchSpecification> definesFilterListEntity(List<SearchSpecificationRequest> filterList) {
		var searchList = new ArrayList<SearchSpecification>();

		for (SearchSpecificationRequest searchSpecificationEntity : filterList) {
			var searchResponseObj = new SearchSpecification();
			var animalCharacteristicsResponse = new AnimalCharacteristics();
			var animalCharacteristics = searchSpecificationEntity.getAnimalCharacteristics();

			animalCharacteristicsResponse.setId(animalCharacteristics.getId());
			animalCharacteristicsResponse.setPetType(animalCharacteristics.getPetType());
			animalCharacteristicsResponse.setSex(animalCharacteristics.getSex());
			animalCharacteristicsResponse.setAge(animalCharacteristics.getAge());
			animalCharacteristicsResponse.setCastrated(animalCharacteristics.getCastrated());
			animalCharacteristicsResponse.setVaccinated(animalCharacteristics.getVaccinated());
			animalCharacteristicsResponse.setDeficiency(animalCharacteristics.getDeficiency());
			animalCharacteristicsResponse.setPortType(animalCharacteristics.getPortType());

			searchResponseObj.setId(searchSpecificationEntity.getId());
			searchResponseObj.setDate(searchSpecificationEntity.getDate());
			searchResponseObj.setAnimalCharacteristics(animalCharacteristicsResponse);
			searchList.add(searchResponseObj);
		}

		return searchList;
	}

	@Override
	public TutorHistoricResponse tutorHistoricRecordToResponse(TutorHistoric record) {
		return mappingResponse(record);
	}

	private TutorHistoricResponse mappingResponse(TutorHistoric record) {

		TutorHistoricResponse response = new TutorHistoricResponse().builder().id(record.getId())
				.userName(record.getUserName()).filterList(this.definesFilterListResponse(record.getFilterList()))
				.build();

		return response;

	}

	private List<SearchSpecificationResponse> definesFilterListResponse(List<SearchSpecification> filterList) {

		var listSearchSpecificationresponse = new ArrayList<SearchSpecificationResponse>();

		for (SearchSpecification searchSpecificationEntity : filterList) {
			var searchResponseObj = new SearchSpecificationResponse();
			var animalCharacteristicsResponse = new AnimalCharacteristicsResponse();
			var animalCharacteristics = searchSpecificationEntity.getAnimalCharacteristics();

			animalCharacteristicsResponse.setId(animalCharacteristics.getId());
			animalCharacteristicsResponse.setPetType(animalCharacteristics.getPetType());
			animalCharacteristicsResponse.setSex(animalCharacteristics.getSex());
			animalCharacteristicsResponse.setAge(animalCharacteristics.getAge());
			animalCharacteristicsResponse.setCastrated(animalCharacteristics.getCastrated());
			animalCharacteristicsResponse.setVaccinated(animalCharacteristics.getVaccinated());
			animalCharacteristicsResponse.setDeficiency(animalCharacteristics.getDeficiency());
			animalCharacteristicsResponse.setPortType(animalCharacteristics.getPortType());

			searchResponseObj.setId(searchSpecificationEntity.getId());
			searchResponseObj.setDate(searchSpecificationEntity.getDate());
			searchResponseObj.setAnimalCharacteristics(animalCharacteristicsResponse);
			listSearchSpecificationresponse.add(searchResponseObj);
		}

		return listSearchSpecificationresponse;

	}

	@Override
	public List<TutorHistoricResponse> tutorHistoricRecordListToResponseList(List<TutorHistoric> recordList) {
		List<TutorHistoricResponse> filtersHistoricList = new ArrayList<>();

		for (TutorHistoric entity : recordList) {
			filtersHistoricList.add(this.mappingResponse(entity));
		}

		return filtersHistoricList;
	}

}
