package dev.whydn.models;

import dev.whydn.constants.CommandConstant;

public enum Command {
    CREATE_PARKING_LOT(CommandConstant.CREATE_PARKING_LOT),
    PARK(CommandConstant.PARK),
    LEAVE(CommandConstant.LEAVE),
    STATUS(CommandConstant.STATUS);

    private final String label;

    Command(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static Command getCommandByLabel(String label){
        for (Command command:Command.values()) {
            if (command.getLabel().equals(label)) return command;
        }
        return null;
    }
}
