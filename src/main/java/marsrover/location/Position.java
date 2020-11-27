package marsrover.location;

public class Position {
    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private int xCoordinate;
    private int yCoordinate;
    private String direction;
    private boolean stuck;

    public Position() {
        xCoordinate = 0;
        yCoordinate = 0;
        direction = "N";
        stuck = false;
    }

    public String getCurrentPosition() {
        String stuck = this.stuck ? "0-" : "";
        return stuck + xCoordinate + "-" + yCoordinate + "-" + direction;
    }

    public void setStuck(boolean stuck) {
        this.stuck = stuck;
    }

    public boolean isStuck() {
        return stuck;
    }
}
