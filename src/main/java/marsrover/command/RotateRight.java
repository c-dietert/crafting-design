package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class RotateRight implements Command {

    @Override
    public void execute(Position position) {
        switch (position.getDirection()) {
            case NORTH:
                position.setDirection(EAST);
                break;
            case EAST:
                position.setDirection(SOUTH);
                break;
            case SOUTH:
                position.setDirection(WEST);
                break;
            case WEST:
                position.setDirection(NORTH);
                break;
        }
    }
}
