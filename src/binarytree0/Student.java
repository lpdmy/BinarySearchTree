


public class Student implements Comparable<Student>{
    int rollno;

    public Student() {
    }

    public Student(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return   rollno+"" ;
    }

    @Override
    public int compareTo(Student o) {
        if(this.rollno < o.rollno) return -1;
        if(this.rollno > o.rollno) return +1;
        return 0;
    }
    
}
