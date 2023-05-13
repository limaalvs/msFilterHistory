package br.com.fit.petsFilterHistory.domain.model;

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
public class AnimalCharacteristics {
	private Long id;
	private PetType petType; 
	private Gender sex;
	private String age;
	private Answer castrated;
	private Answer vaccinated;
	private Answer deficiency; 	
	private PorType portType; 
}
