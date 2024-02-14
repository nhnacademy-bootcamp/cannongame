package com.nhnacademy;

/**
 * object가 지정된 영역을 벗어난 경우
 */
public class OutOfBoundsException extends RuntimeException {

    public OutOfBoundsException() {
        super();
    }

    public OutOfBoundsException(String message) {
        super(message);
    }
}
