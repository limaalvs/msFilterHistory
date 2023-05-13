package br.com.fit.petsFilterHistory.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryCreateUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryDeletionUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryRetrieverUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryUpdateUseCase;
import br.com.fit.petsFilterHistory.application.ports.output.FilterHistoryOutputPort;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;

@Service
public class FilterHistoryService implements FilterHistoryCreateUseCase, FilterHistoryRetrieverUseCase,
		FilterHistoryUpdateUseCase, FilterHistoryDeletionUseCase {

	@Autowired
	FilterHistoryOutputPort filterHistoryOutputPort; 
	
	
	@Override
	public TutorHistoric createFilter(TutorHistoric record) {
		return filterHistoryOutputPort.saveFilterHistory(record);
	}

	@Override
	public TutorHistoric findFilterHistoricById(Long id) {
		return filterHistoryOutputPort.getTutorHistoricById(id);
	}

	@Override
	public List<TutorHistoric> findAllFilterHistoric() {
		return filterHistoryOutputPort.getAllTutorHistorics();
	}

	@Override
	public TutorHistoric updateFilterHistoricById(Long id, TutorHistoric record) {
		return filterHistoryOutputPort.updateTutorHistoricById(id, record);
	}

	@Override
	public void deleteFilterHistoricById(Long id) {
		filterHistoryOutputPort.deleteTutorHistoricById(id);
	}

}
