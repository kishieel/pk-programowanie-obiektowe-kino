package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.Snack;
import pl.edu.pk.student.carrots.cinema.repositories.SnackRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

public class ListSnacksAction extends SelectableAction {
    SnackRepository snackRepository = SnackRepository.getInstance();

    @Override
    public String getTitle() {
        return "Pokaż przekąski";
    }

    @Override
    public void doAction() {
        System.out.println("Lista dostepnych przekąsek:");
        snackRepository.getAll().forEach(snack -> System.out.println(
                snack.name() + " - " + snack.price() + "zł"
        ));

        IO.accept("Czy chcesz kupić którąś z przekąsek?", this::selectSnack, () -> new UserHomeAction().doAction());
    }

    private void selectSnack() {
        IO.println("Wybierz, którą chcesz przekąskę.");
        IO.list(snackRepository.getAll().stream().map(Snack::name).toList());
        IO.print("Wybrana przekąska: ");
        Snack snack;

        while (true) {
            snack = snackRepository.get(IO.input(Integer.class) - 1);
            if (snack != null) break;
            IO.println("Nieprawidłowy wybór, wybierz jeszcze raz!");
        }

        IO.println("Przekąska - " + snack.name() + " - dodana do koszyka!");

        new UserHomeAction().doAction();
    }
}
