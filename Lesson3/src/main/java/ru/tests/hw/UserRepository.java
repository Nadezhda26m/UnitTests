package ru.tests.hw;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutAll() {
        for (int i = data.size() - 1; i >= 0; i--) {
            if (!data.get(i).isAdmin()) {
                data.get(i).logOut();
                data.remove(i);
            }
        }
    }
}


