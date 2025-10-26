package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName name;
    private int position = 0;
    public Car(String namesInput){
        this.name = new CarName(namesInput);
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(randomNumber >= 4){
            this.position++;
        }
    }

    public int getPosition(){
        return this.position;
    }

    public String getNameValue() {
        return this.name.getValue();
    }

    public String getPositionDisplay() {
        return "-".repeat(this.position);
    }

}
