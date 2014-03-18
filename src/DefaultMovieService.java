import java.lang.reflect.Array;
import java.util.ArrayList;

public class DefaultMovieService {
    public Movie[] Load() throws Exception {
        if (!Session.HasKey("LoggedUser")) {
            throw new Exception("User is not authorized");
        }

        if (Session.HasValue("LoggedUser", "admin")) {
            ArrayList<Movie> movies = ReadDatabase();
            Movie[] result = new Movie[movies.size()];
            for (int i = 0; i < movies.size(); i++) {
                result[i] = movies.get(i);
            }
            return result;
        }
        else {
            if (Session.HasValue("LoggedUser", "user")) {
                ArrayList<Movie> movies = ReadDatabase();
                Movie[] result = new Movie[movies.size()];
                for (int i = 0; i < movies.size(); i++) {
                    if (movies.get(i).Rating <= 14)
                    {
                        result[i] = movies.get(i);
                    }
                }
                return result;
            }
        }

        return new Movie[0];
    }

    private ArrayList<Movie> ReadDatabase() {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie1 = new Movie(1);
        movie1.Title = "Star Wars";
        movie1.Price = "150 RUR";
        movie1.Rating = 18;
        movies.add(movie1);

        Movie movie2 = new Movie(2);
        movie2.Title = "Star Trek";
        movie2.Price = "100 RUR";
        movie2.Rating = 16;
        movies.add(movie2);


        Movie movie3 = new Movie(3);
        movie3.Title = "Indiana Jones";
        movie3.Price = "90 RUR";
        movie3.Rating = 14;
        movies.add(movie3);

        return movies;
    }
}


