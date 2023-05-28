package pl.edu.pk.student.carrots.cinema.utils;

import pl.edu.pk.student.carrots.cinema.models.Ticket;
import pl.edu.pk.student.carrots.cinema.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Auth {
    static Auth instance = null;
    private User currentUser;

    public static Auth getInstance() {
        if (instance == null) instance = new Auth();
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }
}
