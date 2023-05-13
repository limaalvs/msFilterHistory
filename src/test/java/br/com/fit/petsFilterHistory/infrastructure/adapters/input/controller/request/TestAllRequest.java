package br.com.fit.petsFilterHistory.infrastructure.adapters.input.controller.request;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllRequest {
	@Test
	void testeAllrequestObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TutorHistoricRequest.class);
		beanTester.testBean(SearchSpecificationRequest.class);
		beanTester.testBean(AnimalCharacteristicsRequest.class);
	}
}
