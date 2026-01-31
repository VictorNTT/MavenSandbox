import org.example.sandbox.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SandboxTests {
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(textBlock = """
			0,    1,   1
			1,    2,   3
			49,  51, 100
			1,  100, 101
			""")
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }


    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int first = 1, second = 2, expectedResult = 3;
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);

    }
}
