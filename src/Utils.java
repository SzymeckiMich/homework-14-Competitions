import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Utils {

    static final String STOP_WORD = "stop";

    public static List<Person> createAthletesFromUser() {
        String athlete = "";
        List<Person> athletes = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Podaj zawodnika (w formacie IMIE NAZWISKO WYNIK. Wpisz 'stop' aby zakończyć): ");
                athlete = scanner.nextLine();

                if (athlete.equals(STOP_WORD)) {
                    break;
                }

                String[] split = athlete.split(" ");
                double score = Double.parseDouble(split[2]);
                athletes.add(new Person(split[0], split[1], score));
            }
        }
        return athletes;
    }

    public static void sortAndSafeToCSV(List<Person> list) throws IOException {
        Collections.sort(list);
        System.out.println("Posortowano uczestników w kolejności od największej ilości punktów.");
        saveScoresToCSV(list);
    }

    private static void saveScoresToCSV(List<Person> list) throws IOException {
        File file = new File("scores.csv");
        if (!file.exists()) {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(toCSV(list.get(i)));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Zapisano posortowaną listę do pliku.");
        } else {
            System.err.println("Plik już istnieje");
        }
    }

    private static String toCSV(Person person) {
        return person.getFirstName() + ";" + person.getLastName() + ";" + person.getScore();
    }
}
