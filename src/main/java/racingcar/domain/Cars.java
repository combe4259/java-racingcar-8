package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Cars {
    private final List<Car> cars;

    public List<Car> getCars(){
        return this.cars;
    }

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
            carList.add(new Car(name));
        }
        return new Cars(carList);
    }

    public void race(){
        for(Car car : this.cars){
            car.move();
        }
    }

    public List<String> findWinners(){
        int maxPosition = findMaxPosition();
        return this.cars.stream()
                .filter(car -> car.getPosition()==maxPosition)
                .map(car -> car.getName().getValue())
                .toList();
    }
    private int findMaxPosition(){
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }



}
