package marsrover.command;

import marsrover.location.Position;

public interface Command {

    public void execute(Position position);
}
