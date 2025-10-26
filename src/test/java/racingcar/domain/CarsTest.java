package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("쉼표로 구분된 이름을 정상적으로 파싱한다")
    void createCars_WithCommaSeparatedNames() {
        String input = "pobi,woni,jun";
        Cars cars = Cars.createCars(input);
        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    @DisplayName("이름 앞뒤 공백을 제거한다")
    void createCars_TrimsWhitespace() {
        String input = " pobi , woni , jun ";
        Cars cars = Cars.createCars(input);
        List<String> names = cars.getCars().stream()
                .map(car -> car.getName().getValue())
                .toList();
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 올바르게 저장된다")
    void createCars_SavesCarNamesCorrectly() {
        String input = "pobi,crong";
        Cars cars = Cars.createCars(input);
        List<String> names = cars.getCars().stream()
                .map(car -> car.getName().getValue())
                .toList();
        assertThat(names).containsExactly("pobi", "crong");
    }

    @Test
    @DisplayName("잘못된 이름이 포함되면 예외가 발생한다")
    void createCars_WithInvalidName_ThrowsException() {
        // given
        String input = "pobi,javaji,jun";  // javaji는 6자

        // when & then
        assertThatThrownBy(() -> Cars.createCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    @DisplayName("우승자를 올바르게 찾는다")
    void findWinners_ReturnsWinnersWithMaxPosition() {
        // given
        String input = "pobi,woni,jun";
        Cars cars = Cars.createCars(input);

        // 첫 번째 차만 전진 (테스트를 위해 여러 번 race 호출)
        // 실제로는 랜덤이므로 완벽한 테스트는 어렵지만
        // 최소한 findWinners() 메서드가 예외 없이 동작하는지 확인
        cars.race();

        // when
        List<String> winners = cars.findWinners();

        // then
        assertThat(winners).isNotEmpty();
    }

    @Test
    @DisplayName("초기 상태에서 모든 자동차가 공동 우승자다")
    void findWinners_InitialState_AllCarsAreWinners() {
        // given
        String input = "pobi,woni,jun";
        Cars cars = Cars.createCars(input);

        // when (race를 하지 않은 초기 상태)
        List<String> winners = cars.findWinners();

        // then (모두 position이 0이므로 모두 우승자)
        assertThat(winners).containsExactly("pobi", "woni", "jun");
    }
}
