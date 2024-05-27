package ucsal.codehub.developer_task.model.services.factorys;

import ucsal.codehub.developer_task.model.entities.Developer;
import ucsal.codehub.developer_task.model.services.iml.DeveloperService;

import java.util.ArrayList;
import java.util.List;

public class DeveloperServiceFactory {

    public static DeveloperService getDeveloperService() {
        List<Developer> developers = new ArrayList<Developer>();
        return new DeveloperService(developers);
    }
}
