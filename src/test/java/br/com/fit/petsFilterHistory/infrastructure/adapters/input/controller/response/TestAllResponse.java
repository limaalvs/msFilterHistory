package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllResponse {
	@Test
	void testeAllResponseObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TutorHistoricResponse.class);
		beanTester.testBean(SearchSpecificationResponse.class);
		beanTester.testBean(AnimalCharacteristicsResponse.class);
	}
}
