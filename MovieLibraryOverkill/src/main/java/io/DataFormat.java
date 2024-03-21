package io;

import common.DisplayableEnumChoice;
import lombok.Getter;

@Getter
public enum DataFormat implements DisplayableEnumChoice {
    JSON(1, "JSON"),
    XML(2, "XML");

    private final int choice;
    private final String displayName;

    DataFormat(int choice, String displayName) {
        this.choice = choice;
        this.displayName = displayName;
    }

    public int getDisplayChoice() {
        return ordinal() + 1;
    }
}
