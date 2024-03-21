package dataloader;

import model.MovieLibrary;

import java.io.IOException;

public interface MovieLibraryLoader {
    MovieLibrary loadMovieLibrary() throws IOException;
}
