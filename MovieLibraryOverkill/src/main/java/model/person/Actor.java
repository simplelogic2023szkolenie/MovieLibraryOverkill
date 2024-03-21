package model.person;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Actor extends Person {
    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var person = (Person) o;
        return getFirstName().equalsIgnoreCase(person.getFirstName()) && getLastName().equalsIgnoreCase(person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName().toLowerCase(), getLastName().toLowerCase());
    }
}
