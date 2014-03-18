import java.io.File;
import java.io.PrintWriter;

public class Session {
    private static String fileName = "session.txt";

    public static void Add(String loggedUser, String password) {
        createIfNeeded();
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(loggedUser + ";" + password);
            writer.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createIfNeeded() {
        File f = new File(fileName);
        if (!f.exists()) {
            try {
                f.createNewFile();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
