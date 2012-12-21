package com.tw.marsrovers.util;

import com.tw.marsrovers.enumeration.Instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Xiang
 * Date: 20/12/12
 * Time: PM8:30
 * To change this template use File | Settings | File Templates.
 */
public class ParameterParser {

    public static int[] parsePlateauCoordinates(String plateauRange) throws IllegalArgumentException {
        String regEx = "^\\s*\\d+\\s+\\d+\\s*$";            //match cases like "5 5" or "  5  5  "
        Pattern plateauPattern = Pattern.compile(regEx);
        Matcher plateauMatcher = plateauPattern.matcher(plateauRange);
        if (!plateauMatcher.find()) {
            throw new IllegalArgumentException("The upper-coordinates of the plateau is invalid, input again.");
        }

        String[] coordinatesStr = splitStringIgnoreSpaces(plateauRange);
        int[] plateauCoordinates = new int[2];

        plateauCoordinates[0] = Integer.parseInt(coordinatesStr[0]);
        plateauCoordinates[1] = Integer.parseInt(coordinatesStr[1]);
        return plateauCoordinates;
    }

    public static String[] parseRoverPosition(String roverPosition) {
        String regEx = "^\\s*\\d+\\s+\\d+\\s+[N|S|W|E]\\s*$";
        Pattern roverPositionPattern = Pattern.compile(regEx);
        Matcher roverPositionMatcher = roverPositionPattern.matcher(roverPosition);
        if (!roverPositionMatcher.find()) {
            throw new IllegalArgumentException("The rover's position is invalid, input again.");
        }

        return splitStringIgnoreSpaces(roverPosition);
    }

    public static List<Instruction> parseRoverInstructions(String instructions) {
        String regEx = "^[L|M|R]*$";
        Pattern instructionsPattern = Pattern.compile(regEx);
        Matcher instructionsMatcher = instructionsPattern.matcher(instructions);
        if (!instructionsMatcher.find()) {
            throw new IllegalArgumentException("The instructions is invalid, input again.");
        }

        return convertInstructionStrToEnumList(instructions);
    }

    public static String[] splitStringIgnoreSpaces(String str) {
        String regEx = "\\s+";
        Pattern pattern = Pattern.compile(regEx, Pattern.CANON_EQ);
        return pattern.split(str.trim());
    }

    public static List<Instruction> convertInstructionStrToEnumList (String instructions) {
        List<Instruction> instructionList = new ArrayList<Instruction>();
        for(int i = 0; i < instructions.length(); i++) {

            instructionList.add(Instruction.valueOf(String.valueOf(instructions.charAt(i))));
        }
        return instructionList;
    }
}
