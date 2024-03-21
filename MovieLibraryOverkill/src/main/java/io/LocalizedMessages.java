package io;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedMessages {
    private static final String BASE_NAME = "messages";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME);

    public static String getMessage(MessageKey key) {
        return resourceBundle.getString(key.name());
    }

    public static void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }


    public static String invalidChoice(int choice) {
        return String.format(getMessage(MessageKey.INVALID_CHOICE_TEMPLATE), choice);
    }

    public static String noMoviesFoundInRange(int start, int end) {
        return String.format(getMessage(MessageKey.NO_MOVIES_FOUND_IN_RANGE_TEMPLATE), start, end);
    }

    public static String moviesByActorNotFound(String firstName, String lastName) {
        return String.format(getMessage(MessageKey.MOVIES_BY_ACTOR_NOT_FOUND_TEMPLATE), firstName, lastName);
    }
}
