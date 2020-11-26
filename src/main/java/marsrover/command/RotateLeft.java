package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class RotateLeft implements Command {
    @Override
    public void execute(Position position) {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(WEST);
            case WEST:
                position.setDirection(SOUTH);
            case SOUTH:
                position.setDirection(EAST);
            case EAST:
                position.setDirection(NORTH);
        }
    }
}
