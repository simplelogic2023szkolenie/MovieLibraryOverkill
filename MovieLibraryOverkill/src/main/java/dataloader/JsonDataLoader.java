package dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.MovieLibrary;

import java.io.File;
import java.io.IOException;

public class JsonDataLoader implements MovieLibraryLoader {
    private final String jsonFilePath;

    public JsonDataLoader(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    @Override
    public MovieLibrary loadMovieLibrary() throws IOException {
        return new ObjectMapper().readValue(new File(jsonFilePath), MovieLibrary.class);
    }
}

