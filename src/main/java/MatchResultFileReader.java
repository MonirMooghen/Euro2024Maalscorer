import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {
    Scanner scanner;
    List<MatchResult> matchResultList = new ArrayList<>();

    public MatchResultFileReader(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    scanner = new Scanner(file);
    }

    public List<MatchResult> readFile() {
    List<MatchResult> matchResultList = new ArrayList<>();
    while (scanner.hasNext()) {
        String line = scanner.nextLine();    // Split linje og læg tokens i attributter
        String[] match = line.split(";");
        String teams = match[0];
        List<String> goalScorer = new ArrayList<>();
        if(match.length > 1){
            String målscorer = match[1];
            if(målscorer != null){
                String[] målscorerArray = line.split(",");
                for(String m : målscorerArray){
                    goalScorer.add(m);
                }
            }
        }
        MatchResult matchResult = new MatchResult(teams, goalScorer);
        matchResultList.add(matchResult);
    }
    return matchResultList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(MatchResult matchResult : matchResultList){
            result.append(matchResult.toString()).append("\n");
        }
        return result.toString();

    }
}
