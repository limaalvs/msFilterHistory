package br.com.fit.petsFilterHistory.domain.model;

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
public class SearchSpecification {
	private Long id;
	private String date;
	private AnimalCharacteristics animalCharacteristics;
}
