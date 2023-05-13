package br.com.fit.petsFilterHistory.adapters.input.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fit.petsFilterHistory.adapters.input.controller.mapper.impl.FilterHistoryControllerMapper;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryCreateUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryDeletionUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryRetrieverUseCase;
import br.com.fit.petsFilterHistory.application.ports.input.FilterHistoryUpdateUseCase;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request.TutorHistoricRequest;
import br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response.TutorHistoricResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/filterHistoric")
@Validated
public class FilterHistoryController {
	
	@Autowired
	FilterHistoryCreateUseCase filterHistoryCreateUseCase;
	
	@Autowired
	FilterHistoryRetrieverUseCase filterHistoryRetrieverUseCase; 
	
	@Autowired
	FilterHistoryUpdateUseCase filterHistoryUpdateUseCase;
	
	@Autowired
	FilterHistoryDeletionUseCase filterHistoryDeletionUseCase; 
	
	@Autowired
	FilterHistoryControllerMapper filterHistoryControllerMapper; 
	
	
	@PostMapping
	public ResponseEntity<TutorHistoricResponse> createFilterHistoric(@Valid @RequestBody TutorHistoricRequest request) {
		 var record = filterHistoryCreateUseCase.createFilter(filterHistoryControllerMapper.toTutorHistoricRecord(request));
		 return new ResponseEntity<>(filterHistoryControllerMapper.tutorHistoricRecordToResponse(record), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TutorHistoricResponse> getFilterHistoricById(@PathVariable @Min(value = 1, message = "Historic id should be gretter than 0") Long id) {
		var record = filterHistoryRetrieverUseCase.findFilterHistoricById(id);
		return new ResponseEntity<>(filterHistoryControllerMapper.tutorHistoricRecordToResponse(record), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<TutorHistoricResponse>> getAllFiltersHistoric() {
		var recordsList = filterHistoryRetrieverUseCase.findAllFilterHistoric(); 
		return new ResponseEntity<>(filterHistoryControllerMapper.tutorHistoricRecordListToResponseList(recordsList), HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteFilterHistoricById(@PathVariable @Min(value = 1, message = "Historic id should be gretter than 0") Long id) {
		filterHistoryDeletionUseCase.deleteFilterHistoricById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TutorHistoricResponse> updateFilterHistoricById(@PathVariable @Min(value = 1, message = "Historic id should be gretter than 0") Long id, @Valid @RequestBody TutorHistoricRequest request) {
		var record =filterHistoryUpdateUseCase.updateFilterHistoricById(id, filterHistoryControllerMapper.toTutorHistoricRecord(request)) ;
		return new ResponseEntity<>(filterHistoryControllerMapper.tutorHistoricRecordToResponse(record), HttpStatus.OK);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintValidatioException(ConstraintViolationException ex) {
		return new ResponseEntity<>("Error: "+ ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
