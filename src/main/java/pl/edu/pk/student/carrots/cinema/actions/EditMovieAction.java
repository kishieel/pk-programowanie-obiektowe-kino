package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

public class EditMovieAction extends SelectableAction {
    MovieRepository movieRepository = MovieRepository.getInstance();

    @Override
    public String getTitle() {
        return "Edytuj film";
    }

    @Override
    public void doAction() {
        IO.println("Wybierz, który film chcesz zmodyfikować.");
        IO.list(movieRepository.getAll().stream().map(Movie::title).toList());
        IO.print("Wybrany film: ");
        Movie movie;
        int movieId;

        while (true) {
            movieId = IO.input(Integer.class) - 1;
            movie = movieRepository.get(movieId);
            if (movie != null) break;
            IO.println("Nieprawidłowy wybór, wybierz jeszcze raz!");
        }

        IO.println("Obecny tytuł filmu: " + movie.title());
        IO.print("Nowy tytuł filmu: ");
        String title = IO.input(String.class);

        IO.println("Obecny tytuł filmu: " + movie.description());
        IO.print("Nowy opis filmu: ");
        String description = IO.input(String.class);

        IO.println("Obecny czas trwania (w minutach): " + movie.duration());
        IO.print("Czas trwania (w minutach): ");
        int duration = IO.input(Integer.class);

        IO.println("Obecne ograniczenie wiekowe: " + (movie.ageRestricted() ? "TAK" : "NIE"));
        IO.print("Czy jest odpowiedni dla dzieci? (Y/N)");
        boolean ageRestricted = IO.input(Boolean.class);

        movieRepository.update(movieId, new Movie(title, description,  duration, ageRestricted, 20));
        IO.println("Film został zapisany pomyślnie!");

        new AdminHomeAction().doAction();
    }
}
