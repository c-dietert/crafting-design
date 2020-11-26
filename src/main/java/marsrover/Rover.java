package marsrover;

import java.util.Arrays;
import java.util.List;

public class Rover {

    private static final String MOVE = "M";
    private static final String NORTH = "N";
    private static final String EAST = "E";
    private static final String SOUTH = "S";
    private static final String WEST = "W";
    private static final String RIGHT = "R";
    private static final String LEFT = "L";

    private int xCoordinate;
    private int yCoordinate;
    private String direction;

    public Rover() {
        xCoordinate = 0;
        yCoordinate = 0;
        direction = "N";
    }

    public String execute(String command) {

        List<String> commandToExecute = nextCommand(command);

        executeCommands(commandToExecute);

        return xCoordinate + "-" + yCoordinate + "-" + direction;
    }

    private void executeCommands(List<String> commandsToExecute) {
        commandsToExecute.forEach(command -> {
            move(command);
            rotateRight(command);
            rotateLeft(command);
        });
    }

    private void move(String command) {
        if (command.equals(MOVE)) {
            if (direction.equals(NORTH)) {
                yCoordinate++;
            } else if (direction.equals(EAST)) {
                xCoordinate++;
            } else if (direction.equals(SOUTH)) {
                yCoordinate--;
            } else if (direction.equals(WEST)) {
                xCoordinate--;
            }

            yCoordinate = ((yCoordinate % 10) + 10) % 10;
            xCoordinate = ((xCoordinate % 10) + 10) % 10;
        }
    }

    private void rotateRight(String command) {
        if (command.equals(RIGHT)) {
            if (direction.equals(NORTH)) {
                direction = EAST;
            } else if (direction.equals(EAST)) {
                direction = SOUTH;
            } else if (direction.equals(SOUTH)) {
                direction = WEST;
            } else if (direction.equals(WEST)) {
                direction = NORTH;
            }
        }
    }

    private void rotateLeft(String command) {
        if (command.equals(LEFT)) {
            if (direction.equals(NORTH)) {
                direction = WEST;
            } else if (direction.equals(WEST)) {
                direction = SOUTH;
            } else if (direction.equals(SOUTH)) {
                direction = EAST;
            } else if (direction.equals(EAST)) {
                direction = NORTH;
            }
        }
    }

    private List<String> nextCommand(String command) {
        return Arrays.asList(command.split(""));
    }
}
