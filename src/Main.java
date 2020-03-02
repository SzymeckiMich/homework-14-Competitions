import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Person> athletes = Utils.createNewAthletesList();

        Utils.addNewAthletesToList(athletes);

        Utils.sortAndSafeToCSV(athletes);
    }
}
