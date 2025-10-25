package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        String namesInput = inputView.readCarNames();
        Cars cars = createCars(namesInput);
        int count = inputView.readRacingCount();
        outputView.printRacing();
        outputView.printWinner();
    }

    private Cars createCars(String namesInput){
        List<String> names = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .toList();
        return Cars.from(names);
    }
}
