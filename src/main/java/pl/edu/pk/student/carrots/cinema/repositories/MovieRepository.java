package pl.edu.pk.student.carrots.cinema.repositories;

import pl.edu.pk.student.carrots.cinema.models.Movie;
import pl.edu.pk.student.carrots.cinema.models.Snack;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    static MovieRepository instance = null;
    private final List<Movie> movies = new ArrayList<>();

    public static MovieRepository getInstance() {
        if (instance == null) instance = new MovieRepository();
        return instance;
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAll() {
        return movies;
    }
}
