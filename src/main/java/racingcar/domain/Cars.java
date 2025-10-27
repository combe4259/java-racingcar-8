package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Cars {
    private final List<Car> cars;
    private Cars(List<Car> cars){
        this.cars = new ArrayList<>(cars);
    }
    /*
    getter 없이 외부에서 접근 하여 List의 각 Car에 접근할 수 있도록 interface를 이용하는 위임 메서드
    @Param action : List<Car>에서 할 수 있는 행동
     */
    public void forEach(Consumer<Car> action) {
        this.cars.forEach(action);
    }

    public int size() {
        return this.cars.size();
    }

    public static Cars createCars(String namesInput){
        if(namesInput == null){
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
        List<String> namesList = Arrays.stream(namesInput.split(","))
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
                .map(Car::getNameValue)
                .toList();
    }
    private int findMaxPosition(){
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
