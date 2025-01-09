public class Job implements Comparable<Job> {
    private int id;
    private int length;
    private int priority;
// constructs a new jb with given id length and priority
    public Job(int id, int length, int priority) {
        this.id = id;
        this.length = length;
        this.priority = priority;
    }
//returns id of job
    public int getId() {
        return id;
    }
// returns length of job
    public int getLength() {
        return length;
    }
// returns its priority
    public int getPriority() {
        return priority;
    }
//compares job to others and returns 0 or a negative or postive number based on prio
    @Override
    public int compareTo(Job other) {
        return Integer.compare(this.priority, other.priority);
    }
}


