package service.command;


import io.InputHandler;
import io.LocalizedMessages;
import io.MessageKey;
import service.MovieService;

public class ShowMoviesByActorCommand implements MenuCommand {
    @Override
    public void execute(MovieService movieService, InputHandler inputHandler) {
        var firstName = inputHandler.promptForValidString(LocalizedMessages.getMessage(MessageKey.PROMPT_ACTOR_FIRST_NAME));
        var lastName = inputHandler.promptForValidString(LocalizedMessages.getMessage(MessageKey.PROMPT_ACTOR_LAST_NAME));

        var moviesByActor = movieService.findMoviesByActor(firstName, lastName);

        if (moviesByActor.isEmpty()) {
            System.out.println(LocalizedMessages.moviesByActorNotFound(firstName, lastName));
            return;
        }
        moviesByActor.forEach(movie -> System.out.println(movie.getTitle()));
    }
}
