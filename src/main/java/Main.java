import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MatchResultFileReader mrfr = new MatchResultFileReader("src/main/Euro2024QualifyingRound.csv");
        Statistics statistics = new Statistics("src/main/Euro2024QualifyingRound.csv");
        mrfr.readFile();

        System.out.println(mrfr);

        System.out.println(statistics.getGoalScorersWithTotals());
       // String player = "Delaney";
        //System.out.println(player + ": " + statistics.getNumberOfGoals(player));
    }
}
