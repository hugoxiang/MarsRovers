package com.tw.marsrovers.entities;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Xiang
 * Date: 20/12/12
 * Time: PM8:26
 * To change this template use File | Settings | File Templates.
 */
public class Plateau {

    private int upperRightX;
    private int upperRightY;

    public static int LowerLeftX = 0;
    public static int LowerLeftY = 0;

    private static Plateau plateau = null;

    private Plateau() {
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            plateau = new Plateau();
        }
        return plateau;
    }

    public int getUpperRightX() {
        return upperRightX;
    }

    public void setUpperRightX(int upperRightX) {
        this.upperRightX = upperRightX;
    }

    public int getUpperRightY() {
        return upperRightY;
    }

    public void setUpperRightY(int upperRightY) {
        this.upperRightY = upperRightY;
    }
}
