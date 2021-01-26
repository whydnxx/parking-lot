package dev.whydn.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProcessFileTest {

    @Test
    public void createProcessFile_should_return_ProcessFileClass() {
        Class expected = ProcessFile.class;
        Class actual = ProcessFile.createProcessFile().getClass();

        assertEquals(expected, actual);
    }

    @Test
    public void parseFile_should_return_listOfCommands_with_givenFileName_testFile() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("create_parking_lot 6");
        expectedResult.add("park KA-01-HH-1234");
        expectedResult.add("leave KA-01-HH-3141 4");
        expectedResult.add("status");

        List<String> actualResult = ProcessFile.createProcessFile().parseFile("src/main/resources/", "test-file.txt");

        assertEquals(expectedResult, actualResult);
    }

}