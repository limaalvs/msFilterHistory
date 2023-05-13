package br.com.fit.petsFilterHistory.application.ports.output;

import java.util.List;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;

public interface FilterHistoryOutputPort {
	TutorHistoric saveFilterHistory(TutorHistoric record);
	TutorHistoric getTutorHistoricById(Long id);
	List<TutorHistoric> getAllTutorHistorics();
	TutorHistoric updateTutorHistoricById(Long id , TutorHistoric record);
	void deleteTutorHistoricById(Long id);
}
