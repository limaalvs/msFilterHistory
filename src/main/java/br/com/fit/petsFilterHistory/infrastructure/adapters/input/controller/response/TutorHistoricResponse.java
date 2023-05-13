package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(value = Include.NON_NULL)
public class TutorHistoricResponse {
	
	@JsonProperty("id")
	private Long id; 
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("filterList")
	private List<SearchSpecificationResponse> filterList; 
}
