package twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    List<User> followers;
    List<String> messages;

    public User() {
        followers = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public List<String> getAllMessages() {
        return messages;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void addFollower(User follower) {
        followers.add(follower);
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
