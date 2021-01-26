package dev.whydn.process;

import dev.whydn.dao.ParkingLotDao;
import dev.whydn.dao.ParkingLotDaoMapImpl;
import dev.whydn.utils.ProcessFile;
import dev.whydn.models.Car;
import dev.whydn.models.Command;

import java.util.List;
import java.util.Objects;

public class RunCommand {
    private List<String> commands;
    private ParkingLotDao parkingLotDao;
    public static final String COMMAND_REGEX = " ";

    private RunCommand(String directory, String fileName) {
        this.commands = ProcessFile.createProcessFile().parseFile(directory, fileName);
    }

    public static RunCommand createRunCommand(String directory, String fileName){
        return new RunCommand(directory, fileName);
    }

    public void run() {
        for (String command : commands){
            digestCommand(command);
        }
    }

    public void digestCommand(String commandLine) {
        switch (Objects.requireNonNull(Command.getCommandByLabel(commandLine.split(COMMAND_REGEX)[0].toLowerCase()))){
            case CREATE_PARKING_LOT:
                this.parkingLotDao = ParkingLotDaoMapImpl.createParkingLotDaoMap(Integer.parseInt(commandLine.substring(19)));
                System.out.println(parkingLotDao.generateParkingLot());
                return;
            case PARK:
                System.out.println(parkingLotDao.park(Car.createCar(commandLine.substring(5))));
                return;
            case LEAVE:
                System.out.println(parkingLotDao.remove(Car.createCar(commandLine.substring(6, 19)), Integer.parseInt(commandLine.substring(20))));
                return;
            case STATUS:
                System.out.println(parkingLotDao.printStatus());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Objects.requireNonNull(Command.getCommandByLabel(commandLine.split(COMMAND_REGEX)[0])));
        }

    }
}
