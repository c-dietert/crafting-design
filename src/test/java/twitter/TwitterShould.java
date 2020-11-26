package twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TwitterShould {
    Console console;
    CommandExecuter commandExecuter;
    @BeforeEach
    void setUp() {
        console = mock(Console.class);
        commandExecuter = mock(CommandExecuter.class);
    }

    @Test
    void stop_on_exit() {
        when(console.getNextInput()).thenReturn("Exit");

        Twitter twitter = new Twitter(console, commandExecuter);

        String result = twitter.start();

        assertThat(result).isEqualTo("Exit");
    }

    @Test
    void checks_console_for_inputs() {
        when(console.getNextInput()).thenReturn("User", "User", "Exit");

        Twitter twitter = new Twitter(console, commandExecuter);

        String result = twitter.start();

        verify(console, times(3)).getNextInput();
        assertThat(result).isEqualTo("Exit");
    }

    @Test
    void pint_output_to_console() {
        when(console.getNextInput()).thenReturn("User", "Exit");
        when(commandExecuter.read("User")).thenReturn(Arrays.asList("Print Command"));

        Twitter twitter = new Twitter(console, commandExecuter);

        twitter.start();

        verify(console, times(1)).pint(Arrays.asList("Print Command"));
    }
}
