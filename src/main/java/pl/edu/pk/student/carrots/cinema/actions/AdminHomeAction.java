package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class AdminHomeAction implements Action {


    @Override
    public void doAction() {
        IO.menu(
                "Witaj w panelu admina. Jak możemy Ci pomóc?",
                List.of(new AddNewMovieAction(), new EditMovieAction(), new DeleteMovieAction(), new LogoutAction())
        );
    }
}
