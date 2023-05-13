package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class TutorHistoricRequest {
	
	@NotNull(message = "UserName is required")
	@NotEmpty(message = "UserName must have a value")
	@NotBlank(message = "UserName must have a valid value")
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("filterList")
	private List<SearchSpecificationRequest> filterList; 
	

}
