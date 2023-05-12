package pl.edu.pk.student.carrots.cinema.actions;

public class LogoutAction implements SelectableAction {
    @Override
    public String getTitle() {
        return "Wyloguj";
    }

    @Override
    public void doAction() {
        new WelcomeAction().doAction();
    }
}
