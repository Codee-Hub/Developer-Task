package ucsal.codehub.developer_task.model.services.iml;

import ucsal.codehub.developer_task.model.entities.AssignedTask;
import ucsal.codehub.developer_task.model.entities.DeveloperTask;
import ucsal.codehub.developer_task.model.enums.AssignedTaskStatus;
import ucsal.codehub.developer_task.model.services.AssignedTaskService;
import ucsal.codehub.developer_task.model.services.exceptions.DeveloperWithoutPermission;
import ucsal.codehub.developer_task.model.services.exceptions.EmptyList;
import ucsal.codehub.developer_task.model.services.exceptions.PersonNotFound;
import ucsal.codehub.developer_task.model.services.utils.Util;

import java.util.List;
import java.util.stream.Collectors;

public class DeveloperTaskService implements AssignedTaskService<DeveloperTask> {

    List<DeveloperTask> tasks;

    public DeveloperTaskService(List<DeveloperTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void addAssignedTask(DeveloperTask developerTask) {
        try {
            if (Util.SkillLevelCheck(developerTask.getPerson(), developerTask.getSkillLevel())){
                tasks.add(developerTask);
            } else {
                throw new DeveloperWithoutPermission("The skill level check failed");
            }
        } catch ( DeveloperWithoutPermission e){
            e.printStackTrace();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAssignedTaskById(int id) {
        try {
            tasks.remove(tasks.stream().filter(task -> task.getId() == id).findFirst().orElseThrow(() -> new PersonNotFound("Developer nor found")));
        } catch (PersonNotFound e){
            e.printStackTrace();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAssignedTask(DeveloperTask developerTask) {
        try {
            if (Util.SkillLevelCheck(developerTask.getPerson(), developerTask.getSkillLevel())){
                tasks.stream().filter(task -> task.getId() == developerTask.getId()).findFirst().ifPresentOrElse(task -> updateTask(task, developerTask), () -> {throw new PersonNotFound("Developer not found");});
            } else {
                throw new DeveloperWithoutPermission("The skill level check failed");
            }
        } catch (PersonNotFound e){
            e.printStackTrace();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public DeveloperTask getAssignedTaskById(int id) {
        try {
            return tasks.stream().filter(task -> task.getId() == id).findFirst().orElseThrow(() -> new PersonNotFound("Developer not found"));
        } catch (PersonNotFound e){
            e.printStackTrace();
            return null;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DeveloperTask> getAllAssignedTasks() {
        try {
            if (tasks.isEmpty()) {
                throw new EmptyList("There aren't found any assigned tasks");
            } else {
                return tasks;
            }
        } catch (EmptyList e){
            e.printStackTrace();
            return null;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DeveloperTask> getAssignedTasksByPersonId(int personId) {
        try {
            if (tasks.isEmpty()) {
                throw new EmptyList("There aren't found any assigned tasks");
            } else {
                return tasks.stream().filter(task -> task.getPerson().getId() == personId).collect(Collectors.toList());
            }
        } catch (EmptyList e){
            e.printStackTrace();
            return null;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DeveloperTask> getPedingAssignedTasks() {
        try {
            if (tasks.isEmpty()) {
                throw new EmptyList("There aren't found any assigned tasks");
            } else {
                return tasks.stream().filter(task -> task.getStatus() == AssignedTaskStatus.PENDING).collect(Collectors.toList());
            }
        } catch (EmptyList e){
            e.printStackTrace();
            return null;
        } catch (RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void concludeAssignedTask(int id) {
        try {
            tasks.stream().filter(task -> task.getId() == id).findFirst().ifPresentOrElse(task -> task.setStatus(AssignedTaskStatus.CONCLUDED), () ->{ throw new PersonNotFound("Developer not found"); });
        } catch (PersonNotFound e){
            e.printStackTrace();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateTask(DeveloperTask task, DeveloperTask newTask) {
     task.setName(newTask.getName());
     task.setSkillLevel(newTask.getSkillLevel());
     task.setPerson(newTask.getPerson());
    }
}
