package marsrover;

import marsrover.command.Command;
import marsrover.command.Move;
import marsrover.command.RotateLeft;
import marsrover.command.RotateRight;
import marsrover.location.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static marsrover.location.Instructions.LEFT;
import static marsrover.location.Instructions.RIGHT;

public class Rover {

    private final Position position;
    private List<Obstacle> obstacles;

    public Rover() {
        position = new Position();
        obstacles = Collections.emptyList();
    }

    public Rover(List<Obstacle> obstacles) {
        position = new Position();
        this.obstacles = obstacles;
    }

    public String execute(String command) {

        List<Command> commandToExecute = nextCommand(command);

        executeCommands(commandToExecute);

        return position.getCurrentPosition();
    }

    private void executeCommands(List<Command> commandsToExecute) {
        commandsToExecute.forEach(command -> {
            if (!position.isStuck()) {
                command.execute(position);
            }
        });
    }

    private List<Command> nextCommand(String command) {

        if (command.isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays.stream(command.split(""))
                .map(instruction -> {
                    if (LEFT.equals(instruction)) {
                        return new RotateLeft();
                    }
                    if (RIGHT.equals(instruction)) {
                        return new RotateRight();
                    }
                    return new Move(obstacles);
                }).collect(Collectors.toList());
    }
}
