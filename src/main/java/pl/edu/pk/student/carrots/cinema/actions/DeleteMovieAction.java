package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

public class DeleteMovieAction implements SelectableAction{
        MovieRepository movieRepository = MovieRepository.getInstance();

        @Override
        public String getTitle() {
            return "Usuń film";
        }

        @Override
        public void doAction() {
            IO.println("Wybierz, który film chcesz usunąć.");
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

            movieRepository.remove(movie);
            IO.println("Film został usunięty pomyślnie!");

            new AdminHomeAction().doAction();
        }
}
