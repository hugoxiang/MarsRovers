package com.tw.marsrovers;

import com.tw.marsrovers.entities.Plateau;
import com.tw.marsrovers.entities.Rover;
import com.tw.marsrovers.enumeration.HeadingDirection;
import com.tw.marsrovers.enumeration.Instruction;
import com.tw.marsrovers.util.ParameterParser;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Xiang
 * Date: 20/12/12
 * Time: PM8:25
 * To change this template use File | Settings | File Templates.
 */
public class Program {

    private int inputX;
    private int inputY;
    private String inputHeading;
    private List<Instruction> inputInstructions = new ArrayList<Instruction>();

    private List<Rover> rovers = new ArrayList<Rover>();

    private Scanner scanner = new Scanner(System.in);

    private boolean isRoverPositionValid = false;

    public boolean inputPlateauCoordinates() {
        while (true) {
            try {
                String plateauCoordinatesInput = scanner.nextLine();
                if (plateauCoordinatesInput == "0") {
                    return false;
                }
                int[] plateauCoordinates = ParameterParser.parsePlateauCoordinates(plateauCoordinatesInput);
                Plateau.getInstance().setUpperRightX(plateauCoordinates[0]);
                Plateau.getInstance().setUpperRightY(plateauCoordinates[1]);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        return true;
    }

    public boolean inputRoverPositionAndInstructions() {
        try {
            if (!isRoverPositionValid) {
                String roverPositionInput = scanner.nextLine();
                if (roverPositionInput.equals("0")) {
                    return false;
                }
                String[] roverPosition = ParameterParser.parseRoverPosition(roverPositionInput);
                inputX = Integer.parseInt(roverPosition[0]);
                inputY = Integer.parseInt(roverPosition[1]);
                inputHeading = roverPosition[2];
                isRoverPositionValid = true;
            }

            String roverInstructions = scanner.nextLine();
            if (roverInstructions.equals("0")) {
                return false;
            }
            inputInstructions = ParameterParser.parseRoverInstructions(roverInstructions);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }

        Rover rover = new Rover(inputX, inputY,
                HeadingDirection.valueOf(inputHeading), inputInstructions);
        rovers.add(rover);

        isRoverPositionValid = false;

        return true;
    }

    public void executeInstructions() {
        int index = 1;
        for (Rover rover : rovers) {
            if (rover.executeInstructions()) {
                System.out.println(rover.getX() + " " +
                        rover.getY() + " " + rover.getHeading().toString());
            } else {
                System.out.println("Rover" + index + " is out of range!");
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Program program = new Program();

        System.out.println("Tips: Press 0 to end the input!");

        if (!program.inputPlateauCoordinates()) {
            return;
        }

        while (program.inputRoverPositionAndInstructions()) {

        }
        program.executeInstructions();

        return;
    }
}
