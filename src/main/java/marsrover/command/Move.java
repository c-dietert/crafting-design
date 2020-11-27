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
        switch (position.getDirection()) {
            case NORTH:
                if(!obstacleInFront(position.getxCoordinate(), adjustPositionOnGrid(position.getyCoordinate() + 1))) {
                    position.setyCoordinate(adjustPositionOnGrid(position.getyCoordinate() + 1));
                } else {
                    position.setStuck(true);
                }
                break;
            case EAST:
                if(!obstacleInFront(adjustPositionOnGrid(position.getxCoordinate() + 1), position.getyCoordinate())) {
                    position.setxCoordinate(adjustPositionOnGrid(position.getxCoordinate() + 1));
                } else {
                    position.setStuck(true);
                }
                break;
            case SOUTH:
                if(!obstacleInFront(position.getxCoordinate(), adjustPositionOnGrid(position.getyCoordinate() - 1))) {
                    position.setyCoordinate(adjustPositionOnGrid(position.getyCoordinate() - 1));
                } else {
                    position.setStuck(true);
                }
                break;
            case WEST:
                if(!obstacleInFront(adjustPositionOnGrid(position.getxCoordinate() - 1), position.getyCoordinate())) {
                    position.setxCoordinate(adjustPositionOnGrid(position.getxCoordinate() - 1));
                } else {
                    position.setStuck(true);
                }
                break;
        }
    }

    private boolean obstacleInFront(int x, int y) {
        for (Obstacle obstacle: obstacles) {
            if (obstacle.x == x && obstacle.y == y) {
                return true;
            }
        }
        return false;
    }

    private int adjustPositionOnGrid(int coordinate){
        return((coordinate % 10) + 10) % 10;
    }
}
