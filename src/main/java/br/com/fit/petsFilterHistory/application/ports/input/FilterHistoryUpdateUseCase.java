package br.com.fit.petsFilterHistory.application.ports.input;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;

public interface FilterHistoryUpdateUseCase {
	TutorHistoric updateFilterHistoricById(Long id, TutorHistoric record);
}
