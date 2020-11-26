package marsrover.location;

public class Position {
    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = ((xCoordinate % 10) + 10) % 10;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = ((yCoordinate % 10) + 10) % 10;
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

    public Position() {
        xCoordinate = 0;
        yCoordinate = 0;
        direction = "N";
    }

    public String getCurrentPosition() {
        return xCoordinate + "-" + yCoordinate + "-" + direction;
    }
}
