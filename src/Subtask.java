public class Subtask extends Task {
    private Epic epicTask;

    Subtask(String name, String description, Epic epicTask) {
        super(name, description);
        this.epicTask = epicTask;
        putSubTaskToEpic();
    }

    Subtask(String name, String description, int id, double status) {
        super(name, description, id, status);
    }

    public Epic getEpicTask() {
        return epicTask;
    }

    public void setEpicTask(Epic epicTask) {
        this.epicTask = epicTask;
    }

    private void putSubTaskToEpic() {
        epicTask.getSubtasks().put(getId(), this);
    }
}

