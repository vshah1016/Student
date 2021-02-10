package dataClass;

public class Student extends Person {
    final int studentID;

    public Student(String name, int studentID) {
        super(name);
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentID=" + studentID +
                '}';
    }
}
