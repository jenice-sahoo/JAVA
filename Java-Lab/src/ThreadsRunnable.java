class Task implements Runnable {
    private String taskName;

    Task(String name) {
        taskName = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + ": " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ThreadsRunnable {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
