package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response;


import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AnimalCharacteristicsResponseTest {
	@InjectMocks
	AnimalCharacteristicsResponse animalCharacteristicsResponse;
	
	

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFlatFileReaderMetadata_Parameters() throws Exception {

		Assertions.assertNotNull(new AnimalCharacteristicsResponse());

		assertThat(AnimalCharacteristicsResponse.class, allOf(hasValidBeanConstructor(), hasValidBeanEquals(),
				hasValidGettersAndSetters(), hasValidBeanHashCode(), hasValidBeanToString()));
	}
}
