package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

public class AddNewMovieAction implements SelectableAction {
    MovieRepository movieRepository = MovieRepository.getInstance();

    @Override
    public String getTitle() {
        return "Dodaj film";
    }

    @Override
    public void doAction() {
        IO.print("Tytuł filmu: ");
        String title = IO.input(String.class);

        IO.print("Opis filmu: ");
        String description = IO.input(String.class);

        IO.print("Czas trwania (w minutach): ");
        int duration = IO.input(Integer.class);

        IO.print("Czy jest odpowiedni dla dzieci? (Y/N)");
        boolean ageRestricted = IO.input(Boolean.class);

        movieRepository.add(new Movie(title, description,  duration, ageRestricted));
        IO.println("Nowy film dodany pomyślnie!");

        new AdminHomeAction().doAction();
    }
}
