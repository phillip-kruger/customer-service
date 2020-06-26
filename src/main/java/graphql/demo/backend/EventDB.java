package graphql.demo.backend;

import graphql.demo.model.Event;
import java.util.List;
import java.util.Map;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventDB {
    private final Logger log = Logger.getLogger(EventDB.class.getName());
    
    private final Map<String,List<Event>> eventDatabase = Database.getEventsSchema();
    
    public List<Event> getEvents(String id){
        log.logf(Level.ERROR, "======= Getting events [{0}] =======", id);
        return eventDatabase.get(id);
    }
}