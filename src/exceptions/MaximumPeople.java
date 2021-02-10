package exceptions;

public class MaximumPeople extends Exception {
    public MaximumPeople() {
        super("There are already 10 people in the list. You cannot add more.");
    }
}
