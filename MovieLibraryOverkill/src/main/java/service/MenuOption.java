package service;

import common.DisplayableEnumChoice;
import io.InputHandler;
import io.LocalizedMessages;
import io.MessageKey;
import lombok.Getter;
import service.command.*;


public enum MenuOption implements DisplayableEnumChoice {
    SHOW_MOVIES_BETWEEN_DATES(1, LocalizedMessages.getMessage(MessageKey.PROMPT_DATES), new ShowMoviesBetweenDatesCommand()),
    SHOW_RANDOM_MOVIE(2, LocalizedMessages.getMessage(MessageKey.DISPLAY_RANDOM_MOVIE), new ShowRandomMovieCommand()),
    SHOW_MOVIES_BY_ACTOR(3, LocalizedMessages.getMessage(MessageKey.PROMPT_SEARCH_ACTOR), new ShowMoviesByActorCommand()),
    EXIT_PROGRAM(4, LocalizedMessages.getMessage(MessageKey.EXIT_PROGRAM), new ExitProgramCommand());

    private final int optionNumber;
    @Getter
    private final String displayName;
    private final MenuCommand command;

    MenuOption(int optionNumber, String displayName, MenuCommand command) {
        this.optionNumber = optionNumber;
        this.displayName = displayName;
        this.command = command;
    }


    public static MenuOption getOptionByChoice(int choice) {
        for (var option : values()) {
            if (option.optionNumber == choice) {
                return option;
            }
        }
        throw new IllegalArgumentException(LocalizedMessages.invalidChoice(choice));
    }

    public void execute(MovieService movieService, InputHandler inputHandler) {
        this.command.execute(movieService, inputHandler);
    }

    @Override
    public int getDisplayChoice() {
        return ordinal() + 1;
    }
}
