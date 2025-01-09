import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class JobScheduler {
// main method
// prio queue for the jobs
    public static void main(String[] args) {
        PriorityQueue<Job> queue = new PriorityQueue<>();
        try {
        // reads the file for the hobs
            Scanner scanner = new Scanner(new File("jobs.txt"));
            int currentTime = 0;
        // assgins read jobs and adds them to queue
            while (scanner.hasNext()) {
                int id = scanner.nextInt();
                int length = scanner.nextInt();
                int priority = scanner.nextInt();
                queue.add(new Job(id, length, priority));
            }

            // print the chart for the jobs
            System.out.printf("%-10s %-10s %-10s %-15s%n", "jobID", "length", "priority", "completionTime");
            // process job in queue order based on prio
            while (!queue.isEmpty()) {
                Job job = queue.poll();
                currentTime += job.getLength();
                // Prints each job in a new row
                System.out.printf("%-10d %-10d %-10d %-15d%n", job.getId(), job.getLength(), job.getPriority(), currentTime);
            }
        } catch (FileNotFoundException e) {
        // handle case if job file not found
            System.out.println("File not found. Please check the file path.");
        }
    }
}
