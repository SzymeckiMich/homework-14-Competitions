import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Person> athletes = Utils.createAthletesFromUser();

        Utils.sortAndSafeToCSV(athletes);
    }
}
