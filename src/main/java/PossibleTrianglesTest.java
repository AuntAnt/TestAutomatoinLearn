import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class PossibleTrianglesTest {

    private final Rest rest = new Rest();

    @Test
    public void withoutParameters() {
        assertThat(rest.getPossibleTriangleWithoutParameters().getIsPossible())
                .describedAs("Проверка треугольника без параметров")
                .isFalse();
    }

    @Test
    public void isoscelesTriangle() {
        assertThat(rest.getPossibleTriangleWithParameters(3, 3, 5)
                .getIsPossible())
                .describedAs("Проверка равнобедренного треугольника")
                .isTrue();
    }

    @Test
    public void equilateralTriangle() {
        assertThat(rest.getPossibleTriangleWithParameters(6, 6, 6)
                .getIsPossible())
                .describedAs("Проверка равностороннего треугольника")
                .isTrue();
    }

    @Test
    public void existingTriangle() {
        assertThat(rest.getPossibleTriangleWithParameters(2, 3, 4)
                .getIsPossible())
                .describedAs("Проверка существующего треугольника")
                .isTrue();
    }

    @Test
    public void negativeTriangleParameters() {
        assertThat(rest.getPossibleTriangleWithParameters(-2, 3, 4)
                .getIsPossible())
                .describedAs("Проверка НЕсуществования треугольника c отрицательными значениями сторон")
                .isFalse();
    }

    @Test
    public void parametersWithZeroParameters() {
        assertThat(rest.getPossibleTriangleWithParameters(0, 0, 0)
                .getIsPossible())
                .describedAs("Проверка треугольника со сторонами равными нулю")
                .isFalse();
    }
}
