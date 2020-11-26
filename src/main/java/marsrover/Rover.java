package marsrover;

import marsrover.location.Position;

import java.util.Arrays;
import java.util.List;

import static marsrover.location.Direction.*;
import static marsrover.location.Instructions.*;

public class Rover {

    private final Position position;

    public Rover() {
        position = new Position();
    }

    public String execute(String command) {

        List<String> commandToExecute = nextCommand(command);

        executeCommands(commandToExecute);

        return position.getCurrentPosition();
    }

    private void executeCommands(List<String> commandsToExecute) {
        commandsToExecute.forEach(command -> {
            move(command);
            rotateRight(command);
            rotateLeft(command);
        });
    }

    private void move(String command) {
        String direction = position.getDirection();
        int yCoordinate = position.getyCoordinate();
        int xCoordinate = position.getxCoordinate();

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

            position.setyCoordinate(yCoordinate);
            position.setxCoordinate(xCoordinate);
        }
    }

    private void rotateRight(String command) {

        String direction = position.getDirection();

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
            position.setDirection(direction);
        }
    }

    private void rotateLeft(String command) {
        String direction = position.getDirection();

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
            position.setDirection(direction);
        }
    }

    private List<String> nextCommand(String command) {
        return Arrays.asList(command.split(""));
    }
}
