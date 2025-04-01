class User {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}

public class SecureUser {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("JohnDoe");
        user.setPassword("securePass");

        System.out.println("Username: " + user.getUsername());
    }
}
