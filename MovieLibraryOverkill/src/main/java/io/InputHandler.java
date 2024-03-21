package io;

import common.DisplayableEnumChoice;
import config.AvailableLocale;
import model.YearRange;
import validator.InputValidator;

import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public YearRange promptForYearRange() {
        while (true) {
            var startYear = promptForInt(LocalizedMessages.getMessage(MessageKey.SELECT_START_YEAR));
            var endYear = promptForInt(LocalizedMessages.getMessage(MessageKey.SELECT_END_YEAR));

            if (isValidYearOrder(startYear, endYear)) {
                return new YearRange(startYear, endYear);
            }
            System.out.println(LocalizedMessages.getMessage(MessageKey.INVALID_YEAR_ORDER));
        }
    }


    public int promptForInt(String message) {
        while (true) {
            System.out.print(message);
            var input = scanner.nextLine();
            if (InputValidator.isValidInt(input)) {
                return Integer.parseInt(input);
            }
            System.out.println(LocalizedMessages.getMessage(MessageKey.ENTER_VALID_INT));
        }
    }

    public String promptForValidString(String message) {
        while (true) {
            System.out.print(message);
            var input = scanner.nextLine();
            if (InputValidator.isValidString(input)) {
                return input;
            }
            System.out.println(LocalizedMessages.getMessage(MessageKey.ENTER_VALID_STRING));
        }
    }

    public AvailableLocale getLocaleChoice() {
        return getChoice(AvailableLocale.class, MessageKey.PROMPT_LOCALE_CHOICE, MessageKey.INVALID_LOCALE_CHOICE);
    }

    public DataFormat getDataFormatChoice() {
        return getChoice(DataFormat.class, MessageKey.PROMPT_DATA_FORMAT_CHOICE, MessageKey.INVALID_MENU_CHOICE);
    }

    private boolean isValidYearOrder(int start, int end) {
        return start <= end;
    }

    private <E extends Enum<E> & DisplayableEnumChoice> E getChoice(Class<E> enumClass, MessageKey promptMessage, MessageKey invalidChoiceMessage) {
        while (true) {
            EnumChoiceDisplayHelper.displayChoices(enumClass, promptMessage);

            var choice = promptForInt(LocalizedMessages.getMessage(MessageKey.YOUR_CHOICE));
            var selectedOption = EnumChoiceDisplayHelper.fromChoice(enumClass, choice);

            if (selectedOption.isPresent()) {
                return selectedOption.get();
            }
            System.out.println(LocalizedMessages.getMessage(invalidChoiceMessage));
        }
    }

    private void displayError(MessageKey key) {
        System.out.println(LocalizedMessages.getMessage(key));
    }
}
