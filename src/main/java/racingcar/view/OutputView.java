package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    /*
    FIXME: 실제 자동차 이름을 출력하도록 변경
     */
    public void printRacing(Cars cars){
        System.out.println("실행 결과");
        for (Car car : cars.getCars()){
            System.out.print(car.getName() + " : ");
            int count = car.getPosition();
            while(count-- > 0){
                System.out.print("-");
            }
            System.out.println();
        }
    }
    /*
   FIXME: 실제 우승자 이름을 출력하도록 변경
    */
    public void printWinner(){
        System.out.print("최종 우승자");
    }



}
