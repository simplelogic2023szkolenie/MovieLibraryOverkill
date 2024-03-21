package model.person;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Director extends Person {
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}