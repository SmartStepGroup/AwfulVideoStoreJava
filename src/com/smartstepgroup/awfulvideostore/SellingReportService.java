package com.smartstepgroup.awfulvideostore;

public class SellingReportService {
    public String getReport() throws Exception {
        if (Session.HasValue("LoggedUser", "Admin")) {
            String reportString = getBestSellingCategory();
            reportString += GetTop5();
            return reportString;
        }

        return "You have no access to report";
    }

    public String GetTop5() {
        return "";
    }

    private String getBestSellingCategory() throws Exception {
        Movie[] data = new DefaultMovieService().load();

        int regular = 0;
        int newReleases = 0;
        int children = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].GetMovieCodeName() == "Regular") {
                regular++;
            }
            if (data[i].GetMovieCodeName() == "New Releases") {
                newReleases++;
            }
            if (data[i].GetMovieCodeName() == "Children") {
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
}
