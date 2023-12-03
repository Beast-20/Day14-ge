import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int deadline;
    int minutes;

    public Task(int deadline, int minutes) {
        this.deadline = deadline;
        this.minutes = minutes;
    }
}

public class Taskproblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        Task[] tasks = new Task[T];

        for (int i = 0; i < T; i++) {
            int D = scanner.nextInt();
            int M = scanner.nextInt();
            tasks[i] = new Task(D, M);
        }

        calculateOvershoots(tasks);

        scanner.close();
    }

    private static void calculateOvershoots(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.deadline));

        int currentTime = 0;
        int maxOvershoot = 0;

        for (Task task : tasks) {
            currentTime += task.minutes;
            int overshoot = Math.max(0, currentTime - task.deadline);
            maxOvershoot = Math.max(maxOvershoot, overshoot);
        }

        System.out.println(maxOvershoot);
    }
}
