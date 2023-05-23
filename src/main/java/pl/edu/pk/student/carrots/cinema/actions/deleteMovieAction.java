package pl.edu.pk.student.carrots.cinema.actions;

import pl.edu.pk.student.carrots.cinema.utils.IO;

public class deleteMovieAction {
    System.out.println("Lista dostepnych filmów:");
        movieRepository.getAll().forEach(movie -> System.out.println(
            movie.title() +

            ));

        IO.accept("Czy chcesz obejrzeć któryś z filmów?", this::selectMovie, () -> new LoggedInAction().doAction());
}
