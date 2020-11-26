package twitter;

import java.util.List;

public class Twitter {

    public static final String EXIT = "Exit";

    private Console console;
    private CommandExecuter commandExecuter;

    public Twitter(Console console, CommandExecuter commandExecuter) {
        this.console = console;

        this.commandExecuter = commandExecuter;
    }

    public String start() {
        while (true) {
            String nextInput = console.getNextInput();
            if (nextInput.equals(EXIT)) break;

            List<String> output = commandExecuter.read(nextInput);
            console.pint(output);
        }
        return EXIT;
    }
}
