package graphql.demo.backend;

import graphql.demo.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

@ApplicationScoped
public class PersonDB {
    private final Logger log = Logger.getLogger(PersonDB.class.getName());
    
    private final Map<Integer,Person> personDatabase = Database.getPeopleSchema();
    
    public Person getPerson(Integer id){
        log.logf(Level.ERROR, "======= Getting person [{0}] =======", id);    
        return personDatabase.get(id);
    }
    
    public List<Person> getPeople(){
        return new ArrayList<>(personDatabase.values());
    }
    
    public List<Person> getPeopleWithSurname(String surname){
        log.logf(Level.ERROR, "======= Finding people with surname [{0}] =======", surname);
        List<Person> p = new ArrayList<>();
        for(Person person: personDatabase.values()) {
            if(person.surname.equalsIgnoreCase(surname))p.add(person);
        }
        return p;
    }
    
    public Person updatePerson(Person person){
        if(person.getId() == null || person.getId() <= 0){
            person.setId(getNextId());
            log.logf(Level.ERROR, "======= Adding person [{0}] =======", person.getId());
        }else{
            log.logf(Level.ERROR, "======= Updating person [{0}] =======", person.getId());
        }
        personDatabase.put(person.getId(), person);
        return person;
    }
    
    public Person deletePerson(Integer id){
        if(personDatabase.containsKey(id)){
            log.logf(Level.ERROR, "======= Deleting person [{0}] =======", id);
            return personDatabase.remove(id);
        }
        return null;
    }
    
    private synchronized int getNextId(){
        return personDatabase.size() + 1;
    }
}
