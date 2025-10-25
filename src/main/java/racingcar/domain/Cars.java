package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public Cars from(List<String> names){
        for (String name : names){
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
