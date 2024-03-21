package main;

import config.AppConfig;
import dataloader.JsonDataLoader;
import dataloader.MovieLibraryLoader;
import dataloader.XmlDataLoader;
import io.EnumChoiceDisplayHelper;
import io.InputHandler;
import io.LocalizedMessages;
import io.MessageKey;
import model.MovieLibrary;
import service.MenuOption;
import service.MovieService;

import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    private static final AppConfig appConfig = AppConfig.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputHandler inputHandler = new InputHandler(scanner);

    public static void main(String[] args) {
        setApplicationLocale();
        MovieLibraryLoader movieLibraryLoader = selectDataLoader();
        MovieLibrary movieLibrary = loadData(movieLibraryLoader);
        MovieService movieService = new MovieService(movieLibrary);
        mainMenuLoop(movieService);
    }

    private static void setApplicationLocale() {
        var selectedLocale = inputHandler.getLocaleChoice();
        LocalizedMessages.setLocale(selectedLocale.getLocale());
    }

    private static MovieLibraryLoader selectDataLoader() {
        var formatChoice = inputHandler.getDataFormatChoice();

        return switch (formatChoice) {
            case JSON -> new JsonDataLoader(appConfig.getJsonPath());
            case XML -> new XmlDataLoader(appConfig.getXmlPath());
        };
    }

    private static MovieLibrary loadData(MovieLibraryLoader movieLibraryLoader) {
        try {
            return movieLibraryLoader.loadMovieLibrary();
        } catch (IOException e) {
            System.out.println("Error while loading data: " + e.getMessage());
            System.exit(1);
            return null;
        }
    }

    private static void mainMenuLoop(MovieService movieService) {
        while (true) {
            EnumChoiceDisplayHelper.displayChoices(MenuOption.class, MessageKey.PROMPT_MAIN_MENU_CHOICE);

            var choice = inputHandler.promptForInt(LocalizedMessages.getMessage(MessageKey.YOUR_CHOICE));

            if (choice < 1 || choice > MenuOption.values().length) {
                System.out.println(LocalizedMessages.getMessage(MessageKey.INVALID_MENU_CHOICE));
                continue;
            }

            var option = EnumChoiceDisplayHelper.fromChoice(MenuOption.class, choice);
            option.ifPresent(menuOption -> menuOption.execute(movieService, inputHandler));
        }
    }
}
