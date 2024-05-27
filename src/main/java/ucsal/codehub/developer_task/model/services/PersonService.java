package ucsal.codehub.developer_task.model.services;

import ucsal.codehub.developer_task.model.entities.Person;

import java.util.List;

public interface PersonService <T extends Person> {
    void addPerson(T person);
    void removePersonById(int id);
    void updatePerson(T person);
    T getPersonById(int id);
    List<T> getPersons();
}
