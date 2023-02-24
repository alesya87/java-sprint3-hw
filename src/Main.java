public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = taskManager.createSimpleTask(new Task("Уборка", "Сделать генеральную уборку"));
        Task task2 = taskManager.createSimpleTask(new Task("Готовка", "Приготовить ужин"));

        Task epicTask1 = taskManager.createEpicTask(new Epic("Досуг", "Куда сходить на выходных"));
        Task subtask1 = taskManager.createSubtask(new Subtask("Кино", "Посмотреть какой-нибудь фильм", (Epic) epicTask1));
        Task subtask2 = taskManager.createSubtask(new Subtask("Караоке", "Съездить в караоке комнату", (Epic) epicTask1));

        Task epicTask2 = taskManager.createEpicTask(new Epic("Здоровье", "К каким врачам сходить"));
        Task subtask3 = taskManager.createSubtask(new Subtask("Невролог", "Сходить к неврологу", (Epic) epicTask2));

        System.out.println(taskManager.getAllSimpleTasks());
        taskManager.updateSimpleTask(new Task("Уборка", "Сделать генеральную уборку", task1.getId(), 4.2));
        System.out.println(taskManager.getSimpleTaskById(task1.getId()));

        taskManager.updateSimpleTask(new Task("Готовка", "Приготовить ужин", task2.getId(), 4.3));
        System.out.println(taskManager.getAllSimpleTasks());

        taskManager.updateSubtask(new Subtask("Кино", "Посмотреть фильм \"Джанго освобожденный\"", subtask1.getId(), 4.3));
        taskManager.updateSubtask(new Subtask("Караоке", "Съездить в караоке комнату, спеть 10 пеесен", subtask2.getId(), 4.3));
        System.out.println(taskManager.getEpicTaskById(epicTask1.getId()));

        taskManager.updateSubtask(new Subtask("Невролог", "Сходить к неврологу", subtask3.getId(), 4.2));
        System.out.println(taskManager.getAllEpicTasks());
        taskManager.deleteSubtaskById(subtask3.getId());
        System.out.println(taskManager.getEpicTaskById(epicTask2.getId()));

        taskManager.deleteAllSubtasks();
        System.out.println(taskManager.getAllEpicTasks());

        taskManager.deleteEpicTaskById(epicTask2.getId());
        System.out.println(taskManager.getAllEpicTasks());
    }
}