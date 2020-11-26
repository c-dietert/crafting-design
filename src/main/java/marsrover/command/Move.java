package marsrover.command;

import marsrover.location.Position;

import static marsrover.location.Direction.*;

public class Move implements Command {
    @Override
    public void execute(Position position) {
        String direction = position.getDirection();
        int yCoordinate = position.getyCoordinate();
        int xCoordinate = position.getxCoordinate();

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
