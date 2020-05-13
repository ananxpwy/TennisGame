package main.java.enums;

public enum ScoreEnum {

	FORTY(3), THIRTY(2), FIFTEEN(1), LOVE(0);

    private Integer value;

    ScoreEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
