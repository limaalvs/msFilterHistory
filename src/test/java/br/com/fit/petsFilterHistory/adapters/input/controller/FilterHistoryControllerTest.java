package br.com.fit.petsFilterHistory.adapters.input.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fit.petsFilterHistory.adapters.input.controller.mapper.impl.FilterHistoryControllerMapper;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryCreateUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryDeletionUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryRetrieverUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryUpdateUseCase;
import br.com.fit.petsFilterHistory.domain.model.TutorHistoric;
import br.com.fit.petsFilterHistory.factory.FilterHistoricRecordFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricRequestFactory;
import br.com.fit.petsFilterHistory.factory.FilterHistoricResponseFactory;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.TutorHistoricRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.TutorHistoricResponse;

@WebMvcTest(FilterHistoryController.class)
class FilterHistoryControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper; 
	
	@MockBean
	FilterHistoryCreateUseCase filterHistoryCreateUseCase;
	
	@MockBean
	FilterHistoryRetrieverUseCase filterHistoryRetrieverUseCase; 
	
	@MockBean
	FilterHistoryUpdateUseCase filterHistoryUpdateUseCase;
	
	@MockBean
	FilterHistoryDeletionUseCase filterHistoryDeletionUseCase; 
	
	@MockBean
	FilterHistoryControllerMapper filterHistoryControllerMapper; 
	
	TutorHistoricRequest request;
	
	TutorHistoricResponse response;
	
	TutorHistoric record; 
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = FilterHistoricRequestFactory.buildRequestMock();
		response = FilterHistoricResponseFactory.buildResponseMock();
		record = FilterHistoricRecordFactory.buildRecordeMock();
	}
	
	
	@Test
	void createNewHistoric_with_sucess() throws Exception {
		given(filterHistoryControllerMapper.toTutorHistoricRecord(request)).willReturn(record);
		given(filterHistoryControllerMapper.tutorHistoricRecordToResponse(record)).willReturn(response);
		given(filterHistoryCreateUseCase.createFilter(record)).willReturn(record);
		var content = this.objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/filterHistoric")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content))
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.userName", is(request.getUserName())));
	}
	
	
	@Test
	void getAllFiltersHistoric__with_success() throws Exception {		
		mockMvc.perform(get("/filterHistoric")).andExpect(status().isOk());
	}
	
	
	@Test
	void deleteFilterHistoricById__with_success() throws Exception {
		mockMvc.perform(delete("/filterHistoric/1")).andExpect(status().isOk());
	}
	
	
	@Test
	void getById__with_success() throws Exception {
		given(filterHistoryRetrieverUseCase.findFilterHistoricById(1L)).willReturn(record);
		given(filterHistoryControllerMapper.tutorHistoricRecordToResponse(record)).willReturn(response);
		mockMvc.perform(get("/filterHistoric/1"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id",is(1)));
	}
	
	
	@Test
	void updateById__with_success() throws Exception {
		given(filterHistoryControllerMapper.toTutorHistoricRecord(request)).willReturn(record);
		given(filterHistoryControllerMapper.tutorHistoricRecordToResponse(record)).willReturn(response);
		given(filterHistoryUpdateUseCase.updateFilterHistoricById(1L, record)).willReturn(record);
		var content = this.objectMapper.writeValueAsString(request);
		
		mockMvc.perform(put("/filterHistoric/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content))
		.andExpect(status().isOk());
	}
	
	@Test
	void whenUsernameIsInvalid_thenReturnsStatus400() throws Exception {
		request.setUserName(null);
		var content = this.objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/filterHistoric")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content)).andExpect(status().isBadRequest());
	} 
	
	@Test
	void whenPathVariableGetIsInvalid_thenReturnsStatus400() throws Exception {
		mockMvc.perform(get("/filterHistoric/0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void whenPathVariablePutIsInvalid_thenReturnsStatus400 () throws Exception {
		mockMvc.perform(put("/filterHistoric/0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void whenPathVariableDeleteIsInvalid_thenReturnsStatus400 () throws Exception {
		mockMvc.perform(delete("/filterHistoric/0")).andExpect(status().isBadRequest());

	}
}
