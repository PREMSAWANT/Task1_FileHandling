import java.io.*;
import java.util.*;

/**
 * TodoListManager - A simple To-Do List manager using file handling in Java.
 * Features: Add, view, and mark tasks as completed. All tasks are stored in 'todo.txt'.
 */
public class TodoListManager {
    private static final String FILE_NAME = "todo.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== To-Do List Manager ====");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    viewTasks();
                    break;
                case "2":
                    addTask(scanner);
                    break;
                case "3":
                    markTaskCompleted(scanner);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // View all tasks
    private static void viewTasks() {
        List<String> tasks = readTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\nYour To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Add a new task
    private static void addTask(Scanner scanner) {
        System.out.print("Enter the new task: ");
        String task = scanner.nextLine();
        try {
            File file = new File(FILE_NAME);
            boolean needsNewline = false;
            if (file.exists() && file.length() > 0) {
                try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                    raf.seek(file.length() - 1);
                    int lastChar = raf.read();
                    if (lastChar != '\n' && lastChar != '\r') {
                        needsNewline = true;
                    }
                }
            }
            try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
                if (needsNewline) fw.write(System.lineSeparator());
                fw.write("[ ] " + task + System.lineSeparator());
                System.out.println("Task added!");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Mark a task as completed
    private static void markTaskCompleted(Scanner scanner) {
        List<String> tasks = readTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark as completed.");
            return;
        }
        viewTasks();
        System.out.print("Enter the task number to mark as completed: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 1 || num > tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }
            String task = tasks.get(num - 1);
            if (task.startsWith("[x]")) {
                System.out.println("Task is already completed.");
                return;
            }
            tasks.set(num - 1, task.replaceFirst("\\[ \\]", "[x]"));
            writeTasks(tasks);
            System.out.println("Task marked as completed!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    // Read all tasks from the file
    private static List<String> readTasks() {
        List<String> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return tasks;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    tasks.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return tasks;
    }

    // Write all tasks to the file
    private static void writeTasks(List<String> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                bw.write(task);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
} 