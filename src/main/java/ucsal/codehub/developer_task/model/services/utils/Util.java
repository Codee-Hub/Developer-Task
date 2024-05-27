package ucsal.codehub.developer_task.model.services.utils;

import ucsal.codehub.developer_task.model.entities.Developer;
import ucsal.codehub.developer_task.model.enums.SkillLevel;
import ucsal.codehub.developer_task.model.services.exceptions.DeveloperWithoutPermission;

public class Util {

    public static Boolean SkillLevelCheck(Developer developer, SkillLevel skillLevel){

        SkillLevel developerSkillLevel = developer.getSkillLevel();
        if (developerSkillLevel != null) {
            switch (skillLevel) {
                case JUNIOR:
                        return true;
                case PLENO:
                    if (developerSkillLevel != SkillLevel.JUNIOR) {
                        return true;
                    }
                    break;
                case SENIOR:
                    if (developerSkillLevel == SkillLevel.SENIOR) {
                        return true;
                    }
                default:
                    break;
            }
        } else {
            throw new DeveloperWithoutPermission("This Developer don't have a SkillLevel");
        }
        return false;
    }
}
