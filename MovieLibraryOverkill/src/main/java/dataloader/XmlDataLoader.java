package dataloader;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.MovieLibrary;

import java.io.File;
import java.io.IOException;

public class XmlDataLoader implements MovieLibraryLoader {
    private final String xmlFilePath;

    public XmlDataLoader(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    @Override
    public MovieLibrary loadMovieLibrary() throws IOException {
        return new XmlMapper().readValue(new File(xmlFilePath), MovieLibrary.class);
    }
}
