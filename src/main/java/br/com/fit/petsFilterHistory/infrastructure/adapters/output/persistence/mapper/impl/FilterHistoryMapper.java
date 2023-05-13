package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsFilterHistory.domain.model.AnimalCharacteristics;
import br.com.fit.petsFilterHistory.domain.model.SearchSpecification;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.AnimalCharacteristicsEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.SearchSpecificationEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.EntityMapper;

@Component
public class FilterHistoryMapper implements EntityMapper{

	@Override
	public TutorHistoricEntity tutorRecordToEntity(TutorHistoric record) {
		return this.mapping(record);

	}

	private TutorHistoricEntity mapping(TutorHistoric record) {
		TutorHistoricEntity entityObj = new TutorHistoricEntity().builder().userName(record.getUserName())
				.filterList(this.definesFilterListEntity(record.getFilterList())).build();

		return entityObj;
	}

	private List<SearchSpecificationEntity> definesFilterListEntity(List<SearchSpecification> filterList) {
		var listEntityObj = new ArrayList<SearchSpecificationEntity>();

		for (SearchSpecification searchSpecification : filterList) {
			var searchEntityObj = new SearchSpecificationEntity();
			var animalCharacteristicsEntity = new AnimalCharacteristicsEntity();
			var animalCharacteristics = searchSpecification.getAnimalCharacteristics();

			animalCharacteristicsEntity.setPetType(animalCharacteristics.getPetType());
			animalCharacteristicsEntity.setSex(animalCharacteristics.getSex());
			animalCharacteristicsEntity.setAge(animalCharacteristics.getAge());
			animalCharacteristicsEntity.setCastrated(animalCharacteristics.getCastrated());
			animalCharacteristicsEntity.setVaccinated(animalCharacteristics.getVaccinated());
			animalCharacteristicsEntity.setDeficiency(animalCharacteristics.getDeficiency());
			animalCharacteristicsEntity.setPortType(animalCharacteristics.getPortType());

			searchEntityObj.setDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
			searchEntityObj.setAnimalCharacteristics(animalCharacteristicsEntity);

			listEntityObj.add(searchEntityObj);
		}

		return listEntityObj;
	}

	@Override
	public TutorHistoric entityToTutorHistoricRecord(TutorHistoricEntity entity) {
		return this.unmapping(entity);
	}

	@Override
	public List<TutorHistoric> entitieslistToFilterResponseList(List<TutorHistoricEntity> entityList) {

		List<TutorHistoric> filtersHistoricList = new ArrayList<>();

		for (TutorHistoricEntity entity : entityList) {
			filtersHistoricList.add(this.unmapping(entity));
		}

		return filtersHistoricList;
	}

	private TutorHistoric unmapping(TutorHistoricEntity entity) {

		TutorHistoric response = new TutorHistoric().builder()
				.id(entity.getId())
				.userName(entity.getUserName())
				.filterList(this.definesFilterListResponse(entity.getFilterList())).build();

		return response;
	}

	private List<SearchSpecification> definesFilterListResponse(List<SearchSpecificationEntity> filterList) {
		var listResponseObj = new ArrayList<SearchSpecification>();

		for (SearchSpecificationEntity searchSpecificationEntity : filterList) {
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
			listResponseObj.add(searchResponseObj);
		}

		return listResponseObj;
	}

}
