package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.repositories.MovieRepository;
import pl.edu.pk.student.carrots.cinema.utils.IO;

public class ListMoviesAction implements SelectableAction {
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

        IO.accept("Czy chcesz obejrzeć któryś z filmów?", this::selectMovie, () -> new UserHomeAction().doAction());
    }

    private void selectMovie() {
        IO.println("Wybierz, który film chcesz obejrzeć.");
        IO.list(movieRepository.getAll().stream().map(Movie::title).toList());
        IO.print("Wybrany film: ");
        Movie movie;

        while (true) {
            movie = movieRepository.get(IO.input(Integer.class) - 1);
            if (movie != null) break;
            IO.println("Nieprawidłowy wybór, wybierz jeszcze raz!");
        }

        if (movie.ageRestricted()) {
            IO.accept(
                    "Wybrany film jest przeznaczony wyłącznie dla dorosłych! Czy ukonczyłeś 18 lat?",
                    () -> IO.println("Miłego oglądania!"),
                    () -> IO.println("Niestety! Nie możesz obejrzeć tego filmu :(")
            );

        } else {
            IO.println("Wybrałeś: " + movie.title() + ". Miłego oglądania!");
        }

        IO.println("Tum.. tum.. tum.. " + movie.duration() + " minuty później..");
        new UserHomeAction().doAction();
    }
    }
}
