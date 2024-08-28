import java.util.List;

public class MatchResult {
    private String teams;
    private List<String> goalScorers;

    public MatchResult(String teams, List<String> goalScorers) {
        this.teams = teams;
        this.goalScorers = goalScorers;
    }

    public List<String> getGoalScorers() {
        return goalScorers;
    }

    @Override
    public String toString(){
         String result = "Hold: " + teams + "\nMålscorere: ";
                for(String scorer : goalScorers) {
                    result += scorer;
                }
                return result;
    }
}
