package ucsal.codehub.developer_task.model.services;

import ucsal.codehub.developer_task.model.entities.AssignedTask;

import java.util.List;

public interface AssignedTaskService<T extends AssignedTask> {

    void addAssignedTask(T assignedTask);
    void deleteAssignedTaskById(int id);
    void updateAssignedTask(T assignedTask);
    T getAssignedTaskById(int id);
    List<T> getAllAssignedTasks();
    List<T> getAssignedTasksByPersonId(int personId);
    List<T> getPedingAssignedTasks();
    void concludeAssignedTask(int id);
    void updateTask(T task, T newTask);
}
