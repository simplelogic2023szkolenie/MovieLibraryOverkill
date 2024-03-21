package service.command;

import io.InputHandler;
import io.LocalizedMessages;
import service.MovieService;

public class ShowMoviesBetweenDatesCommand implements MenuCommand {
    @Override
    public void execute(MovieService movieService, InputHandler inputHandler) {
        var yearRange = inputHandler.promptForYearRange();
        var movies = movieService.findMoviesBetweenYears(yearRange);

        if (movies.isEmpty()) {
            System.out.println(LocalizedMessages.noMoviesFoundInRange(yearRange.startYear(), yearRange.endYear()));
            return;
        }
        movies.forEach(movie -> System.out.println(movie.getTitle()));
    }
}
