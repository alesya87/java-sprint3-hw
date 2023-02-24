import java.util.HashMap;

public class TaskManager {
    private HashMap<Integer, Task> allSimpleTasks;
    private HashMap<Integer, Epic> allEpicTasks;
    private HashMap<Integer, Subtask> allSubtasks;

    public TaskManager() {
        allSimpleTasks = new HashMap<>();
        allEpicTasks = new HashMap<>();
        allSubtasks = new HashMap<>();
    }

    public HashMap<Integer, Task> getAllSimpleTasks() {
        return allSimpleTasks;
    }

    public void deleteAllSimpleTasks() {
        allSimpleTasks.clear();
    }

    public Task getSimpleTaskById(int id) {
        return allSimpleTasks.get(id);
    }

    public Task createSimpleTask(Task task) {
        allSimpleTasks.put(task.getId(), task);
        return task;
    }

    public void updateSimpleTask(Task task) {
        allSimpleTasks.put(task.getId(), task);
    }

    public void deleteSimpleTaskById(int id) {
        allSimpleTasks.remove(id);
    }

    public HashMap<Integer, Epic> getAllEpicTasks() {
        return allEpicTasks;
    }

    public void deleteAllEpicTasks() {
        allEpicTasks.clear();
    }

    public Task getEpicTaskById(int id) {
        return allEpicTasks.get(id);
    }

    public Epic createEpicTask(Epic epicTask) {
        allEpicTasks.put(epicTask.getId(), epicTask);
        return epicTask;
    }

    public void updateEpicTask(Epic epicTask) {
        Epic epicTaskOld = allEpicTasks.get(epicTask.getId());
        epicTask.setSubtasks(epicTaskOld.getSubtasks());
        allEpicTasks.put(epicTask.getId(), epicTask);
    }

    public void deleteEpicTaskById(int id) {
        allEpicTasks.get(id).getSubtasks().clear();
        allEpicTasks.remove(id);
    }

    public HashMap<Integer, Subtask> getAllSubtasks() {
        return allSubtasks;
    }

    public void deleteAllSubtasks() {
        allSubtasks.clear();
        for (Epic epicTask : allEpicTasks.values()) {
            epicTask.getSubtasks().clear();
            epicTask.setStatus(4.1);
        }
    }

    public Subtask createSubtask(Subtask subtask) {
        allSubtasks.put(subtask.getId(), subtask);
        return subtask;
    }

    public void updateSubtask(Subtask subtask) {
        int id = subtask.getId();
        double oldStatus = allSubtasks.get(id).getStatus();
        Epic epicTask = allSubtasks.get(id).getEpicTask();
        subtask.setEpicTask(epicTask);
        epicTask.getSubtasks().put(id, subtask);
        allSubtasks.put(id, subtask);

        if (oldStatus != subtask.getStatus()) {
            int countSubtasks = epicTask.getSubtasks().size();
            int countNewTasks = 0;
            int countDoneTasks = 0;

            for (Subtask epicSubtask : epicTask.getSubtasks().values()) {
                double status = epicSubtask.getStatus();
                if (status == 4.1) {
                    countNewTasks++;
                } else if (status == 4.3) {
                    countDoneTasks++;
                }
            }

            if (countSubtasks == 0 || countSubtasks == countNewTasks) {
                epicTask.setStatus(4.1);
            } else if (countSubtasks == countDoneTasks) {
                epicTask.setStatus(4.3);
            } else {
                epicTask.setStatus(4.2);
            }
        }

    }

    public void deleteSubtaskById(int id) {
        Epic epicTask = allSubtasks.get(id).getEpicTask();
        epicTask.getSubtasks().remove(id);
        if (epicTask.getSubtasks().size() == 0) {
            epicTask.setStatus(4.1);
        }
        allSubtasks.remove(id);
    }

    public HashMap<Integer, Subtask> getAllEpicSubtasks(Epic epicTask) {
        return epicTask.getSubtasks();
    }

}
