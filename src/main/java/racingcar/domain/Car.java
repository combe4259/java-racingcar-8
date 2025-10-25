package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Car(String name){
        validateName(name);
        this.name = name;
    }

    private void validateName(String name){
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
