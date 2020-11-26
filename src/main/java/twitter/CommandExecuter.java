package twitter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class CommandExecuter {

    UserService userService;

    public CommandExecuter(UserService userService) {
        this.userService = userService;
    }

    public List<String> read(String input) {

        String[] writeMessage = input.split(" -> ", 2);
        if (writeMessage.length == 2) {
            return emptyList();
        }

        String[] wallMessage = input.split(" wall");
        if(input.length() > wallMessage[0].length()) {
            User user = userService.findUser(wallMessage[0]);
            List<String> messagesToPrint = new ArrayList<>();
            messagesToPrint.addAll(user.getAllMessages());
            user.getFollowers().forEach(follower -> {
                messagesToPrint.addAll(follower.getAllMessages());
            });
            return messagesToPrint;
        }

        if (writeMessage.length != 2) {
            User user = userService.findUser(writeMessage[0]);
            return user.getAllMessages();
        }

        return emptyList();
    }
}
