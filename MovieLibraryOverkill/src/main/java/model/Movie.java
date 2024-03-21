package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.person.Actor;
import model.person.Director;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String title;
    private Director director;
    private String genre;
    private int date;
    private List<Actor> actors;

    @Override
    public String toString() {
        return "title: " + title + "\ndirector: " + director + "\ngenre: " + genre + "\ndate: " + date + "\nactors: " + actors;
    }
}