package ucsal.codehub.developer_task.model.services.exceptions;

public class PersonNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PersonNotFound (String msg) {
        super(msg);
    }
}
