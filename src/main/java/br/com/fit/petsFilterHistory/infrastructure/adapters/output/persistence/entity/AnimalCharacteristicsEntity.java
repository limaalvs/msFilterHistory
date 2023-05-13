package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity;

import br.com.fit.petsFilterHistory.domain.enums.Answer;
import br.com.fit.petsFilterHistory.domain.enums.Gender;
import br.com.fit.petsFilterHistory.domain.enums.PetType;
import br.com.fit.petsFilterHistory.domain.enums.PorType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PET_CHARACTERISTICS")
public class AnimalCharacteristicsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	private PetType petType; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SEX")
	private Gender sex;
	
	@Column(name = "AGE")
	private String age;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CASTRATED")
	private Answer castrated;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "VACCINATED")
	private Answer vaccinated;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DEFICIENCY")
	private Answer deficiency; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PORT")
	private PorType portType; 
}
