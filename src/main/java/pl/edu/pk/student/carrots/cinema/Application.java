package pl.edu.pk.student.carrots.cinema;

import pl.edu.pk.student.carrots.cinema.actions.ExitAction;
import pl.edu.pk.student.carrots.cinema.actions.LoginAction;
import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        MovieRepository.getInstance().add(new Movie("a", "b", 12, true));

        IO.menu("Witaj w kinie Politechnika! Jak możemy Ci pomóc?", List.of(new LoginAction(), new ExitAction()));
    }
}
