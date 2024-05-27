package ucsal.codehub.developer_task.model.services.exceptions;

public class TaskNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TaskNotFound (String msg) {
        super(msg);
    }
}


