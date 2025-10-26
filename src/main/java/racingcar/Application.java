package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        try{
            RacingController controller = new RacingController();
            controller.run();
        }finally {
            Console.close();
        }

    }
}
