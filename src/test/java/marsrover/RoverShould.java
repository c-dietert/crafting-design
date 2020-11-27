package marsrover;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverShould {

    @Test
    void
    return_initial_possition_when_executed_without_commands() {
        Rover rover = new Rover();

        String position = rover.execute("");

        assertThat(position).isEqualTo("0-0-N");
    }

    @Test
    void
    move_north() {

        Rover rover = new Rover();

        String position = rover.execute("M");

        assertThat(position).isEqualTo("0-1-N");
    }

    @Test
    void
    turn_right() {
        Rover rover = new Rover();

        String position = rover.execute("R");

        assertThat(position).isEqualTo("0-0-E");
    }

    @Test
    void
    move_and_rotate_right() {
        Rover rover = new Rover();

        String position = rover.execute("MR");

        assertThat(position).isEqualTo("0-1-E");
    }

    @Test
    void
    rotate_right_three_times() {
        Rover rover = new Rover();

        String position = rover.execute("RRR");

        assertThat(position).isEqualTo("0-0-W");
    }

    @Test
    void
    rotate_left_three_times() {
        Rover rover = new Rover();

        String position = rover.execute("LLL");

        assertThat(position).isEqualTo("0-0-E");
    }

    @Test
    void move_east() {
        Rover rover = new Rover();

        String position = rover.execute("RM");

        assertThat(position).isEqualTo("1-0-E");
    }

    @Test
    void move_south() {
        Rover rover = new Rover();

        String position = rover.execute("RRM");

        assertThat(position).isEqualTo("0-9-S");
    }

    @Test
    void move_west() {
        Rover rover = new Rover();

        String position = rover.execute("LM");

        assertThat(position).isEqualTo("9-0-W");
    }

    @Test
    void stop_in_front_of_obstacle() {
        Obstacle obstacle = new Obstacle(0,3);

        Rover rover = new Rover(Arrays.asList(obstacle));

        String position = rover.execute("MMM");

        assertThat(position).isEqualTo("0-0-2-N");
    }
}
