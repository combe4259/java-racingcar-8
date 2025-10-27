package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    public RacingController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run(){
        String namesInput = inputView.readCarNames();
        Cars cars = Cars.createCars(namesInput);
        int count = inputView.readRacingCount();
        for (int i=0; i < count; i++){
            cars.race();
            outputView.printRacing(cars);
        }
        outputView.printWinner(cars.findWinners());
    }


}
