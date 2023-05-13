package br.com.fit.petsFilterHistory.adapters.input.controller.mapper;

import java.util.List;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.TutorHistoricRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.TutorHistoricResponse;

public interface MapperController {
	TutorHistoric toTutorHistoricRecord(TutorHistoricRequest request);
	TutorHistoricResponse tutorHistoricRecordToResponse(TutorHistoric record);
	List<TutorHistoricResponse> tutorHistoricRecordListToResponseList(List<TutorHistoric> recordList);
}
