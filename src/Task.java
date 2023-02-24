import java.util.HashMap;

public class Task {
    private String name;
    private String description;
    private int id;
    private double status;
    private static int increment;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        status = 4.1;
        increment++;
        id += increment;
    }

    public Task(String name, String description, int id) {
        this(name, description);
        this.id = id;
    }

    public Task(String name, String description, int id, double status) {
        this(name, description, id);
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getStatus() {
        return status;
    }

    public String getStringStatus() {
        HashMap<Double, String> stringStatuses = new HashMap<>();
        stringStatuses.put(4.1, "NEW");
        stringStatuses.put(4.2, "IN_PROGRESS");
        stringStatuses.put(4.3, "DONE");
        return stringStatuses.get(status);
    }

    public void setStatus(double status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + getStringStatus() +
                '}';
    }
}
