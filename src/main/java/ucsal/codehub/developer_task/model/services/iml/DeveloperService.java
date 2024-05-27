package ucsal.codehub.developer_task.model.services.iml;

import ucsal.codehub.developer_task.model.entities.Developer;
import ucsal.codehub.developer_task.model.services.PersonService;
import ucsal.codehub.developer_task.model.services.exceptions.EmptyList;
import ucsal.codehub.developer_task.model.services.exceptions.PersonNotFound;

import java.util.List;

public class DeveloperService implements PersonService<Developer> {

    List<Developer> developers;

    public DeveloperService(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public void addPerson(Developer dev) {
        try {
            developers.add(dev);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removePersonById(int id) {
        try {
            developers.remove(developers.stream().filter(dev -> dev.getId() == id).findFirst().orElseThrow( () -> new PersonNotFound("Person not found")));
        } catch (PersonNotFound e) {
            e.printStackTrace();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePerson(Developer developer) {
        try {
            developers.stream().filter(dev -> dev.getId() == developer.getId()).findFirst().ifPresentOrElse(dev -> updateData(dev, developer), () -> { throw new PersonNotFound("Person not found"); });
        } catch (PersonNotFound e) {
            e.printStackTrace();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getPersonById(int id) {
        try {
            return developers.stream().filter(dev -> dev.getId() == id).findFirst().orElseThrow( () -> new PersonNotFound("Person not found"));
        } catch (PersonNotFound e) {
            e.printStackTrace();
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

    @Override
    public List<Developer> getPersons() {
        try {
            if (developers.size() == 0) {
                throw new EmptyList("The list of developers is empty");
            }
            return developers;
        } catch (EmptyList e){
            e.printStackTrace();
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

    @Override
    public void updateData(Developer dev, Developer developer) {
    dev.setName(developer.getName());
    dev.setSkillLevel(developer.getSkillLevel());
    }
}
