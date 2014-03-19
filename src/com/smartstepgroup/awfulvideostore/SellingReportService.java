package com.smartstepgroup.awfulvideostore;

import java.io.IOException;
import java.util.ArrayList;

public class SellingReportService {
    public String GetReport() throws IOException {
        if (Session.HasValue("LoggedUser", "Admin")) {
            ArrayList<Movie> data = LoadFake();

            int regular = 0;
            int newReleases = 0;
            int children = 0;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).GetMovieCodeName() == "Regular") {
                    regular++;
                }
                if (data.get(i).GetMovieCodeName() == "New Releases") {
                    newReleases++;
                }
                if (data.get(i).GetMovieCodeName() == "Children") {
                    children++;
                }
            }

            if (regular >= newReleases && regular >= children)
                return "Best selling is: Regular";

            if (children >= newReleases && children >= regular)
                return "Best selling is: Children";

            if (newReleases >= children && newReleases >= regular)
                return "Best selling is: New Releases";

            return "All movies are awful";
        }

        return "You have no access to report";
    }

    private ArrayList<Movie> LoadFake() {
        Movie movie1 = new Movie(2);
        movie1.Price = "1.99$";
        movie1.Title = "Star Wars";
        movie1.Rating = 18;

        Movie movie2 = new Movie(1);
        movie2.Price = "2.99$";
        movie2.Title = "Star Trek";
        movie2.Rating = 16;

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(movie1);
        movies.add(movie2);
        return movies;
    }
}
