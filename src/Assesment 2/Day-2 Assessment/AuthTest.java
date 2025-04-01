class Authentication {
    private String secret = "mySecret";

    class User {
        void checkPassword(String pass) {
            if (pass.equals(secret)) {
                System.out.println("Access Granted!");
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}

public class AuthTest {
    public static void main(String[] args) {
        Authentication auth = new Authentication();
        Authentication.User user = auth.new User();
        user.checkPassword("mySecret");
    }
}
