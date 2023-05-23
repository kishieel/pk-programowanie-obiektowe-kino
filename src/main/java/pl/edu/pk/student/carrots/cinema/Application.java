package pl.edu.pk.student.carrots.cinema;

import pl.edu.pk.student.carrots.cinema.actions.AdminHomeAction;
import pl.edu.pk.student.carrots.cinema.actions.ExitAction;
import pl.edu.pk.student.carrots.cinema.actions.LoginAction;
import pl.edu.pk.student.carrots.cinema.actions.WelcomeAction;
import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.models.Snack;
import pl.edu.pk.student.carrots.cinema.models.User;
import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.repositories.SnackRepository;
import pl.edu.pk.student.carrots.cinema.repositories.UserRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        MovieRepository movieRepository = MovieRepository.getInstance();
        movieRepository.add(new Movie("Piękna i bestia", "Lorem ipsum...", 123, false));
        movieRepository.add(new Movie("O cierpieniu człowieka", "Lorem ipsum...", 154, true));
        movieRepository.add(new Movie("Kubuś puchatek i przyjaciele", "Lorem ipsum...", 45, false));

        SnackRepository snackRepository = SnackRepository.getInstance();
        snackRepository.add(new Snack("Popcorn zwykły", 12, 43));
        snackRepository.add(new Snack("Popcorn karmelowy", 15, 65));
        snackRepository.add(new Snack("Cola Zero", 4, 76));
        snackRepository.add(new Snack("Coca Cola ", 4, 12));

        UserRepository userRepository = UserRepository.getInstance();
        userRepository.add(new User("user", "password", "adam", "nowak", "adam.nowak@gmail.com", 123456789, false));
        userRepository.add(new User("admin", "password", "jan", "kowalski", "jan.kowalski@gmail.com", 987654321,
                                    true));

        new WelcomeAction().doAction();
    }
}
