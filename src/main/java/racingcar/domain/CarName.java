package racingcar.domain;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public CarName(String value){
        validateName(value);
        this.value = value;
    }

    private void validateName(String value){
        if(value.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
    public String getValue(){
        return value;
    }
}
