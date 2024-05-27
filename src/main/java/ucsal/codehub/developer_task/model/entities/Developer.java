package ucsal.codehub.developer_task.model.entities;

import ucsal.codehub.developer_task.model.enums.SkillLevel;

public class Developer extends Person{

    private SkillLevel skillLevel;

    public Developer(String name, SkillLevel skillLevel) {
        super(name);
        this.skillLevel = skillLevel;
    }

    public Developer(String name, Integer id, SkillLevel skillLevel) {
        super(name, id);
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
        return "Developer{" +
                ", name='" + name + '\'' +
                ", id=" + id +
                "skillLevel=" + skillLevel +
                '}';
    }
}
