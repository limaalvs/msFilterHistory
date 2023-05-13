package br.com.fit.petsFilterHistory.domain.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import br.com.fit.petsFilterHistory.application.ports.output.FilterHistoryOutputPort;

@ExtendWith(SpringExtension.class)
class FilterHistoryServiceImplTest {

	@InjectMocks
	FilterHistoryService filterHistoryService;
	
	@Mock
	FilterHistoryOutputPort filterHistoryOutputPort;  
	
	@Test
	void whenCreateRegisterIsCallVerify() {
		filterHistoryService.createFilter(any());
		Mockito.verify(filterHistoryOutputPort, Mockito.times(1)).saveFilterHistory(any());
	}
	
	@Test
	void whenFindFilteHistoricByIdIsCallVerify() {
		filterHistoryService.findFilterHistoricById(any());
		Mockito.verify(filterHistoryOutputPort, Mockito.times(1)).getTutorHistoricById(any());
	}
	
	@Test
	void whenFindAllFilteHistoricByIdIsCallVerify() {
		filterHistoryService.findAllFilterHistoric();
		Mockito.verify(filterHistoryOutputPort, Mockito.times(1)).getAllTutorHistorics();
	}
	
	@Test
	void whenDeleteFilterHistoricByIdIsCallVerify() {
		filterHistoryService.deleteFilterHistoricById(any());
		Mockito.verify(filterHistoryOutputPort, Mockito.times(1)).deleteTutorHistoricById(any());
	}
	
	@Test
	void whenUpdateFilterHistoricIsCallVerify() {
		filterHistoryService.updateFilterHistoricById(any(), any());
		Mockito.verify(filterHistoryOutputPort, Mockito.times(1)).updateTutorHistoricById(any(), any());
	}
}
