package service.command;


import io.InputHandler;
import service.MovieService;

public class ShowRandomMovieCommand implements MenuCommand {
    @Override
    public void execute(MovieService movieService, InputHandler inputHandler) {
        System.out.println(movieService.getRandomMovie());
    }
}
