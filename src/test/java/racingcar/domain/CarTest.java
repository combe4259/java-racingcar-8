package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest extends NsTest {

    @Test
    @DisplayName("랜덤값이 4 이상이면 전진한다")
    void move_Forward() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            car.move();
            assertThat(car.getPosition()).isEqualTo(1);
        }, 4);
    }

    @Test
    @DisplayName("랜덤값이 3 이하면 정지한다")
    void move_Stop() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            car.move();
            assertThat(car.getPosition()).isEqualTo(0);
        }, 3);
    }

    @Test
    @DisplayName("여러 번 전진할 수 있다")
    void move_MultipleTimes() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            car.move();
            car.move();
            car.move();
            assertThat(car.getPosition()).isEqualTo(3);
        }, 9, 8, 7);
    }

    @Test
    @DisplayName("위치 표시를 변환한다")
    void getPositionDisplay() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("pobi");
            car.move();
            car.move();
            car.move();
            assertThat(car.getPositionDisplay()).isEqualTo("---");
        }, 4, 4, 4);
    }

    @Override
    protected void runMain() {
    }
}
