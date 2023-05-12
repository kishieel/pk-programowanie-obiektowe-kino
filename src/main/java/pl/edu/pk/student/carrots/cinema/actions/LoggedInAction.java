package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class LoggedInAction implements Action {


    @Override
    public void doAction() {
        IO.menu(
                "Witaj w panelu użytkownika. Jak możemy Ci pomóc?",
                List.of(new ListMoviesAction(), new ListSnacksAction(), new LogoutAction())
        );
    }
}
