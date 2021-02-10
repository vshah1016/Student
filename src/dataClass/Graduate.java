package dataClass;

public class Graduate extends Student {
    final String major;

    public Graduate(String name, int studentID, String major) {
        super(name, studentID);
        this.major = major;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "major='" + major + '\'' +
                ", name='" + name + '\'' +
                ", studentID=" + studentID +
                '}';
    }

    public boolean equals(String major) {
        return this.major.equalsIgnoreCase(major);
    }
}
