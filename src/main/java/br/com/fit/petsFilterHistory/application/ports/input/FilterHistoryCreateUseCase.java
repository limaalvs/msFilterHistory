package br.com.fit.petsFilterHistory.application.ports.input;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;

public interface FilterHistoryCreateUseCase {
	TutorHistoric createFilter(TutorHistoric record);
}
