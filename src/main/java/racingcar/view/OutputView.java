package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;

public class OutputView {

    public void printRacing(Cars cars){
        System.out.println();
        cars.forEach(car -> {
            System.out.println(car.getNameValue() + " : " + car.getPositionDisplay());
        });
    }

    public void printWinner(List<String> winners){
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
