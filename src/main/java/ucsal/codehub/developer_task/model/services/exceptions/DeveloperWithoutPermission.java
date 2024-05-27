package ucsal.codehub.developer_task.model.services.exceptions;

public class DeveloperWithoutPermission extends RuntimeException{

    public DeveloperWithoutPermission(String message){
        super(message);
    }
}
