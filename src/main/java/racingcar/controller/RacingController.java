package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        String name = inputView.readCarNames();
        int count = inputView.readRacingCount();
        outputView.printRacing();
        outputView.printWinner();
    }
}
