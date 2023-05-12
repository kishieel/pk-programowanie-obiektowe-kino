package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

public class ListMoviesAction implements Action {
    MovieRepository movieRepository = MovieRepository.getInstance();

    @Override
    public String getTitle() {
        return "Pokaż filmy";
    }

    @Override
    public void doAction() {
        System.out.println("Lista dostepnych filmów:");
        movieRepository.getAll().forEach(movie -> System.out.println(
                movie.title() + " " +
                (movie.ageRestricted() ? " (+18) " : "") + " - " +
                movie.description() + " | Czas trwania: " + movie.duration() + "m"
        ));

        IO.accept("Czy chcesz obejrzeć któryś z filmów?", () -> {}, () -> {});
    }
}
