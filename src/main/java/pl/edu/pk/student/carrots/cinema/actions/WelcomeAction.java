package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.IO;

import java.util.List;

public class WelcomeAction implements Action {
    @Override
    public void doAction() {
        IO.menu("Witaj w kinie Politechnika! Jak możemy Ci pomóc?", List.of(new LoginAction(), new ExitAction()));
    }
}
