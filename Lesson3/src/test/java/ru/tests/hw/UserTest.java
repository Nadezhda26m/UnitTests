package ru.tests.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository = new UserRepository();
    }

    @Test
    void positiveUserData() {
        User user = new User("user", "password");
        assertTrue(user.authenticate("user", "password"));
    }

    @ParameterizedTest
    @CsvSource({"root, 1234",
            "root, password",
            "user, 1234"})
    void negativeCredentials(String name, String password) {
        User user = new User("user", "password");
        assertFalse(user.authenticate(name, password));
    }

    @Test
    void positiveDataForUserRepository() {
        User user = new User("user", "password");
        user.authenticate("user", "password");
        userRepository.addUser(user);
        assertTrue(userRepository.findByName("user"));
    }

    @Test
    void negativeDataForUserRepository() {
        User user = new User("Ivan", "1111");
        userRepository.addUser(user);
        assertFalse(userRepository.findByName("Ivan"));
    }

    @Test
    void logOutAllExceptAdmins() {
        User user = new User("Ivan", "1111");
        user.authenticate("Ivan", "1111");
        userRepository.addUser(user);
        User user2 = new User("Sergei", "222", true);
        user2.authenticate("Sergei", "222");
        userRepository.addUser(user2);
        User user3 = new User("Tom", "3333");
        user3.authenticate("Tom", "3333");
        userRepository.addUser(user3);
        User user4 = new User("Piter", "44", true);
        user4.authenticate("Piter", "44");
        userRepository.addUser(user4);

        userRepository.logOutAll();

        assertThat(userRepository.data)
                .isNotEmpty()
                .hasSize(2)
                .containsAll(Arrays.asList(user2, user4));
    }

    @Test
    void logOutAllExceptAdmin() {
        User user = new User("Ivan", "1111");
        user.authenticate("Ivan", "1111");
        userRepository.addUser(user);
        User user2 = new User("Sergei", "222", true);
        user2.authenticate("Sergei", "222");
        userRepository.addUser(user2);
        User user3 = new User("Tom", "3333");
        user3.authenticate("Tom", "3333");
        userRepository.addUser(user3);
        User user4 = new User("Piter", "44", false);
        user4.authenticate("Piter", "44");
        userRepository.addUser(user4);

        userRepository.logOutAll();

        assertThat(userRepository.data)
                .isNotEmpty()
                .hasSize(1)
                .containsAll(List.of(user2));
    }

    @Test
    void logOutAllWithoutAdmins() {
        User user = new User("Ivan", "1111");
        user.authenticate("Ivan", "1111");
        userRepository.addUser(user);
        User user2 = new User("Sergei", "222");
        user2.authenticate("Sergei", "222");
        userRepository.addUser(user2);
        User user3 = new User("Tom", "3333");
        user3.authenticate(user3.name, user3.password);
        userRepository.addUser(user3);

        userRepository.logOutAll();

        assertThat(userRepository.data)
                .isEmpty();
    }

    @Test
    void logOutEmptyRepository() {
        userRepository.logOutAll();

        assertThat(userRepository.data)
                .isEmpty();
    }
}