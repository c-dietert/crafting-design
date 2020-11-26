package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class Move implements Command {

    @Override
    public void execute(Position position) {

        switch (position.getDirection()) {
            case NORTH:
                position.setyCoordinate(position.getyCoordinate() + 1);
            case EAST:
                position.setxCoordinate(position.getxCoordinate() + 1);
            case SOUTH:
                position.setyCoordinate(position.getyCoordinate() - 1);
            case WEST:
                position.setxCoordinate(position.getxCoordinate() - 1);
        }
    }
}
