package com.smartstepgroup.awfulvideostore;

import java.util.ArrayList;

public class DefaultMovieService {
    private Movie[] LoadedMovies;
    public Movie[] Load() throws Exception {
        Movie[] finalResult = new Movie[0];
        if (!Session.HasKey("LoggedUser")) {
            throw new Exception("User is not authorized");
        }

        if (Session.HasValue("LoggedUser", "admin")) {
            XmlDocument xmlMovies = LoadXml();
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
            if (Session.HasValue("LoggedUser", "user")) {
                XmlDocument xmlMovies = LoadXml();
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

        LoadedMovies = finalResult;
        return finalResult;
    }

    public void ExportToExcel() {

    }

    private XmlDocument LoadXml() {
        XmlDocument document = new XmlDocument();
        document.Load();
        return document;
    }
}


