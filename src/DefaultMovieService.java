import java.util.ArrayList;

public class DefaultMovieService {
    public Movie[] Load() throws Exception {
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
            result = resultMovies.toArray(result);
            return result;
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
                result = resultMovies.toArray(result);
                return result;
            }
        }

        return new Movie[0];
    }

    private XmlDocument LoadXml() {
        XmlDocument document = new XmlDocument();
        document.Load();
        return document;
    }
}


