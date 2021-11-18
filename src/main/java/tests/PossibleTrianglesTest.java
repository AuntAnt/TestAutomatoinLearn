package tests;

import helper.ResponseReaderHelper;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class PossibleTrianglesTest {

    private final ResponseReaderHelper helper = new ResponseReaderHelper();
    private final static String ERROR_MESSAGE = "Not valid data";
    private final static String FUNNY_ERROR_MESSAGE = "You broke everything. Grats.";

    @Test(description = "Негативный тест на треугольник без параметров")
    public void withoutParametersTest() {
        assertThat(helper.readResponseWithValidParametersAsObject().getIsPossible())
                .describedAs("Проверка треугольника без параметров")
                .isFalse();
    }

    @Test(description = "Проверка равнобедренного треугольника")
    public void isoscelesTriangleTest() {
        assertThat(helper.readResponseWithValidParametersAsObject(3, 3, 5)
                .getIsPossible())
                .describedAs("Проверка равнобедренного треугольника")
                .isTrue();
    }

    @Test(description = "Проверка равностороннего треугольника")
    public void equilateralTriangleTest() {
        assertThat(helper.readResponseWithValidParametersAsObject(6, 6, 6)
                .getIsPossible())
                .describedAs("Проверка равностороннего треугольника")
                .isTrue();
    }

    @Test(description = "Позитивыный тест проверки треугольника")
    public void existingTriangleTest() {
        assertThat(helper.readResponseWithValidParametersAsObject(2, 3, 4)
                .getIsPossible())
                .describedAs("Проверка существующего треугольника")
                .isTrue();
    }

    @Test(description = "Проверка отрицательных параметров")
    public void negativeTriangleParametersTest() {
        assertThat(helper.readResponseWithInvalidParametersAsObject(-2, 3, 4)
                .getMessage()
                .getError())
                .describedAs("Проверка сообщения о некорректных параметрах")
                .isEqualTo(ERROR_MESSAGE);
    }

    @Test(description = "Проверка параметров равных нулю")
    public void parametersWithZeroParametersTest() {
        assertThat(helper.readResponseWithInvalidParametersAsObject(0, 0, 0)
                .getMessage()
                .getError())
                .describedAs("Проверка сообщения о некорректных параметрах")
                .isEqualTo(ERROR_MESSAGE);
    }

    @Test(description = "Проверка дробных параметров")
    public void fractionalParametersTest() {
        assertThat(helper.readResponseWithInvalidParametersAsObject(1.1F, 2.22F, 3.333F)
                .getMessage()
                .getError())
                .describedAs("Проверка сообщения о некорректных параметрах")
                .isEqualTo(ERROR_MESSAGE);
    }

    @Test(description = "Проверка треугольника с четырьмя параметрами")
    public void withFourParametersTest() {
        assertThat(helper.readResponseWithInvalidParametersAsObject(1, 2, 2, 4)
                .getMessage()
                .getError())
                .describedAs("Проверка треугольника с четырьмя параметрами")
                .isEqualTo(FUNNY_ERROR_MESSAGE);
    }

    @Test(description = "Проверка ответа при символах в значении параметров")
    public void withSymbolsAsParametersValueTest() {
        assertThat(helper.readResponseWithInvalidParametersAsObject(4, 'a', '&')
                .getMessage()
                .getError())
                .describedAs("Проверка ответа при символах в значении параметров")
                .isEqualTo(ERROR_MESSAGE);
    }
}
