package ucsal.codehub.developer_task.model.services.factorys;

import ucsal.codehub.developer_task.model.entities.Developer;
import ucsal.codehub.developer_task.model.services.iml.DeveloperService;

import java.util.ArrayList;

public class DeveloperServiceFactory {

    public static DeveloperService getDeveloperService() {
        return new DeveloperService(new ArrayList<Developer>());
    }
}
