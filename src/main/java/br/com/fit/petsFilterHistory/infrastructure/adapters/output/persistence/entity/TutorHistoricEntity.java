package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "FILTER_HISTORIC")
public class TutorHistoricEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name ="userName")
	private String userName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_user_id", referencedColumnName = "id")
	private List<SearchSpecificationEntity> filterList;
}
