package ucsal.codehub.developer_task.model.entities;

import ucsal.codehub.developer_task.model.enums.SkillLevel;

public class DeveloperTask extends AssignedTask<Developer>{

    private SkillLevel skillLevel;

    public DeveloperTask(String name, Developer person, SkillLevel skillLevel) {
        super(name, person);
        this.skillLevel = skillLevel;
    }

    public DeveloperTask(String name, Developer person, Integer id, SkillLevel skillLevel) {
        super(name, person, id);
        this.skillLevel = skillLevel;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "DeveloperTask{" +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", person= " + person +
                ", status= " + status +
                " skillLevel= " + skillLevel +
                '}';
    }
}
