package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }

    public static Cars createCars(String namesInput){
        List<String> namesList = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .toList();
        return Cars.from(namesList);
    }

    public static Cars from(List<String> namesList){
        List<Car> carList = new ArrayList<>();
        for (String name : namesList){
            CarName carname = new CarName(name);
            carList.add(new Car(carname.getValue()));
        }
        return new Cars(carList);
    }
}
