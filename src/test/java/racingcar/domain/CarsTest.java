package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("쉼표로 구분된 이름을 정상적으로 파싱한다")
    void createCars_CommaSeparatedNames() {
        String input = "pobi,woni,jun";
        Cars cars = Cars.createCars(input);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("1대의 자동차만 입력해도 정상 동작한다")
    void createCars_SingleCar() {
        String input = "pobi";
        Cars cars = Cars.createCars(input);
        assertThat(cars.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("빈 문자열 입력 시 예외가 발생한다")
    void createCars_EmptyString_ThrowsException() {
        assertThatThrownBy(() -> Cars.createCars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 이름이 포함되면 예외가 발생한다")
    void createCars_EmptyName_ThrowsException() {
        assertThatThrownBy(() -> Cars.createCars("pobi,,jun"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 입력 시 예외가 발생한다")
    void createCars_Null_ThrowsException() {
        assertThatThrownBy(() -> Cars.createCars(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자를 올바르게 찾는다")
    void findWinners_ReturnsWinnersWithMaxPosition() {
        String input = "pobi,woni,jun";
        Cars cars = Cars.createCars(input);
        cars.race();
        List<String> winners = cars.findWinners();
        assertThat(winners).isNotEmpty();
    }


}
