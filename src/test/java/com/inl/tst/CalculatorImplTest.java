package com.inl.tst;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.inl.tst.Publisher.Operation;

@ExtendWith(MockitoExtension.class)
public class CalculatorImplTest {

	@Mock
	Publisher publisher;

	@InjectMocks
	Calculator calculator = new CalculatorImpl();


	@ParameterizedTest
	@CsvSource({ "9,3,3", "12,4,3" })
	public void shouldBeValidResultForDivideInteger(int value1, int value2, int expected) {

		lenient().doNothing().when(publisher).publish(Operation.DIVIDE, value1, value2, expected);

		assertThat(expected).isEqualTo(calculator.devide(9, 3));
	}
	
	/**
	 * Strictness#STRICT_STUBS make sure clean code, unnecessary and unused mock and stubbing are avoided,
	 * reduces code duplication, improves debuggability hence overall increases 
	 * the performance and productivity, but some times we are not sure at invocation 
	 * time which parameter will be used hence need to stub with multiple inputs. 
	 * Strictness#STRICT_STUBS will not allow this and throw UnnecessaryStubbingException.
	 * 
	 * Mockito provides a way to add lenient stubs with Strictness#STRICT_STUBS.
	 *
	 * lenient().when().thenReturn()
	 */
	@Test
	public void shouldSumIntegers() {				
		lenient().doNothing().when(publisher).publish(Operation.SUM, 5, 5, 10);
		assertEquals(10, calculator.sum(5, 5));
	}
}
