package pl.edu.pk.student.carrots.cinema.repositories;

import pl.edu.pk.student.carrots.cinema.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    static UserRepository instance = null;
    private final List<User> users = new ArrayList<>();

    public static UserRepository getInstance() {
        if (instance == null) instance = new UserRepository();
        return instance;
    }

    public void add(User user) {
        users.add(user);
    }

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return users.stream().filter(user -> user.login().equals(login) && user.password().equals(password)).findFirst();
    }
}
