package ucsal.codehub.developer_task.model.services;

import ucsal.codehub.developer_task.model.services.iml.AssignedTaskServiceIml;
import ucsal.codehub.developer_task.model.entities.AssignedTask;

import java.util.ArrayList;
import java.util.List;

public class AssignedTaskFactory {

    public static AssignedTaskServiceIml createAssignedTask() {
        List<AssignedTask> tasks = new ArrayList<AssignedTask>();
        return new AssignedTaskServiceIml(tasks);
    }
}
