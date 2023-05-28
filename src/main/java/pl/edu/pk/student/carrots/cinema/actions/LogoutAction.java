package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.Auth;

public class LogoutAction extends SelectableAction {
    @Override
    public String getTitle() {
        return "Wyloguj";
    }

    @Override
    public void doAction() {
        Auth.getInstance().setCurrentUser(null);
        new WelcomeAction().doAction();
    }
}
