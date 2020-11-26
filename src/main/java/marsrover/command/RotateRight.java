package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class RotateRight implements Command {
    @Override
    public void execute(Position position) {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(EAST);
            case EAST:
                position.setDirection(SOUTH);
            case SOUTH:
                position.setDirection(WEST);
            case WEST:
                position.setDirection(NORTH);
        }
    }
}
