import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<MatchResult> matchResults;

    public Statistics(String filename) throws FileNotFoundException {
    MatchResultFileReader mrfr = new MatchResultFileReader(filename);
    matchResults = mrfr.readFile();
    }

    public Set<String> getGoalScorers() {
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult matchResult : matchResults) {
            for(String scorer : matchResult.getGoalScorers()){
                goalScorers.add(scorer);
            }
        }
        return goalScorers;
    }

    public Map<String, Integer> getGoalScorersWithTotals() {
       Map<String, Integer> scorerAndGoals = new HashMap<>();
       Set<String> listOfGoalScorers = getGoalScorers();
       for(String goalScorer : listOfGoalScorers){
           int goals = getNumberOfGoals(goalScorer);
           scorerAndGoals.put(goalScorer, goals);
       }
       return scorerAndGoals;
    }

    public int getNumberOfGoals(String goalScorer) {
       int numberOfGoals = 0;
       for(MatchResult m : matchResults){
           for(String scorer : m.getGoalScorers()){
               if(scorer.equalsIgnoreCase(goalScorer)){
                   numberOfGoals++;
               }
           }
       } return numberOfGoals;
    }
}


