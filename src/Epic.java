import java.util.HashMap;
public class Epic extends Task {
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

    Epic(String name, String description) {
        super(name, description);
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(HashMap<Integer, Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    Epic(String name, String description, int id) {
        super(name, description, id);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", status=" + getStringStatus() +
                ", subtasks=" + subtasks +
                '}';
    }
}
