package service;

import model.Movie;
import model.MovieLibrary;
import model.YearRange;
import model.person.Actor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MovieService {

    private final MovieLibrary movieLibrary;
    private final Random random = new Random();

    public MovieService(MovieLibrary movieLibrary) {
        this.movieLibrary = movieLibrary;
    }

    public List<Movie> findMoviesBetweenYears(YearRange yearRange) {
        return movieLibrary.getMovies().stream()
                .filter(movie -> movie.getDate() >= yearRange.startYear() && movie.getDate() <= yearRange.endYear())
                .collect(Collectors.toList());
    }

    public Movie getRandomMovie() {
        List<Movie> movies = movieLibrary.getMovies();
        return movies.get(random.nextInt(movies.size()));
    }

    public List<Movie> findMoviesByActor(String firstName, String lastName) {
        return movieLibrary.getMovies().stream()
                .filter(movie -> movie.getActors().contains(new Actor(firstName, lastName)))
                .collect(Collectors.toList());

    }
}
