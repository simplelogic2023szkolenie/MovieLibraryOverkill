package io;

import common.DisplayableEnumChoice;

import java.util.Optional;

public class EnumChoiceDisplayHelper {
    public static <E extends Enum<E> & DisplayableEnumChoice> void displayChoices(Class<E> enumClass, MessageKey messageKey) {
        System.out.println(LocalizedMessages.getMessage(messageKey));
        for (var choice : enumClass.getEnumConstants()) {
            System.out.printf("%d. %s%n", choice.getDisplayChoice(), choice.getDisplayName());
        }
    }

    public static <E extends Enum<E> & DisplayableEnumChoice> Optional<E> fromChoice(Class<E> enumClass, int choice) {
        for (E enumValue : enumClass.getEnumConstants()) {
            if (enumValue.getDisplayChoice() == choice) {
                return Optional.of(enumValue);
            }
        }
        return Optional.empty();
    }

}

