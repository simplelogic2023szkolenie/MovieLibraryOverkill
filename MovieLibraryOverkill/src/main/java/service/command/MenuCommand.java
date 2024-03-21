package service.command;

import io.InputHandler;
import service.MovieService;

public interface MenuCommand {
    void execute(MovieService movieService, InputHandler inputHandler);
}
