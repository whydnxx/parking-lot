package dev.whydn;

import dev.whydn.process.RunCommand;

public class Main {
    public static void main(String[] args) {
        String directory = System.getProperty("user.dir");
        String fileName = args[0];
        RunCommand runCommand = RunCommand.createRunCommand(directory, fileName);
        runCommand.run();
    }
}
