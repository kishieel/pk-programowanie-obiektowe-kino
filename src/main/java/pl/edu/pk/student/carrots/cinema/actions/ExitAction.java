package pl.edu.pk.student.carrots.cinema.actions;

public class ExitAction implements Action {
    @Override
    public String getTitle() {
        return "Wyjdź z kina";
    }

    @Override
    public void doAction() {
        System.exit(0);
    }
}
