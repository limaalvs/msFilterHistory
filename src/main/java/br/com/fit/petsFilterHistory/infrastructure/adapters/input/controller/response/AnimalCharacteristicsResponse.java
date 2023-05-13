package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
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
public class AnimalCharacteristicsResponse {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("petType")
	private PetType petType; 
	
	@JsonProperty("sex")
	private Gender sex;
	
	@JsonProperty("age")
	private String age;
	
	@JsonProperty("castrated")
	private Answer castrated;
	
	@JsonProperty("vaccinated")
	private Answer vaccinated;
	
	@JsonProperty("deficiency")
	private Answer deficiency; 
	
	@JsonProperty("portType")
	private PorType portType; 
}
