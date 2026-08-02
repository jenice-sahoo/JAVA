import java.util.ArrayList;
import java.util.Scanner;

class TodoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + ": ");
            tasks.add(sc.nextLine());
        }

        StringBuffer taskList = new StringBuffer();

        for (String task : tasks) {
            taskList.append(task).append("\n");
        }

        System.out.println("\nTo-Do List:");
        System.out.println(taskList);

        sc.close();
    }
}