package com.tw.marsrovers.enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 20/12/12
 * Time: PM8:27
 * To change this template use File | Settings | File Templates.
 */
public enum HeadingDirection {

    N(1), E(2), S(3), W(4);

    private final int value;
    private HeadingDirection(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static HeadingDirection valueOf(int value) {
        for(HeadingDirection headingDirection : HeadingDirection.values()) {
            if(headingDirection.value()  == value) {
                return headingDirection;
            }
        }
        return null;
    }
}
