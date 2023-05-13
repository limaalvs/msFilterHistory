package br.com.fit.petsFilterHistory.domain.model;

import java.util.List;

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
public class TutorHistoric {
	private Long id; 
	private String userName;
	private List<SearchSpecification> filterList; 
}
