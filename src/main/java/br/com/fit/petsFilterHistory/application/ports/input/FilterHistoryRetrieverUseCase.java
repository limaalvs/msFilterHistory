package br.com.fit.petsFilterHistory.application.ports.input;

import java.util.List;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;

public interface FilterHistoryRetrieverUseCase {
	TutorHistoric findFilterHistoricById(Long id);
	List<TutorHistoric> findAllFilterHistoric();
}
