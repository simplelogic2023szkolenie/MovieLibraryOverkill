package config;

import common.DisplayableEnumChoice;
import lombok.Getter;

import java.util.Locale;

@Getter
public enum AvailableLocale implements DisplayableEnumChoice {
    ENGLISH("English", Locale.ENGLISH),
    POLISH("Polski", new Locale("pl"));

    private final String displayName;
    private final Locale locale;

    AvailableLocale(String displayName, Locale locale) {
        this.displayName = displayName;
        this.locale = locale;
    }

    @Override
    public int getDisplayChoice() {
        return ordinal() + 1;
    }
}
