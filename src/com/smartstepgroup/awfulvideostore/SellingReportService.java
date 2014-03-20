package com.smartstepgroup.awfulvideostore;

public class SellingReportService {
    public String getReport() throws Exception {
        if (Session.hasValue("LoggedUser", "Admin")) {
            Movie[] data = new DefaultMovieService().load();

            int regular = 0;
            int newReleases = 0;
            int children = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i].getMovieCodeName() == "Regular") {
                    regular++;
                }
                if (data[i].getMovieCodeName() == "New Releases") {
                    newReleases++;
                }
                if (data[i].getMovieCodeName() == "Children") {
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
}
