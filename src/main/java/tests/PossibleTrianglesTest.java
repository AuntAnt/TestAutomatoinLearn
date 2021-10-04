package tests;

import org.testng.annotations.Test;
import utils.Rest;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class PossibleTrianglesTest {

    private final Rest rest = new Rest();
    private final static String ERROR_MESSAGE = "Not valid data";

    @Test(description = "Негативный тест на треугольник без параметров")
    public void withoutParameters() {
        assertThat(rest.getPossibleTriangleWithoutParameters().getIsPossible())
                .describedAs("Проверка треугольника без параметров")
                .isFalse();
    }

    @Test(description = "Проверка равнобедренного треугольника")
    public void isoscelesTriangle() {
        assertThat(rest.getPossibleTriangleWithValidParameters(3, 3, 5)
                .getIsPossible())
                .describedAs("Проверка равнобедренного треугольника")
                .isTrue();
    }

    @Test(description = "Проверка равностороннего треугольника")
    public void equilateralTriangle() {
        assertThat(rest.getPossibleTriangleWithValidParameters(6, 6, 6)
                .getIsPossible())
                .describedAs("Проверка равностороннего треугольника")
                .isTrue();
    }

    @Test(description = "Позитивыный тест проверки треугольника")
    public void existingTriangle() {
        assertThat(rest.getPossibleTriangleWithValidParameters(2, 3, 4)
                .getIsPossible())
                .describedAs("Проверка существующего треугольника")
                .isTrue();
    }

    @Test(description = "Проверка отрицательных параметров")
    public void negativeTriangleParameters() {
        assertThat(rest.getPossibleTriangleWithInvalidParameters(-2, 3, 4)
                .getMessage()
                .getError())
                .describedAs("Проверка сообщения о некорректных параметрах")
                .isEqualTo(ERROR_MESSAGE);
    }

    @Test(description = "Проверка параметров равных нулю")
    public void parametersWithZeroParameters() {
        assertThat(rest.getPossibleTriangleWithInvalidParameters(0, 0, 0)
                .getMessage()
                .getError())
                .describedAs("Проверка сообщения о некорректных параметрах")
                .isEqualTo(ERROR_MESSAGE);
    }

    @Test(description = "Проверка дробных параметров")
    public void fractionalParameters() {
        assertThat(rest.getPossibleTriangleWithFractionalParameters(
                1.1F, 2.22F, 3.333F)
                .getMessage()
                .getError())
                .describedAs("Проверка сообщения о некорректных параметрах")
                .isEqualTo(ERROR_MESSAGE);
    }
}
