package twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommandExecuterShould {

    CommandExecuter commandExecuter;
    UserService userService;
    User mihail;
    User chris;

    @BeforeEach
    void setUp() {
        mihail = new UserBuilder().addMessages("Hallo I'm Mihail =)").build();
        chris = new UserBuilder().addFollower(mihail).addMessages("Hallo").build();
        userService = mock(UserService.class);
    }

    @Test
    void read_new_post() {
        commandExecuter = new CommandExecuter(userService);

        List<String> output = commandExecuter.read("Chris -> Hallo");

        assertThat(output).isEmpty();
    }

    @Test
    void return_all_posts_of_user() {
        when(userService.findUser("Chris")).thenReturn(chris);
        commandExecuter = new CommandExecuter(userService);

        List<String> output = commandExecuter.read("Chris");

        assertThat(output.get(0)).isEqualTo("Hallo");
    }

    @Test
    void return_all_posts_of_user_and_followers() {
        when(userService.findUser("Chris")).thenReturn(chris);

        commandExecuter = new CommandExecuter(userService);

        List<String> output = commandExecuter.read("Chris wall");

        assertThat(output.get(0)).isEqualTo("Hallo");
        assertThat(output.get(1)).isEqualTo("Hallo I'm Mihail =)");
    }
}
