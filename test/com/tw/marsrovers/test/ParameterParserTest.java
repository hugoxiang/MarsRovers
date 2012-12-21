package com.tw.marsrovers.test;

import com.tw.marsrovers.util.ParameterParser;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Xiang
 * Date: 20/12/12
 * Time: PM8:29
 * To change this template use File | Settings | File Templates.
 */
public class ParameterParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void InstructionsParserInvalidTest()
    {
        String instructions = "LMLSLMLRMMM";
        ParameterParser.parseRoverInstructions(instructions);
    }

    @Test
    public void PlateauRangeParserNormalTest()
    {
        String plateauRange = "5 5";
        int[] expected = {5,5};
        int[] actual;
        actual = ParameterParser.parsePlateauCoordinates(plateauRange);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void PlateauRangeParserPreSpaceTest()
    {
        String plateauRange = " 5 5";
        int[] expected = { 5, 5 };
        int[] actual;
        actual = ParameterParser.parsePlateauCoordinates(plateauRange);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void PlateauRangeParserPostSpaceTest()
    {
        String plateauRange = "5 5 ";
        int[] expected = { 5, 5 };
        int[] actual;
        actual = ParameterParser.parsePlateauCoordinates(plateauRange);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void PlateauRangeParserDoubleSpaceTest()
    {
        String plateauRange = "5  5";
        int[] expected = { 5, 5 };
        int[] actual;
        actual = ParameterParser.parsePlateauCoordinates(plateauRange);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void PlateauRangeParserOnlyOneElementTest()
    {
        String plateauRange = "5";
        ParameterParser.parsePlateauCoordinates(plateauRange);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PlateauRangeParserInvalidArgumentTest()
    {
        String plateauRange = "5 S";
        ParameterParser.parsePlateauCoordinates(plateauRange);
    }

    @Test
    public void RoverPositionNormalTest()
    {
        String roverPosition = "1 2 N";
        String[] expected = {"1", "2", "N"};
        String[] actual;

        actual = ParameterParser.parseRoverPosition(roverPosition);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void RoverPositionPreSpaceTest()
    {
        String roverPosition = " 1 2 N";
        String[] expected = { "1", "2", "N" };
        String[] actual;

        actual = ParameterParser.parseRoverPosition(roverPosition);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void RoverPositionPostSpaceTest()
    {
        String roverPosition = "1 2 N ";
        String[] expected = { "1", "2", "N" };
        String[] actual;

        actual = ParameterParser.parseRoverPosition(roverPosition);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void RoverPositionDoubleSpaceTest()
    {
        String roverPosition = "1  2 N ";
        String[] expected = { "1", "2", "N" };
        String[] actual;

        actual = ParameterParser.parseRoverPosition(roverPosition);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++)
        {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void RoverPositionInvalidFormatTest()
    {
        String roverPosition = "1 S N";
        ParameterParser.parseRoverPosition(roverPosition);
    }
}
