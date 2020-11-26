package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class RotateLeft implements Command {
    @Override
    public void execute(Position position) {
        String direction = position.getDirection();

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
