import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class TodoList {

    private static ArrayList<String> todo = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = getChoice();
            executeAction(choice);
        }
    }

    private static void printMenu() {
        System.out.println("\nTo-Do List Menu:");
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Display tasks");
        System.out.println("4. Exit");
        System.out.println("5. ???????");
        System.out.print("Enter a number: ");
    }

    private static int getChoice() {
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        return choice;
    }

    private static void executeAction(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                displayTasks();
                break;
            case 4:
                System.out.println("Exiting program.");
                System.exit(0);
                break;
            case 5:
                randomtask();
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private static void addTask() {
        System.out.print("Enter task to add: ");
        String task = scanner.nextLine();
        todo.add(task);
        System.out.println("Task added.");
    }

    private static void removeTask() {
        if (todo.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        System.out.println("Current tasks:");
        displayTasks();
        System.out.print("Enter the number of the task to remove: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;
            if (taskNumber >= 0 && taskNumber < todo.size()) {
                todo.remove(taskNumber);
                System.out.println("Task removed.");
                if (todo.isEmpty()) {
                    System.out.println("Great job, you have no tasks left to complete!!!");
                }
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void displayTasks() {
        if (todo.isEmpty()) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < todo.size(); i++) {
            System.out.println((i + 1) + ". " + todo.get(i));
        }
    }
    private static void randomtask() {
        Random gennum = new Random();
        String randomtasks[] = {"Clean your desk", "Clean your room", "Do your chores"};
        String rtasks = randomtasks[gennum.nextInt(3)];
        String task = rtasks;
        todo.add(task);
        System.out.println("Task added.");

    }
}