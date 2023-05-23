package pl.edu.pk.student.carrots.cinema.actions;

public class ExitAction extends SelectableAction {
    @Override
    public String getTitle() {
        return "Wyjdź z kina";
    }

    @Override
    public void doAction() {
        System.exit(0);
    }
}
