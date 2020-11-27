package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class RotateLeft implements Command {
    @Override
    public void execute(Position position) {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(WEST);
                break;
            case WEST:
                position.setDirection(SOUTH);
                break;
            case SOUTH:
                position.setDirection(EAST);
                break;
            case EAST:
                position.setDirection(NORTH);
                break;
        }
    }
}
