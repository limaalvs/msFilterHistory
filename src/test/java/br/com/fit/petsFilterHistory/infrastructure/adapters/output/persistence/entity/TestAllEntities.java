package br.com.fit.petsFilterHistory.infrastructure.adapters.output.persistence.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllEntities {

	@Test
	void testeAllEntityObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TutorHistoricEntity.class);
		beanTester.testBean(SearchSpecificationEntity.class);
		beanTester.testBean(AnimalCharacteristicsEntity.class);
	}
}
