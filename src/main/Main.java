package main;

import dataClass.Graduate;
import dataClass.Student;
import dataClass.Undergraduate;
import gui.AddPerson;
import gui.RemovePerson;

import java.util.function.BooleanSupplier;

public class Main {

    public static final Data data = new Data();
    private static final Client client = new Client();
    private static final BooleanSupplier runAgain = client::isRunAgain;


    public static void main(String[] args) {
        int choice = client.runAgain();
        while (runAgain.getAsBoolean()) {
            switch (choice) {
                case 1 -> AddPerson.main();
                case 2 -> RemovePerson.main();
                case 3 -> data.stream().forEach(System.out::println);
                case 4 -> data.stream().filter(p -> p instanceof Student).forEach(System.out::println);
                case 5 -> data.stream().filter(p -> p instanceof Undergraduate).forEach(System.out::println);
                case 6 -> data.stream().filter(p -> p instanceof Graduate).forEach(System.out::println);
                case 7 -> {
                    System.out.println("What grade do you want to match?\n 1. Freshmen\n 2. Sophomores\n 3. Juniors\n 4. Seniors\nPlease enter the number of the grade you would like: ");
                    int grade = Integer.parseInt(client.gatherInput().trim());
                    data.stream().filter(p -> p instanceof Undergraduate).map(p -> (Undergraduate) p).filter(p -> p.equals(grade)).forEach(System.out::println);
                }
                case 8 -> {
                    System.out.println("Please enter the major you would like to match: ");
                    String major = client.gatherInput().trim();
                    data.stream().filter(p -> p instanceof Graduate).map(p -> (Graduate) p).filter(p -> p.equals(major)).forEach(System.out::println);
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
            choice = client.runAgain();
        }
        System.out.println("Goodbye!");
        System.exit(0);
    }
}