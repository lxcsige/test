package GenTest;

/**
 * Created by lxcfour on 16/7/28.
 */
public class Student implements Comparable<Student> {

    private int id;

    public Student(int id){
        this.id = id;
    }

    @Override
    public int compareTo(Student o) {
        return (id > o.id) ? 1 : ((id < o.id) ? -1 : 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
