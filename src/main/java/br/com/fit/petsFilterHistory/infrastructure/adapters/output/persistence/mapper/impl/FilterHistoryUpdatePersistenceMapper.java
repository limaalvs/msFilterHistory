package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.mapper.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.fit.petsFilterHistory.domain.model.AnimalCharacteristics;
import br.com.fit.petsFilterHistory.domain.model.SearchSpecification;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.AnimalCharacteristicsEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.SearchSpecificationEntity;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;

@Component
public class FilterHistoryUpdatePersistenceMapper {

	public void tutorFilterToEntity(TutorHistoric record, TutorHistoricEntity entity) {
		this.updateUsername(record, entity);
		this.updateAnimalCharacteristics(record.getFilterList(), entity.getFilterList());
	}

	private void updateUsername(TutorHistoric record, TutorHistoricEntity entity) {
		entity.setUserName(record.getUserName().equalsIgnoreCase(entity.getUserName()) ? entity.getUserName()
				: record.getUserName());
	}

	private void updateAnimalCharacteristics(List<SearchSpecification> filterListRecord,
			List<SearchSpecificationEntity> filterListEntity) {

		for (int i = 0; i < filterListEntity.size(); i++) {
			for (int j = 0; j < filterListRecord.size(); j++) {
				if (this.updateObj(filterListEntity.get(i), filterListRecord.get(j))) {

					this.comparisonToUpdate(filterListEntity.get(i).getAnimalCharacteristics(),
							filterListRecord.get(j).getAnimalCharacteristics());
					filterListRecord.remove(j);
				} else if (Objects.isNull(filterListRecord.get(j))) {

					var search = new SearchSpecificationEntity().builder().date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()))
							.animalCharacteristics(
									this.characteristicsNewValues(filterListRecord.get(j).getAnimalCharacteristics()))
							.build();
					filterListEntity.add(search);
					filterListRecord.remove(j);
				}

			}
		}
		this.validateRequestList(filterListRecord, filterListEntity);
	}

	private void validateRequestList(List<SearchSpecification> recordList, List<SearchSpecificationEntity> entityList) {
		if (!recordList.isEmpty()) {
			for (br.com.fit.petsFilterHistory.domain.model.SearchSpecification searchObj : recordList) {
				var search = new SearchSpecificationEntity().builder().date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()))
						.animalCharacteristics(this.characteristicsNewValues(searchObj.getAnimalCharacteristics()))
						.build();

				entityList.add(search);
			}
		}

	}

	private AnimalCharacteristicsEntity characteristicsNewValues(AnimalCharacteristics characteristics) {

		var animalCharacteristics = new AnimalCharacteristicsEntity().builder().petType(characteristics.getPetType())
				.sex(characteristics.getSex()).age(characteristics.getAge()).castrated(characteristics.getCastrated())
				.vaccinated(characteristics.getVaccinated()).deficiency(characteristics.getVaccinated())
				.portType(characteristics.getPortType()).build();

		return animalCharacteristics;
	}

	private void comparisonToUpdate(AnimalCharacteristicsEntity entity,
			br.com.fit.petsFilterHistory.domain.model.AnimalCharacteristics request) {
		entity.setPetType(request.getPetType() == entity.getPetType() ? entity.getPetType() : request.getPetType());

		entity.setSex(request.getSex() == entity.getSex() ? entity.getSex() : request.getSex());

		entity.setAge(request.getAge().equalsIgnoreCase(entity.getAge()) ? entity.getAge() : request.getAge());

		entity.setCastrated(
				request.getCastrated() == entity.getCastrated() ? entity.getCastrated() : request.getCastrated());

		entity.setVaccinated(
				request.getVaccinated() == entity.getVaccinated() ? entity.getVaccinated() : request.getVaccinated());

		entity.setDeficiency(
				request.getDeficiency() == entity.getDeficiency() ? entity.getDeficiency() : request.getDeficiency());

		entity.setPortType(
				request.getPortType() == entity.getPortType() ? entity.getPortType() : request.getPortType());
	}

	private boolean updateObj(SearchSpecificationEntity objEntity,
			br.com.fit.petsFilterHistory.domain.model.SearchSpecification ObjRequest) {
		return (null != ObjRequest.getId()) && (objEntity.getId() == ObjRequest.getId());
	}

}
