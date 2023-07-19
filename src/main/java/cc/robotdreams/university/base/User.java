package cc.robotdreams.university.base;

abstract public class User
{
    static private int counter = 0;

    public enum Type {
        TEACHER,
        STUDENT
    }

    final public int        id;
    final public String     username;
    final private String    password;

    private int loginAttempts = 0;
    private boolean isBlocked = false;

    public User(String username, String password) {
        if (username == null || username.isEmpty())
            throw new RuntimeException("Username is empty or null");
        this.username = username;

        if (password == null || password.isEmpty())
            throw new RuntimeException("Password is empty or null");

        this.password = password;
        this.id = ++ counter;
    }

    final public boolean isBlocked() {
        return this.isBlocked;
    }

    final public boolean login(String password) {
        if (isBlocked || password == null || password.isEmpty())
            return false;
        if (loginAttempts == 3) {
            isBlocked = true;
            return false;
        }
        boolean result = this.password.equals(password);
        if (result) {
            loginAttempts = 0;
        } else {
            loginAttempts ++;
        }
        return result;
    }

    abstract public Type getType();
}
