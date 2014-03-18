public class Movie {
    private String MovieCodeName;
    public Movie(int movieCd) {
        if (movieCd == MovieCodes.CHILDRENS)
            MovieCodeName = "Children";
        else if (movieCd == MovieCodes.NEW_RELEASE)
            MovieCodeName = "New Release";
        else if (movieCd == MovieCodes.REGULAR)
            MovieCodeName = "Regular";
        else MovieCodeName = null;
    }

    public String Title;
    public String Price;
    public int Rating;

    public String GetMovieCodeName() {
        return MovieCodeName;
    }
}
