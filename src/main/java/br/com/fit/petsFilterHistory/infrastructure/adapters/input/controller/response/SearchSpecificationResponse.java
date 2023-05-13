package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class SearchSpecificationResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("animalCharacteristics")
	private AnimalCharacteristicsResponse animalCharacteristics;
	
}
