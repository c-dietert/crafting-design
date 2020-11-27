package marsrover.command;

import marsrover.Obstacle;
import marsrover.location.Position;

import java.util.List;

import static marsrover.location.Direction.*;

public class Move implements Command {

    private List<Obstacle> obstacles;

    public Move(List<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    @Override
    public void execute(Position position) {
        int x = position.getxCoordinate();
        int y = position.getyCoordinate();

        switch (position.getDirection()) {
            case NORTH:
                y = adjustPositionOnGrid(y + 1);
                break;
            case EAST:
                x = adjustPositionOnGrid(x + 1);
                break;
            case SOUTH:
                y = adjustPositionOnGrid(y - 1);
                break;
            case WEST:
                x = adjustPositionOnGrid(x - 1);
                break;
        }
        if (!obstacleInFront(x, y)) {
            position.setxCoordinate(x);
            position.setyCoordinate(y);
        } else {
            position.setStuck(true);
        }
    }

    private boolean obstacleInFront(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.x == x && obstacle.y == y) {
                return true;
            }
        }
        return false;
    }

    private int adjustPositionOnGrid(int coordinate) {
        return ((coordinate % 10) + 10) % 10;
    }
}
