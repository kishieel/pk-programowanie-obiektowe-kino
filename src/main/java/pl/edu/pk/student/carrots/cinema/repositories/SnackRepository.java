package pl.edu.pk.student.carrots.cinema.repositories;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.models.Snack;

import java.util.ArrayList;
import java.util.List;

public class SnackRepository {
    static SnackRepository instance = null;
    private final List<Snack> snacks = new ArrayList<>();

    public static SnackRepository getInstance() {
        if (instance == null) instance = new SnackRepository();
        return instance;
    }

    public void add(Snack snack) {
        snacks.add(snack);
    }
}
