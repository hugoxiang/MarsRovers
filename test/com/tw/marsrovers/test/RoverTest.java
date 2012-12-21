package com.tw.marsrovers.test;

import com.tw.marsrovers.entities.Plateau;
import com.tw.marsrovers.entities.Rover;
import com.tw.marsrovers.enumeration.HeadingDirection;
import com.tw.marsrovers.enumeration.Instruction;
import com.tw.marsrovers.util.ParameterParser;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Zhang Xiang
 * Date: 20/12/12
 * Time: PM8:28
 * To change this template use File | Settings | File Templates.
 */
public class RoverTest {

    @Before
    public void setUp() {
        Plateau.getInstance().setUpperRightX(5);
        Plateau.getInstance().setUpperRightY(5);
    }

    @Test
    public void executeInstructionsInsidePlateauTest() {
        Rover rover = new Rover(1, 2, HeadingDirection.N,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = true;
        boolean actual;

        actual = rover.executeInstructions();

        assertEquals(expected, actual);
        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals(rover.getHeading(), HeadingDirection.N);
    }

    @Test
    public void excuteInstructionsOutsidePlateauTest()
    {
        Rover rover = new Rover(1, 2, HeadingDirection.N,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMMMMMMM"));
        boolean expected = false;
        boolean actual;

        actual = rover.executeInstructions();

        assertEquals(expected, actual);
    }

    @Test
    public void moveForwardWhenFacingNorthInsidePlateauTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.N,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = true;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
        assertEquals(1, rover.getX());
        assertEquals(4, rover.getY());
    }

    @Test
    public void moveForwardWhenFacingSouthInsidePlateauTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.S,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = true;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
        assertEquals(1, rover.getX());
        assertEquals(2, rover.getY());
    }

    @Test
    public void moveForwardWhenFacingEastInsidePlateauTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.E,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = true;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
        assertEquals(2, rover.getX());
        assertEquals(3, rover.getY());
    }

    @Test
    public void moveForwardWhenFacingWestInsidePlateauTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.W,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = true;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
        assertEquals(0, rover.getX());
        assertEquals(3, rover.getY());
    }

    @Test
    public void moveForwardWhenFacingNorthOutsidePlateauTest()
    {
        Rover rover = new Rover(1, 5, HeadingDirection.N,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = false;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
    }

    @Test
    public void moveForwardWhenFacingSouthOutsidePlateauTest()
    {
        Rover rover = new Rover(1, 0, HeadingDirection.S,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = false;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
    }

    @Test
    public void moveForwardWhenFacingEastOutsidePlateauTest()
    {
        Rover rover = new Rover(5, 3, HeadingDirection.E,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = false;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
    }

    @Test
    public void moveForwardWhenFacingWestOutsidePlateauTest()
    {
        Rover rover = new Rover(0, 3, HeadingDirection.W,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        boolean expected = false;
        boolean actual;

        actual = rover.moveForward();

        assertEquals(expected, actual);
    }

    @Test
    public void spinLeftWhenFacingNorthTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.N,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.W;

        rover.spin(Instruction.L);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinRightWhenFacingNorthTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.N,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.E;

        rover.spin(Instruction.R);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinLeftWhenFacingSouthTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.S,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.E;

        rover.spin(Instruction.L);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinRightWhenFacingSouthTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.S,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.W;

        rover.spin(Instruction.R);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinLeftWhenFacingEastTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.E,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.N;

        rover.spin(Instruction.L);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinRightWhenFacingEastTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.E,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.S;

        rover.spin(Instruction.R);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinLeftWhenFacingWestTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.W,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.S;

        rover.spin(Instruction.L);

        assertEquals(excepted, rover.getHeading());
    }

    @Test
    public void spinRightWhenFacingWestTest()
    {
        Rover rover = new Rover(1, 3, HeadingDirection.W,
                ParameterParser.convertInstructionStrToEnumList("LMLMLMLMM"));
        HeadingDirection excepted = HeadingDirection.N;

        rover.spin(Instruction.R);

        assertEquals(excepted, rover.getHeading());
    }
}
