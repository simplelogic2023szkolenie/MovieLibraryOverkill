package service.command;

import io.InputHandler;
import service.MovieService;

public class ExitProgramCommand implements MenuCommand {
    @Override
    public void execute(MovieService movieService, InputHandler inputHandler) {
        System.exit(0);
    }
}
