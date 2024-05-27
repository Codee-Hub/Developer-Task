package ucsal.codehub.developer_task.model.services.factorys;

import ucsal.codehub.developer_task.model.entities.DeveloperTask;
import ucsal.codehub.developer_task.model.services.iml.DeveloperTaskService;

import java.util.ArrayList;

public class DeveloperTaskServiceFactory {

    public static DeveloperTaskService getDeveloperTaskService() {
        return new DeveloperTaskService(new ArrayList<DeveloperTask>());
    }
}
