package ru.tests.hw;

public class User {

    String name;
    String password;
    private final boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this(name, password, false);
    }

    // 3.6.
    public boolean authenticate(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = true;
            return true;
        }
        return false;
    }

    public void logOut() {
        isAuthenticate = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}