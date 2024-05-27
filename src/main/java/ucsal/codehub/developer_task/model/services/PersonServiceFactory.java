package ucsal.codehub.developer_task.model.services;

import ucsal.codehub.developer_task.model.services.iml.PersonServiceIml;
import ucsal.codehub.developer_task.model.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceFactory {

    public static PersonServiceIml createPersonService() {
        List<Person> people =  new ArrayList<Person>();
        return new PersonServiceIml(people);
    }


}
