package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class LoginAction implements Action {
    @Override
    public String getTitle() {
        return "Zaloguj się";
    }

    @Override
    public void doAction() {
        IO.menu(
                "Witaj w panelu użytkownika. Jak możemy Ci pomóc?",
                List.of(new ListMoviesAction(), new ListSnacksAction(), new LogoutAction())
        );
    }
}
