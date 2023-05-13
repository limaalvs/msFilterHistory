package br.com.fit.petsFilterHistory.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllRecords {
	
	@Test
	void testeAllRecordsObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TutorHistoric.class);
		beanTester.testBean(SearchSpecification.class);
		beanTester.testBean(AnimalCharacteristics.class);
	}
}
