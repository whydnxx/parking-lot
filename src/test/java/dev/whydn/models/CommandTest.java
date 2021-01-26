package dev.whydn.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void getLabel_should_return_park_with_givenCommand_PARK() {
        String expectedResult = "park";
        String actualResult = Command.PARK.getLabel();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getCommandByLabel_should_return_command_with_givenLabel_park() {
        String givenLabel = "park";

        Command expectedResult = Command.PARK;
        Command actualResult = Command.getCommandByLabel(givenLabel);

        assertEquals(expectedResult, actualResult);
    }

}