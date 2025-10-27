package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output()).contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 여러_회_경주_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "3");
                assertThat(output()).contains("pobi : ---", "woni : -", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP,  // 1회차
            MOVING_FORWARD, STOP,  // 2회차
            MOVING_FORWARD, MOVING_FORWARD  // 3회차
        );
    }

    @Test
    void 단일_자동차_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi", "2");
                assertThat(output()).contains("pobi : --", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 모두_정지_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "1");
                assertThat(output()).contains(
                    "pobi : ",
                    "woni : ",
                    "jun : ",
                    "최종 우승자 : pobi, woni, jun"
                );
            },
            STOP, STOP, STOP
        );
    }

    @Test
    void 출력_형식_검증() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains(":");
                assertThat(output()).contains("최종 우승자 :");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
