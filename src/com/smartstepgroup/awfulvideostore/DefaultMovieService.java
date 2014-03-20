package com.smartstepgroup.awfulvideostore;

import java.util.ArrayList;

public class DefaultMovieService {
    public Movie[] load() throws Exception {
        Movie[] finalResult = new Movie[0];
        if (!Session.hasKey("LoggedUser")) {
            throw new Exception("User is not authorized");
        }

        if (Session.hasValue("LoggedUser", "admin")) {
            XmlDocument xmlMovies = loadXml();
            ArrayList<Movie> resultMovies = new ArrayList<Movie>();
            for (int i = 0; i < xmlMovies.Elements.size(); i++) {
                    Movie movie = new Movie(Integer.parseInt(xmlMovies.Elements.get(i).Values[3]));
                    movie.Rating = Integer.parseInt(xmlMovies.Elements.get(i).Values[2]);
                    movie.Title = xmlMovies.Elements.get(i).Values[0];
                    movie.Price = xmlMovies.Elements.get(i).Values[1];
                    resultMovies.add(movie);

            }
            Movie[] result = new Movie[resultMovies.size()];
            finalResult = resultMovies.toArray(result);
        }
        else {
            if (Session.hasValue("LoggedUser", "user")) {
                XmlDocument xmlMovies = loadXml();
                ArrayList<Movie> resultMovies = new ArrayList<Movie>();

                for (int i = 0; i < xmlMovies.Elements.size(); i++) {
                    if (Integer.parseInt(xmlMovies.Elements.get(i).Values[2]) <= 14)
                    {
                        Movie movie = new Movie(Integer.parseInt(xmlMovies.Elements.get(i).Values[3]));
                        movie.Rating = Integer.parseInt(xmlMovies.Elements.get(i).Values[2]);
                        movie.Title = xmlMovies.Elements.get(i).Values[0];
                        movie.Price = xmlMovies.Elements.get(i).Values[1];
                        resultMovies.add(movie);
                    }
                }
                Movie[] result = new Movie[resultMovies.size()];
                finalResult = resultMovies.toArray(result);
            }
        }

        return finalResult;
    }

    private XmlDocument loadXml() {
        XmlDocument document = new XmlDocument();
        document.load();
        return document;
    }
}


