package dataClass;

public class Undergraduate extends Student {
    final int gradeLevel;

    public Undergraduate(String name, int studentID, int gradeLevel) {
        super(name, studentID);
        assert (gradeLevel >= 1 && gradeLevel <= 4);
        this.gradeLevel = gradeLevel;
    }

    public Undergraduate(String name, int studentID, String gradeLevel) {
        super(name, studentID);
        this.gradeLevel = gradeLevel(gradeLevel);
        assert (this.gradeLevel >= 1 && this.gradeLevel <= 4);
    }

    @Override
    public String toString() {
        return "Undergraduate{" +
                "name='" + name + '\'' +
                ", studentID=" + studentID +
                ", gradeLevel=" + gradeLevel() +
                '}';
    }

    String gradeLevel() {
        return switch (gradeLevel) {
            case 1 -> "Freshman";
            case 2 -> "Sophomore";
            case 3 -> "Junior";
            case 4 -> "Senior";
            default -> null;
        };
    }

    public int gradeLevel(String level) {
        level = level.trim().toLowerCase();
        return switch (level) {
            case "freshman" -> 1;
            case "sophomore" -> 2;
            case "junior" -> 3;
            case "senior" -> 4;
            default -> 0;
        };
    }

    public boolean equals(int gradeLevel) {
        return gradeLevel == this.gradeLevel;
    }
}
