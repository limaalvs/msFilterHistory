package br.com.fit.petsFilterHistory.adapters.input.controller.mapper.impl;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.factory.FilterHistoricEntityFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricRecordFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricRequestFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricResponseFactory;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.TutorHistoricRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.TutorHistoricResponse;
import br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity.TutorHistoricEntity;

@ExtendWith(SpringExtension.class)
class FilterHistoryControllerMapperTest {

	@InjectMocks
	FilterHistoryControllerMapper filterHistoryControllerMapper;
	
	private TutorHistoricRequest request;

	private TutorHistoricResponse response;

	private TutorHistoricEntity entity;
	
	private TutorHistoric record;
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = FilterHistoricRequestFactory.buildRequestMock();
		response = FilterHistoricResponseFactory.buildResponseMock();
		record = FilterHistoricRecordFactory.buildRecordeMock();
		entity = FilterHistoricEntityFactory.buildEntityMock();
	}
	
	
	@Test
	void shouldConvertToRecordWithSuccess() {
		Assertions.assertDoesNotThrow(() -> {
			var recordConverted = filterHistoryControllerMapper.toTutorHistoricRecord(request);
			Assertions.assertNotNull(recordConverted);
			Assertions.assertEquals(recordConverted.getUserName(), request.getUserName());
		});
	}

	@Test
	void shouldConvertToResponse() {
		Assertions.assertDoesNotThrow(() -> {
			var response = filterHistoryControllerMapper.tutorHistoricRecordToResponse(record);
			Assertions.assertNotNull(response);
			Assertions.assertEquals(response.getUserName(), record.getUserName());
		});

	}

	@Test
	void sholdConvertToListResponsePetInfoWithSuccess() {
		var tutorHistoricList = new ArrayList<TutorHistoric>();

		Assertions.assertDoesNotThrow(() -> {
			var listResponseHistoric = filterHistoryControllerMapper.tutorHistoricRecordListToResponseList(tutorHistoricList);
			Assertions.assertNotNull(listResponseHistoric);
			Assertions.assertEquals(tutorHistoricList.size(), listResponseHistoric.size());
		});

	}
	
}
