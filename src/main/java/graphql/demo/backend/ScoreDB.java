package graphql.demo.backend;

import graphql.demo.model.Score;
import graphql.demo.model.ScoreType;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

@ApplicationScoped
public class ScoreDB {
    private final Logger log = Logger.getLogger(ScoreDB.class.getName());
    
    private final Map<String,List<Score>> scoreDatabase = Database.getScoresSchema();
    
    public List<Score> getScores(String idNumber){
        log.logf(Level.ERROR, "======= Getting scores [{0}] =======", idNumber);
        return scoreDatabase.get(idNumber);
    }
    
    public Score getScore(ScoreType type,String idNumber){
        List<Score> scores = getScores(idNumber);
        for(Score score:scores){
            if(score.getName().equals(type))return score;
        }
        return null;
    }
}