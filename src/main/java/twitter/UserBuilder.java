package twitter;

public class UserBuilder {

    User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder addFollower(User... followers) {
        for(User follower: followers) {
            this.user.addFollower(follower);
        }
        return this;
    }

    public UserBuilder addMessages(String... messages) {
        for (String message: messages) {
            this.user.addMessage(message);
        }
        return this;
    }

    public User build(){
        return user;
    }

}
