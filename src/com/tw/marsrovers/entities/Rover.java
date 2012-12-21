package com.tw.marsrovers.entities;

import com.tw.marsrovers.entities.Plateau;
import com.tw.marsrovers.enumeration.HeadingDirection;
import com.tw.marsrovers.enumeration.Instruction;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 20/12/12
 * Time: PM8:25
 * To change this template use File | Settings | File Templates.
 */
public class Rover {

    private int x;
    private int y;
    private HeadingDirection heading;
    private List<Instruction> instructions;
    private final int MOVE_STEP = 1;


    public Rover(int x, int y, HeadingDirection heading, List<Instruction> instructions) {
        this.x = x;
        this.y = y;
        this.heading = heading;
        this.instructions = instructions;
    }

    public boolean moveForward() {
        switch (heading) {
            case N:
                if (y + MOVE_STEP > Plateau.getInstance().getUpperRightY()) {
                    return false;
                }
                y += MOVE_STEP;
                break;
            case E:
                if (x + MOVE_STEP > Plateau.getInstance().getUpperRightX()) {
                    return false;
                }
                x += MOVE_STEP;
                break;
            case S:
                if (y - MOVE_STEP < Plateau.LowerLeftY) {
                    return false;
                }
                y -= MOVE_STEP;
                break;
            case W:
                if (x - MOVE_STEP < Plateau.LowerLeftX) {
                    return false;
                }
                x -= MOVE_STEP;
                break;
            default:
                return false;
        }
        return true;
    }

    public void spin(Instruction instruction) {
        int headingValue = 1;
        if (instruction == Instruction.L) {
            headingValue = (heading.value() - 1) < HeadingDirection.N.value()
                    ? HeadingDirection.W.value() : (heading.value() - 1);
        } else {
            headingValue = (heading.value() + 1) > HeadingDirection.W.value()
                    ? 1 : (heading.value() + 1);
        }
        heading = HeadingDirection.valueOf(headingValue);
    }

    public boolean executeInstructions() {
        for (Instruction instruction : instructions) {
            if (instruction == Instruction.M) {
                if (!moveForward()) {
                    return false;
                }
            } else {
                this.spin(instruction);
            }
        }
        return true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public HeadingDirection getHeading() {
        return heading;
    }

    public void setHeading(HeadingDirection heading) {
        this.heading = heading;
    }
}
